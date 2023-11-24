package tds.td7_swing_;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Model {
	private List<File> files;
	private List<Character> contents;
	
	public Model() {
	}
	
	public void setContents(List<Character> contents) {
		this.contents = contents;
	}
	
	public void setFiles(List<File> files) {
		this.files = files;
		this.contents = new ArrayList<Character>();
		for(File file : files) {
			ReadWriteManager.readFile(file, this.contents);
		}
	}
	
	public List<Character> getContents() {
		return contents;
	}
	
	public List<File> getFiles() {
		return files;
	}
}
