package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 * WEB-INF下面的文件，直接访问或者redirect是无法直接访问的。
 * 需要通过后台简介访问
 * <p>
 * WEB-IN 里的页面跳转
 */
@RequestMapping("/page")
@Controller
public class PageController {

//    @RequestMapping("{pageName}")
//    public ModelAndView toPage(@PathVariable("pageName") String pageName) {
//        ModelAndView mv = new ModelAndView(pageName);
//        return mv;
//    }

    /**
     * @param pageName 即需要跳转的页面
     * @return
     * @PathVariable可以用来映射URL中的占位符到目标方法的参数中 例如页面可以这样写 <a href="${pageContext.request.contextPath}/page/add.do">注册</a>
     * 然后add会被提取出来赋值给pageName
     */
    @RequestMapping("{pageName}")
    public String toPage(@PathVariable("pageName") String pageName) {

        System.out.println("testPathVariable:" + pageName);

        return pageName;
    }


//    @RequestMapping(value = "{pageName}",params = "redirect")
//    public ModelAndView toPageIndex(@PathVariable("pageName") String pageName) {
//        ModelAndView mv = new ModelAndView("redirect:/"+pageName+".jsp");
//        return mv;
//    }

}
