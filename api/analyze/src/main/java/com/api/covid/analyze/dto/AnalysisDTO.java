package com.api.covid.analyze.dto;

import com.api.covid.analyze.model.CovidInfo;

/**
 *
 * @author 12386616703
 */
public class AnalysisDTO {
    
    private double deathGrowth;
    private double casesGrowth;
    private CovidInfo fullInfo;

    public AnalysisDTO() {
    }
    
    public AnalysisDTO(CovidInfo fullInfo) {
        this.fullInfo = fullInfo;
    }

    public double getDeathGrowth() {
        return deathGrowth;
    }
    
    public double getCasesGrowth() {
        return casesGrowth;
    }

    public CovidInfo getFullInfo() {
        return fullInfo;
    }
    
}
