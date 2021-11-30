package com.ofw.ofw.security.jwt;

import com.ofw.ofw.exception.type.ExpiredAccessTokenException;
import com.ofw.ofw.exception.type.InvalidTokenException;
import com.ofw.ofw.security.jwt.auth.AuthDetailsService;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.access.exp}")
    private Long accessExp;

    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.prefix}")
    private String prefix;

    private final AuthDetailsService authDetailsService;

    public String generateAccessToken(String id, String aud) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, getSecretKey())
                .setHeaderParam("typ", "JWT")
                .setSubject(id)
                .setAudience(aud)
                .claim("type", "access")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessExp * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(header);
        if (bearer != null && bearer.startsWith(prefix)) {
            return bearer.replace(prefix, "");
        }
        return null;
    }

    public boolean validateToken(String token) {
        return getTokenBody(token)
                .getExpiration().after(new Date());
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new ExpiredAccessTokenException();
        } catch (MalformedJwtException e) {
            throw new InvalidTokenException();
        }
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private String getSecretKey() {
        return Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
}
