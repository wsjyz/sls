package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Hall;
import com.eighthinfo.sls.service.HallService;
import com.eighthinfo.sls.service.TopicService;
import com.eighthinfo.sls.utils.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by dam on 13-12-12.
 */
@Controller
@RequestMapping(value = "/manage")
public class ManageController {

    @Autowired
    protected HallService hallService;
    @Autowired
    protected TopicService topicService;

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public String redis() {
        return "/manage/redis";
    }

    @ResponseBody
    @RequestMapping(value = "/get-hall-list", method = RequestMethod.GET)
    public List<Hall> get() {
        List<Hall> hallList = hallService.getHallList();
        return hallList;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete() {
        return "/manage/delete";
    }
    @RequestMapping(value = "/online", method = RequestMethod.GET)
    public String onlineCounts() {
        return "/manage/playercounts";
    }

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    public String toManageTopic() {
        return "/manage/topic";
    }
    @ResponseBody
    @RequestMapping(value = "/topic-upload")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request){
        String result = "error";
        String fileName = file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("upload/topic");
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
            ExcelReader reader = new ExcelReader();
            int importCounts = topicService.importTopic(reader.readExcelContent(new FileInputStream(targetFile)));
            result = "success import "+importCounts;
        } catch (Exception e) {
            e.printStackTrace();
            result = e.getMessage();
        }
        return result;
    }
}
