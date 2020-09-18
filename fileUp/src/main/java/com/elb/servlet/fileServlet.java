package com.elb.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class fileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!ServletFileUpload.isMultipartContent(req) ){
            return;
        }
        //创建上传文件保存路径，建议在web-inf 安全
        String realPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();//创建目录文件
        }
        //缓冲，临时文件
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tem");
        File tmpfile = new File(tmpPath);
        if(!tmpfile.exists()){
            tmpfile.mkdir();
        }
        disk(tmpfile);
        ServletFileUpload servletFileUpload = getServletFileUpload();
        String msg=up(req, servletFileUpload,realPath);
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/message.jsp").forward(req, resp);

    }

    private String up(HttpServletRequest req, ServletFileUpload servletFileUpload,String uploadpath) throws IOException {
        String msg="";
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                if(fileItem.isFormField()){
                    String name = fileItem.getName();
                    String value = fileItem.getString("UTF-8");//处理乱码
                }else{
                    //处理文件
                    String name = fileItem.getName();
                    if(name.trim().equals("")||name==null)
                        continue;
                    String filename = name.substring(name.lastIndexOf("/") + 1);
                    String fileExName = name.substring(name.lastIndexOf(".") + 1);
                    //网络传输中都需要序列化
                    String uuidpath = UUID.randomUUID().toString();
                    //存放地址
                    String reapath = uploadpath + "/" + uuidpath;
                    File realfile = new File(reapath);
                    if(!realfile.exists())
                        realfile.mkdir();
                    //文件传输
                    InputStream inputStream = fileItem.getInputStream();
                    FileOutputStream fileOutputStream = new FileOutputStream(reapath + "/" + filename);
                    byte[] bytes = new byte[1024 * 1024];
                    int len=0;
                    while ((len=inputStream.read(bytes))>0){
                        fileOutputStream.write(bytes,0,len);
                    }
                    fileOutputStream.close();
                    inputStream.close();
                    msg="文件上传成功";
                    fileItem.delete();
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return msg;
    }

    private ServletFileUpload getServletFileUpload() {
        //获取servletfileupload
        ServletFileUpload servletFileUpload = new ServletFileUpload();
        servletFileUpload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long l, long l1, int i) {
                System.out.println("总大小："+l+"  已上传："+l1);
            }
        });
        servletFileUpload.setHeaderEncoding("UTF-8");
        servletFileUpload.setFileSizeMax(1024*1024*10);
        servletFileUpload.setSizeMax(1024*1024*10);
        return servletFileUpload;
    }

    private void disk(File tmpfile) {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1024*1024);//
        diskFileItemFactory.setRepository(tmpfile);//
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
