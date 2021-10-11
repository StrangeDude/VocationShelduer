package ua.upc.vocationprojectpres.test;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import ua.upc.vocationprojectpres.util.RequestReader;
import ua.upc.vocationprojectpres.util.RequestWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TestModel {
        private final ObservableList<Person> personList = FXCollections.observableArrayList(person ->
            new Observable[] {person.firstNameProperty(), person.secondNameProperty()});

        private final SimpleObjectProperty<Person> currentPerson = new SimpleObjectProperty<>();

        private final ObservableList<NewRequest> requestList = FXCollections.observableArrayList();

        private final SimpleObjectProperty<Request> currentRequest = new SimpleObjectProperty<>();

        public ObjectProperty<Person> currentPersonProperty() {
            return currentPerson ;
        }

        public final Person getCurrentPerson() {
            return currentPersonProperty().get();
        }

        public final void setCurrentPerson(Person person) {
            currentPersonProperty().set(person);
        }

        public ObservableList<Person> getPersonList() {
            return personList ;
        }

        public ObjectProperty<Request> currentRequestProperty() {
            return currentRequest ;
        }

        public final Request getCurrentRequest() {
            return currentRequestProperty().get();
        }

        public final void setCurrentRequest(Request request) {
            currentRequestProperty().set(request);
        }

        public ObservableList<NewRequest> getRequestList() {
            return requestList ;
        }

        private Node panel;

        public void loadTestData() {
            Person user = new Person("Name","Second name","Position");
            this.setCurrentPerson(user);
        }

        public void writeRequest() throws IOException {
            new RequestWriter((NewRequest) this.getCurrentRequest());
        }

        public void readRequest() throws IOException {
            RequestReader requestReader = new RequestReader();
            if(!requestList.isEmpty()){ requestList.clear();}
            requestList.addAll(requestReader.getRequestList());

            //List<String[]> requestsData = requestReader.getRequestsData();
            //for(String[] arr: requestsData){
            //System.out.println(Arrays.toString(arr));
            //}
            //System.out.println(requestsData.toString());
        }

        private  Map<String, SideMenuItem> menuItemMap;

        public Map<String, SideMenuItem> getMenuItemMap() {
            return menuItemMap;
        }

        public void setMenuItemMap(Map<String, SideMenuItem> menuItemMap) {
            this.menuItemMap = menuItemMap;
        }

        private String test;

        public void setTestHello(String test) {
            this.test = test;
        }

        public String getTestHello() {
            return test;
        }
}
