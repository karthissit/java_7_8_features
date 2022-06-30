package suppressedException.imp;

import suppressedException.resource.CustomDirtyResource;
import java.util.logging.Logger;

public class HandleSuppressedException {
    private static final Logger logger = Logger.getLogger("HandleSuppressedException.Logger");
    public static void main(String[] args) {
        try{
            beforeJava7();
        }catch (Exception ex){
            logger.severe("Java7: Got some exception"+ ex.getMessage());
        }
        try{
            fromJava7();
        }catch (Exception ex){
            for (Throwable throwable : ex.getSuppressed()) {
                if(throwable instanceof NullPointerException){
                    logger.severe("Caught" + throwable.getMessage());
                }else if(throwable instanceof RuntimeException){
                    logger.severe("Caught RTE" + throwable.getMessage());
                }
            }
        }
    }

    // Java 7 new methods introduced
    // Throwable.addSuppressed(a Throwable object type)
    // Throwable.getSuppressed()


    public static void beforeJava7() throws Exception{
        CustomDirtyResource resource = null;
        try
        {
            resource = new CustomDirtyResource();
            resource.readFromResource();
        }finally {
            resource.close();
        }
    }

    public static void fromJava7() throws Exception{
        try(CustomDirtyResource cr = new CustomDirtyResource();){
            cr.readFromResource();
        }
    }
}
