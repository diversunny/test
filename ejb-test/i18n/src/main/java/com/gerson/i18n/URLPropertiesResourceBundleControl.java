package com.gerson.i18n;

import java.io.*;
import java.net.*;
import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class URLPropertiesResourceBundleControl extends ResourceBundle.Control {
	
	 @Override
	    public ResourceBundle newBundle(String baseName, Locale locale,
	                                    String format,
	                                    ClassLoader loader,
	                                    boolean reload)
	        throws IllegalAccessException,
	               InstantiationException, IOException {
		 System.out.println("called me");
	        if (baseName == null || locale == null
	            || format == null || loader == null) {
	            throw new NullPointerException();
	        }
	        ResourceBundle bundle = null;
	        if(format.equals("java.properties")) {	        	 
	        	 String url="https://qs.ifco-online.com/ResourcesWeb/resources/properties/";
	        	 URL[] urls=new URL[] {new URL(url)}; 
	        	 URLClassLoader urlClassloader=new URLClassLoader(urls,loader);	        	
	        	 bundle= super.newBundle(baseName, locale, format, urlClassloader, reload);
	        	 if(bundle==null)bundle= super.newBundle(baseName, locale, format, loader, reload);	
	        }else {
	        	bundle= super.newBundle(baseName, locale, format, loader, reload);	
	        }
	        return bundle;
	    }
}
