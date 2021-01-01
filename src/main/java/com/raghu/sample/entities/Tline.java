package com.raghu.sample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TLINE")
public class Tline implements Serializable{

    @EmbeddedId
    private EmbeddedTlineId id;

    @Column
    private String sampleDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date insDate;
}
