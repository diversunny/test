package com.gerson;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.gerson.i18n.URLPropertiesResourceBundleControlProvider;

@Singleton
@Startup
public class StatelessSingleton {
	@EJB(lookup="java:global/ejb-test-ear/test-ejb/Service!com.gerson.IRemoteService")
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
		String url="https://qs.ifco-online.com/ResourcesWeb/resources/properties/";
   	 URL[] urls;
//	try {
//		urls = new URL[] {new URL(url)};
//		
//		 URLClassLoader urlClassloader=new URLClassLoader(urls,Thread.currentThread().getContextClassLoader());	   
//		 ResourceBundle rb=ResourceBundle.getBundle("MessageResources", Locale.GERMAN,urlClassloader);
//			System.out.println("navi.abholung_neu: " +rb.getString("navi.abholung_neu"));
//	} catch (MalformedURLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} 
//   
//		
//		 URLPropertiesResourceBundleControlProvider provider=new URLPropertiesResourceBundleControlProvider();
//		 Control control = provider.getControl("MessageResources");
//		ResourceBundle rb=ResourceBundle.getBundle("MessageResources", Locale.ENGLISH,control);
//		System.out.println("navi.abholung_neu: " +rb.getString("navi.abholung_neu"));
//		
		ResourceBundle rb2=ResourceBundle.getBundle("MessageResources", Locale.GERMAN);
		System.out.println("navi.abholung_neu: " +rb2.getString("navi.abholung_neu"));
//		
	}
//	@Produces
//	public static IRemoteService getService() throws NamingException {		
//		return InitialContext.doLookup("java:global/ejb-test/test-ejb/Service!com.gerson.IRemoteService");
//	}
}
