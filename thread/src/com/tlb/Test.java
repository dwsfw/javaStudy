package com.tlb;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Test extends Thread{
    private String url;//网络图片地址
    private String name;//文件的名字

    public Test(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("正在下载"+name);
        super.run();
    }

    public static void main(String[] args) {
        Test test3=new Test("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4046421373,3523928932&fm=26&gp=0.jpg","1.jpg");
        Test test1=new Test("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3874473603,4242529909&fm=26&gp=0.jpg","2.jpg");
        Test test2=new Test("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2123314630,3110609258&fm=26&gp=0.jpg","3.jpg");
        test3.start();
        test1.start();
        test2.start();

    }
}
class WebDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}
