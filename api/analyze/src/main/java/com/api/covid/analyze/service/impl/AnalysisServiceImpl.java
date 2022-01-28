package com.api.covid.analyze.service.impl;

import com.api.covid.analyze.dto.AnalysisDTO;
import com.api.covid.analyze.model.CovidInfo;
import com.api.covid.analyze.service.AnalysisService;
import com.api.covid.analyze.repository.CovidInfoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author 12386616703
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {
    
    private CovidInfoRepository repository;
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    private final int pageSize = 25;

    public AnalysisServiceImpl(CovidInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<AnalysisDTO> find(String date, String state, String city, int page) {
        return null;
    }

    @Override
    public Page<AnalysisDTO> findAllStates(String date, int page) {
        Page<CovidInfo> dbInfo = this.repository.findAllStatesByDate(this.getParsedDate(date), PageRequest.of(page, pageSize));
        return this.convertToDto(dbInfo);
    }
    
    private Date getParsedDate(String date) {
        // Tentando converter a data...
        try {
            return this.sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(AnalysisServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException("Data com formato inválido: " + date);
        }
    }
    
    
    private Page<AnalysisDTO> convertToDto(Page<CovidInfo> result) {
        return result.map(info -> new AnalysisDTO(info));
    }
    
}
