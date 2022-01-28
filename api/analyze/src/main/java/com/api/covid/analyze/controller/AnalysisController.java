package com.api.covid.analyze.controller;

import com.api.covid.analyze.dto.AnalysisDTO;
import com.api.covid.analyze.service.AnalysisService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 12386616703
 */
@RestController
@RequestMapping("/api/analise")
public class AnalysisController {
    
    private AnalysisService service;

    public AnalysisController(AnalysisService service) {
        this.service = service;
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<AnalysisDTO> findAnalysis(
        @RequestParam(required = true) String date, 
        @RequestParam(required = false) String state, 
        @RequestParam(required = false) String city, 
        @RequestParam(required = true) int page) {
        Page<AnalysisDTO> response = this.service.find(date, state, city, page);
        return response;
    }
    
    @GetMapping(path = "/estados", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<AnalysisDTO> findAnalysisAllStates(
        @RequestParam(required = true) String date,
        @RequestParam(required = true) int page
    ) {
        Page<AnalysisDTO> response = this.service.findAllStates(date, page);
        return response;
    }
}
