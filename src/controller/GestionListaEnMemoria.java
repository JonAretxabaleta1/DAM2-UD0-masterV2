/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ingrediente;

/**
 *
 * @author idoia
 */
public class GestionListaEnMemoria {
    
 //  
    //static ObservableList<Ingrediente> dataIng = null;
//    public static ObservableList<Ingrediente> cargarDatos(){
//        
//        return FXCollections.observableArrayList(new Ingrediente("1", "Letxuga", "Xabier","Kg","Nevera","10.5"),
//            new Ingrediente("2", "Tomate", "Xabier","Kg","Nevera","45.8")
//        );
//    }
//    
    public static void gordeFitxategian(ObservableList<Ingrediente> data) throws FileNotFoundException, IOException {
       String aukeratutakoa = "ingrediente.txt";
        BufferedWriter outWriter = null;
        try{    
        outWriter = new BufferedWriter(new FileWriter(aukeratutakoa));
            for (Ingrediente aux : data){
                outWriter.write(aux.toString());
                outWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ezin izan da fitxategia zabaldu");
        } catch (NullPointerException npe) {
            outWriter.close();
        }
        outWriter.close();
    }
    
    public static ObservableList<Ingrediente> datuakKargatu() throws FileNotFoundException, IOException {
        String aukeratutakoa = "ingrediente.txt";
        BufferedReader inputStream = null;
        ObservableList<Ingrediente> dataIng = null;
        try {
            inputStream = new BufferedReader(new FileReader(aukeratutakoa));
            dataIng = FXCollections.observableArrayList();
            String hitza;
            while ((hitza = inputStream.readLine()) != null) {
                Scanner s = new Scanner(hitza).useDelimiter(",");
                Ingrediente ing = new Ingrediente(s.next(), s.next(), s.next(), s.next(),s.next(), s.next());   //añadir tipo de datos de las variables
                dataIng.add(ing);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Ez da fitxategia aurkitu.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return dataIng;
    }
}
