package com.tencent.util.expection;

public class ErrorExpection extends Exception{
    private String expectionMessage;
    public ErrorExpection(String expectionMessage){
        this.expectionMessage=expectionMessage;
    }

    public String getExpectionMessage() {
        return expectionMessage;
    }

    public void setExpectionMessage(String expectionMessage) {
        this.expectionMessage = expectionMessage;
    }
}
