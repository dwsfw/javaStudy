package com.elb.URLDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDown {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://m10.music.126.net/20200915113945/40ce2f63ac4d1c46dc988b2cbb83ee35/yyaac/obj/wonDkMOGw6XDiTHCmMOi/3047335779/c10c/e3a7/4c42/719b0c3fcba91b78ad27ace8be81c3e4.m4a");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("name.m4a");
        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
