package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Number {

    @Id
    private Integer id;

    @Column(name = "first_number")
    private Double first_number;

    @Column(name = "operator")
    private String operator;

    @Column(name = "second_number")
    private Double second_number;

    @Column(name = "calculated_result")
    private Double calculated_result;



}
