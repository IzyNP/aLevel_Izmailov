package com.izmaylov.hw6;

public enum EngineType {
    ELECTICAL("электрический"), DIESEL("дизельный"), GAS("бензиновый");
    private String type;

    EngineType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
