package com.raghu.sample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "TEMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column
    private String empId;

    private String empName;

    private String phoneNumber;

    private BigDecimal height;

    private BigDecimal weight;

    private String bloodGroup;

    private String gender;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<EmpAddress> address;
}
