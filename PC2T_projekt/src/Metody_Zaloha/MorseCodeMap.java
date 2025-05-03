package Metody_Zaloha;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeMap {

	public static Map<String, String> morseCodeBook = new HashMap<String, String>();
	
	public static void fillMap() {
		morseCodeBook.put("a", ".-");
		morseCodeBook.put("b", "-...");
		morseCodeBook.put("c", "-.-.");
		morseCodeBook.put("d", "-..");
		morseCodeBook.put("e", ".");
		morseCodeBook.put("f", "..-.");
		morseCodeBook.put("g", "--.");
		morseCodeBook.put("h", "....");
		morseCodeBook.put("i", "..");
		morseCodeBook.put("j", ".---");
		morseCodeBook.put("k", "-.-");
		morseCodeBook.put("l", ".-..");
		morseCodeBook.put("m", "--");
		morseCodeBook.put("n", "-.");
		morseCodeBook.put("o", "---");
		morseCodeBook.put("p", ".--.");
		morseCodeBook.put("q", "--.-");
		morseCodeBook.put("r", ".-.");
		morseCodeBook.put("s", "...");
		morseCodeBook.put("t", "-");
		morseCodeBook.put("u", "..-");
		morseCodeBook.put("v", "...-");
		morseCodeBook.put("w", ".--");
		morseCodeBook.put("x", "-..-");
		morseCodeBook.put("y", "-.--");
		morseCodeBook.put("z", "--..");
	}
		
}
