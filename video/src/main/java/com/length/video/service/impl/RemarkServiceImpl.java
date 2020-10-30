package com.length.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.video.dao.RemarkDao;
import com.length.video.entity.Remark;
import com.length.video.service.RemarkService;
import org.springframework.stereotype.Service;

/**
 * (Remark)表服务实现类
 *
 * @author PQF
 * @since 2020-10-30 20:01:38
 */
@Service("remarkService")
public class RemarkServiceImpl extends ServiceImpl<RemarkDao, Remark> implements RemarkService {

}