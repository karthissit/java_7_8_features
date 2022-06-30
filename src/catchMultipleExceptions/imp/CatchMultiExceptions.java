package catchMultipleExceptions.imp;

public class CatchMultiExceptions {
    public static void main(String[] args) {
        //before Java7
        try{
            callToPrintIf2(2);
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }

        //From Java 7

        try{
            callToPrintIf2(2);
        }catch (NullPointerException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    public static void callToPrintIf2(int numberToProcess) throws NullPointerException, IllegalArgumentException{
        if(numberToProcess == 0){
            throw new NullPointerException();
        }else if(numberToProcess == 1){
            throw new IllegalArgumentException();
        }else{
            System.out.println("The number is valid! No Exceptions thrown");
        }
    }
}
