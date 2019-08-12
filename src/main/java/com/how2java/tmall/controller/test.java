package com.how2java.tmall.controller;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("")
public class test {
    @RequestMapping("index")
    public String index(){
        return "admin/test";
    }

    @RequestMapping(value="add",method = RequestMethod.POST)
    public String add(int id){
        String sid = String.valueOf(id);
        return "admin/test";
    }


    @RequestMapping(value="showdata",method = RequestMethod.POST)
    public ModelAndView showdata(Integer id, @RequestParam("testFile") MultipartFile[] testFile,String setDate){
        for (int i = 0; i < testFile.length ; i++) {
            MultipartFile file  = testFile[i];
        }
        ModelAndView mav= new ModelAndView();
        mav.setViewName("success");
        mav.addObject("id",id);
        mav.addObject("testFile",testFile);
        mav.addObject("setDate",setDate);
        return mav;
    }

    @RequestMapping("addtest")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/testAdd");
        return mav;
    }

    @RequestMapping("datashow")
    public ModelAndView datashow(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("");
        return mav;
    }

    @RequestMapping(value = "testAjax",method = RequestMethod.POST)
    @ResponseBody
    public Integer ajaxRequest(@RequestBody JSONObject jsonObject){
        String exitTheStage = jsonObject.getString("exitTheStage");
        String exitTime = jsonObject.getString("exitTime");
        String exitRatio = jsonObject.getString("exitRatio");
        String residualRatio = jsonObject.getString("residualRatio");
        String quitMoney = jsonObject.getString("quitMoney");
//        System.out.println(exitTheStage);
//        System.out.println(exitTime);
        System.out.println();
        return 200;
    }


}
