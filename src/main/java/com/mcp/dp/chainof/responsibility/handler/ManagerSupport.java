package com.mcp.dp.chainof.responsibility.handler;

import com.mcp.dp.chainof.responsibility.SupportServiceItf;
import com.mcp.dp.chainof.responsibility.entity.ServiceLevel;
import com.mcp.dp.chainof.responsibility.entity.ServiceRequest;

public class ManagerSupport implements SupportServiceItf {
	
	private SupportServiceItf next = new DirectorSupport();
	public SupportServiceItf getNext() {
		return next;
	}
	public void setNext(SupportServiceItf next) {
		this.next = next;
	}

	public void handleRequest(ServiceRequest request) {
		if(request.getType() == ServiceLevel.LEVEL_THREE)
		{
			request.setConclusion("Manager solved level three reuqest !!");
		}
		else
		{
			if(next != null){
				next.handleRequest(request);
			}
			else
			{
				throw new IllegalArgumentException("No handler found for :: " + request.getType());
			}
		}
	}

}
