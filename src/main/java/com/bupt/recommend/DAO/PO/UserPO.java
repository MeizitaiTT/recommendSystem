package com.bupt.recommend.DAO.PO;

public class UserPO {
    private Integer id;

    private String userId;

    private String name;

    private Double averageStars;

    private Integer reviewCount;

    public UserPO(Integer id, String userId, String name, Double averageStars, Integer reviewCount) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.averageStars = averageStars;
        this.reviewCount = reviewCount;
    }

    public UserPO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getAverageStars() {
        return averageStars;
    }

    public void setAverageStars(Double averageStars) {
        this.averageStars = averageStars;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }
}