package com.raghu.sample.repositories;

import com.raghu.sample.entities.EmbeddedTlineId;
import com.raghu.sample.entities.Tline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TlineRepository extends JpaRepository<Tline,EmbeddedTlineId> {

    Optional<Tline> findByIdLineNoAndIdLineSeqNo(Integer lineNo,Integer lineSeqNo);

    @Modifying
    @Query("delete from Tline t where t.id.lineNo = :lineNo and t.id.lineSeqNo = :lineSeqNo")
    void deleteLine(@Param("lineNo") Integer lineNo,@Param("lineSeqNo") Integer lineSeqNo);
}
