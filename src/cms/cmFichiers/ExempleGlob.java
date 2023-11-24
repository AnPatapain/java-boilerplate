package cms.cmFichiers;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class ExempleGlob {

	public static void main(String[] args) {
	      PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.pdf");
	      Path path = Paths.get("c:/tmp/main.pdf").getFileName();
	      if (matcher.matches(path)) {
	        System.out.println(path);
	      }

	}

}
