package com.ysl.demo.dao;

import com.ysl.demo.entity.replyDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface replyDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(replyDetail record);

    int insertSelective(replyDetail record);

    replyDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(replyDetail record);

    int updateByPrimaryKey(replyDetail record);

    @Select("select * from reply_detail where invid = #{id}")
    List<replyDetail> selectByInvid(@Param("id") Integer invid);

    @Delete("delete from reply_detail where invid = #{id}")
    int deleteByInvid(@Param("id") Integer invid);

}