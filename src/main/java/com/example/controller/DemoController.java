package com.example.controller;

import com.example.service.SearchCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
    @Autowired
    SearchCustomService searchCustomService;

    /**
     * filtering custom example source
     *
     */
    @ResponseBody
    @GetMapping("/demo")
    public String demo(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        modelAndView.addObject("custom", searchCustomService.getSearchCustomInfo(httpServletRequest));
        return "/demo";
    }



}
