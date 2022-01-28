package com.api.covid.analyze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.covid.analyze.model.CovidInfo;

/**
 *
 * @author 12386616703
 */
public interface CovidInfoRepository extends JpaRepository<CovidInfo, Long>{
    
}
