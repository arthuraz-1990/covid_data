package com.api.covid.analyze.repository;

import com.api.covid.analyze.dto.AnalysisDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.covid.analyze.model.CovidInfo;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 12386616703
 */
public interface CovidInfoRepository extends JpaRepository<CovidInfo, Long> {

    @Query("SELECT info FROM CovidInfo info WHERE info.dateInfo = ?1 AND info.placeType = 'state'")
    public Page<CovidInfo> findAllStatesByDate(Date date, Pageable page);
    
}
