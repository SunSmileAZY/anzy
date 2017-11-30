package com.anzy.freemarker.base.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * Controller公共组件
 * @author anzy
 */
public abstract class AbstractController {
    protected static final int DEFAULT_PAGE_SIZE = 10;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;

    @Autowired
    protected ServletContext application;

    /**
     * 生成分页项
     * @param pageNo
     * @return
     */
    protected <T> Page<T> getPage(Integer pageNo) {
        Page<T> page = new Page<T>();
        if (null != pageNo) {
            page.setCurrent(pageNo);
        }
        page.setSize(DEFAULT_PAGE_SIZE);
        return page;
    }

    /**
     * 生成分页项
     * @param pageNo
     * @param pageSize
     * @return
     */
    protected <T> Page<T> getPage(int pageNo, int pageSize) {
        Page<T> page = new Page<T>();
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        return page;
    }

}
