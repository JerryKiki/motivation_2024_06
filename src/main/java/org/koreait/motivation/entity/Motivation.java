package org.koreait.motivation.entity;

public class Motivation {
    private int myId;
    private String body;
    private String source;

    public int getMyId() {
        return myId;
    }

    public Motivation(int myId, String body, String source) {
        this.myId = myId;
        this.body = body;
        this.source = source;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String motivation) {
        this.body = motivation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
