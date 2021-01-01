package com.raghu.sample.services;

import com.raghu.sample.entities.Tline;
import com.raghu.sample.repositories.TlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LineService {

    @Autowired
    TlineRepository lineRepository;

    public Optional<Tline> findByLineAndLineSeqNo(Integer lineNo,Integer lineSeqNo){
        return lineRepository.findByIdLineNoAndIdLineSeqNo(lineNo,lineSeqNo);
    }

    public Tline createLine(Tline line){
        return lineRepository.saveAndFlush(line);
    }

    public Optional<Tline> updateLine(Integer lineNo,Integer lineSeqNo,Tline line){
        Optional<Tline> optTline = findByLineAndLineSeqNo(lineNo,lineSeqNo);
        if(optTline.isPresent()){
            Tline lineUpd = optTline.get();
            lineUpd.setSampleDate(line.getSampleDate());
            return Optional.of(lineRepository.saveAndFlush(lineUpd));
        }
        return Optional.empty();
    }

    public void deleteLine(Integer lineNo, Integer lineSeqNo){
        lineRepository.deleteLine(lineNo,lineSeqNo);
    }
}
