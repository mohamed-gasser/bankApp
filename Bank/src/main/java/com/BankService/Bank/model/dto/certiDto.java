package com.BankService.Bank.model.dto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class certiDto {
    private String name;
    private Long years;
    private Long profit;
    private Long price;
    //boolean deleted;
    private String operation;
}
