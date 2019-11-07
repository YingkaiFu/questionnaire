package com.questionnaire.demo.controller;
import com.questionnaire.demo.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.questionnaire.demo.service.QuestionService;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
public class QuestionController{
    @Autowired
    private QuestionService questionService;


    @RequestMapping("/")
    public String index1(Model model){
        return "redirect:/index";

    }

    @RequestMapping("/index")
    public String index(Model model) throws Exception {
        List<String> options = new ArrayList<>();
        options.add("The left one");
        options.add("The right one");
        List<String> q1 = questionService.readColumn(new File("table.xls"),1);
        List<QuestionEntity> list= questionService.findAll();
        for(int i=0;i<list.size();i++)
        {
            String name = q1.get(i);

            String label = "Which image do you think is more corresponding to "+ name;
            QuestionEntity temp = list.get(i);
            temp.setName(label);
            list.set(i,temp);
        }
        model.addAttribute("questionList",list);
        model.addAttribute("options",options);
        model.addAttribute("q1s",q1);
        return "index";
    }

    @RequestMapping("/test")
    public String test(Model model) throws Exception {
        List<String> options = new ArrayList<>();
        options.add("The left one");
        options.add("The right one");
        List<String> q1 = questionService.readColumn(new File("table.xls"),1);
        List<QuestionEntity> list= questionService.test();
        for(int i=0;i<5;i++)
        {
            String name = q1.get(i);

            String label = "Which image do you think is more corresponding to "+ name;
            QuestionEntity temp = list.get(i);
            temp.setName(label);
            list.set(i,temp);
        }
        model.addAttribute("questionList",list);
        model.addAttribute("options",options);
        model.addAttribute("q1s",q1);
        return "index";
    }

    @RequestMapping(value = "/postdata")
    public String result(@RequestParam(value = "data[]") String[] data){
        FileOutputStream fileOutputStream = null;
        String txtPath = "result/"+data[data.length-2]+".txt";
        File file = new File(txtPath);
        try {
            if(file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            for (String lis:data) {
                fileOutputStream.write(lis.getBytes());
                fileOutputStream.write(",".getBytes());
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "postList";
    }
}