package com.mcp.dp.chainof.responsibility.handler;

import com.mcp.dp.chainof.responsibility.SupportServiceItf;
import com.mcp.dp.chainof.responsibility.entity.ServiceRequest;

public class SupportService implements SupportServiceItf {

	private SupportServiceItf handler = new FrontDeskSupport();
	
	public SupportServiceItf getHandler() {
		return handler;
	}

	public void setHandler(SupportServiceItf handler) {
		this.handler = handler;
	}

	public void handleRequest(ServiceRequest request) {
		handler.handleRequest(request);
	}
}
