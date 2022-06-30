package rethrowExceptionWithInclusiveTypeCheck.imp;

import rethrowExceptionWithInclusiveTypeCheck.exceptions.FirstException;
import rethrowExceptionWithInclusiveTypeCheck.exceptions.SecondException;

public class TestRethrowExceptionWithTypeCheck {
    public static void main(String[] args) {
        try{
            beforeJava7("FirstException");
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            fromJava7("SecondException");
        }catch (FirstException | SecondException e){
            e.printStackTrace();
        }
    }
    private static void beforeJava7(String exceptionName) throws Exception{
        // before Java 7 compiler is not intelligent enough to detect what is thrown
        if(exceptionName.equals("FirstException")){
            throw new FirstException();
        }else if(exceptionName.equals("SecondException")){
            throw new SecondException();
        }
    }
    private static void fromJava7(String exceptionName) throws FirstException, SecondException{
        if(exceptionName.equals("FirstException")){
            throw new FirstException();
        }else if(exceptionName.equals("SecondException")){
            throw new SecondException();
        }
    }
}
