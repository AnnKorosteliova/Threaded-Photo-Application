package main;

import java.io.IOException;

import config.ConfigurationProvider;
import observer.DirectoryObserver;
import utils.image.ImageProcessor;

public class Application {
	
	public static void main(String[] args) throws IOException {
		
		ImageProcessor ip = new ImageProcessor();
		ConfigurationProvider cp = new ConfigurationProvider();
		
		DirectoryObserver dirObserver = new DirectoryObserver(ip, cp);		
		dirObserver.observe(5000);
		
	}
	

}
