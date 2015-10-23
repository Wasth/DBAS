package tars.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.*;

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
	Statement stat;
	public Model(String username,String pass,String host,String port){
		this.username = username;
		this.pass = pass;
		this.host = host;
		this.port = port;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/",username, pass);
			stat = connect.createStatement();
			System.out.println("Соединение установлено..");
		}catch(Exception ex){
			System.out.println("Не удалось установить соединение.");
			ex.printStackTrace();
		}
		
	}
	public TreeView updateResultSet() throws SQLException{
		
		TreeItem<String>rootItem = new TreeItem<String>("Databases");
		ResultSet databases = stat.executeQuery("SHOW DATABASES;");
		Statement statTables = connect.createStatement();
		while(databases.next()){
			String db = databases.getString("Database");
			tables = statTables.executeQuery("SHOW TABLES FROM "+db+";");
			TreeItem<String> item = new TreeItem<String>(db);
			System.out.println(db);
			while(tables.next()){
				String tb = tables.getString("Tables_in_"+db);
				item.getChildren().add(new TreeItem<String>(tb));
				System.out.println("\t"+tb);
			}
			rootItem.getChildren().add(item);
		}
		databases.close();
		TreeView<String> treeView = new TreeView<String>(rootItem);
		return treeView;
	}
	public void showProperties(){
		System.out.println(username+" "+pass+" "+host+" "+port);
	}
}
