package com.raghu.sample.api;

import com.raghu.sample.entities.Tline;
import com.raghu.sample.services.LineService;
import com.raghu.sample.utils.ExternalAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@ExternalAPI
public class LineController {

    @Autowired
    LineService lineService;

    @GetMapping(value = "/line/{lineNo}/{lineSeqNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getLineInformation(@PathVariable(value = "lineNo", required = true) int lineNo, @PathVariable(value = "lineSeqNo", required = true) int lineSeqNo) {
        Optional<Tline> line = lineService.findByLineAndLineSeqNo(lineNo, lineSeqNo);
        if (line.isPresent()) {
            return ResponseEntity.ok(line.get());
        } else {
            return new ResponseEntity("NotFound", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/line", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createLine(@RequestBody Tline line) {

        Optional<Tline> Optline = Optional.of(lineService.createLine(line));
        if (Optline.isPresent()) {
            return new ResponseEntity("Created", HttpStatus.CREATED);
        }
        return new ResponseEntity("Error in creating Line", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(value = "/line/{lineNo}/{lineSeqNo}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateLine(@PathVariable(value = "lineNo", required = true) int lineNo, @PathVariable(value = "lineSeqNo", required = true) int lineSeqNo, @RequestBody Tline line) {

        Optional<Tline> optLine = lineService.updateLine(lineNo,lineSeqNo,line);
        if(optLine.isPresent()){
            return new ResponseEntity("Updated",HttpStatus.OK);
        }
        return new ResponseEntity("Not Found ",HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/line/{lineNo}/{lineSeqNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteLineInformation(@PathVariable(value = "lineNo", required = true) int lineNo, @PathVariable(value = "lineSeqNo", required = true) int lineSeqNo) {
        lineService.deleteLine(lineNo, lineSeqNo);
        return new ResponseEntity("Deleted", HttpStatus.OK);
    }
}
