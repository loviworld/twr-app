package com.lovi.twr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.lovi.puppyio.core.launcher.AppLauncher;

@SpringBootApplication
public class App 
{
	private final static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
    	AppLauncher appLauncher = AppLauncher.create();
        
        appLauncher.runAsSpringApp(App.class, 8080,r->{
        	logger.info(r);
        }, fail->{
        	logger.error(fail.getMessage());
        }, args);
    }
}
