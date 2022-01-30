package com.mawen.spock.test.chapter1.invoice

import spock.lang.Specification

/**
 * 发票邮箱测试
 */
class InvoiceMailingTest extends Specification {

    def "将电子发票发送到指定的邮箱"() {
        given: "一个发票、一位消费者，一个邮件服务和打印服务"
        def printerService = Mock(PrinterService)
        def emailService = Mock(EmailService)
        def customer = new Customer()
        def finalInvoiceStep = new FinalInvoiceStep(printerService, emailService)
        def invoice = new Invoice()

        when: "提供了邮箱的消费者"
        customer.hasEmail("acme@example.com")
        finalInvoiceStep.handleInvoice(invoice, customer)

        then: "不会打印任何东西，只会发送邮件"
        0 * printerService.printInvoice(invoice)
        1 * emailService.sendInvoice(invoice, "acme@example.com")
    }

}
