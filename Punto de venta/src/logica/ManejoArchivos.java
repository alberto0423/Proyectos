/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.*;
import javax.swing.JOptionPane;
import static inventario.Inventario.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Crack-ALS
 */
public class ManejoArchivos {

    private static final DefaultTableModel tableModel = (DefaultTableModel) tablaProductos.getModel();

    public static void crearArchivo(String nombreArchivos) {
        int recibido = JOptionPane.showConfirmDialog(null, "¿Desea crear un nuevo archivo?", "Crear Archivo", JOptionPane.OK_OPTION);

        if (JOptionPane.OK_OPTION == recibido) {
            File file = new File(nombreArchivos);
            try {
                PrintWriter printWriter = new PrintWriter(new FileWriter(nombreArchivos));
                JOptionPane.showMessageDialog(null, "Se ha creado el archivo de manera exitosa");
                printWriter.close();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un problema al crear el archivo");

            }

        }
    }

    public static void escribirArchivo(String nombreArchivo) {
        File file = new File(nombreArchivo);
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));

            String contenido[] = new String[4];
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
                tableModel.setValueAt(lectura, 0, 0);
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
