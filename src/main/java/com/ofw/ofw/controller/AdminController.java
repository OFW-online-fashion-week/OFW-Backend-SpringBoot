package com.ofw.ofw.controller;

import com.ofw.ofw.payload.admin.response.AdminBrandDetailResponse;
import com.ofw.ofw.payload.admin.response.AdminBrandListResponse;
import com.ofw.ofw.service.admin.AdminService;
import com.ofw.ofw.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final EmailService emailService;

    @GetMapping
    public AdminBrandListResponse adminBrandList() {
        AdminBrandListResponse response = adminService.getBrandList();
        return response;
    }

    @GetMapping("/{id}")
    public AdminBrandDetailResponse adminBrandDetail(@PathVariable("id") String brandId) {
        return adminService.getBrandDetail(brandId);
    }

    @PostMapping("/{id}")
    public String adminAcceptBrand(@PathVariable("id") String brandId) {
        adminService.acceptBrand(brandId);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String adminRejectBrand(@PathVariable("id") String brandId) {
        adminService.rejectBrand(brandId);
        return "success";
    }

    @GetMapping("/email/{id}")
    public void adminEmailBrand(@PathVariable("id") String brandId) {
        emailService.sendBrandConfirmForm(brandId);
        adminService.setTimeToLiveThree(brandId);
    }
}
