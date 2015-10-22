package tars.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Model {
	private String username;
	private String pass;
	private String host;
	private String port;
	public static Connection connect;
	ResultSet databases;
	ResultSet tables;
	ResultSet fields;
	ResultSet tableContent;
	public Model(String username,String pass,String host,String port){
		this.username = username;
		this.pass = pass;
		this.host = host;
		this.port = port;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/",username, pass);
			System.out.println("Соединение установлено..");
		}catch(Exception ex){
			System.out.println("Не удалось установить соединение.");
			ex.printStackTrace();
		}
		
	}
	public void showProperties(){
		System.out.println(username+" "+pass+" "+host+" "+port);
	}
}
