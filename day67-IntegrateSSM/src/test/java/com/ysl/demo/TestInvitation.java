package com.ysl.demo;

import com.github.pagehelper.PageInfo;
import com.ysl.demo.controller.ControllerInvitation;
import com.ysl.demo.service.InvitationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestInvitation {

    @Autowired
    private InvitationService invitationService;

    @Test
    public void t01(){
        PageInfo pageInfo = invitationService.findinvitation("", 2);
        List list = pageInfo.getList();
        list.forEach(System.out::println);
    }
}
