package ua.upc.vocationprojectpres.util;

import ua.upc.vocationprojectpres.test.NewRequest;
import ua.upc.vocationprojectpres.test.ProcessedRequest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class RequestWriter {

    private final String requestsFilePath =  "D://requests.csv";
    private final String processedRequestsFilePath = "D://processed_requests.csv";

    public RequestWriter(ProcessedRequest request) throws IOException {
        File requests = new File(processedRequestsFilePath);
        if(!requests.exists()){
            createFileTemplate(request);
        }
    }

    public RequestWriter(NewRequest request) throws IOException {
        File requests = new File(requestsFilePath);
        if(!requests.exists()) {
            createFileTemplate(request);
        }
        writeToFile(request);
    }


    private void writeToFile(ProcessedRequest request) throws IOException {
        FileWriter csvWriter = new FileWriter(processedRequestsFilePath);
        List<String> requestData = request.getRequestData();
        for (String row : requestData) {
            csvWriter.append(String.join(",",row));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    private void writeToFile(NewRequest request) throws IOException {
        FileWriter csvWriter = new FileWriter(requestsFilePath,true);
        List<String> requestData = request.getRequestData();
        csvWriter.append(String.join(", ",requestData));
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }


    private void createFileTemplate(NewRequest request) throws IOException {
        System.out.println(request.getRequester().getFirstName());
        System.out.println("Creating new file");
        FileWriter  csvWriter = new FileWriter(requestsFilePath);
        List<String> templateRows = Arrays.asList(
                "Name","Second name","Position","Image path","Vocation type","Start date","End date","Reason");
        for(String row : templateRows){
            csvWriter.append(String.join(",",row));
        }
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }

    private void createFileTemplate(ProcessedRequest request) throws IOException {
        FileWriter  csvWriter = new FileWriter(processedRequestsFilePath);
        List<String> templateRows = Arrays.asList(
                "Name","Second name","Position","Image path","Vocation type","Start date","End date","Reason",
                "Approver name","Aprrover Second name","Status","DenyReason");
        for(String row : templateRows){
            csvWriter.append(String.join(",",row));
        }
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }



}
