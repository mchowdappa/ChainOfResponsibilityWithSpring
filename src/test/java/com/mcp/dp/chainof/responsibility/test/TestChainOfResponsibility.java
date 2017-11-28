package com.mcp.dp.chainof.responsibility.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mcp.dp.chainof.responsibility.SupportServiceItf;
import com.mcp.dp.chainof.responsibility.entity.ServiceLevel;
import com.mcp.dp.chainof.responsibility.entity.ServiceRequest;
import com.mcp.dp.chainof.responsibility.handler.SupportService;

public class TestChainOfResponsibility {
	public static void main(String[] args) 
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		SupportServiceItf supportService = (SupportService) context.getBean("supportService");
		
	//	SupportServiceItf supportService = new SupportService();
		
		ServiceRequest request = new ServiceRequest();
		request.setType(ServiceLevel.LEVEL_ONE);
		supportService.handleRequest(request);
		System.out.println(request.getConclusion());
		
		request = new ServiceRequest();
		request.setType(ServiceLevel.LEVEL_THREE);
		supportService.handleRequest(request);
		System.out.println(request.getConclusion());
		
		request = new ServiceRequest();
		request.setType(ServiceLevel.INVALID_REQUEST);
		supportService.handleRequest(request);
		System.out.println(request.getConclusion());
	}
}
