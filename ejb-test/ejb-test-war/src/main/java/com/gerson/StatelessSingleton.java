package com.gerson;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Singleton
@Startup
public class StatelessSingleton {
	@EJB(lookup="java:global/ejb-test/test-ejb/Service!com.gerson.IRemoteService")
	IService service;
	@PostConstruct
	public void start() {
		try {
			System.out.println("getHello:"+service.getHello());
		} catch (Exception e) {
			System.out.println("getHello: failed =>" +e.getMessage());
		}
		
		try {
			System.out.print("getHellowArr:");
			for(String result:service.getHelloArr()) {
				System.out.print(result+" ");
			}
			System.out.println("");
		} catch (Exception e) {
			System.out.println("getHellowArr: failed =>" +e.getMessage());
		}
		
		try {
			IResult apiResult = service.getApiResult();
			System.out.print("apiResult:");
			for(IResultRow row:apiResult.getResult()) {
				System.out.print(row.getText()+" ");
			}
			System.out.println("");
		} catch (Exception e) {
			System.out.println("getHellowArr: failed =>" +e.getMessage());
		}
		
		try {
			IResult hellowResult = service.getHellowResult();
			System.out.print("getHellowResult:");
			for(IResultRow row:hellowResult.getResult()) {
				System.out.print(row.getText()+" ");
			}
			System.out.println("");
		} catch (Exception e) {
			System.out.println("getHellowResult: failed =>" +e.getMessage());
		}
	
		try {
			System.out.print("getHelloApiList:");
			for(IResultRow row:service.getHelloApiList()) {
				System.out.print(row.getText()+" ");
			}
			System.out.println("");			
		} catch (Exception e) {
			System.out.println("getHelloApiList: failed =>" +e.getMessage());
		}
		
		try {
			System.out.print("getHellowList:");
			for(IResultRow row:service.getHellowList()) {
				System.out.print(row.getText()+" ");
			}
			System.out.println("");			
		} catch (Exception e) {
			System.out.println("getHellowResult: failed =>" +e.getMessage());
		}

		
		
	}
	@Produces
	public static IRemoteService getService() throws NamingException {		
		return InitialContext.doLookup("java:global/ejb-test/test-ejb/Service!com.gerson.IRemoteService");
	}
}
