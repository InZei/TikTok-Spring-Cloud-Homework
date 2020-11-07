package com.length.video.entity;

import com.length.video.dao.PageDao;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> extends PageDao {
    public List<T> result;
    public int total;

    public PageResult(){
        total=0;
        result=new ArrayList<>();
    }

    public void setPage(PageDao pageDao){
        pageNum=pageDao.pageNum;
        pageSize=pageDao.pageSize;
        orderBy=pageDao.orderBy;
        total=0;
    }
}
