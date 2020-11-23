package com.length.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.length.user.entity.User;
import com.length.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * (User)表控制层
 *
 * @author PQF
 * @since 2020-11-18 16:25:27
 */
@RestController
@Api
@RequestMapping("user")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<User> page, User user) {
        return success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }


    /**
     * headimg
     * @param id
     * @param response
     */
    @GetMapping("headimg")
    public void headimg(@RequestParam String id, HttpServletResponse response){
        User user=this.userService.getById(id);
        String path=System.getProperty("user.dir")+"/source"+"/image/headImg/"+user.getHeadimgUrl();
        this.userService.sendImg(response,path);
    }
    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(User user) {
        user.setId(user.getUsername());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setDault();
        return success(this.userService.save(user));
    }

    @GetMapping("check")
    public R check(String username,String password){
        User user=this.userService.getById(username);
        if(user==null){
            return success("不存在该用户名");
        }else{
            String md5Pas=DigestUtils.md5DigestAsHex(password.getBytes());
            if(md5Pas.equals(user.getPassword())){
                return success("登录成功");
            }else{
                return success("用户名或密码错误");
            }
        }
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update( User user, MultipartFile headimg) {
        if(headimg!=null){
            try{
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                String fileExt = headimg.getOriginalFilename().substring(headimg.getOriginalFilename().lastIndexOf(".") + 1)
                        .toLowerCase();

                String path=System.getProperty("user.dir")+"/source"+"/image/headImg/";
                File dir = new File(path);
                File fileSave = new File(path, pikId+"."+fileExt);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                headimg.transferTo(fileSave);
                user.setHeadimgUrl(pikId+"."+fileExt);

            }catch (IOException e){
                e.fillInStackTrace();
            }
        }
        user.setDault();
        if(user.getPassword()!=null&&user.getPassword()!="")
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }
}