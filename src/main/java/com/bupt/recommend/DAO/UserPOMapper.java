package com.bupt.recommend.DAO;

import com.bupt.recommend.DAO.PO.UserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}