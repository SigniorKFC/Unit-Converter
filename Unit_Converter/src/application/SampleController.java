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
 // Tout les @FXML ici sont pour declarer les conteneurs JavaFX.
    @FXML
    private Button btnexit;

    @FXML
    private ComboBox<String> combox3;

    @FXML
    private ComboBox<String> combox2;

    @FXML
    private ComboBox<String> combox5;

    @FXML
    private ComboBox<String> combox4;

    @FXML
    private ComboBox<String> combox7;

    @FXML
    private ComboBox<String> combox6;

    @FXML
    private TextField txt6;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt1;

    @FXML
    private Button btnexit2;

    @FXML
    private Button btnexit3;

    
    @FXML
    private ObservableList<String> listMass=FXCollections.observableArrayList("g","kg","mg");
    private double []Mass= {1,1000,0.001}; //pour differencier les differents conversions de mass.
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// Ces lignes designe chaque combobox a une des lists et met le premier option a chaqu'un des combobox.
		combox2.setItems(listMass);
		combox3.setItems(listMass);
		combox2.getSelectionModel().selectFirst();
		combox3.getSelectionModel().selectFirst();
		combox4.setItems(listSpeed);
		combox5.setItems(listSpeed);
		combox4.getSelectionModel().selectFirst();
		combox5.getSelectionModel().selectFirst();
		combox6.setItems(listEnergy);
		combox7.setItems(listEnergy);
		combox6.getSelectionModel().selectFirst();
		combox7.getSelectionModel().selectFirst();
	}
	@FXML
	void quitter()
	   {
			//Methode pour quitter une programme.
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
	//Cette methode determine si le chose tape est un nombre. S'il n'est pas il ne l'enleve.
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
			//Code pour faire la conversion des differents types.
			depart=Double.parseDouble(c.getText()); //Code pour prendre le String du textfield comme Double.
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
	
	@FXML
    private ObservableList<String> listSpeed=FXCollections.observableArrayList("meter/second","kilometer/hour","mile/hour");
    private double []Speed= {1,3.6,2.237}; //pour differencier les differents conversions de vitesse.
    
    @FXML
	private void Convert3()
	{
		convert(combox4,combox5,txt3,txt4,Speed);
	}
	@FXML
	private void Convert4()
	{
		convert(combox5,combox4,txt4,txt3,Speed);
	}
	
	@FXML
    private ObservableList<String> listEnergy=FXCollections.observableArrayList("Joules","Kilojoules","Watt hour");
    private double []Energy= {1,1000,0.000277778}; //pour differencier les differents conversions energies.
    
    @FXML
	private void Convert5()
	{
		convert(combox6,combox7,txt5,txt6,Energy);
	}
	@FXML
	private void Convert6()
	{
		convert(combox7,combox6,txt6,txt5,Energy);
	}
}
