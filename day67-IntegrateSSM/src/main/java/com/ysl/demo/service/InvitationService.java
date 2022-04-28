package com.ysl.demo.service;

import com.github.pagehelper.PageInfo;

public interface InvitationService {

    Boolean delinvitation(Integer id);

    PageInfo findinvitation(String searchTitle,Integer pageNum);
}
