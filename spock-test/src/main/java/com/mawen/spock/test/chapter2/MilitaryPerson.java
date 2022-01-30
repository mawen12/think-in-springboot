package com.mawen.spock.test.chapter2;

/**
 * 军人
 *
 * @author mawen
 * @create 2022-01-30 9:32
 */
public class MilitaryPerson {
    private String firstName;
    private String lastName;
    private String rank;

    public String createTitle() {
        return lastName + ", " + firstName + " (" + rank + ")";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
