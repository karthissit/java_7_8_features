package objectsFeature.imp;

import objectsFeature.entity.Employee;

import java.util.Objects;

public class TestObjectsUtilJava7 {
    public static void main(String[] args) {
        testObject("a");
        testObject(new Employee());
        testObject(null);
        testObject(1);
    }

    public static void testObject(Object obj){
        Objects.requireNonNull(obj, "The Object is "+ obj);
        Objects.requireNonNull(obj, new Object().toString());
    }
}
