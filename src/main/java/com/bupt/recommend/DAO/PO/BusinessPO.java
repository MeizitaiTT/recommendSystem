package com.bupt.recommend.DAO.PO;

public class BusinessPO {
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

    public BusinessPO(Integer id, String businessId, String fullAddress, Integer open, String categories, String city, Integer reviewCount, String name, Double longitude, Double latitude, Integer stars, String state) {
        this.id = id;
        this.businessId = businessId;
        this.fullAddress = fullAddress;
        this.open = open;
        this.categories = categories;
        this.city = city;
        this.reviewCount = reviewCount;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.stars = stars;
        this.state = state;
    }

    public BusinessPO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress == null ? null : fullAddress.trim();
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories == null ? null : categories.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}