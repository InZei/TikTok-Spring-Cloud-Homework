package com.length.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.length.video.dao.PageDao;
import com.length.video.entity.PageResult;
import com.length.video.entity.Remark;

/**
 * (Remark)表服务接口
 *
 * @author PQF
 * @since 2020-10-30 20:01:38
 */
public interface RemarkService extends IService<Remark> {
    PageResult<Remark> queryAll(PageDao page, Remark remark);
}