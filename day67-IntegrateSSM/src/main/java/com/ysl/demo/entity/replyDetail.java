package com.ysl.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class replyDetail {
    private Integer id;

    private Integer invid;

    private String content;

    private String author;

    private Date createdate;

}