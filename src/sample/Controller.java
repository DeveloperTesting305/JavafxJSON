package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField address;

    @FXML
    private TextField contactNo;

    static {
//        JSONObject objectDetail = new JSONObject();
//        objectDetail.put("Name","Salman");
//        objectDetail.put("Father Name","Mustaque");
//        objectDetail.put("Age","22");
//
//        JSONObject object = new JSONObject();
//        object.put("Biodata", objectDetail);
//
//        try(FileWriter fileWriter = new FileWriter("config.json")){
//            fileWriter.write(object.toJSONString());
//            fileWriter.flush();
//        }catch (Exception ee){
//            ee.printStackTrace();
//        }

//
//        objectDetail = new JSONObject();
//        objectDetail.put("Number", "54654");
//
//        object = new JSONObject();
//        object.put("Contact", objectDetail);
//
//        array.add(object);
//
//        try(FileWriter fileWriter = new FileWriter("config.json", true)){
//            fileWriter.write(array.toJSONString());
//            fileWriter.flush();
//        }catch (Exception ee){
//            ee.printStackTrace();
//        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("config.json")){
            JSONObject object = (JSONObject) parser.parse(reader);
            System.out.println(object);

            JSONObject objectDetail = (JSONObject) object.get("Biodata");

            address.setText(objectDetail.get("Name").toString());
            contactNo.setText(objectDetail.get("Age").toString());
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }

    @FXML private void saveAction(){
        JSONObject objectDetail = new JSONObject();
        objectDetail.put("Name", address.getText());
        objectDetail.put("Age", contactNo.getText());

        JSONObject object = new JSONObject();
        object.put("Biodata", objectDetail);

        try(FileWriter writer = new FileWriter("config.json")){
            writer.write(object.toJSONString());
            writer.flush();
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }
}
