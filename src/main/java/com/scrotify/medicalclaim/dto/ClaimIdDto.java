package com.scrotify.medicalclaim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class ClaimIdDto {

    private Long claimId;

    private String status;

}
