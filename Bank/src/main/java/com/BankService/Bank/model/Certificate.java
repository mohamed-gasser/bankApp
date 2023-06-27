package com.BankService.Bank.model;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Certificate {

    private String name;
    private Long years;
    private Long profit;
    private Long price;
    private Long update_id;
    //private Boolean deleted=false;
    private String operation ="pos";

    @Override
    public String toString() {
        return "Certificate{" +
                "name='" + name + '\'' +
                ", years=" + years +
                ", profit=" + profit +
                ", price=" + price +
                '}';
    }
}
