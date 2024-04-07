package com.bestiary.bestiary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bestiary.bestiary.config.AppConfig;

public class BestiaryApplication {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		BestiaryRunApp runApp = appContext.getBean(BestiaryRunApp.class);

		runApp.run(args);

		((AnnotationConfigApplicationContext) appContext).close();
	}

}
