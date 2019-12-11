package com.scrotify.medicalclaim.controller;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.dto.ClaimDto;
import com.scrotify.medicalclaim.dto.ClaimIdDto;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.service.ClaimService;
import com.scrotify.medicalclaim.service.ClaimServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
public class MedicalClaimController {


    private static Log logger = LogFactory.getLog(MedicalClaimController.class);

    @Autowired
    private ClaimServiceImpl claimService;

    @PostMapping
    public ResponseEntity<ApiResponse> postClaims(@RequestBody ClaimDto claimDto) {
        logger.info("Enter into post claims method");
        Claim claimEntity = new Claim();
        BeanUtils.copyProperties(claimDto, claimEntity);
        ApiResponse response = claimService.postClaims(claimEntity);
        logger.info("End of post claims method, response :" + response );
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/{claimId}")
    public ResponseEntity<ClaimDto> getClaimsById(@PathVariable Long claimId) {
        logger.info("Enter into get claims method");
        Claim claim = claimService.getClaimById(claimId);
        ClaimDto claimDto = new ClaimDto();
        BeanUtils.copyProperties(claim, claimDto);
        claimDto.setPolicyId(claim.getPolicyDetail().getPolicyId());
        logger.info("End of get claims method");
        return new ResponseEntity<>(claimDto, HttpStatus.OK);
    }
}
