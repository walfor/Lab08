/**
 * Sample Skeleton for 'DizionarioGraph.fxml' Controller Class
 */

package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	

	private Model model= new Model();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textNmberOfLetter"
    private TextField textNmberOfLetter; // Value injected by FXMLLoader

    @FXML // fx:id="textWord"
    private TextField textWord; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreateGraph"
    private Button btnCreateGraph; // Value injected by FXMLLoader

    @FXML // fx:id="btnFindNeighbours"
    private Button btnFindNeighbours; // Value injected by FXMLLoader

    @FXML // fx:id="btnFindMaxDegree"
    private Button btnFindMaxDegree; // Value injected by FXMLLoader

    @FXML // fx:id="textArea"
    private TextArea textArea; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    public void creaModello (Model model) {
		this.model=model;
	}

	@FXML
    void handleCreateGraph(ActionEvent event) {
    	try {
    	int numerolettere= Integer.parseInt(textNmberOfLetter.getText()); 
    	model.createGraph( numerolettere);
    	textArea.appendText(model.getGraph()+"\n");
    	}catch (NumberFormatException nfe) {
    		textArea.setText("Errore nel formato del numero lettere.\n Inserire numero lettere.");
    	}
    	

    }

    @FXML
    void handleFindMaxDegree(ActionEvent event) {
    	
    	textArea.appendText("Il grado massimo del grafo costruito è: "+model.findMaxDegree()+"\n");

    }

    @FXML
    void handleFindNeighbours(ActionEvent event) {
    	textArea.appendText(model.displayNeighbours(textWord.getText()).toString()+"\n");
    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.textArea.clear();
    	this.textNmberOfLetter.clear();
    	this.textWord.clear();
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textNmberOfLetter != null : "fx:id=\"textNmberOfLetter\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert textWord != null : "fx:id=\"textWord\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnCreateGraph != null : "fx:id=\"btnCreateGraph\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnFindNeighbours != null : "fx:id=\"btnFindNeighbours\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnFindMaxDegree != null : "fx:id=\"btnFindMaxDegree\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }
}
