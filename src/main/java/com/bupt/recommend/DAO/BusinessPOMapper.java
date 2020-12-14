package com.bupt.recommend.DAO;

import com.bupt.recommend.DAO.PO.BusinessPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BusinessPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusinessPO record);

    int insertSelective(BusinessPO record);

    BusinessPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessPO record);

    int updateByPrimaryKey(BusinessPO record);

    List<BusinessPO> selectTopBusiness(@Param("start") Integer start, @Param("count") Integer count) throws Exception;

    List<String> selectBusinessCity() throws Exception;

    List<String> selectBusinessState() throws Exception;

    List<BusinessPO> selectBusinessByCondition(@Param("reviewCountMin") Integer reviewCountMin, @Param("reviewCountMax") Integer reviewCountMax,
                                       @Param("city") String city, @Param("state") String state,
                                       @Param("stars") Integer stars, @Param("start") Integer start,
                                       @Param("count") Integer count) throws Exception;
    int countBusinessByCondition(@Param("reviewCountMin") Integer reviewCountMin, @Param("reviewCountMax") Integer reviewCountMax,
                                 @Param("city") String city, @Param("state") String state,
                                 @Param("stars") Integer stars) throws Exception;
    List<BusinessPO> selectLongtitdeLatitdude() throws Exception;
}