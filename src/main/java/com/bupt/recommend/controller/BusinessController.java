package com.bupt.recommend.controller;

import com.bupt.recommend.DTO.BusinessDTO;
import com.bupt.recommend.common.ResultBean;
import com.bupt.recommend.service.BusinessService;
import com.bupt.recommend.vo.BusinessCityRespVo;
import com.bupt.recommend.vo.BusinessRespVO;
import com.bupt.recommend.vo.BusinessStateRespVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessController {
    private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);
    @Autowired
    BusinessService businessService;

    @RequestMapping("/business/topBusiness")
    public ResultBean<BusinessRespVO> getTopBusiness(@RequestParam(value = "start", required = true) int start,
                                                     @RequestParam(value = "count", required = true) int count) {
        logger.info("getTopBusiness: start {}, count {}", start, count);
        try {
            BusinessRespVO businessRespVO = new BusinessRespVO();
            businessRespVO.setBusinessDTOList(businessService.getTopBusiness(start, count));
            businessRespVO.setStart(start);
            businessRespVO.setCount(count);
            businessRespVO.setTotal(250);
            return new ResultBean<>(businessRespVO);
        } catch (Exception e) {
            logger.warn("getTopMovies exception: start {}, count {}", start, count, e);
            return new ResultBean<>(e);
        }
    }

    @RequestMapping("/business/businessCity")
    public ResultBean<List<String>> getBusinessCity() {
        logger.info("getBusinessCity");
        try {
            ResultBean<List<String>> ResultBean = new ResultBean<>();
            ResultBean.setData(businessService.getBusinessCity());
            return ResultBean;
        } catch (Exception e) {
            logger.warn("getBusinessCity exception: ", e);
            return new ResultBean<>(e);
        }
    }

    @RequestMapping("/business/businessState")
    public ResultBean<List<String>> getBusinessState() {
        logger.info("getBusinessState");
        try {
            ResultBean<List<String>> ResultBean = new ResultBean<>();
            ResultBean.setData(businessService.getBusinessState());
            return ResultBean;
        } catch (Exception e) {
            logger.warn("getBusinessState exception: ", e);
            return new ResultBean<>(e);
        }
    }

    @RequestMapping("/business/condition")
    public ResultBean<BusinessRespVO> getConditionBusiness(@RequestParam(value="city", required=false) String city,
                                                         @RequestParam(value="state", required=false) String state,
                                                         @RequestParam(value="stars", required=false) int stars,
                                                         @RequestParam(value="reviewCount", required=false) String reviewCount,
                                                         @RequestParam(value="start", required=true) int start,
                                                         @RequestParam(value="count", required=true) int count) {
        logger.info("getConditionBusiness,city {},state {},stars {},reviewCount {}",city,state,stars,reviewCount);
        try {

            Integer reviewCountMin = null;
            Integer reviewCountMax = null;
            if(reviewCount!=null){
                switch (reviewCount){
                    case "---":
                        break;
                    case "1000以上":
                        reviewCountMin = 1000;
                        break;
                    default:
                        String[] reviewCounts = reviewCount.split("-");
                        reviewCountMin = Integer.valueOf(reviewCounts[0].trim());
                        reviewCountMax = Integer.valueOf(reviewCounts[1].trim());
                }
            }
            BusinessRespVO businessRespVO = new BusinessRespVO();
            List<BusinessDTO> businessRespVOList = businessService.getBusinessByCondition(reviewCountMin,reviewCountMax,
                    "---".equals(city)? null: city, "---".equals(state)? null: state,stars==0?null:stars,start,count);
            businessRespVO.setBusinessDTOList(businessRespVOList);
            businessRespVO.setStart(start);
            businessRespVO.setCount(count);
            businessRespVO.setTotal(businessService.countBusinessByConditions(reviewCountMin,reviewCountMax,
                    "---".equals(city)? null: city, "---".equals(state)? null: state,stars==0?null:stars));
            return new ResultBean<>(businessRespVO);
        } catch (Exception e) {
            logger.warn("getBusinessState exception: ", e);
            return new ResultBean<>(e);
        }
    }
    @RequestMapping("/business/search")
    public ResultBean<BusinessRespVO> searchBusiness(@RequestParam(value="keyword", required=true) String keyword,
                                                   @RequestParam(value="start", required=true) int start,
                                                   @RequestParam(value="count", required=true) int count) {
        logger.info("searchMovies: keyword {}, start {}, count {}", keyword, start, count);
        try {
            // TODO implement this, return fake data temporarily
            BusinessRespVO businessRespVO = new BusinessRespVO();
            businessRespVO.setBusinessDTOList(businessService.getTopBusiness(start, count));
            businessRespVO.setStart(start);
            businessRespVO.setCount(count);
            businessRespVO.setTotal(250);
            return new ResultBean<>(businessRespVO);
        } catch (Exception e) {
            logger.warn("searchMovies: keyword {}, start {}, count {}", keyword, start, count, e);
            return new ResultBean<>(e);
        }
    }

    @RequestMapping(path="/business/recommend", method= RequestMethod.GET)
    public ResultBean<BusinessRespVO> recommendBusiness(
            @RequestParam(value="algorithm", required=true) String algorithm,
            @RequestParam(value="userId", required=true) String[] userId,
            @RequestParam(value="start", required=true) int start,
            @RequestParam(value="count", required=true) int count) {
        logger.info("recommendMovies: algorithm {}, movieTitles {}, start {}, count {}",
                algorithm, userId, start, count);
        try {
            // TODO implement this, return fake data temporarily
            BusinessRespVO businessRespVO = new BusinessRespVO();
            businessRespVO.setBusinessDTOList(businessService.getRandBusiness(start, count));
            businessRespVO.setStart(start);
            businessRespVO.setCount(count);
            businessRespVO.setTotal(10);
            return new ResultBean<>(businessRespVO);
        } catch (Exception e) {
            logger.warn("recommendMovies: algorithm {}, start {}, count {}", algorithm, start, count, e);
            return new ResultBean<>(e);
        }
    }
    @RequestMapping(path="/business/longitudeLatitude", method= RequestMethod.GET)
    public ResultBean<BusinessRespVO> getLongitudeLatitude() {
        logger.info("getLongitudeLatitude");
        try {
            BusinessRespVO businessRespVO = new BusinessRespVO();
            businessRespVO.setBusinessDTOList(businessService.selectLongtitudeLatitude());
            return new ResultBean<>(businessRespVO);
        } catch (Exception e) {
            logger.warn("getLongitudeLatitude");
            return new ResultBean<>(e);
        }
    }

}
