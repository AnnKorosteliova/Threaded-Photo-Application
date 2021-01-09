package observer;

import java.io.File;
import java.io.IOException;

import config.ConfigurationProvider;
import utils.image.ImageProcessor;

public class DirectoryObserver {
	
	private ImageProcessor ip;
	private ConfigurationProvider cfgProvider;
	
	public DirectoryObserver(ImageProcessor ip, ConfigurationProvider cp) {
		this.ip = ip;
		this.cfgProvider = cp;
	}
		
	public void observe(long lifeSpan /*REQUIRED FOR TESTING*/ ) throws IOException {
		File rootDirectory = new File(cfgProvider.get("original.path"));
		int lifeCounter = 0; /*REQUIRED FOR TESTING*/
		
		if(rootDirectory.exists()) {
			if(rootDirectory.isDirectory()) {	
											
				System.out.println("DIRECTORY FOUND!");				
									
				String[] fileNames;
				long lastLenght = 0;			
				
//				int lifeCounter = 0; /*REQUIRED FOR TESTING*/
				
				while(lifeCounter <= lifeSpan /*REQUIRED FOR TESTING*/ ) {
					fileNames = rootDirectory.list();	
					
							if(fileNames.length != lastLenght) {																	
								System.out.println("--------------------------------");
								lastLenght = fileNames.length;
								System.out.println("Files found: " + lastLenght);
								for (String name : fileNames) {
									System.out.println(">>  " + name);
									//processing image file
									this.ip.resizeImage(new File(cfgProvider.get("original.path") + "\\" + name), new File(cfgProvider.get("processed.path") + "\\thumb-" + name));
								}
							}							
					}				  	
				} 
		    else {
				System.err.println("is NOT a Directory!");
			}
		} else {
			System.err.println("No such directory!");
		}
		
		try {
			Thread.sleep(100);
			lifeCounter += 100; /*REQUIRED FOR TESTING*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
