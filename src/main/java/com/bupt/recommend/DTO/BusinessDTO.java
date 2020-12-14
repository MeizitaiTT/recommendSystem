package com.bupt.recommend.DTO;

import lombok.Data;

@Data
public class BusinessDTO {
    private Integer id;

    private String businessId;

    private String fullAddress;

    private Integer open;

    private String categories;

    private String city;

    private Integer reviewCount;

    private String name;

    private Double longitude;

    private Double latitude;

    private Integer stars;

    private String state;
}
