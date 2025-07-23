package com.example.pajoheshgram.ui.login;

public class Country {
    private final String name;
    private final String code;

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name + " (" + code + ")";
    }
}
