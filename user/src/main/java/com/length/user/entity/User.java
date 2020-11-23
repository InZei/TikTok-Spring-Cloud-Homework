package com.length.user.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author PQF
 * @since 2020-11-18 16:25:21
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
    
    private String id;
    
    private Date createDate;
    
    private Date updateDate;
    
    private String remarks;
    
    private String headimgUrl;
    
    private String username;
    
    private String password;

    public  User(){
        id="";
        remarks="什么也没有留下。";
        headimgUrl="";

    }

    public boolean setDault(){
        createDate=new Date();
        updateDate=new Date();
        return true;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public String getHeadimgUrl() {
        return headimgUrl;
    }

    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }