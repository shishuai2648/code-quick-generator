package com.person.quick.processor;

import com.baomidou.dynamic.datasource.processor.DsProcessor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author shishuai04
 */
public class DataSourceProcessor extends DsProcessor {

    @Override
    public boolean matches(String s) {
        return true;
    }

    @Override
    public String doDetermineDatasource(MethodInvocation methodInvocation, String s) {
        Object[] arguments = methodInvocation.getArguments();
        return String.valueOf(arguments[0]);
    }
}
