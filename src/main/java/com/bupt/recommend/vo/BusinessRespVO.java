package com.bupt.recommend.vo;

import com.bupt.recommend.DTO.BusinessDTO;
import lombok.Data;

import java.util.List;

@Data
public class BusinessRespVO {
    List<BusinessDTO> businessDTOList;
    private Integer total;

    private Integer start;

    private Integer count;
}
