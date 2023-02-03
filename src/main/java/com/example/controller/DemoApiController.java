package com.example.controller;

import com.example.service.SearchCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DemoApiController {

    @Autowired
    SearchCustomService searchCustomService;


    @RequestMapping(value = "/search/something.do")
    public void searchSomethingList(HttpServletRequest httpServletRequest, @RequestParam List<String> tableList) {
        /** 검색 테이블 화이트 리스트 체크 */
        boolean isPossibleSearch = searchCustomService.checkAccessibleTableList(httpServletRequest.getRequestURI(),tableList);

    }

    /**
     * jpa-mybatis comparing source
     */
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
