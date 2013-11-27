package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Topic;
import com.eighthinfo.sls.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-27
 * Time: PM9:18
 */
@Controller
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;


    @ResponseBody
    @RequestMapping(value = "/random/{level}", method = RequestMethod.GET)
    public List<Topic> random50TopicList(@PathVariable int level) {
        return topicService.loadRandomTopicList(level, 50);
    }
}
