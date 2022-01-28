package com.api.covid.analyze.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "casos_full")
public class CovidInfo implements Serializable {
    
    @Id
    private Integer id;
    private String city;
    private int cityIbgeCode;
    private Date dateInfo;
    private int epidemiologicalWeek;
    private int estimatedPopulation;
    @Column(name = "estimated_population_2019")
    private int estimatedPopulation2019;
    private boolean isLast;
    private boolean isRepeated;
    private int lastAvailableConfirmed;
    @Column(name = "last_available_confirmed_per_100k_inhabitants")
    private double lastAvailableConfirmedPer100kInhabitants;
    private Date lastAvailableDate;
    private double lastAvailableDeathRate;
    private int lastAvailableDeaths;
    private int orderForPlace;
    private String placeType;
    private String stateInfo;
    private int newConfirmed;
    private int newDeaths;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityIbgeCode() {
        return cityIbgeCode;
    }

    public void setCityIbgeCode(int cityIbgeCode) {
        this.cityIbgeCode = cityIbgeCode;
    }

    public Date getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(Date dateInfo) {
        this.dateInfo = dateInfo;
    }

    public int getEpidemiologicalWeek() {
        return epidemiologicalWeek;
    }

    public void setEpidemiologicalWeek(int epidemiologicalWeek) {
        this.epidemiologicalWeek = epidemiologicalWeek;
    }

    public int getEstimatedPopulation() {
        return estimatedPopulation;
    }

    public void setEstimatedPopulation(int estimatedPopulation) {
        this.estimatedPopulation = estimatedPopulation;
    }

    public int getEstimatedPopulation2019() {
        return estimatedPopulation2019;
    }

    public void setEstimatedPopulation2019(int estimatedPopulation2019) {
        this.estimatedPopulation2019 = estimatedPopulation2019;
    }

    public boolean isIsLast() {
        return isLast;
    }

    public void setIsLast(boolean isLast) {
        this.isLast = isLast;
    }

    public boolean isIsRepeated() {
        return isRepeated;
    }

    public void setIsRepeated(boolean isRepeated) {
        this.isRepeated = isRepeated;
    }

    public int getLastAvailableConfirmed() {
        return lastAvailableConfirmed;
    }

    public void setLastAvailableConfirmed(int lastAvailableConfirmed) {
        this.lastAvailableConfirmed = lastAvailableConfirmed;
    }

    public double getLastAvailableConfirmedPer100kInhabitants() {
        return lastAvailableConfirmedPer100kInhabitants;
    }

    public void setLastAvailableConfirmedPer100kInhabitants(double lastAvailableConfirmedPer100kInhabitants) {
        this.lastAvailableConfirmedPer100kInhabitants = lastAvailableConfirmedPer100kInhabitants;
    }

    public Date getLastAvailableDate() {
        return lastAvailableDate;
    }

    public void setLastAvailableDate(Date lastAvailableDate) {
        this.lastAvailableDate = lastAvailableDate;
    }

    public double getLastAvailableDeathRate() {
        return lastAvailableDeathRate;
    }

    public void setLastAvailableDeathRate(double lastAvailableDeathRate) {
        this.lastAvailableDeathRate = lastAvailableDeathRate;
    }

    public int getLastAvailableDeaths() {
        return lastAvailableDeaths;
    }

    public void setLastAvailableDeaths(int lastAvailableDeaths) {
        this.lastAvailableDeaths = lastAvailableDeaths;
    }

    public int getOrderForPlace() {
        return orderForPlace;
    }

    public void setOrderForPlace(int orderForPlace) {
        this.orderForPlace = orderForPlace;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CovidInfo other = (CovidInfo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
