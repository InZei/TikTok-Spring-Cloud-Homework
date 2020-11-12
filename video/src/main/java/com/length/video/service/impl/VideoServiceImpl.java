package com.length.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.video.dao.PageDao;
import com.length.video.dao.VideoDao;
import com.length.video.entity.PageResult;
import com.length.video.entity.Video;
import com.length.video.service.VideoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * (Video)表服务实现类
 *
 * @author PQF
 * @since 2020-10-30 20:02:13
 */
@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoDao, Video> implements VideoService {

    @Autowired(required = false)
    private VideoDao videoDao;

    /**
     * video数据搜索
     * @param video 视频
     * @param page 页规则
     * @return
     */
    public PageResult<Video> queryAll(PageDao page,Video video){
        int begin=(page.pageNum-1)*page.pageSize;
        int count=page.pageSize;
        String orderBy=page.orderBy;

        List<Video> listSum=videoDao.queryAll(video,orderBy,-1,0);
        List<Video> listRes=videoDao.queryAll(video,orderBy,begin,count);

        PageResult<Video> res=new PageResult<>();

        res.result=listRes;
        res.setPage(page);
        res.total=listSum.size();

        return res;
    }


    /**
     * 服务传视频
     * @param response
     * @param path
     */
    public void sendVideo(HttpServletResponse response, String path){
        String file = path;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            String filename=path.split("/")[path.split("/").length-1];
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            String diskfilename = filename;
            String type=filename.substring(filename.lastIndexOf(".") + 1)
                    .toLowerCase();

            response.setContentType("video/"+type);
            response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");
            response.setContentLength(data.length);
            response.setHeader("Content-Range", "" + Integer.valueOf(data.length - 1));
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Etag", "W/\"9767057-1323779115364\"");

            OutputStream os = response.getOutputStream();

            os.write(data);
            //先声明的流后关掉！
            os.flush();
            os.close();
            inputStream.close();

        } catch (HttpMessageNotWritableException e) {
            e.fillInStackTrace();
        }catch (IOException e){
            e.fillInStackTrace();
        }

    }

}