package com.scrotify.medicalclaim.exception;

import com.scrotify.medicalclaim.entity.PolicyDetail;

import java.util.function.Supplier;

/**
 * @author Mahendran
 */
public class PolicyNotFoundException extends Exception implements Supplier<PolicyDetail> {

    public PolicyNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public PolicyDetail get() {
        return new PolicyDetail();
    }
}
