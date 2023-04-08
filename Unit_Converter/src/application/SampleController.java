package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
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
    private Button btnexit;
    
    @FXML
    private ObservableList<String> listMass=FXCollections.observableArrayList("g","kg","mg");
    private double []Mass= {1,0.001,1000}; //pour differencier les differents conversions.
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		combox2.setItems(listMass);
		combox3.setItems(listMass);
		combox2.getSelectionModel().selectFirst();
		combox3.getSelectionModel().selectFirst();

	}
	@FXML
	void quitter()
	   {
		   Alert alert=new Alert(AlertType.CONFIRMATION);
		   alert.setHeaderText("Confirmation");
		   alert.setTitle("Quit");
		   alert.setContentText("Do you really want to quit?");
		   Optional<ButtonType> result=alert.showAndWait();
		   if (result.get()==ButtonType.OK)
		   {
			   System.exit(0);
		   }
	   }
	@FXML
	private void verifNum(KeyEvent e)
	{
	TextField txt=(TextField)e.getSource();
	txt.textProperty().addListener((observable,oldValue,newValue)->
		{
			if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
			{
				txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
			}
		});
	}
	private double Conversion(ComboBox a,double tbl [])
	{
		int item=a.getSelectionModel().getSelectedIndex();
		double val=tbl[item];
		return val;
	}
	
	private void convert(ComboBox a,ComboBox b,TextField c,TextField d,double tbl[])
	{
		double from=Conversion(a,tbl);
		double depart=0;
		if (c.getText().equals(""))
		{
			depart=0;
		}
		else 
		{
			depart=Double.parseDouble(c.getText());
			double to=Conversion(b,tbl);
			double dest=(to/from)*depart;
			d.setText(String.valueOf(dest));
		}
	}
	@FXML
	private void Convert1()
	{
		convert(combox2,combox3,txt1,txt2,Mass);
	}
	@FXML
	private void Convert2()
	{
		convert(combox3,combox2,txt2,txt1,Mass);
	}
}
