package com.scrotify.medicalclaim.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.medicalclaim.dto.ApproverDto;
import com.scrotify.medicalclaim.dto.ApproverResponseDto;
import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.entity.Approver;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.ClaimRequest;
import com.scrotify.medicalclaim.exception.ApproverNotFound;
import com.scrotify.medicalclaim.repository.ApproverRepository;
import com.scrotify.medicalclaim.repository.ClaimRepository;
import com.scrotify.medicalclaim.repository.ClaimRequestRepository;
import com.scrotify.medicalclaim.repository.PolicyDetailRepository;
import com.scrotify.medicalclaim.util.MedicalClaimConstants;

@Service
public class ApproverServiceImpl implements ApproverService {

	@Autowired
	ApproverRepository approverRepository;

	@Autowired
	ClaimRequestRepository claimRequestRepository;
	
	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	PolicyDetailRepository policyDetailRepository;

	@Override
	public ApproverResponseDto loginApprover(ApproverDto approverDto) throws ApproverNotFound {
		ApproverResponseDto approverResponseDto = new ApproverResponseDto();
		Optional<Approver> approver = approverRepository.findByApproverEmail(approverDto.getApproverEmail());
		if (approver.isPresent()) {
			if (approver.get().getApproverEmail().equals(approverDto.getApproverEmail())
					&& approver.get().getApproverPassword().equals(approverDto.getApproverPassword())) {
				approverResponseDto.setApproverId(approver.get().getApproverId());
				approverResponseDto.setApproverName(approver.get().getApproverName());
				approverResponseDto.setApproverRole(approver.get().getApproverRole());
				approverResponseDto.setStatusCode(MedicalClaimConstants.SUCCESS_CODE);
				approverResponseDto.setMessage(MedicalClaimConstants.SUCCESS_MESSAGE);
			} else {
				approverResponseDto.setStatusCode(MedicalClaimConstants.INVALID_CODE);
				approverResponseDto.setMessage(MedicalClaimConstants.LOGIN_FAILURE);
			}

		} else {
			throw new ApproverNotFound("Approver Not Found");
		}
		return approverResponseDto;

	}

	@Override
	public List<ClaimRequestResponseDto> getByApproverId(Long approverId) throws ApproverNotFound {
		ClaimRequestResponseDto claimRequestResponseDto = null;
		Optional<Approver> approver = approverRepository.findByApproverId(approverId);
		List<ClaimRequestResponseDto> listofRequest = new ArrayList<>();
		if (approver.isPresent()) {
			List<ClaimRequest> claimRequest = claimRequestRepository
					.findAllByApproverRole(approver.get().getApproverRole());
			for (ClaimRequest claimList : claimRequest) {
				Optional<Claim> claim=claimRepository.findByClaimId(claimList.getClaimId());
				claimRequestResponseDto = new ClaimRequestResponseDto();
				claimRequestResponseDto.setClaimRequestId(claimList.getClaimRequestId());
				claimRequestResponseDto.setClaimId(claimList.getClaimId());
				claimRequestResponseDto.setHospitalName(claim.get().getHospitalDetails());
				claimRequestResponseDto.setDiagnosis(claim.get().getDiagnosis());
				claimRequestResponseDto.setPolicyId(claim.get().getPolicyId());
				claimRequestResponseDto.setPolicyHolderName(claim.get().getName());
				claimRequestResponseDto.setTotalClaimAmount(claim.get().getTotalClaimAmount());
				claimRequestResponseDto.setClaimStatus(claimList.getClaimStatus());
				BeanUtils.copyProperties(claimList, claimRequestResponseDto);
				listofRequest.add(claimRequestResponseDto);
			}
		} else {
			throw new ApproverNotFound("Approver Not Found");
		}

		return listofRequest;
	}

}
