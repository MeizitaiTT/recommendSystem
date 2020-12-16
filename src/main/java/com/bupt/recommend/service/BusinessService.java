package com.bupt.recommend.service;

import com.bupt.recommend.DTO.BusinessDTO;

import java.util.List;

public interface BusinessService {
    List<BusinessDTO> getTopBusiness(int start,int count) throws Exception;
    List<String> getBusinessCity() throws Exception;
    List<String> getBusinessState() throws Exception;
    List<BusinessDTO> getBusinessByCondition(Integer reviewCountMin, Integer reviewCountMax, String city, String state,
                                             Integer stars, int start, int count) throws Exception;
    int countBusinessByConditions(Integer reviewCountMin, Integer reviewCountMax, String city, String state,
                                Integer stars) throws Exception;
    List<BusinessDTO> selectLongtitudeLatitude() throws Exception;
    List<BusinessDTO> getRandBusiness(int start,int count) throws Exception;
}
