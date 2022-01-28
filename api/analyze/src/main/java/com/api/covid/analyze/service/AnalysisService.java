package com.api.covid.analyze.service;

import com.api.covid.analyze.dto.AnalysisDTO;
import org.springframework.data.domain.Page;

/**
 *
 * @author 12386616703
 */
public interface AnalysisService {
    
    Page<AnalysisDTO> find(String date, String state, String city, int page);
    
    Page<AnalysisDTO> findAllStates(String date, int page);
}
