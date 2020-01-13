package dev.sgp.entite;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Value;

public class Test {
	@Value("${sgp.email}")
	static String domain;
	public static void main(String[] args) {
		Collaborateur c = new Collaborateur();
		System.out.println(domain);
		ResourceBundle myConfig = ResourceBundle.getBundle("application");
Enumeration<String> keys = myConfig.getKeys();
		
		while (keys.hasMoreElements()) {
			String key=keys.nextElement();
	         System.out.println(key+" "+myConfig.getString(key));
	      }
	}

}
