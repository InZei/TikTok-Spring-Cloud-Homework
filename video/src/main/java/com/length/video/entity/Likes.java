package com.length.video.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Likes)表实体类
 *
 * @author PQF
 * @since 2020-10-30 19:59:04
 */
@SuppressWarnings("serial")
@Data
public class Likes extends Model<Likes> {
    
    private String id;
    
    private String createBy;
    
    private Date createDate;
    
    private Date updateDate;

    private String videoId;

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