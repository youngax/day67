package com.ysl.demo.service;

import com.github.pagehelper.PageInfo;
import com.ysl.demo.entity.replyDetail;


public interface ReplyDetailService {

    PageInfo findReplyDetail(Integer invid, Integer pageNum);
    Boolean addReplyDetail(replyDetail replyDetail);
}
