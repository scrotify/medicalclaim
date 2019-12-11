package com.scrotify.medicalclaim.controller;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.dto.ClaimDto;
import com.scrotify.medicalclaim.dto.ClaimIdDto;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.service.ClaimService;
import com.scrotify.medicalclaim.service.ClaimServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
  import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.exception.ClaimIdNotFoundException;
import com.scrotify.medicalclaim.service.ClaimService;

@RestController
@RequestMapping("/claims")
@CrossOrigin
public class MedicalClaimController {


    private static Log logger = LogFactory.getLog(MedicalClaimController.class);

    @Autowired
    private ClaimServiceImpl claimService;

     @PostMapping
    public ResponseEntity postClaims(@RequestBody ClaimDto claimDto) {
        logger.info("Enter into post claims method");
        Claim claimEntity = new Claim();
        BeanUtils.copyProperties(claimDto, claimEntity);
        ApiResponse response = claimService.postClaims(claimEntity);
        logger.info("End of post claims method, response :" + response );
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    
    @PostMapping("/{claimId}/validate")
//    @Scheduled(fixedRate = 60000)
    public ClaimRequestResponseDto validateClaims(@PathVariable Long claimId) throws ClaimIdNotFoundException {
    //public ClaimRequestResponseDto validateClaims(@PathVariable Long claimId) throws ClaimIdNotFoundException {
    	ClaimRequestResponseDto ClaimRequestResponseDto=claimService.validateUser(claimId);
        return ClaimRequestResponseDto;
     }

  
    /**
     * Gets all claims.
     *
     * @return the all claims
     */
    @GetMapping
    public ResponseEntity<List<ClaimDto>> getAllClaims() {
    List<ClaimDto> claimDtos = new ArrayList<ClaimDto>();
    logger.info("Enter into get all claims method");
    List<Claim> claimsEntites = claimService.getAllClaims();
    if(Optional.ofNullable(claimsEntites).isPresent()) {
    claimDtos = claimsEntites.stream().map(entity -> {
    ClaimDto claimDto = new  ClaimDto();
    BeanUtils.copyProperties(entity, claimDto);
    claimDto.setPolicyId(entity.getPolicyDetail().getPolicyId());
    return claimDto;
      }).collect(Collectors.toList());
    }
      return new ResponseEntity(claimDtos, HttpStatus.OK);
    } 
    
    
    @GetMapping("/{claimId}")
    public ResponseEntity<ClaimDto> getClaimsById(@PathVariable Long claimId) {
    	ClaimDto claimDto = new ClaimDto();
    	logger.info("Enter into get claims method");
        Claim claim = claimService.getClaimById(claimId);
        if (Optional.ofNullable(claim).isPresent()) { 
        BeanUtils.copyProperties(claim, claimDto);
        claimDto.setPolicyId(claim.getPolicyDetail().getPolicyId());
        logger.info("End of get claims method");
        } else {
        	logger.info("Claim ID is not found");
        }
        return new ResponseEntity(claimDto, HttpStatus.OK);
    }
    
}
