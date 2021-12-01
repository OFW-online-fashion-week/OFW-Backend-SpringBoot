package com.ofw.ofw.service.email;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.entity.like.Like;
import com.ofw.ofw.entity.like.LikeRepository;
import com.ofw.ofw.exception.type.BrandCacheNotFoundException;
import com.ofw.ofw.exception.type.BrandNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final BrandRepository brandRepository;
    private final LikeRepository likeRepository;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    @SneakyThrows
    public void sendBrandConfirmForm(String brandId) {
        InputStream inputStream = new ClassPathResource("templates/email/BrandConfirmForm.html").getInputStream();

        String body = getEmailBody(inputStream);

        javaMailSender.send(mimeMessage -> {
            final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(senderEmail);
            helper.setTo(brandId);
            helper.setSubject("OFW Brand Register Authorization Email");
            helper.setText(body.replace("{{brand_id}}", brandId), true);
        });
    }

    @Override
    @SneakyThrows
    public void sendNewCollectionNoticeForm(Long brandId) {
        InputStream inputStream = new ClassPathResource("templates/email/NewCollectionNoticeForm.html").getInputStream();

        String body = getEmailBody(inputStream);

        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(BrandCacheNotFoundException::new);

        List<Like> likeList = likeRepository.findAllByBrand(brandRepository.findById(brandId)
                .orElseThrow(BrandNotFoundException::new));
        if (likeList.isEmpty()) return;
        String[] emailList = new String[likeList.size()];
        for (int i = 0; i < likeList.size(); i++) {
            emailList[i] = likeList.get(i).getUser().getEmail();
        }

        javaMailSender.send(mimeMessage -> {
            final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(senderEmail);
            helper.setTo(emailList);
            helper.setSubject("OFW Brand Register Authorization Email");
            helper.setText(body.replace("{{brand_profile}}", brand.getProfilePath())
                    .replace("{{brand_name}}", brand.getName()), true);
        });
    }

    private String getEmailBody(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();

        bufferedReader.lines()
                .filter(Objects::nonNull)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
