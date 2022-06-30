package reflectiveMethodExceptionHandling.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectiveMethodExceptionHandling {
    public static void main(String[] args) {
        try {
            Class.forName("reflectiveMethodExceptionHandling.exceptions.CustomReflectionMethodException")
                    .getMethod("withJava7")
                    .invoke(null, new Object[]{});
        } catch (ReflectiveOperationException e) {
            //newly introduced super class for ClassNotFoundException |
            // NoSuchMethodException |
            // IllegalAccessException |
            // InvocationTargetException
            Logger.getLogger("reflectiveMethodExceptionHandling.imp.ReflectiveMethodExceptionHandling")
                    .log(Level.SEVERE, e.toString());
        }
    }
}
