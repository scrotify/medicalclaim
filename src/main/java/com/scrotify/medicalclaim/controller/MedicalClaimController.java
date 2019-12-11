package com.scrotify.medicalclaim.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.exception.ClaimIdNotFoundException;
import com.scrotify.medicalclaim.service.ClaimService;

@RestController
@RequestMapping("/claims")
public class MedicalClaimController {


    private static Log logger = LogFactory.getLog(MedicalClaimController.class);

    @Autowired
    private ClaimService claimService;


//    @PostMapping
//    public ResponseEntity postClaims(@RequestBody ClaimDto claimDto) {
//        logger.info("Enter into post claims method");
//        Claim claimEntity = new Claim();
//        BeanUtils.copyProperties(claimDto, claimEntity);
//        ApiResponse response = claimService.postClaims(claimEntity);
//        logger.info("End of post claims method, response :" + response );
//        return new ResponseEntity(response, HttpStatus.CREATED);
//    }
    
    @PostMapping("/{claimId}/validate")
//    @Scheduled(fixedRate = 60000)
    public ClaimRequestResponseDto validateClaims(@PathVariable Long claimId) throws ClaimIdNotFoundException {
    	ClaimRequestResponseDto ClaimRequestResponseDto=claimService.validateUser(claimId);
        return ClaimRequestResponseDto;
    }

}
