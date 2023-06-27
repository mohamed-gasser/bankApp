package com.ClientService.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Setter
@Getter

public class certiDto {

    private String name;
    private Long years;
    private Long profit;
    private Long price;
    private Long update_id;
    //private Boolean deleted;
    private String operation ;


    @Override
    public String toString() {
        return "certiDto{" +
                "name='" + name + '\'' +
                ", years=" + years +
                ", profit=" + profit +
                ", price=" + price +
                '}';
    }
}
