package com.scrotify.medicalclaim.service;

import java.util.List;

import com.scrotify.medicalclaim.dto.ApproverDto;
import com.scrotify.medicalclaim.dto.ApproverResponseDto;
import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.exception.ApproverNotFound;

public interface ApproverService {
	
	public ApproverResponseDto loginApprover(ApproverDto approverDto) throws ApproverNotFound;
	public List<ClaimRequestResponseDto> getByApproverId(Long approverId) throws ApproverNotFound;

}
