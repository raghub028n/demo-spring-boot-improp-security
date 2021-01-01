package com.raghu.sample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EmbeddedTlineId implements Serializable{

    @Column
    private Integer lineNo;

    @Column
    private Integer lineSeqNo;
}
