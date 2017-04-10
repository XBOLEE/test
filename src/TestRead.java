import java.io.File;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;  
import java.nio.MappedByteBuffer;  
import java.nio.channels.FileChannel;  
  
public class TestRead {  
  
    public static void main(String[] args) throws Exception {  
    	try{
    		byte[] src = null;
    		int len = 0;
    		while(true){
        		File accessFile = new File("src/a");
        		len = (int)accessFile.length();
        		src = new byte[len];
        		FileChannel fc = new RandomAccessFile(accessFile, "rw").getChannel();
        		MappedByteBuffer mappedFBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, len);
        		for(int i = 0; i < len; i++){
        			src[i] = mappedFBuffer.get(i);
        		}
        		String content = new String(src, "utf-8");
        		System.out.println("content = " + content);
        		fc.close();
        		Thread.sleep(1000);
    		}

    		
    	} catch(Exception e) {
    		System.out.println("exception:" + e);
    	}
    }  
  
}  