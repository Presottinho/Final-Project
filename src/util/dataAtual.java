package util;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class dataAtual {
	
	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
}
