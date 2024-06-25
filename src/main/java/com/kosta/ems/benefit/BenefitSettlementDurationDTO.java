package com.kosta.ems.benefit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BenefitSettlementDurationDTO {
    private int settlementDurationSeq;
    private LocalDate settlementDurationStartDate;
    private LocalDate settlementDurationEndDate;
    private int courseSeq;
    private String managerId;
    private int benefitSeq;
    private int trainingAidAmount;
    private int mealAidAmount;
    private int settlementAidAmount;
    private LocalDate benefitSettlementDate;
    private String studentId;


}
