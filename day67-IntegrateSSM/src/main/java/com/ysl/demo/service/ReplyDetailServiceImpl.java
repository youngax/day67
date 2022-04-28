package com.ysl.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysl.demo.dao.replyDetailMapper;
import com.ysl.demo.entity.replyDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyDetailServiceImpl implements ReplyDetailService {

    @Autowired
    private replyDetailMapper replyDetailMapper;


    @Override
    public PageInfo findReplyDetail(Integer invid, Integer pageNum) {
        PageHelper.startPage(pageNum,2);
        List<replyDetail> replyDetails = replyDetailMapper.selectByInvid(invid);
        PageInfo pageInfo = new PageInfo(replyDetails);
        return pageInfo;
    }

    @Override
    public Boolean addReplyDetail(replyDetail replyDetail) {
        int i =  replyDetailMapper.insert(replyDetail);
        return i>0?true:false;
    }

}
