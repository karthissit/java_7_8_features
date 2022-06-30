package javaIO;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaIOLearning {
    private static final String READ_RESOURCE = "/src/resource/string.txt";
    private static final String WRITE_RESOURCE = "/src/resource/write.txt";
    public static void main(String[] args) {
        String projectDir = System.getProperty("user.dir");
        //Check out the children of input Stream
        try(InputStream inputStream = new FileInputStream(projectDir+READ_RESOURCE)){
            System.out.println((char)inputStream.read());
//            long skip = inputStream.skip(2);
//            System.out.println("Skipped: " + skip);
//            if(inputStream.markSupported()){
//                System.out.println("This input stream is marked as supported");
//            }
//            inputStream.reset(); //resetting the marked positions
        }catch (IOException ex){
            Logger.getGlobal().log(Level.SEVERE, "Not able to read the file " + projectDir+READ_RESOURCE);
            ex.printStackTrace();
        }

        //Check out the children of output Stream
        try(OutputStream outputStream = new FileOutputStream(projectDir+WRITE_RESOURCE)){
//            byte[] b = { 65, 66, 67, 68, 69, 70 };
//            outputStream.write(b);
//            outputStream.flush();

            for (int i = 65; i < 91; i++) {
                outputStream.write(i);
            }
            outputStream.flush();
        }catch (IOException ex){
            Logger.getGlobal().log(Level.SEVERE, "Not able to write to the file " + projectDir+WRITE_RESOURCE);
            ex.printStackTrace();
        }
    }
}
