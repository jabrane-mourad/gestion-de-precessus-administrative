package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Documents.Procedures;
import Documents.Livre;
import Documents.Magazine;
import citoyen.citoyen;
import Documents.Dictionnaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MenuProcedures  implements Initializable{
	
	int by;
	private Procedures Proceduredem;

	private citoyen adherent;


	
	 @FXML
	 private Pane demander;
	 @FXML
	private Pane procedures;
	 @FXML
	 private Pane parametres;
	 @FXML
	 private JFXTextField pseudomodif;
	 @FXML
	 private JFXTextField telephonemodif;
	 @FXML
	 private JFXTextField adressemodif;
	
	 @FXML
	 private Label title;
	    @FXML
	    private Label pseudomodifechec;

	    @FXML
	    private Label pseudomodifsucce;

	    @FXML
	    private JFXPasswordField oldmotpass;

	    @FXML
	    private JFXPasswordField newmotpass;

	    @FXML
	    private JFXPasswordField confirmer;

	    @FXML
	    private Label motpassmodifechec;

	    @FXML
	    private Label motpassmodifsucce;
	    @FXML 
	    private Label test;
	 
	 // les FXML de tableu des procedures
	    @FXML
	    private TableView<Procedures> tableuprocedures;

	    @FXML
	    private TableColumn<Procedures,Integer> id_procedure;

	    @FXML
	    private TableColumn<Procedures,String> nom ;

	    @FXML
	    private TableColumn<Procedures,String>description;

	    @FXML
	    private TableColumn<Procedures,Integer>nombre_etapes ;

	    @FXML
	    private TableColumn<Livre,Boolean> est_archive;

	    @FXML
	    private TableColumn<Livre,String> matricule;

	    @FXML
	    private TableColumn<Livre,String> tome;

	    
		@FXML
	    private TextField cherche;
	    @FXML
	    private JFXButton demanderB;
	    @FXML
	    private Label echecdemander;
	    @FXML
	    private Label succedemander;
		
		
	   

	    
		
		
		
	     public void afficheDetProcedures(ActionEvent e)throws IOException,SQLException {
			DocumentBD.getConnection();
			detProcedures(e);
	    }
	    
		public static Connection getConnection() {
			Connection con=null;
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/projet_java_gestion_des_processus_administratifs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			con = DriverManager.getConnection(url,"root","");
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			return con;
		}
		
		
		
		
		
	   
//////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
//////////////////////////Menu Principale////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	    
	    static Connection con = null;
	    @Override
		public void initialize(URL location, ResourceBundle resources){
			cmpt=CompteBD.getCompteByEtat(1);
		
	    	tableProcedures();
	    	nom.setText(cmpt.getPseudo_nom());
	    	
		}
		
	    
	    
	    
	    

	    public void Procedures(ActionEvent e)throws IOException,SQLException {
//	    	succedemander.setVisible(false);
//			echecdemander.setVisible(false);
			tableLivre();
			demanderB.setDisable(true);
	    	Procedures.toFront();
			//demander.toBack();
			parametres.toBack();
		}
		
		
		public void demander(ActionEvent e)throws IOException,SQLException {
			//demander.toFront();
			Procedures.toBack();
			parametres.toBack();
			//rendre.toBack();
		
		}
		
		public void parametres(ActionEvent e)throws IOException,SQLException{
			parametres.toFront();
			Procedures.toBack();
			//rendre.toBack();
			//deamnder.toBack();
			pseudomodif.setText(cmpt.getPseudo_nom());

				}
		

		

		 public ObservableList<Procedures> data = FXCollections.observableArrayList();
		
	    
//////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
//////////////////////////Procedures////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	    public void  tableProcedures(){
	    	
	    	tableauProcedures.getItems().clear();
			try {
				String sql="SELECT procedures.id_procedure,nom,description,nombre_etapes,est_archive,  from procedures";
				Connection con = DocumentBD.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs  = preparedStatement.executeQuery();
				while(rs.next()) {
					data.add(new Procedures(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
				
				
				}
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			isbn.setCellValueFactory(new PropertyValueFactory<Procedures,Integer>("id_procedure  "));
			titre.setCellValueFactory(new PropertyValueFactory<Procedures,String>("nom"));
			editeur.setCellValueFactory(new PropertyValueFactory<Procedures,String>("description   "));
			anne.setCellValueFactory(new PropertyValueFactory<Procedures,Integer>("nombre_etapes "));
			nbrpage.setCellValueFactory(new PropertyValueFactory<Livre,Boolean>("est_archive   "));
			type.setCellValueFactory(new PropertyValueFactory<Livre,String>("matricule "));
			
			
			tableulivre.setItems(data);
	    }

//////////////////////////Chercher/////////////////////////////////////

	   


	    public void ById_procedure(ActionEvent e)throws IOException,SQLException{
	    	by=1;
			demanderB.setDisable(true);

	    }

	    
	    
	    public void ChercheById_procedure(ActionEvent e)throws IOException,SQLException{
	    	tableuprocedures.getItems().clear();
	    	emprunterB.setDisable(true);
			String sql="SELECT procedures.id_procedure,nom,description,nombre_etapes,est_archive,  from procedures"
			Connection con = DocumentBD.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setString(1,cherche.getText());
			ResultSet rs  = preparedStatement.executeQuery();
			while(rs.next()) {
			data.add(new Procedures(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8)));

				}
			con.close();
			isbn.setCellValueFactory(new PropertyValueFactory<Procedures,Integer>("id_procedure"));
			titre.setCellValueFactory(new PropertyValueFactory<Procedures,String>("nom"));
			editeur.setCellValueFactory(new PropertyValueFactory<Procedures,String>("description"));
			anne.setCellValueFactory(new PropertyValueFactory<Procedures,Integer>("nombre_etapes "));
			nbrpage.setCellValueFactory(new PropertyValueFactory<Procedures,Boolean>("est_archive   "));
			type.setCellValueFactory(new PropertyValueFactory<Procedures,String>("matricule     "));
			
			
			tableulivre.setItems(data);
	    	
	    }
	    	    
	   
	
	
	   
	    
		public void Demander(ActionEvent e)throws IOException,SQLException{
			int test1 =DocumentBD.ProcedureDemander(proceduredem,cmpt.getCin());
			int test2 = DocumentBD.ajouterHistorique(livreEmpr,cmpt.getCode_adh());
				if(test1!=0) {
					succeeprunter.setText("Vous avez demander la procedure.");
					echecdemander.setVisible(false);
				}
				else {
					echecemprunter.setText("Désole! il ya un erreur.");
					succedemander.setVisible(false);
				}
		    	tableProcedures();
		    	demanderB.setDisable(true);

				
			}
		
	

	


//////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
//////////////////////////Modifier les informations de Profile///////////
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	
	
	//Mot de passe
public void motpassModif(ActionEvent e )throws IOException,ParseException{
		Compte cmp = new Compte();
		if(oldmotpass.getText().equals(cmpt.getMot_pass())) {
				if(newmotpass.getText().equals(confirmer.getText())) {
					
					cmp.setMot_pass(confirmer.getText());
					int statue = CompteBD.motpassModif(cmp,1);
					if(statue>0) {
						motpassmodifsucce.setText("Vous avez modifier votre mot de passe");
						motpassmodifechec.setVisible(false);
					}else {
						motpassmodifechec.setText("Erreur technique");
						motpassmodifsucce.setVisible(false);
					}
				}
			else {
				motpassmodifechec.setText("Mot de pass different.");
				motpassmodifsucce.setVisible(false);
			}
			}
		else {
			motpassmodifechec.setText("Mot de passe incorrect");
			motpassmodifsucce.setVisible(false);
		}
		
	}
	

///////////////Pseudo Nom///////////////////////////////////////////////

	public void personneModif(ActionEvent e )throws IOException,ParseException{

		Compte cmp = new Compte();
		cmp.setPseudo_nom(pseudomodif.getText());
		cmp.setTelephone(telephonemodif.getText());
		cmp.setAdresse(adressemodif.getText());
		int statue = CompteBD.personneModif(cmp,cmpt.getCode_adh());
		if(statue>0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setContentText("Vous avez modifier les informations! ");
			
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Message");
			alert.setContentText("Erreur, essayez encore");
			
			alert.showAndWait();
		}
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void deconnecter(ActionEvent e)throws IOException,SQLException{
		CompteBD.getConnection();
		InscriptionEtAuthentification.deconnection();
		loadAuthen(e);
			}
	
	public void loadAuthen(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("InscriptionEtAuthentification.fxml" ));
		Scene s = new Scene(root);
		Stage fenetre = (Stage) ((Node)e.getSource()).getScene().getWindow();
		fenetre.setScene(s);
		fenetre.setResizable(false);
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        fenetre.setX((primScreenBounds.getWidth() - fenetre.getWidth()) / 2); 
        fenetre.setY((primScreenBounds.getHeight() - fenetre.getHeight()) / 4); 
        fenetre.show();		
	}


}





