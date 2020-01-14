package dev.sgp.util;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author janka
 *
 */
public class Matricule {

	/**
	 * Créer un matricule alpha-numérique d'une longueur de 10 charactères
	 * 
	 * @return
	 */
	public static String creerMatricule() {
		byte[] byteArray = new byte[256];
		new Random().nextBytes(byteArray);

		String randStr = new String(byteArray, Charset.forName("UTF-8"));
		StringBuffer sb = new StringBuffer();
		String alphaNum = randStr.replaceAll("[^A-Za-z0-9]", "");

		for (int i = 0; i < alphaNum.length(); i++) {
			if (Character.isLetter(alphaNum.charAt(i)) || Character.isDigit(alphaNum.charAt(i))) {
				sb.append(alphaNum.charAt(i));
				if(sb.length()==10){
					break;
				}
			}
		}
		String matricule=sb.toString();
		return matricule;
	}
}
