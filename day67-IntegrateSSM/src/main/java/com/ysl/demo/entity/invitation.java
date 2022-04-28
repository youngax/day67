package com.ysl.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class invitation {
    private Integer id;

    private String title;

    private String summary;

    private String author;

    private Date createdate;

}