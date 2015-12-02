package tars.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Table {
		private static ObservableList <ListView> lists = FXCollections.observableArrayList();
		private static ObservableList <Label> listLabel = FXCollections.observableArrayList();
		public static void clear(){
			lists.clear();
			listLabel.clear();
		}
		public static ListView getList(int i){
			return lists.get(i);
		}
		public static ObservableList getAllList(){
			return lists;
		}
		public static void addList(ListView list){
			lists.add(list);
		}
		public static void setAllList(ObservableList<ListView> list){
			lists = list;
		}
		public static void setList(int i,ListView list){
			lists.set(i, list);
		}
		
		public static Label getLabel(int i){
			return listLabel.get(i);
		}
		public static ObservableList getAllLabel(){
			return listLabel;
		}
		public static void addLabel(Label label){
			listLabel.add(label);
		}
		public static void setAllLabel(ObservableList<Label> labels){
			listLabel = labels;
		}
		public static void setLabel(int i,Label label){
			listLabel.set(i, label);
		}
		
		
}
