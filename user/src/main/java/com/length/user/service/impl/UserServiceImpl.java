package com.length.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.user.dao.UserDao;
import com.length.user.entity.User;
import com.length.user.service.UserService;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * (User)表服务实现类
 *
 * @author PQF
 * @since 2020-11-18 16:25:25
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    public void sendImg(HttpServletResponse response, String path){
        String file = path;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            String filename=path.split("/")[path.split("/").length-1];
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            String diskfilename = filename;
            String type=filename.substring(filename.lastIndexOf(".") + 1)
                    .toLowerCase();

            response.setContentType("image/"+type);
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