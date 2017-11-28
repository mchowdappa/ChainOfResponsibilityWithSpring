package com.mcp.dp.chainof.responsibility.handler;

import com.mcp.dp.chainof.responsibility.SupportServiceItf;
import com.mcp.dp.chainof.responsibility.entity.ServiceLevel;
import com.mcp.dp.chainof.responsibility.entity.ServiceRequest;

public class DirectorSupport implements SupportServiceItf {
	
	private SupportServiceItf next = null;
	public SupportServiceItf getNext() {
		return next;
	}
	public void setNext(SupportServiceItf next) {
		this.next = next;
	}
	
	public void handleRequest(ServiceRequest request) {
		if(request.getType() == ServiceLevel.LEVEL_FOUR)
		{
			request.setConclusion("Director solved level four reuqest !!");
		}
		else
		{
			if(next != null){
				next.handleRequest(request);
			}
			else
			{
				request.setConclusion("You problem is none of our business");
				throw new IllegalArgumentException("You problem is none of our business :: " + request.getType());
			}
		}
	}

}
