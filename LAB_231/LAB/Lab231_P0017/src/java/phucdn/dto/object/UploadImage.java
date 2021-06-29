/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author ASUS
 */
public class UploadImage {
    private static final String UPLOAD_DIR = "images";

    public String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart("photo");
            fileName = (String) getImageName(filePart);

            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
            

            //be lai duong dan
            String applicationPath_2 = applicationPath.substring(0, applicationPath.length() - 10);
            String basePath_2 = applicationPath_2 + "web" + File.separator + UPLOAD_DIR + File.separator;

            InputStream inputStream = null;
            OutputStream outputStream = null;
            InputStream inputStream_2 = null;
            OutputStream outputStream_2 = null;
            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);

                File outputFilePath_2 = new File(basePath_2 + fileName);
                inputStream_2 = filePart.getInputStream();
                outputStream_2 = new FileOutputStream(outputFilePath_2);

                int read = 0;
                final byte[] bytes = new byte[1024];

                int read_2 = 0;
                final byte[] bytes_2 = new byte[1024];

                while ((read = inputStream.read(bytes)) != -1 && (read_2 = inputStream_2.read(bytes_2)) != -1) {
                    outputStream.write(bytes, 0, read);
                    outputStream_2.write(bytes, 0, read_2);
                }

               
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            } finally {
                if (inputStream_2 != null) {
                    inputStream_2.close();
                }
                if (outputStream_2 != null) {
                    outputStream_2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

            }

        } catch (Exception e) {
            fileName = "";
        }
        return fileName;
    }

    public String getImageName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
    }
}
