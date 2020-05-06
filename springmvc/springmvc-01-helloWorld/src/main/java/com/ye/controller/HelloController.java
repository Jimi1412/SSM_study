package com.ye.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ye.Utils.JsonUtil;
import com.ye.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {

   /* public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        String result="Hello SpringMVC";
        mv.addObject("msg",result);
        mv.setViewName("test");
        return mv;
    }*/
   @RequestMapping("/hello")
   public  String hello(Model model){
       model.addAttribute("msg","Hello SpringMVC");
      return "test";
   }
   //测试数据绑定
   @RequestMapping("/h2")
   public String hello2(@RequestParam("username") String name,Model model){
      model.addAttribute("msg",name);
      return "test";
   }
   @RequestMapping("/h3")
   public String hello3(User user){
      System.out.println(user);
      return "test";
   }
   //处理乱码的测试
   @RequestMapping("/h4")
   public String hello4(String username,Model model){
      System.out.println(username);
      model.addAttribute("msg",username);
      return "test";
   }
   //测试json
   @RequestMapping("/h5")
   @ResponseBody //不走视图解析器，返回一个字符串
   public String hello5() throws JsonProcessingException {
      ObjectMapper mapper=new ObjectMapper();
      User user=new User("叶叶","10086",19);
      return mapper.writeValueAsString(user);
   }
   @RequestMapping("/h6")
   @ResponseBody //不走视图解析器，返回一个字符串
   public String hello6() throws JsonProcessingException {
    /*  User u1=new User("叶叶1","10086",19);
      User u2=new User("叶叶2","10086",19);
      User u3=new User("叶叶3","10086",19);
      User u4=new User("叶叶4","10086",19);
      List <User> list=new ArrayList<>();
      list.add(u1);list.add(u2);list.add(u3);list.add(u4);
      return JsonUtil.getJson(list);*/
    Date date=new Date();
    return JsonUtil.getJson(date);
   }

}
