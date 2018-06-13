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
	IRemoteService service;
	@PostConstruct
	public void start() {
		System.out.println("getHello:"+service.getHello());
		System.out.print("getHellowArr:");
		for(String result:service.getHelloArr()) {
			System.out.print(result+" ");
		}
		System.out.println("");
		IResult apiResult = service.getApiResult();
		System.out.print("apiResult:");
		for(IResultRow row:apiResult.getResult()) {
			System.out.print(row.getText()+" ");
		}
		System.out.println("");
		IResult hellowResult = service.getHellowResult();
		System.out.print("getHellowResult:");
		for(IResultRow row:hellowResult.getResult()) {
			System.out.print(row.getText()+" ");
		}
		System.out.println("");
		
		
		
		System.out.print("getHellowList:");
		for(IResultRow row:service.getHellowList()) {
			System.out.print(row.getText()+" ");
		}
		System.out.println("");
		System.out.println(service.getHelloArr());
	}
//	@Produces
//	public static IRemoteService getService() throws NamingException {
//		return InitialContext.doLookup("java:global/ejb-test-ear-0.0.1-SNAPSHOT/ejb-test-ejb-0.0.1-SNAPSHOT/Service!com.gerson.IRemoteService");
//	}
}
