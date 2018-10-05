/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import controller.GestionListaEnMemoria;
import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Ingrediente;

/**
 *
 * @author idoia
 */
public class MainWindow extends Application {

    private final TableView<Ingrediente> table = new TableView<>();
    JFrame frame = new JFrame();
    //Fuckkkkkkk

    final HBox hb = new HBox();
    ObservableList<Ingrediente> data = null;
    @Override
    public void start(Stage stage) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scene scene = new Scene(new Group());

//        String fitxategia = "froga.txt";
        data = GestionListaEnMemoria.datuakKargatu();
//        ObservableList<Ingrediente> data = GestionListaEnMemoria.cargarDatos();
                
        stage.setTitle("Datuen Taula");
        stage.setWidth(1025);
        stage.setHeight(550);
        final Label label = new Label("Ingredientes");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<Ingrediente, String> id = new TableColumn<>("ID");
        id.setMinWidth(100);
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        id.setCellFactory(TextFieldTableCell.<Ingrediente>forTableColumn());
        id.setOnEditCommit((TableColumn.CellEditEvent<Ingrediente, String> t) -> {
            ((Ingrediente) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setId(t.getNewValue());
        });

        TableColumn<Ingrediente, String> izena = new TableColumn<>("Izena");
        izena.setMinWidth(100);
        izena.setCellValueFactory(new PropertyValueFactory<>("Izena"));
        izena.setCellFactory(TextFieldTableCell.<Ingrediente>forTableColumn());
        izena.setOnEditCommit((TableColumn.CellEditEvent<Ingrediente, String> t) -> {
            ((Ingrediente) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setIzena(t.getNewValue());
        });

        TableColumn<Ingrediente, String> provedor = new TableColumn<>("Provedor");
        provedor.setMinWidth(200);
        provedor.setCellValueFactory(new PropertyValueFactory<>("Provedor"));
        provedor.setCellFactory(TextFieldTableCell.<Ingrediente>forTableColumn());
        provedor.setOnEditCommit((TableColumn.CellEditEvent<Ingrediente, String> t) -> {
            ((Ingrediente) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setProvedor(t.getNewValue());
        });

        TableColumn<Ingrediente, String> uniti = new TableColumn<>("Uniti");
        uniti.setMinWidth(200);
        uniti.setCellValueFactory(new PropertyValueFactory<>("Uniti"));
        uniti.setCellFactory(TextFieldTableCell.<Ingrediente>forTableColumn());
        uniti.setOnEditCommit((TableColumn.CellEditEvent<Ingrediente, String> t) -> {
            ((Ingrediente) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setUniti(t.getNewValue());
        });

        TableColumn<Ingrediente, String> sitio = new TableColumn<>("Sitio");
        sitio.setMinWidth(200);
        sitio.setCellValueFactory(new PropertyValueFactory<>("Sitio"));
        sitio.setCellFactory(TextFieldTableCell.<Ingrediente>forTableColumn());
        sitio.setOnEditCommit((TableColumn.CellEditEvent<Ingrediente, String> t) -> {
            ((Ingrediente) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setSitio(t.getNewValue());
        });

        TableColumn<Ingrediente, String> precio = new TableColumn<>("Precio");
        precio.setMinWidth(200);
        precio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        precio.setCellFactory(TextFieldTableCell.<Ingrediente>forTableColumn());
        precio.setOnEditCommit((TableColumn.CellEditEvent<Ingrediente, String> t) -> {
            ((Ingrediente) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setPrecio(t.getNewValue());
        });

        table.setItems(data);
        table.getColumns().addAll(id, izena, provedor, uniti, sitio, precio);
        final TextField addId = new TextField();
        addId.setPromptText("ID");
        addId.setMaxWidth(id.getPrefWidth());
        final TextField addIzena = new TextField();
        addIzena.setMaxWidth(izena.getPrefWidth());
        addIzena.setPromptText("Izena");
        final TextField addProvedor = new TextField();
        addProvedor.setMaxWidth(provedor.getPrefWidth());
        addProvedor.setPromptText("Provedor");
        final TextField addUniti = new TextField();
        addUniti.setMaxWidth(provedor.getPrefWidth());
        addUniti.setPromptText("Uniti");
        final TextField addSitio = new TextField();
        addSitio.setMaxWidth(provedor.getPrefWidth());
        addSitio.setPromptText("Sitio");
        final TextField addPrecio = new TextField();
        addPrecio.setMaxWidth(provedor.getPrefWidth());
        addPrecio.setPromptText("Precio");

        final Button addButton = new Button("Gehitu");
        addButton.setOnAction((ActionEvent e) -> {

            if (addId.getText().isEmpty() || addIzena.getText().isEmpty() || addProvedor.getText().isEmpty() || addUniti.getText().isEmpty() || addSitio.getText().isEmpty() || addPrecio.getText().isEmpty()) {
                System.out.println("Kanpo guztiak beteta egon behar dira");
            } else {
                Ingrediente p = new Ingrediente(
                        addId.getText(),
                        addIzena.getText(),
                        addProvedor.getText(),
                        addUniti.getText(),
                        addSitio.getText(),
                        addPrecio.getText());
                data.add(p);
                try {
                    GestionListaEnMemoria.gordeFitxategian(data);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                addId.clear();
                addIzena.clear();
                addProvedor.clear();
                addUniti.clear();
                addSitio.clear();
                addPrecio.clear();
            }
        });

        final Button removeButton = new Button("Ezabatu");
        removeButton.setOnAction((ActionEvent e) -> {
            Ingrediente person = table.getSelectionModel().getSelectedItem();
            data.remove(person);
            try {
                GestionListaEnMemoria.gordeFitxategian(data);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        hb.getChildren().addAll(addId, addIzena, addProvedor, addUniti, addSitio, addPrecio, addButton, removeButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public void tabla(){
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
