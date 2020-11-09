package com.chuangyun.common.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传下载工具类
 *
 * @author Jerry Yu
 * @date 2017/11/9 15:46
 */
public class FileUtils extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -2252286021072946028L;

    /**
     * 保存文件
     *
     * @param file
     * @param savePath
     * @throws IOException
     */
    public static String upload(MultipartFile file, String savePath) throws IOException {

        File parentPath = new File(savePath);

        String fileName = file.getOriginalFilename();

        //判断上级路径是否存在，不存在就创建
        if (!parentPath.exists()) {
            parentPath.mkdirs();
        }

        String ref = savePath + File.separator + UUIDUtil.generateId() + "." + fileName.split("\\.")[1];


        //获取文件存储路径
        File fileToSave = new File(ref);
        //保存文件
        file.transferTo(fileToSave);

        return ref;
    }

}
