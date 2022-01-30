package com.mawen.spock.test.chapter1.invoice;

/**
 * 顾客
 *
 * @author mawen
 * @create 2022-01-29 14:40
 */
public class Customer {

    private String email = "";

    public String getEmail() {
        return email;
    }

    public void hasEmail(String emailAddress) {
        this.email = emailAddress;
    }
}
