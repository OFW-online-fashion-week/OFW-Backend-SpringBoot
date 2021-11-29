package com.ofw.ofw.service.email;

public interface EmailService {

    void sendBrandConfirmForm(String brandId);

    void sendNewCollectionNoticeForm(Long brandId);
}
