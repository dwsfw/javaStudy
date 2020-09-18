package com.elb.chat;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend("localhost",5555,8888)).start();
        new Thread(new TalkReceive(9999,"学生")).start();
    }
}
