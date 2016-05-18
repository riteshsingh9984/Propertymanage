package ironman.propertyutility.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public enum ApplicationBeanLoader {

	INSTANCE;
	private ApplicationContext applicationContext;
	
	private ApplicationBeanLoader() {
		System.out.println("start the bean loading...");
		applicationContext = new ClassPathXmlApplicationContext(new String [] {
				"classpath:applicationContext.xml"
		});
		System.out.println("Done the bean loading process");
	}
	public Object getBean(String serviceName) throws Exception{
		Object obj = null;
		if(serviceName != null && !serviceName.isEmpty()){
			obj = applicationContext.getBean(serviceName);
			if(obj != null){
				return obj;
			}else{
				throw new Exception("Bean is not found");
			}
		}
		return null;
	}
	
	public ApplicationBeanLoader getInstance(){
		return ApplicationBeanLoader.INSTANCE.getInstance();
	}
}
