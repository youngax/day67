package com.ysl.demo.dao;

import com.ysl.demo.entity.invitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface invitationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(invitation record);

    int insertSelective(invitation record);

    invitation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(invitation record);

    int updateByPrimaryKey(invitation record);

    List<invitation> selectInvitation(@Param("searchTitle") String searchTitle);
}