package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.implementation.Implementation;

public final class Task3 {
    private Task3() {
    }

    private static final String FIB_CLASS_NAME = "FibonacciUtils";
    private static final String METHOD_NAME = "fib";

    public static Object returnClass() {
        var unloaded = new ByteBuddy()
            .subclass(Object.class)
            .name(FIB_CLASS_NAME)
            .defineMethod(METHOD_NAME, long.class, Visibility.PUBLIC)
            .withParameter(int.class, "n")
            .intercept(createMethodFib())
            .make().load(Task3.class.getClassLoader()).getLoaded();
        try {
            return unloaded.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Implementation createMethodFib() {
        return new Implementation.Simple(new FibByteCodeAppender());
    }
}
