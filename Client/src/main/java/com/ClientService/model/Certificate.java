package com.ClientService.model;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Data
@Entity
@Table(name="certification")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Long years;
    @Column
    private Long profit;
    @Column
    private Long price;
    public Certificate(Long id, String name, Long years, Long profit, Long price) {
        this.id = id;
        this.name = name;
        this.years = years;
        this.profit = profit;
        this.price = price;

    }

}
