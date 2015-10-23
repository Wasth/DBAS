package tars.controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;;

public class MainController implements EventHandler<MouseEvent>{
	public void handle(MouseEvent event) {
		TreeItem<String> item = (TreeItem) event.getSource();
		System.out.println(item.getValue());
		System.out.println("NOT VALUE FAAACK");
	}
}
