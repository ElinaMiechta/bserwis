package com.budserwis.javacore.domain.exception;

public class UserDoesNotExist extends Exception {
    private final String msg = "User is not present in DataBase";

    public String toString() {
        return "Information from DB: " + msg;
    }
}
