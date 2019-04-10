package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import java.util.*;

import it.polito.tdp.model.Anagramma;
import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAreaCorretti;

    @FXML
    private TextArea txtAreaErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	String parola = this.txtParola.getText();
    	
    	if(parola.matches("[a-zA-Z]*")) {
    		
    	Map<String,Boolean> anagrammi = model.anagrammi(parola);
    	
    	this.txtAreaCorretti.appendText("Gli anagrammi corretti della parola "+parola+" sono: \n");
    	this.txtAreaErrati.appendText("Gli anagrammi errati della parola "+parola+" sono: \n");
    		
    	for(String s : anagrammi.keySet()) {
    		if(anagrammi.get(s)) {
    			txtAreaCorretti.appendText(s+"\n");
    		}else {
    			txtAreaErrati.appendText(s+"\n");
    		}
    	}
    		
    		
    	}
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtParola.clear();
    	this.txtAreaCorretti.clear();
    	this.txtAreaErrati.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAreaCorretti != null : "fx:id=\"txtAreaCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAreaErrati != null : "fx:id=\"txtAreaErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}
