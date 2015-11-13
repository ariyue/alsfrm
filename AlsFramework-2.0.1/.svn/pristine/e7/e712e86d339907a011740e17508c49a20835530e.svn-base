package com.als.frm.bas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

import com.als.abc.module.classloader.Decrypt;

public class AlsDispatcher extends DispatcherServlet {

	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("请求开始------------------------------------");
		Decrypt d = new Decrypt();
		d.decr();
		super.doService(request, response);
		
		System.out.println("请求结束------------------------------------");
		
		
	}
}
