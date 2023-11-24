package tds.td7_swing_;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class ReadWriteManager {
	public static void readFile(File file, List<Character> contents) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath()));
			int currentChar;
			while((currentChar = bufferedReader.read()) != -1) {
				contents.add((char) currentChar);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
