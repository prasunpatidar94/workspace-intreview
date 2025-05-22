package com.pp.sun.singleton_pattern;


//called class
public class DoubleCheckLockingSingletonClass {
    private volatile static DoubleCheckLockingSingletonClass instance;

    private DoubleCheckLockingSingletonClass() {
    }

    public static DoubleCheckLockingSingletonClass getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockingSingletonClass.class) {
                if (instance == null) instance = new DoubleCheckLockingSingletonClass();
            }
        }
        return instance;
    }

}


