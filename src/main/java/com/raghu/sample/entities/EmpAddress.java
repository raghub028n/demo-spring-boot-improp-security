package com.raghu.sample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAddress")
public class EmpAddress {

    @Id
    private Long id;

    @Column
    private Long employeeId;

    @Column
    private String addressLn1;

    @Column
    private String addressLn2;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId", insertable = false, updatable = false)
    private Employee employee;
}
