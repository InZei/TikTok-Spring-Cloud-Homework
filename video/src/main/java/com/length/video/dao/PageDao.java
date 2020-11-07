package com.length.video.dao;

import lombok.Data;

@Data
public class PageDao {
    public int pageSize;
    public int pageNum;
    public String orderBy;

    public PageDao(){
        orderBy="";
        pageSize=10;
        pageNum=1;
    }

}
