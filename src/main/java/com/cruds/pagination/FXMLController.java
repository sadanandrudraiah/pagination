package com.cruds.pagination;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class FXMLController implements Initializable {
 
    @FXML
    private FlowPane fpane;  
    
    private int pgStartIdx, pgEndIdx, counter;
    
   // private boolean paginate = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genL1MenuGrid();
    }    

    private void genL1MenuGrid()
    {
        int size = 35;

        pgStartIdx = 0;
        pgEndIdx = 10;
        generatePage(pgStartIdx,pgEndIdx,size);
    }

    private void generatePage(int startIdx, int endIdx, int size)
    {
        Button btn = null;
        counter = 0;
        
        if(startIdx != 0)
        {
             btn = new Button("PREV");
             btn.setId("PREV");
             
             btn.setOnAction((ActionEvent event) -> {
                     
                     pgEndIdx = pgEndIdx - counter;
                     pgStartIdx = pgEndIdx - 10;
                     if(pgStartIdx <= 0)
                     {
                         pgStartIdx = 0;
                     }
                     fpane.getChildren().clear();
                     generatePage(pgStartIdx,pgEndIdx,size);
                 });              
             
             fpane.getChildren().add(btn);
        }
        
        for(int i=startIdx; i < endIdx; i++)
        {
            counter++;
            btn = new Button(String.valueOf(i));
            btn.setPrefSize(100, 50);
            btn.setStyle("-fx-background-color: #4faf5a");
            btn.setId(String.valueOf(i));
            fpane.getChildren().add(btn);
        }
        
        if(endIdx < size)
        {
             btn = new Button("Next");
             btn.setId("Next");
             
             btn.setOnAction((ActionEvent event) -> {
                     pgStartIdx = pgEndIdx;
                     pgEndIdx = pgEndIdx + 10;
                     if(pgEndIdx >= size)
                     {
                         pgEndIdx = size;
                     }
                     fpane.getChildren().clear();
                     generatePage(pgStartIdx,pgEndIdx,size);
                 });              
             
             fpane.getChildren().add(btn);
        }
        
    }
    

}
