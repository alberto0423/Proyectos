/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.*;
import javax.swing.JOptionPane;
import static inventario.Inventario.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Crack-ALS
 */
public class ManejoArchivos {

    private static final DefaultTableModel tableModel = (DefaultTableModel) tablaProductos.getModel();
    private static String contenido[] = new String[4];
    private static ArrayList<Object> list = new ArrayList<>();

    public static void crearArchivo(String nombreArchivos) {
        int recibido = JOptionPane.showConfirmDialog(null, "¿Desea crear un nuevo archivo?", "Crear Archivo", JOptionPane.OK_OPTION);
        JFileChooser jfc = new JFileChooser();
        File file = new File(nombreArchivos);
        jfc.showSaveDialog(jfc);
        jfc.addChoosableFileFilter(new FileNameExtensionFilter(nombreArchivos, ".txt"));
        jfc.getSelectedFile();

        if (JOptionPane.OK_OPTION == recibido) {
            if (file != null) {
                try {

                    PrintWriter printWriter = new PrintWriter(new FileWriter(nombreArchivos + ".txt"));
                    JOptionPane.showMessageDialog(null, "Se ha creado el archivo de manera exitosa");
                    printWriter.close();

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un problema al crear el archivo");

                }

            } else {
            }

        }
    }

    public static void escribirArchivo(String nombreArchivo) {
        File file = new File(nombreArchivo);
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));

            contenido[0] = (String) tableModel.getValueAt(0, 0);
            contenido[1] = (String) tableModel.getValueAt(0, 1);
            contenido[2] = (String) tableModel.getValueAt(0, 2);
            contenido[3] = (String) tableModel.getValueAt(0, 3);
//
//            textPiezas.setText(contenido[0]);
//            textProducto.setText(contenido[1]);
//            textPrecio.setText(contenido[2]);
//            textExistencia.setText(contenido[3]);

            printWriter.println(contenido[0] + " " + contenido[1] + " " + contenido[2] + " " + contenido[3]);
            tableModel.setValueAt(contenido, 0, 0);
            printWriter.println();
            printWriter.println("************");
            limpiar();
            limpiarDatosTabla();
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leerArchivo(String nombreArchivo) {
        File file = new File(nombreArchivo);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String lectura;
            lectura = bufferedReader.readLine();
            while (lectura != null) {
                System.out.println("Lectura: " + lectura);
                contenido = lectura.split(" ");
                tableModel.addRow(contenido);
                lectura = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void anexarArchivo(String nombreArchivo) {
//        File    file    =   new File(nombreArchivo);
//        try {
//            PrintWriter printWriter =   new PrintWriter(new FileWriter(file,true));
//            String contenido   = jTextFieldEntrada.getText();
//            jTextFieldEntrada.setText(contenido);
//            printWriter.close();
//            printWriter.println();
//             printWriter.println("************"
//            jTextFieldEntrada.setText("");
//            printWriter.close();
//            JOptionPane.showMessageDialog(null,"Se ha anexado informacion de manera exitosa");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    public static void crearArchivoNuevo(String nombreArchivo){
        JFileChooser    jfc =   new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("todos los archivos *.txt", "txt","EDU"));
        int abrir   =   jfc.showDialog(null,"Abrir");
        if (abrir == JFileChooser.APPROVE_OPTION) {
            FileReader  reader  =   null;
            BufferedReader  br  =   null;
            
        } else {
        }
    }

    public static void limpiar() {
        textPiezas.setText("");
        textExistencia.setText("");
        textPrecio.setText("");
        textProducto.setText("");
    }

    private static void limpiarDatosTabla() {
        int a = tablaProductos.getSelectedRow();

        tableModel.setValueAt("", 0, 0);
        tableModel.setValueAt("", 0, 1);
        tableModel.setValueAt("", 0, 2);
        tableModel.setValueAt("", 0, 3);
        tableModel.removeRow(a);

    }

}
