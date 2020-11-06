package com.length.video.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Video)表实体类
 *
 * @author PQF
 * @since 2020-10-30 20:02:13
 */
@SuppressWarnings("serial")
@Data
public class Video extends Model<Video> {
    
    private String id;
    
    private String createBy;
    
    private Date createDate;
    
    private Date updateDate;
    
    private String remarks;
    
    private String videoUrl;
    
    private Integer type;

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