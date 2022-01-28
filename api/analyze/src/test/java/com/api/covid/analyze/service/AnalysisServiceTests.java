package com.api.covid.analyze.service;

import com.api.covid.analyze.dto.AnalysisDTO;
import com.api.covid.analyze.service.impl.AnalysisServiceImpl;
import com.api.covid.analyze.repository.CovidInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author 12386616703
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class AnalysisServiceTests {
    
    @MockBean
    CovidInfoRepository repository;
    
    AnalysisService service;
    
    @BeforeEach
    public void setUp() {
        this.service = new AnalysisServiceImpl(repository);
    }
    
    @Test
    @DisplayName("Deve retornar os dados para um determinado dia")
    public void findByDayTest() {
        final String date = "2021-01-01";
        Page<AnalysisDTO> result = this.service.find(date, null, null, 0);
       
        assertThat(result.getTotalElements()).isPositive();
        assertThat(result.getContent()).isNotEmpty();
    }
    
    @Test
    @DisplayName("Deve lançar erro no formato da data")
    public void errorDateFormatTest() {
        final String date = "2021-abc-abc";
        
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            this.service.find(date, null, null, 0);
        });
        
        String expected = "formato inválido";
        
        assertTrue(ex.getMessage().contains(expected));
    }
    
    @Test
    @DisplayName("Deve lançar erro por falta da data")
    public void errorDateRequiredTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            this.service.find(null, null, null, 0);
        });
        
        String expected = "parâmetro obrigatório";
        
        assertTrue(ex.getMessage().contains(expected));
    }
    
    @Test
    @DisplayName("Deve retornar os dados para um determinado dia e cidade")
    public void findByDayAndCityTest() {
        final String date = "2021-01-01";
        final String city = "Niterói";
        Page<AnalysisDTO> result = this.service.find(date, null, city, 0);
       
        assertThat(result.getTotalElements()).isPositive();
        assertThat(result.getContent()).isNotEmpty();
    }
    
    @Test
    @DisplayName("Deve retornar todas os dados para um determinado dia e tipo de dado - estados")
    public void findByDayAndTypeTest() {
        final String date = "2021-01-01";
        Page<AnalysisDTO> result = this.service.findAllStates(date, 0);
       
        assertThat(result.getTotalElements()).isPositive();
        assertThat(result.getContent()).isNotEmpty();
    }
    
    
    
}
