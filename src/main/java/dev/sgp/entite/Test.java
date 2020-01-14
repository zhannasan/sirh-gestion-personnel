package dev.sgp.entite;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Value;

import dev.sgp.util.DateFormatMatcher;

public class Test {
	
	public static void main(String[] args) {
		byte[] byteArray = new byte[256];
		new Random().nextBytes(byteArray);

		String randStr = new String(byteArray, Charset.forName("UTF-8"));
		StringBuffer sb = new StringBuffer();
		String alphaNum = randStr.replaceAll("[^A-Za-z0-9]", "");
		int len = 10;
		for (int i = 0; i < alphaNum.length(); i++) {
			if (Character.isLetter(alphaNum.charAt(i)) || Character.isDigit(alphaNum.charAt(i))) {
				sb.append(alphaNum.charAt(i));
				if(sb.length()==10){
					break;
				}
			}
		}
		System.out.println(sb.toString()+1);
	}

}
