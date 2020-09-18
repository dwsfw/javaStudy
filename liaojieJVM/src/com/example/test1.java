package com.example;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class test1 {
    public static void main(String[] args) throws AWTException {

        String sentence = "爱我你怕了吗";//定义要发送的话

        //以下三行为将上述字符串放到剪切板内，相当于做了一次复制操作
//        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
//        Transferable tText = new StringSelection(sentence);
//        clip.setContents(tText, null);
        Robot robot = new Robot();
        robot.delay(1000);
        for (int i = 0; i < 30; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }
}








