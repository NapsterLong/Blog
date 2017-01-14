package com.napster.controller.admin;

import com.baidu.ueditor.ActionEnter;
import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.StorageManager;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * UEditor编辑器后台Controller
 */
@Controller
@RequestMapping(value = "/admin")
public class UEditorController {

    @Value("${rootPath}")
    private String rootPath;

    @RequestMapping(value = "/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        try {
            FileItemStream fileStream = null;
            ServletFileUpload upload = new ServletFileUpload(
                    new DiskFileItemFactory());
            FileItemIterator iterator = upload.getItemIterator(request);
            while (iterator.hasNext()) {
                fileStream = iterator.next();
                if (!fileStream.isFormField())
                    break;
                fileStream = null;
            }
            if (fileStream == null) {
                System.out.println("还是tm没有");
            } else {
                InputStream is = fileStream.openStream();
                State storageState = StorageManager.saveFileByInputStream(is,
                        "/Users/mfhj-dz-001-324/Desktop/A/a1.jpeg", 1000000000);
                is.close();
                System.out.println("有了");
            }
        } catch (Exception e) {

        }

        PrintWriter writer = null;
        try {
            response.setContentType("application/json");
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            String exec = new ActionEnter(request, rootPath).exec();
            writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }


}
