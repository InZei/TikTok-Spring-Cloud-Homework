package com.length.video.service;

        import com.baomidou.mybatisplus.extension.service.IService;
        import com.length.video.dao.PageDao;
        import com.length.video.entity.PageResult;
        import com.length.video.entity.Video;

        import javax.servlet.http.HttpServletResponse;
        import java.util.List;

/**
 * (Video)表服务接口
 *
 * @author PQF
 * @since 2020-10-30 20:02:13
 */
public interface VideoService extends IService<Video> {
        PageResult<Video> queryAll(PageDao page,Video video);
        PageResult<Video> queryFree(int begin,int count,Video video);
        void sendVideo(HttpServletResponse response,String path);
}