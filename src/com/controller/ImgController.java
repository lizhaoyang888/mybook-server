package com.controller;


import com.DateFormater;
import com.alibaba.fastjson.JSONObject;
import com.bean.MyPerson;
import com.service.MyPersonService;
import com.util.IdGenertor;
import com.util.MAC;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/img")
public class ImgController {

    @Autowired
    @Qualifier("myPersonService")
    private MyPersonService myPersonService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//		接收图片与用户Id
        changeUserImage(request, response);
    }
    // 修改用户的图片
    private void changeUserImage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        MyPerson myPerson = new MyPerson();
        try{
            request.setCharacterEncoding("UTF-8");
            DiskFileItemFactory dff = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(dff);
            sfu.setHeaderEncoding("UTF-8");
            List<FileItem> items = sfu.parseRequest(request);
            for(FileItem item:items){
                if(item.isFormField()){
                    //普通表单
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString("UTF-8");
                    System.out.println("name="+fieldName + ", value="+ fieldValue);
                    if ("no".equals(fieldName)){
                        myPerson.setNo(fieldValue);
                    }
                    if ("name".equals(fieldName)){
                        myPerson.setName(fieldValue);
                    }
                    if ("password".equals(fieldName)){
                        myPerson.setPassword(fieldValue);
                    }
                } else {// 获取上传字段
                    // 更改文件名为唯一的
                    String filename = item.getName();
                    if (filename != null) {
                        filename = IdGenertor.generateGUID() + "." + FilenameUtils.getExtension(filename);
                    }
                    // 生成存储路径
                    String storeDirectory = request.getSession().getServletContext().getRealPath("/files/images");
                    File file = new File(storeDirectory);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    String path = genericPath(filename, storeDirectory);
                    // 处理文件的上传
                    try {
                        item.write(new File(storeDirectory + path, filename));

                        String filePath = "/files/images" + path + "/" + filename;
                        System.out.println("filePath="+filePath);
                        myPerson.setImg(filePath);
                        message = filePath;
                    } catch (Exception e) {
                        message = "上传图片失败";
                        response.getWriter().write(message);
                    }
                }
            }
            Date date = new Date();
            myPerson.setDate(DateFormater.getDateToString(date));
            String mac = MAC.getLocalMac();
            myPerson.setMac(mac);
            myPersonService.addMyPerson(myPerson);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(JSONObject.toJSONString(myPerson));
        } catch (Exception e) {
            e.printStackTrace();
            message = "上传图片失败";
            response.getWriter().write(message);
        }
    }

    //计算文件的存放目录
    private String genericPath(String filename, String storeDirectory) {
        int hashCode = filename.hashCode();
        int dir1 = hashCode&0xf;
        int dir2 = (hashCode&0xf0)>>4;
        Date datess = new Date();
        String date = DateFormater.getDateToStringShort(datess);

        String dir = "/"+date+"/"+dir2;

        File file = new File(storeDirectory,dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }
}
