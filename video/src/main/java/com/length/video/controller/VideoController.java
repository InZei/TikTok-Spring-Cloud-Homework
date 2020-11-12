package com.length.video.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.reflect.ClassPath;
import com.length.video.dao.PageDao;
import com.length.video.entity.Video;
import com.length.video.service.VideoService;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (Video)表控制层
 *
 * @author PQF
 * @since 2020-10-30 20:02:13
 */
@RestController
@RequestMapping("video")
public class VideoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private VideoService videoService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @return 所有数据
     */
    @GetMapping
    public R queryAll(PageDao page,Video video) {
        return success(this.videoService.queryAll(page,video));
    }


    /**
     * 用视频id获得视频
     * @param id
     * @param response
     */
    @JsonBackReference
    @GetMapping("/sendVideo")
    public void  sendVideo( @RequestParam String id, HttpServletResponse response){
        Video video=this.videoService.getById(id);
        String path=System.getProperty("user.dir")+"/source"+"/video/"
                +String.valueOf(video.getType())+"/"
                +video.getVideoUrl();
        this.videoService.sendVideo(response,path);
    }


    @GetMapping("sendCover")
    public void sendCover(@RequestParam String id, HttpServletResponse response){
        Video video=this.videoService.getById(id);
        String path=System.getProperty("user.dir")+"/source"+"/image/"+"cover/"+video.getCoverUrl();
        this.videoService.sendCover(response,path);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.videoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param video 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(Video video,@RequestParam("file") MultipartFile file, @RequestParam("cover") MultipartFile cover, HttpServletRequest request) {
        video.setId(UUID.randomUUID().toString());
        video.setTime();
        try{
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
                    .toLowerCase();
            String coverExt=cover.getOriginalFilename().substring(cover.getOriginalFilename().lastIndexOf(".") + 1)
                    .toLowerCase();
            String path=System.getProperty("user.dir")+"/source"+"/video/"+String.valueOf(video.getType())+"/";
            String coverpath=System.getProperty("user.dir")+"/source"+"/image/"+"cover/";
            File dir = new File(path);
            File fileSave = new File(path, pikId+"."+fileExt);
            if(!dir.exists()){
                dir.mkdirs();
            }
            file.transferTo(fileSave);
            video.setVideoUrl(pikId+"."+fileExt);

            File coverdir=new File(coverpath);
            File coverSave=new File(coverpath,pikId+"."+coverExt);
            if(!coverdir.exists()){
                coverdir.mkdirs();
            }
            cover.transferTo(coverSave);
            video.setCoverUrl(pikId+"."+coverExt);
        }catch (IOException e){
            e.fillInStackTrace();
        }
        return success(this.videoService.save(video));
    }

    /**
     * 修改数据
     *
     * @param video 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Video video) {
        video.setUpdateDate(new Date());
        return success(this.videoService.updateById(video));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.videoService.removeByIds(idList));
    }
}