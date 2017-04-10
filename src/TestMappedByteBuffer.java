import java.io.File;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;  
import java.nio.MappedByteBuffer;  
import java.nio.channels.FileChannel;  
import java.util.Scanner;
  
public class TestMappedByteBuffer {  
  
    public static void main(String[] args) throws Exception {  
    	try{
    		byte[] src = null;
    		File file = new File("src/a");
    		String content = "helloworld";
    		if(!file.exists())
    			file.createNewFile();
    		//RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
    		//FileChannel fc = accessFile.getChannel();
    		while(true){
        		RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
        		FileChannel fc = accessFile.getChannel();
    	        Scanner in = new Scanner(System.in);
    	        content= in.nextLine();
    	       
        		src = content.getBytes("utf-8");
        		int count = src.length;
        		System.out.println("len=" + src.length);
        		MappedByteBuffer mappedFBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, count);
        		mappedFBuffer.put(src);
        		fc.truncate(count);
        		fc.close();
        		accessFile.close();
    		}

    		
    	} catch(Exception e) {
    		System.out.println("exception:" + e);
    	}
    }  
  
}  