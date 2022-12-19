package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class UploadImage extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Part filePart;
        try {
            filePart = request.getPart("file");
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
        String fileName = filePart.getSubmittedFileName();
        String imagePath = request.getServletContext().getRealPath("img/");
        if(!new File(imagePath+ "/" + fileName).exists()) {
            File myfile = new File(imagePath+ "/" + fileName);
            myfile.createNewFile();
            for(Part part : request.getParts()) {
                part.write(imagePath+ "/"+ fileName);
            }service.addImageToDatabase(fileName);
            return "Controller?command=ShowImages";
        }
        return null;
    }
}
