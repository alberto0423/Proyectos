/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.*;
import javax.swing.JOptionPane;
import static inventario.Inventario.*;
/**
 *
 * @author Crack-ALS
 */
public class ManejoArchivos {
    public static void crearArchivo(String nombreArchivos){
      int recibido = JOptionPane.showConfirmDialog(null,"¿Desea crear un nuevo archivo?","Crear Archivo",JOptionPane.OK_OPTION);
       
        if(JOptionPane.OK_OPTION==recibido){
             File    file    =   new File(nombreArchivos);
        try {
          PrintWriter printWriter =   new PrintWriter(new FileWriter(nombreArchivos));
         JOptionPane.showMessageDialog(null,"Se ha creado el archivo de manera exitosa");
          printWriter.close();
          
        } catch (Exception e) {
            e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Hubo un problema al crear el archivo");

            
        }
        
        }
    }
    
    public static void escribirArchivo(String nombreArchivo){
        File    file    =   new File(nombreArchivo);
        try {
            PrintWriter printWriter =   new PrintWriter(new FileWriter(file));
            String contenido   = textPiezas.getText();
            textPiezas.setText(contenido);
            printWriter.println(contenido);
            printWriter.println();
            printWriter.println("Fin de escritura");
            textPiezas.setText("");
            printWriter.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void leerArchivo(String nombreArchivo){
        File    file    =   new File(nombreArchivo);
        try {
            BufferedReader  bufferedReader  =   new BufferedReader(new FileReader(file));
            String lectura;
            lectura =   bufferedReader.readLine();
            while (lectura!=null) {                
                System.out.println("Lectura: " + lectura);
                lectura =   bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
//    
//    public static void anexarArchivo(String nombreArchivo){
//        File    file    =   new File(nombreArchivo);
//        try {
//            Inicio  inicio  =   new Inicio();
//            PrintWriter printWriter =   new PrintWriter(new FileWriter(file,true));
//            String contenido   = jTextFieldEntrada.getText();
//            jTextFieldEntrada.setText(contenido);
//            printWriter.close();
//            printWriter.println();
//            printWriter.println("Fin de anexar");
//            jTextFieldEntrada.setText("");
//            printWriter.close();
//            JOptionPane.showMessageDialog(null,"Se ha anexado informacion de manera exitosa");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    
}
