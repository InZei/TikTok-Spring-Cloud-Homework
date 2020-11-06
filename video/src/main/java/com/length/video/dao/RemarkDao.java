package com.length.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.length.video.entity.Remark;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Remark)表数据库访问层
 *
 * @author PQF
 * @since 2020-10-30 20:01:38
 */
@Mapper
public interface RemarkDao extends BaseMapper<Remark> {

}