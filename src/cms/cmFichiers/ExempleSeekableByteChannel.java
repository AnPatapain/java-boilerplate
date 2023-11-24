package cms.cmFichiers;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExempleSeekableByteChannel{

	public static void main(String[] args)  throws Exception{
	    final ByteBuffer donneesBonjour = ByteBuffer.wrap("Bonjour".getBytes());
	    final ByteBuffer donneesBonsoir = ByteBuffer.wrap("Bonsoir".getBytes());
	      
	    final Path path = Paths.get("C:/tmp/fichier.bin");
	     
	    Files.deleteIfExists(path);
	    try (FileChannel fileChannel = FileChannel.open(path, 
	         StandardOpenOption.CREATE, StandardOpenOption.WRITE,
	         StandardOpenOption.SYNC)) {
	      fileChannel.position(100);
	      fileChannel.write(donneesBonjour);
	    }
	      
	    try (SeekableByteChannel sbc = Files.newByteChannel(path, 
	         StandardOpenOption.WRITE, StandardOpenOption.SYNC)) {
	      sbc.position(200);
	      sbc.write(donneesBonsoir);
	    }
	    
	    // regarder avec Format-hex le fichier

	}

}
