package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

public class SampleController implements Initializable
{


    @FXML
    private TextField txt2;

    @FXML
    private TextField txt1;

    @FXML
    private ComboBox<String> combox3;

    @FXML
    private ComboBox<String> combox2;

    @FXML
    private Button bt1;

    @FXML
    private ObservableList<String> listMass=FXCollections.observableArrayList("g","kg","mg");
    private double []Mass= {1,1000,0.001}; //pour differencier les differents conversions.
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		combox2.setItems(listMass);
		combox3.setItems(listMass);
		combox2.getSelectionModel().selectFirst();
		combox3.getSelectionModel().selectFirst();

	}
	@FXML
	void convert1()
	{
		double orig,Dest;
		System.out.println(combox2.getSelectionModel().getSelectedIndex());
	}
}
