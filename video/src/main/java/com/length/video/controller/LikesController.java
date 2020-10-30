package com.length.video.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.length.video.entity.Likes;
import com.length.video.service.LikesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Likes)表控制层
 *
 * @author PQF
 * @since 2020-10-30 19:59:07
 */
@RestController
@RequestMapping("likes")
public class LikesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private LikesService likesService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param likes 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Likes> page, Likes likes) {
        return success(this.likesService.page(page, new QueryWrapper<>(likes)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.likesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param likes 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Likes likes) {
        return success(this.likesService.save(likes));
    }

    /**
     * 修改数据
     *
     * @param likes 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Likes likes) {
        return success(this.likesService.updateById(likes));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.likesService.removeByIds(idList));
    }
}