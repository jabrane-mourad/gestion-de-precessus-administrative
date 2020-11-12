package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import citoyen.citoyen;
import citoyen.Etudiant;
import citoyen.Personne;
import citoyen.Professeur;

public class CitoyenBD {

	public static Connection getConnection() {
		Connection con=null;;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/projet_java_gestion_des_processus_administratifs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		con = DriverManager.getConnection(url,"root","");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	
	
	
	public static  List<String> getAdhrents(int type){
		List<String> list = new ArrayList<String>();
		try {
			String sql = "select cin from citoyen where adresse=?";
			
			Connection con =CitoyenBD.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setInt(1,type);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String id;
				id=resultSet.getString(1);
				list.add(id);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
public static boolean savecitoyen(citoyen adh) {
		
		int statue1 =0,statue2=0;
		try {
			Connection con = CitoyenBD.getConnection();
			String sql1 ="INSERT INTO citoyen (cin,nom) Values (?,?)";
		
		
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (statue1 > 0 && statue2 >0);
	}






	//

	
	
	public static int getTypeByCode(String code)throws IOException,SQLException{
			int nbr;
			String sql = "select nomcitoyen from citoyen where cin=?";
			Connection con =CitoyenBD.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setString(1,code);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				nbr =  resultSet.getInt(1);
				   //do other stuff
				} else {
					nbr=0;
				}
			con.close();
			return nbr;
		
	}
	

	
	
	
	
	
	
	
	
	public static int updatecitoyen(citoyen adh) throws IOException,SQLException {
		int statue1 =0,statue2=0;
		try {
			
			String sql = "UPDATE citoyen SET nom=?,prenom=?,adresse=?,tel=?  where cin=?";
			Connection con = CitoyenBD.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		
			preparedStatement.setString(1,adh.getNom());
			preparedStatement.setString(2,adh.getPrenom());
			preparedStatement.setString(3,adh.getAdresse());
			preparedStatement.setString(4,adh.getTel());
			preparedStatement.setString(5,adh.getCin());

			

			
	
	
	
	public static boolean supprimercitoyen(citoyen adh) {
		int statue1 =0,statue2=0,statue3=0;
		try {
			
			String sql = "DELETE FROM citoyen where cin=?";
			Connection con = CitoyenBD.getConnection();
			
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setString(1,adh.getCin());
			statue1 = preparedStatement.executeUpdate();
			
			
		}
	}
	}

