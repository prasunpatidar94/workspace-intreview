package com.pp.sun.singleton_pattern;

//Caller code
public class SingletonCallerClass {
    public static void main(String[] args) {
//       #01 Double-Checked Locking (Recommended for performance + safety)
        System.out.println(DoubleCheckLockingSingletonClass.getInstance());
        System.out.println(DoubleCheckLockingSingletonClass.getInstance());
        System.out.println(DoubleCheckLockingSingletonClass.getInstance());
        System.out.println(DoubleCheckLockingSingletonClass.getInstance());

//       #02 Singleton using Enum (Best way in Java)
//        Thread-safe, Serialization-safe, Reflection-safe
//        Recommended by Effective Java (by Joshua Bloch)
        System.out.println(SingletonUsingEnumClass.INSTANCE);
        System.out.println(SingletonUsingEnumClass.INSTANCE);
        System.out.println(SingletonUsingEnumClass.INSTANCE);
        System.out.println(SingletonUsingEnumClass.INSTANCE);
        SingletonUsingEnumClass.INSTANCE.doWork();
    }
}


