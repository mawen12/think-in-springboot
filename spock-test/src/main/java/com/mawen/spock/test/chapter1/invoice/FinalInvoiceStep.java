package com.mawen.spock.test.chapter1.invoice;

/**
 * 生成发票的步骤
 *
 * @author mawen
 * @create 2022-01-29 14:47
 */
public class FinalInvoiceStep {

    private final PrinterService printerService;

    private final EmailService emailService;

    public FinalInvoiceStep(PrinterService printerService, EmailService emailService) {
        this.printerService = printerService;
        this.emailService = emailService;
    }

    public void handleInvoice(Invoice invoice, Customer customer) {
        String email = customer.getEmail();
        if (email.isEmpty()) {
            printerService.printInvoice(invoice);
        } else {
            emailService.sendInvoice(invoice, email);
        }
    }
}
