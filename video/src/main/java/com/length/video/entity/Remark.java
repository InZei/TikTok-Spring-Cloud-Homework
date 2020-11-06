package com.length.video.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Remark)表实体类
 *
 * @author PQF
 * @since 2020-10-30 20:01:38
 */
@SuppressWarnings("serial")
@Data
public class Remark extends Model<Remark> {
    
    private String id;
    
    private String createBy;
    
    private Date createDate;
    
    private Date updateDate;
    
    private String remark;
    
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