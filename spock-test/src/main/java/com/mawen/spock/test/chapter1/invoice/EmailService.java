package com.mawen.spock.test.chapter1.invoice;

/**
 * 邮件服务
 *
 * @author mawen
 * @create 2022-01-29 14:41
 */
public interface EmailService {
    void sendInvoice(Invoice invoice, String email);

}
