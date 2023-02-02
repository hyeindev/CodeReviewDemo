package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

    @ResponseBody
    @RequestMapping(value = "/search/jpa/example.do")
    public String searchJPAExample() {
        return "jpa search success";
    }

    @ResponseBody
    @RequestMapping(value = "/search/mybatis/example.do")
    public String searchMybatisExample() {
        return "mybatis search success";
    }
}
