package com.ysl.demo.controller;


import com.github.pagehelper.PageInfo;
import com.ysl.demo.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/invitation")
public class ControllerInvitation {

    @Autowired
    private InvitationService invitationService;

    @RequestMapping("/MainUI")
    public String MainUI(@RequestParam(required = false) String searchTitle,
                         @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                         Model model){
        PageInfo pageInfo = invitationService.findinvitation(searchTitle, pageNum);
        model.addAttribute("PageInfo",pageInfo);
        model.addAttribute("SearchTitle",searchTitle);
        return "main";
    }

    @RequestMapping("/del/{id}")
    public String Del(@PathVariable("id") Integer id, Model model){
        Boolean b = invitationService.delinvitation(id);
        System.out.println("b = " + b);
        if (b){
            model.addAttribute("delmsg","删除成功");
        }else{
            model.addAttribute("delmsg","删除失败");
        }
        return "forward:/invitation/MainUI";
    }
}
