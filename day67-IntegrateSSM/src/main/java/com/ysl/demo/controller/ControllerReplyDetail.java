package com.ysl.demo.controller;

import com.github.pagehelper.PageInfo;
import com.ysl.demo.entity.replyDetail;
import com.ysl.demo.service.ReplyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Component
@RequestMapping("ReplyDetail")
public class ControllerReplyDetail {

    @Autowired
    private ReplyDetailService replyDetailService;

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer invid,
                         @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                         Model model){
        PageInfo pageInfo = replyDetailService.findReplyDetail(invid, pageNum);
        model.addAttribute("PageInfo",pageInfo);
        model.addAttribute("Invid",invid);
        return "detail";
    }

    @RequestMapping("add")
    public String add(replyDetail detail,Model model){
        model.addAttribute("Invid",detail.getInvid());
        if (detail.getContent()!= null && detail.getAuthor() != null){
            detail.setCreatedate(new Date());
            Boolean b = replyDetailService.addReplyDetail(detail);
            if (b){
                model.addAttribute("addmsg","添加成功");
            }else{
                model.addAttribute("addmsg","添加失败");
            }
        }
        return "add";
    }
}
