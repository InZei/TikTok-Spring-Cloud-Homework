package com.length.video.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.length.video.dao.PageDao;
import com.length.video.entity.Follow;
import com.length.video.entity.Likes;
import com.length.video.service.FollowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Follow)表控制层
 *
 * @author PQF
 * @since 2020-10-30 20:01:55
 */
@RestController
@RequestMapping("follow")
public class FollowController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private FollowService followService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @return 所有数据
     */
    @GetMapping
    public R queryAll(PageDao page, Follow follow) {
        return success(this.followService.queryAll(page,follow));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.followService.getById(id));
    }

    /**
     * 新增数据
     *x
     * @param follow 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Follow follow) {
        return success(this.followService.save(follow));
    }

    /**
     * 修改数据
     *
     * @param follow 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Follow follow) {
        return success(this.followService.updateById(follow));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.followService.removeByIds(idList));
    }
}