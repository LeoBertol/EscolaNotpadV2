package br.escolanotpad.sc.commons;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Utils {
	
	public static String senhaToSha256(String senha){
		try{
			MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
			BigInteger hash = new BigInteger(1, algoritmo.digest(senha.getBytes("UTF-8")));
			System.out.println(hash);
			//%[flags][width]conversion
			//[flags] = 0 -> Indica que n�o ter� zeros a esquerda (polariza��o)
			//[width] = 1 -> tamanho m�ximo da convers�o de cada hash.
			//conversion = X -> Convers�o para hexadecimal
			return String.format("%01x", hash);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
