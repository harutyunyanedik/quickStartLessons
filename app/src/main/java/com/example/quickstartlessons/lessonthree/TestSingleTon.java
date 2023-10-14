package com.example.quickstartlessons.lessonthree;

public class TestSingleTon {

    private static TestSingleTon instance = null;

    private TestSingleTon() {

    }

    public static TestSingleTon getInstance() {
        if (instance == null) {
            synchronized (TestSingleTon.class) {
                if (instance == null) {
                    instance = new TestSingleTon();
                }
            }
        }
        return instance;
    }
}
