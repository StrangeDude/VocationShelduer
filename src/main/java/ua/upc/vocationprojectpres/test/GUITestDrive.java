package ua.upc.vocationprojectpres.test;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUITestDrive {

    private Person testPerson;
    private Request testVocationRequest;
    private Vocation testVocation;

    public void startTest() throws FileNotFoundException {
        testPerson = new Person("Test","Person","TestPosition");
        try {
            FileInputStream inputstream = new FileInputStream("D:\\testavatar.jpg");
            System.out.println("Image loaded");
            testPerson.setAvatar(new Image(inputstream));
        }catch (Exception ex ) {ex.printStackTrace();}
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd. MM. yyyy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = dateFormat.parse("12. 08. 2000");
            endDate = dateFormat.parse("12. 09. 2000");
            System.out.println(dateFormat.format(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

    public Person getTestPerson() {
        return testPerson;
    }

    public Request getTestVocationRequest() {
        return this.testVocationRequest;
    }


}
