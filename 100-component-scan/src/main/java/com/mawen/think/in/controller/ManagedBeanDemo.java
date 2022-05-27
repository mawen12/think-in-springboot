package com.mawen.think.in.controller;

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

import javax.annotation.ManagedBean;
import java.lang.annotation.Annotation;

/**
 * 被 @ManagedBean 标注的类也是被会Spring管理的
 *
 * @see {@link ClassPathScanningCandidateComponentProvider#registerDefaultFilters()}
 */
@ManagedBean
public class ManagedBeanDemo{

    public void print() {
        System.out.println("This is ManagedBeanDemo");
    }
}
