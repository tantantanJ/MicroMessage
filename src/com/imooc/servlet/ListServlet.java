package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.ListService;

/**
 * 
 * 1)列表页面初始化
 * 2)查询
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
	    	req.setCharacterEncoding("UTF-8");    	    	
	    	//接收req传过来的参数
	    	String command = req.getParameter("command");
	    	String description = req.getParameter("description");
    	    //向页面传值
    	    req.setAttribute("command",command);
    	    req.setAttribute("description",description);

    	    ListService listService = new ListService();
    	    //查询消息列表并传给页面
		    req.setAttribute("messageList",listService.queryMessageList(command, description));
            //想页面跳转
		    req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO 自动生成的方法存根
    	this.doGet(req, resp);
    }
}
