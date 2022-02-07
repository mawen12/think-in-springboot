package com.mawen.spock.test.chapter2;

/**
 * @author mawen
 * @create 2022-01-30 9:33
 */
public class Stamper {

    private final AddressDao addressDao;

    public Stamper(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public boolean isValid(Long addressId) {
        Address address = addressDao.load(addressId);
        return address.getStreet() != null && address.getPostCode() != null;
    }
}
