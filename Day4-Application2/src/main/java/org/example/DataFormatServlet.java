package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

//@WebServlet(urlPatterns = "/data-formats")
/*Path Variables*/
@WebServlet(urlPatterns = "/data-formats/*")
@MultipartConfig
public class DataFormatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //check the content type
        String contentType= request.getContentType();
        System.out.println("contentType:"+contentType);

        //1.query parameters
            //System.out.println(request.getParameter("id"));
            //System.out.println(request.getParameter("name"));
        //2.path variables
            //System.out.println(request.getPathInfo());
            //System.out.println(request.getPathInfo().substring(1));
        //3.x-www-form-urlencoded
            //System.out.println(request.getParameter("id"));
            //System.out.println(request.getParameter("name"));
        //4.form-data
           /* System.out.println(request.getParameter("id"));
            System.out.println(request.getParameter("name"));
            //Read the file
                Part filePart = request.getPart("image");
                System.out.println(filePart.getSubmittedFileName());
            //create a directory
                File uploadDir = new File("C:\\Lectures\\Batch\\GDSE73\\AAD\\JAVAEE\\JavaEE-Theory\\Day4-Application2\\src\\main\\resources\\images");
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
            //save the file
                String fullPath=uploadDir.getAbsolutePath()+File.separator+filePart.getSubmittedFileName();
                filePart.write(fullPath);*/
        //5.json

        // Feature        // JSON         //XML        //X-WWW-Form-Urlencoded     //form-data
        //--------------------------------------------------------------------------------------
        //human readable  //yes           //yes        //yes                       //Partial
        //file support    //no            //no         //no                        //yes
        //complex data    //yes           //yes        //no                        //yes
        //modern API      //yes*3         //NOOO       //NOOOO                     //yes

    }
}
