package util;

import java.text.Normalizer;

public class corrige {
	
	public static String corrigeEmail(String email) {
		
		email = email.toLowerCase();
		email = Normalizer.normalize(email, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		
		return email;
	}
	
	public static String corrigeNotas(String notaF) {
		
		notaF = notaF.toLowerCase();
		
		return notaF;
	}
	
	public static String corrigeConfirmacao(String confirmacao) {
		
		confirmacao = confirmacao.toLowerCase();
		
		return confirmacao;
	}
	
}
