package com.bupt.recommend.service.impl;

import com.bupt.recommend.DAO.BusinessPOMapper;
import com.bupt.recommend.DAO.PO.BusinessPO;
import com.bupt.recommend.DTO.BusinessDTO;
import com.bupt.recommend.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessPOMapper businessPOMapper;
    @Override
    public List<BusinessDTO> getTopBusiness(int start,int count) throws Exception {
        List<BusinessPO> businessPOList = businessPOMapper.selectTopBusiness(start,count);
        List<BusinessDTO> businessDTOList = new ArrayList<>();
        for(BusinessPO businessPO:businessPOList){
            BusinessDTO businessDTO = businessPoToDTO(businessPO);
            businessDTOList.add(businessDTO);
        }
        return businessDTOList;
    }

    @Override
    public List<String> getBusinessCity() throws Exception {
        return businessPOMapper.selectBusinessCity();
    }

    @Override
    public List<String> getBusinessState() throws Exception {
        return businessPOMapper.selectBusinessState();
    }

    @Override
    public List<BusinessDTO> getBusinessByCondition(Integer reviewCountMin, Integer reviewCountMax, String city, String state, Integer stars, int start, int count) throws Exception {
        List<BusinessPO> businessPOList = businessPOMapper.selectBusinessByCondition(reviewCountMin,reviewCountMax,city,state,stars,start,count);
        List<BusinessDTO> businessDTOList = new ArrayList<>();
        for(BusinessPO businessPO:businessPOList){
            BusinessDTO businessDTO = businessPoToDTO(businessPO);
            businessDTOList.add(businessDTO);
        }
        return businessDTOList;
    }

    @Override
    public int countBusinessByConditions(Integer reviewCountMin, Integer reviewCountMax, String city, String state, Integer stars) throws Exception {
        return businessPOMapper.countBusinessByCondition(reviewCountMin, reviewCountMax, city, state, stars);
    }

    @Override
    public List<BusinessDTO> selectLongtitudeLatitude() throws Exception {
        List<BusinessPO> businessPOList = businessPOMapper.selectLongtitdeLatitdude();
        List<BusinessDTO> businessDTOList = new ArrayList<>();
        for(BusinessPO businessPO:businessPOList){
            BusinessDTO businessDTO = businessPoToDTO(businessPO);
            businessDTOList.add(businessDTO);
        }
        return businessDTOList;
    }

    public BusinessDTO businessPoToDTO(BusinessPO businessPO){
        BusinessDTO businessDTO = new BusinessDTO();
        businessDTO.setId(businessPO.getId());
        businessDTO.setBusinessId(businessPO.getBusinessId());
        businessDTO.setFullAddress(businessPO.getFullAddress());
        businessDTO.setOpen(businessPO.getOpen());
        businessDTO.setCategories(businessPO.getCategories());
        businessDTO.setCity(businessPO.getCity());
        businessDTO.setName(businessPO.getName());
        businessDTO.setLongitude(businessPO.getLongitude());
        businessDTO.setLatitude(businessPO.getLatitude());
        businessDTO.setStars(businessPO.getStars());
        businessDTO.setState(businessPO.getState());
        businessDTO.setReviewCount(businessPO.getReviewCount());
        return  businessDTO;
    }
}
