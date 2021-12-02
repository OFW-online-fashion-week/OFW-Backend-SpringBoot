package com.ofw.ofw.service.email;

import com.ofw.ofw.entity.brand.Brand;

public interface EmailService {

    void sendBrandConfirmForm(String brandId);

    void sendNewCollectionNoticeForm(Brand brand);
}
