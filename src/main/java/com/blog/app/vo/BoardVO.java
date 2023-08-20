package com.blog.app.vo;



@lombok.Data
public class BoardVO {

    private String bno;
    private String title;
    private String content;
    private String userId;
    private String regDate;
    private String reg_date;
    private int hit;

    private int firstContent;
    private int secondContent;


}
