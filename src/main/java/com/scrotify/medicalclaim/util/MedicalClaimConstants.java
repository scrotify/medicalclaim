package com.scrotify.medicalclaim.util;

public class MedicalClaimConstants {

    public static final String CLAIM_SUCCESS_REGISTER_MSG = "Successfully registered, Claim ID:";
    public static final int CLAIM_SUCCESS_REGISTER_STATUS_CODE = 200;
    public static final int CLAIM_REGISTER_FAILED_STATUS_CODE = 500;
    public static final String CLAIM_REGISTER_FAILED_MSG = "Failed to register claims";
    
    public static final String CLAIM_STATUS="Pending";
    public static final String CLAIM_REASON="No";
    public static final String CLAIM_APPROVER_ROLE="lEVEL1";
    
    public static final String CLAIM_SUCCESS_VALIDATE_MESSAGE="Request accepted";
    
    public static final String CLAIM_VALIDATE_POLICY_ID_FAILURE_MESSAGE= "You are not elegible for claim";
    public static final String CLAIM_VALIDATE_HOSPITAL_NOT_MATCHED_FAILURE_MESSAGE="Your hospital is not in the network";
    public static final String CLAIM_VALIDATE_HOSPITAL_EMPTY_FAILURE_MESSAGE="Your hospital field is empty";
    public static final String CLAIM_VALIDATE_AILMENT_NOT_MATCHED_FAILURE_MESSAGE="Your ailment is not under policy";
    public static final String CLAIM_VALIDATE_AILMENT_EMPTY_FAILURE_MESSAGE="Your aliment field is empty"; 
    public static final String CLAIM_VALIDATE_CLAIM_ID_FAILURE_MESSAGE="No value is present";
    
    public static final int CLAIM_SUCCESS_VALIDATE_REGISTER_STATUS_CODE=200;
    public static final int CLAIM_REGISTER_VALIDATE_FAILED_STATUS_CODE=404;

	public static final String CLAIM_PENDING_REGISTER_MSG = "Pending";
	public static final String POLICY_NOT_FOUND = "Policy not found";

	public final static String LOGIN_FAILURE = "Invalid Credentials";

	public final static String SUCCESS_MESSAGE = "Login Successful";

	public final static Integer SUCCESS_CODE = 200;

	public final static Integer INVALID_CODE = 401;
 	
	
	
   
}
