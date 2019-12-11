package com.scrotify.medicalclaim.controller;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.dto.ClaimDto;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.service.ClaimService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claims")
public class MedicalClaimController {


    private static Log logger = LogFactory.getLog(MedicalClaimController.class);

    @Autowired
    private ClaimService claimService;


    @PostMapping
    public ResponseEntity postClaims(@RequestBody ClaimDto claimDto) {
        logger.info("Enter into post claims method");
        Claim claimEntity = new Claim();
        BeanUtils.copyProperties(claimDto, claimEntity);
        ApiResponse response = claimService.postClaims(claimEntity);
        logger.info("End of post claims method, response :" + response );
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
