package com.ysl.demo.config;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    /*日期正则表达式： yyyy-MM-dd*/
    private String datePattern;

    public StringToDateConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String s) {
        Date date = null;
        try {
            //datePattern : 定义的日期转换格式
            //s : 需要被转换的日期字符串
            date = new SimpleDateFormat(datePattern).parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
