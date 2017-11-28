package com.mcp.dp.chainof.responsibility.handler;

import com.mcp.dp.chainof.responsibility.SupportServiceItf;
import com.mcp.dp.chainof.responsibility.entity.ServiceLevel;
import com.mcp.dp.chainof.responsibility.entity.ServiceRequest;

public class FrontDeskSupport implements SupportServiceItf {
	
	private SupportServiceItf next = new SupervisorSupport();
	public SupportServiceItf getNext() {
		return next;
	}
	public void setNext(SupportServiceItf next) {
		this.next = next;
	}

	public void handleRequest(ServiceRequest service) {
		if(service.getType() == ServiceLevel.LEVEL_ONE)
		{
			service.setConclusion("Front desk solved level one reuqest !!");
		}
		else
		{
			if(next != null){
				next.handleRequest(service);
			}
			else
			{
				throw new IllegalArgumentException("No handler found for :: " + service.getType());
			}
		}
	}

}
