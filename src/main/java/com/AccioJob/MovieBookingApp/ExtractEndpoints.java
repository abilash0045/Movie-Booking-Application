package com.AccioJob.MovieBookingApp;

import com.AccioJob.MovieBookingApp.Controller.MovieController;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Endpoints{
    private String requestMethod;
    private String path;

    public Endpoints() {
    }

    public Endpoints(String requestMethod, String path) {
        this.requestMethod = requestMethod;
        this.path = path;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
public class ExtractEndpoints {

    public static void fun() {

        try {
            Workbook workbook = new XSSFWorkbook();


            List<Endpoints> endpointsList = new ArrayList<>();

            getEndpoints(endpointsList);

            Sheet sheet = workbook.createSheet("endpoints");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("path");
            headerRow.createCell(1).setCellValue("Request method");

            int rowCount = 1;

            for (Endpoints endpoints : endpointsList) {

                Row row = sheet.createRow(rowCount++);
                row.createCell(0).setCellValue(endpoints.getPath());
                row.createCell(1).setCellValue(endpoints.getRequestMethod());
            }


            try {
                FileOutputStream fileOutputStream = new FileOutputStream("endpoints.xlsx");
                workbook.write(fileOutputStream);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (Endpoints endpoints : endpointsList) {
                System.out.println(endpoints.getPath() + " " + endpoints.getRequestMethod());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void getEndpoints(List<Endpoints> endpointsList) {

        Class<?> controller = MovieController.class;

        Method[] methods = controller.getDeclaredMethods();

        for (Method method : methods){
            RequestMapping mappingInfo = method.getAnnotation(RequestMapping.class);
            if (mappingInfo != null){
                String[] paths = mappingInfo.value();
                RequestMethod[] requestMethods = mappingInfo.method();
                for (String path : paths){
                    for (RequestMethod requestMethod : requestMethods){

                        Endpoints endpoints = new Endpoints();
                        endpoints.setPath(path);
                        endpoints.setRequestMethod(requestMethod.toString());
                        endpointsList.add(endpoints);
                    }
                }
            }
        }
    }
}
