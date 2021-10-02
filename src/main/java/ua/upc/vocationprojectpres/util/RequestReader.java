package ua.upc.vocationprojectpres.util;

import javafx.scene.image.Image;
import ua.upc.vocationprojectpres.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class RequestReader {

    private final String requestsFilePath =  "D://requests.csv";
    private final String processedRequestsFilePath = "D://processed_requests.csv";




    private String[] getProcesedRequestData() throws IOException {
        String row;
        String[] data = new String[0];
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(processedRequestsFilePath));

            while ((row = csvReader.readLine()) != null) {
                data = row.split(", ");
            }
            csvReader.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<String[]>  getRequestsData() throws IOException {
        List<String[]> stringList = new ArrayList<String[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(requestsFilePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");

                //System.out.println(line + "\n");
                //System.ouxt.println(Arrays.toString(data));
                stringList.add(data);
            }
            return stringList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<NewRequest> getRequestList() throws IOException {
        List<String[]> requestsData = getRequestsData();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        assert requestsData != null;
        List<NewRequest> requestList = new ArrayList<>();
        for (String[] data: requestsData) {

            String name = data[0];
            String secondName = data[1];
            String position = data[2];
            Image image = new Image(data[3]);
            String vocationType = data[4];
            LocalDate startDate = LocalDate.parse(data[5],formatter);
            LocalDate endDate = LocalDate.parse(data[6],formatter);
            String reason;
            Person person = new Person(name,secondName,position,image);
            Vocation vocation = new Vocation(startDate,endDate);
            //if(data.length == 7) {vocation.setReason(data[7]);}
            NewRequest request = new NewRequest(vocation, person);
            requestList.add(request);
        }
        return requestList;
    }
}
