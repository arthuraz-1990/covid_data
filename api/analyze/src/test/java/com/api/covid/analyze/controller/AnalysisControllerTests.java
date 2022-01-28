package com.api.covid.analyze.controller;

import com.api.covid.analyze.dto.AnalysisDTO;
import com.api.covid.analyze.service.AnalysisService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author 12386616703
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class AnalysisControllerTests {
    
    static String API_ROUTE = "/api/analise";
    
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    AnalysisService service;
    
    private List<AnalysisDTO> list;
    
    @BeforeEach
    void prepareData() {
        this.list = Arrays.asList(
            new AnalysisDTO(), new AnalysisDTO(), new AnalysisDTO()
        );
    }
    
    @Test
    @DisplayName("Encontrar analises por data")
    public void findAnalysisByDateTest() throws Exception {
        String date = "2021-01-01";
        int page = 0;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.
                get(API_ROUTE).
                param("date", date).
                param("page", String.valueOf(page));
        
        this.loadItems(date, null, null, page);
        this.validateResponse(mockMvc.perform(request));
    }
    
    @Test
    @DisplayName("Encontrar analises por data e estado")
    public void findAnalysisByDateAndStateTest() throws Exception {
        String date = "2021-01-01";
        String state = "RJ";
        int page = 0;
        
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.
                get(API_ROUTE).
                param("date", date).
                param("state", state).
                param("page", String.valueOf(page));
        
        this.loadItems(date, state, null, page);
        this.validateResponse(mockMvc.perform(request));
    }
    
    @Test
    @DisplayName("Encontrar analises por data e cidade")
    public void findAnalysisByDateAndCityTest() throws Exception {
        String date = "2021-01-01";
        String state = "RJ";
        String city = "Niterói";
        int page = 0;
        
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.
                get(API_ROUTE).
                param("date", date).
                param("state", state).
                param("city", city).
                param("page", String.valueOf(page));
        this.loadItems(date, state, city, page);
        this.validateResponse(mockMvc.perform(request));
    }
    
    @Test
    @DisplayName("Encontrar analises por data e todos os estados")
    public void findAnalysisByDateAndStates() throws Exception {
        String date = "2021-01-01";
        int page = 0;
        
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.
                get(API_ROUTE.concat("/estados")).
                param("date", date).
                param("page", String.valueOf(page));
        BDDMockito.given(this.service.findAllStates(date, page)).willReturn(
            new PageImpl<>(this.list)
        );
        this.validateResponse(mockMvc.perform(request));
    }
    
    private void validateResponse(ResultActions performedRequest) throws Exception {
        performedRequest.andExpectAll(status().isOk(), 
                        jsonPath("content").isArray(), jsonPath("totalElements").isNumber(), jsonPath("size").isNumber());
    }
    
    private void loadItems(String date, String state, String city, int page) {
        BDDMockito.given(this.service.find(date, state, city, page)).willReturn(
            new PageImpl<>(this.list)
        );
    }
    
}
