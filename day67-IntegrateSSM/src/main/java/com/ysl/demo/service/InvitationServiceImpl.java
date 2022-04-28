package com.ysl.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysl.demo.dao.invitationMapper;
import com.ysl.demo.dao.replyDetailMapper;
import com.ysl.demo.entity.invitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    private invitationMapper invitationDao;
    @Autowired
    private replyDetailMapper replyDetailMapper;

    @Override
    public Boolean delinvitation(Integer id) {
        int j = replyDetailMapper.deleteByInvid(id);
        int i = invitationDao.deleteByPrimaryKey(id);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo findinvitation(String searchTitle, Integer pageNum) {
        PageHelper.startPage(pageNum,2);
        List<invitation> invitations = invitationDao.selectInvitation(searchTitle);
        PageInfo pageInfo = new PageInfo(invitations);
        return pageInfo;
    }
}
