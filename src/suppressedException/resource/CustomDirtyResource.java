package suppressedException.resource;

public class CustomDirtyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        throw new NullPointerException("NPE occurred from Custom Dirty Resource");
    }

    public void readFromResource(){
        throw new RuntimeException("Some Runtime Exception from Dirty Resource");
    }
}
