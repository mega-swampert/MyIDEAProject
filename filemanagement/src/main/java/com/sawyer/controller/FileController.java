package com.sawyer.controller;

import com.sawyer.entity.User;
import com.sawyer.entity.UserFile;
import com.sawyer.service.UserFileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

import java.net.URLEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private UserFileService userFileService;

    @GetMapping(value = "/delete")
    public String  delete(Integer id) throws FileNotFoundException {
        //根据ID查询信息
        UserFile userFile = userFileService.findById(id);
        //删除文件
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();
        File file = new File(realPath, userFile.getNewFileName());
        if(file.exists()) {
            file.delete();
        }
        //删除数据库文件
        userFileService.delete(id);
        return "redirect:/file/showAll";
    }

    /**
     * 文件下载和预览
     * @param openStyle
     * @param id
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/download")
    public void download(String openStyle,Integer id, HttpServletResponse response) throws IOException {
        //获取打开方式
        openStyle = openStyle == null ? "attachment" : openStyle;

        //文件ID
        UserFile userFile = userFileService.findById(id);
        //更新下载次数
        if(openStyle.equals("attachment")){
            userFile.setDowncounts(userFile.getDowncounts() + 1);
            userFileService.update(userFile);
        }


        //根据文件信息中文件名字和文件存储路径获取文件输入流
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();
        //获取文件输入流
        FileInputStream fis = new FileInputStream(new File(realPath, userFile.getNewFileName()));
        //附件下载
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(userFile.getOldFileName(), "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //文件拷贝
        IOUtils.copy(fis, os);
        IOUtils.closeQuietly(fis);
        IOUtils.closeQuietly(os);
    }

    /**
     * 文件上传
     *
     * @param aaa
     * @param session
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    public String upload(MultipartFile aaa, HttpSession session) throws IOException {
        //获取用户上传id
        User user = (User) session.getAttribute("user");

        //获取文件的原始名称
        String oldFileName = aaa.getOriginalFilename();
        //获取文件后缀
        String extension = "." + FilenameUtils.getExtension(aaa.getOriginalFilename());
        //生成新的文件名
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
                UUID.randomUUID().toString().replace("-", "") + extension;
        //文件大小
        Long size = aaa.getSize();
        //文件类型
        String type = aaa.getContentType();
        //构建日期文件夹
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateDirPath = realPath + "/" + dateFormat;
        File dateDir = new File(dateDirPath);
        if (!dateDir.exists()) {
            dateDir.mkdirs();
        }
        //处理文件上传
        aaa.transferTo(new File(dateDir, newFileName));
        //将文件信息放入数据库
        UserFile userFile = new UserFile();
        userFile.setOldFileName(oldFileName).setNewFileName(newFileName).setExt(extension)
                .setSize(String.valueOf(size)).setType(type).setPath("/files/" + dateFormat).setUserId(user.getId());
        userFileService.save(userFile);
        return "redirect:/file/showAll";

    }


    /**
     * 展示用户文件信息
     *
     * @param session
     * @param model
     * @return
     */
    @GetMapping(value = "/showAll")
    public String findAll(HttpSession session, Model model) {
        //从session中获取ID
        User user = (User) session.getAttribute("user");
        List<UserFile> userFiles = userFileService.findByUserId(user.getId());
        //存入作用域中
        model.addAttribute("files", userFiles);
        return "/showAll";
    }

}
