package com.example.quickstartlessons.kotlin.lessonthree;

public class Engine {
    private boolean isEngineStarted;


    public boolean isEngineStarted() {
        return isEngineStarted;
    }

    public void setEngineStarted(boolean engineStarted) {
        isEngineStarted = engineStarted;
    }

    public void startEngine(EngineStartListener listener) {
        // 10
        // lcreci benzin

        listener.onEngineStarted();
    }
}
