package com.length.video.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.length.video.dao.PageDao;
import com.length.video.entity.Remark;
import com.length.video.entity.Video;
import com.length.video.service.RemarkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Remark)表控制层
 *
 * @author PQF
 * @since 2020-10-30 20:01:38
 */
@RestController
@RequestMapping("remark")
public class RemarkController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RemarkService remarkService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @return 所有数据
     */
    @GetMapping
    public R queryAll(PageDao page, Remark remark) {
        return success(this.remarkService.queryAll(page,remark));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.remarkService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param remark 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Remark remark) {
        return success(this.remarkService.save(remark));
    }

    /**
     * 修改数据
     *
     * @param remark 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Remark remark) {
        return success(this.remarkService.updateById(remark));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.remarkService.removeByIds(idList));
    }
}