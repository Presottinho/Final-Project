package util;

public class Counter {

	private static Integer cont = 0;
	
	public static Integer proximoId() {
		cont++;
		return cont;
	}
	
}
