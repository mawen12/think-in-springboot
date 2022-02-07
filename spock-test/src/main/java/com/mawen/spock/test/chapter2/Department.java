package com.mawen.spock.test.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门
 *
 * @author mawen
 * @create 2022-01-30 9:24
 */
public class Department {

    private List<Employee> currentStaff = new ArrayList<>();

    public void assign(List<Employee> staff) {
        for (Employee employee : staff) {
            if (employee.isRetired()) {
                throw new IllegalArgumentException("Cannot assign a retired person");
            }
            currentStaff.add(employee);
        }
    }

    public int manpowerCount() {
        return currentStaff.size();
    }

}
