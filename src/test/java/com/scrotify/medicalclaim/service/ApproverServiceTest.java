package com.scrotify.medicalclaim.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.scrotify.medicalclaim.dto.ApproverResponseDto;
import com.scrotify.medicalclaim.entity.Approver;
import com.scrotify.medicalclaim.repository.ApproverRepository;
import com.scrotify.medicalclaim.repository.ClaimRepository;
import com.scrotify.medicalclaim.repository.ClaimRequestRepository;
import com.scrotify.medicalclaim.repository.PolicyDetailRepository;
import com.scrotify.medicalclaim.util.MedicalClaimConstants;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ApproverServiceTest {
	
	@InjectMocks
	ApproverServiceImpl approverServiceImpl;
	
	@Mock
	ApproverRepository approverRepository;

	@Mock
	ClaimRequestRepository claimRequestRepository;
	
	@Mock
	ClaimRepository claimRepository;
	
	@Mock
	PolicyDetailRepository policyDetailRepository;
	
	@Test
	public void testLoginApprover() {
		ApproverResponseDto approverResponseDto = new ApproverResponseDto();
		approverResponseDto.setApproverId(1L);
		approverResponseDto.setApproverName("xyz");
		approverResponseDto.setApproverRole("level1");
		approverResponseDto.setMessage(MedicalClaimConstants.SUCCESS_MESSAGE);
		approverResponseDto.setStatusCode(MedicalClaimConstants.SUCCESS_CODE);
		
		Approver approver = new Approver();
	}


}
