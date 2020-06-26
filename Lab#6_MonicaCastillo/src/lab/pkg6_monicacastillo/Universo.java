/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg6_monicacastillo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author Monica
 */
public class Universo {

    private String nombre;
    private File archivo = null;
    private ArrayList<SerVivo> seresvivos = new ArrayList();

    public Universo() {
    }

    public Universo(String path) {
        archivo = new File(path);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<SerVivo> getSeresvivos() {
        return seresvivos;
    }

    public void setSeresvivos(ArrayList<SerVivo> seresvivos) {
        this.seresvivos = seresvivos;
    }

    public void SetSerVivo(SerVivo sv) {
        this.seresvivos.add(sv);
    }

    @Override
    public String toString() {
        return "Universo{" + "nombre=" + nombre + ", archivo=" + archivo + ", seresvivos=" + seresvivos + '}';
    }

    public void EscribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (SerVivo t : seresvivos) {
                bw.write(t.getNombre() + "|");
                bw.write(t.getPoder() + "|");
                bw.write(t.getAños() + "|");
                bw.write(t.getPlaneta() + "|");
                bw.write(t.getRaza() + "|");
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }

//    public void CargarArchivo(JTextArea TextArea) {
//        try {
//            FileReader fr = null;
//            BufferedReader br = null;
//            fr = new FileReader(archivo);
//            br = new BufferedReader(fr);
//            String linea;
//            while ((linea = br.readLine()) != null) {
//                TextArea.append(linea);
//                TextArea.append("\n");
//            } // Fin While
//            br.close();
//            fr.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } // Fin Try Catch
//    } // Fin Cargar Archivo
    public void CargarArchivo2() {
        Scanner entrada = null;
        seresvivos = new ArrayList();
        if (archivo.exists()) {
            try {
                entrada = new Scanner(archivo);
                entrada.useDelimiter("|");
                while (entrada.hasNext()) {
                    seresvivos.add(new SerVivo(entrada.next(), entrada.nextInt(), entrada.nextInt(), entrada.next(), entrada.next()));
                } // Fin While
            } catch (Exception e) {
                e.printStackTrace();
            } // Fin Try Catch
            entrada.close();
        } // Fin If
    } // Fin Cargar Archivo2

    public void EliminarElemento(SerVivo sv) throws IOException {
        try {
            CargarArchivo2();
            for (int i = 0; i < seresvivos.size(); i++) {
                if (seresvivos.get(i) == sv) {
                    seresvivos.remove(i);
                } // Fin If
            } // Fin For
            EscribirArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch
    } // Fin Eliminar Elemento
} // Fin Eliminar Elemento
