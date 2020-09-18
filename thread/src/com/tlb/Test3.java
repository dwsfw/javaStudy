package com.tlb;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class Test3 implements Callable<Boolean> {
    private String url;//网络图片地址
    private String name;//文件的名字

    public Test3(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("正在下载"+name);
        return true;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test3 test3=new Test3("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4046421373,3523928932&fm=26&gp=0.jpg","1.jpg");
        Test3 test1=new Test3("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3874473603,4242529909&fm=26&gp=0.jpg","2.jpg");
        Test3 test2=new Test3("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2123314630,3110609258&fm=26&gp=0.jpg","3.jpg");
//        创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);
//        提交执行
        Future<Boolean> r1=ser.submit(test1);
        Future<Boolean> r2=ser.submit(test2);
        Future<Boolean> r3=ser.submit(test3);
//        获取结果
        boolean t1=r1.get();
        boolean t2=r2.get();
        boolean t3=r3.get();
//        关闭服务
        ser.shutdownNow();
    }
}
