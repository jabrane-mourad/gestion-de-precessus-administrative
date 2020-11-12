package application;

import java.io.IOException;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Documents.Procedures;
import Documents.Livre;
import Documents.Magazine;
import citoyen.Etudiant;
import Documents.Dictionnaire;

public class DocumentBD {

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
//////////////////////////Procedures////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	
	public static int Proceduredemander(id_procedure proc, String cin ) {
		int st2=0,st1=0;
		try {
			String sql1 = "UPDATE document set id_procedure =? where nom=?";
			String sql2 = "UPDATE citoyen set nbr_demander = nbr_demander + 1 where cin=?";
			Connection con = DocumentBD.getConnection();
			PreparedStatement preparedStatement1 = (PreparedStatement) con.prepareStatement(sql1);
			preparedStatement1.setString(1,cin);
			preparedStatement1.setInt(2,((procedures) doc).getNumeroEnrg());
			st1 = preparedStatement1.executeUpdate();
			PreparedStatement preparedStatement2 = (PreparedStatement) con.prepareStatement(sql2);
			preparedStatement2.setString(1,cin);
			st2 = preparedStatement2.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return st1*st2;
	}
	
	
	public static Procedures getProcedureById_procedure(String id_procedure) throws IOException,SQLException{
		Procedures doc=new Procedures();
		try {
			String sql = "select nom,description,nombre_etapes,est_archive,matricule FROM procedures WHERE id_procedure=? and cin is null";
			Connection con =DocumentBD.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setString(1,id_procedure);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {				
				doc.setNom(resultSet.getString(1));
				doc.setDescription(resultSet.getString(2));
				doc.setNombre_etapes(resultSet.getInt(3));
				doc.setEst_archive(resultSet.getBoolean(4));
				doc.setMatricule(resultSet.getString(5));
				doc.setId_procedure(resultSet.getInt(6));
			}
			
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	
	
	
	public static int updateProcedure(Procedures doc)throws IOException,SQLException {
		int st1 =0;
		try {
			String sql1 = "UPDATE procedures set  nom=?,description=?, nombre_etapes=? where id_procedure=?";

			Connection con = DocumentBD.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql1);

			preparedStatement.setString(1,doc.getNom());
			preparedStatement.setInt(2,doc.getNombre_etapes());
			preparedStatement.setInt(4,doc.getId_procedure());
			
		
			st1 = preparedStatement.executeUpdate();

			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return st1;
		
	}
	
	public static int supprimerProcedure(Procedures doc)throws IOException,SQLException {
		int st1 =0;
		try {
			String sql1 = "DELETE from procedures where id_procedure=?";
		

			Connection con = DocumentBD.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql1);
		

			
			preparedStatement.setInt(1,id_procedure);
	
			
			st1 = preparedStatement.executeUpdate();
		


			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return st1;
		
	}
	

	
	public static int saveLivre(Procedures doc)throws IOException,SQLException {
		int i,st1 =0;
		try {
			String sql = "INSERT INTO Document (isbn,titre,editeur,annee) Values (?,?,?,?)";
			

			Connection con = DocumentBD.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
			preparedStatement.setInt(1,doc.getId_procedure());
			preparedStatement.setString(2,doc.getNom());
			preparedStatement.setString(3,doc.getDescription());
			preparedStatement.setInt(4,doc.getNombre_etapes());
			
			st1 = preparedStatement.executeUpdate();
			for(i=0;i<doc.getNombre_etapes()-1;i++) {
			st1 *= preparedStatement.executeUpdate();
			}
		
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return st1;
	}
	
	
	
	
	

}
