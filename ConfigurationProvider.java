package config;

public class ConfigurationProvider {
	
	public String get(String key) {
		if(key.equals("original.path")) {
			return "C:\\Users\\Lenovo\\Desktop\\Ann\\Java\\image_processing_samples\\original";
		} 
		else if(key.equals("processed.path")) {
			return "C:\\Users\\Lenovo\\Desktop\\Ann\\Java\\image_processing_samples\\processed";
		}
		return null;
	}
	
}
