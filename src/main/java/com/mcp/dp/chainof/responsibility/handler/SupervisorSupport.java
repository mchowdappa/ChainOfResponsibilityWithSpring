package com.mcp.dp.chainof.responsibility.handler;

import com.mcp.dp.chainof.responsibility.SupportServiceItf;
import com.mcp.dp.chainof.responsibility.entity.ServiceLevel;
import com.mcp.dp.chainof.responsibility.entity.ServiceRequest;

public class SupervisorSupport implements SupportServiceItf {
	
	private SupportServiceItf next = new ManagerSupport();
	public SupportServiceItf getNext() {
		return next;
	}
	public void setNext(SupportServiceItf next) {
		this.next = next;
	}

	public void handleRequest(ServiceRequest request) {
		if(request.getType() == ServiceLevel.LEVEL_TWO)
		{
			request.setConclusion("Supervisor solved level two reuqest !!");
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
