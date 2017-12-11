/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Campos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class XML {

    static String fileName;
    static ArrayList<Campos> campos = new ArrayList();
    ArrayList<String> registros = new ArrayList();

//    public static void main(String args[]) throws IOException {
//        String name = "";
//        String type = "";
//        int length = 0;
//        boolean key = true;
//        Campos c;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nombre del archivo");
//        fileName = sc.nextLine();
//        System.out.println("Desea crear un archivo");
//        char resp = 's';
//        while (resp == 's' || resp == 'S') {
//            sc = new Scanner(System.in);
//            System.out.println("ingrese el nombre de un campo");
//            name = sc.nextLine();
//            sc = new Scanner(System.in);
//            System.out.println("tipo de dato");
//            type = sc.nextLine();
//            sc = new Scanner(System.in);
//            System.out.println("Longitud");
//            length = sc.nextInt();
//            sc = new Scanner(System.in);
//            System.out.println("es llave s/n");
//            if (sc.nextLine().charAt(0) == 's') {
//                key = true;
//
//            }else{
//                key = false;
//            }
//            System.out.println("Desea agregar otro campo? s/n");
//            c = new Campos(name, type, length, key);
//            campos.add(c);
//            resp = sc.next().charAt(0);
//        }
//        saveXML(key);
//    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        XML.fileName = fileName;
    }

    public static ArrayList<Campos> getCampos() {
        return campos;
    }

    public static void setCampos(ArrayList<Campos> campos) {
        XML.campos = campos;
    }

    public ArrayList<String> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<String> registros) {
        this.registros = registros;
    }

    
    
    public static void saveXML() throws IOException {
        String path = "./ArchivosXML/" + fileName + ".XML";
        System.out.println("Name: " + fileName);
        File f = new File(path);
        String saving = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n";
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        if (!campos.isEmpty()) {
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).isKey() == true) {
                    saving += "\t<Key>\n";
                }
                saving += "\t\t<" + campos.get(i).getType() + " [" + campos.get(i).getLength() + "]> \n";
                saving += "\t\t\t<" + campos.get(i).getName() + ">" + "Aqui va el nombre de cada registro" + "</" + campos.get(i).getName() + ">\n";
                saving += "\t\t</" + campos.get(i).getType() + ">\n";
                if (campos.get(i).isKey() == true) {
                    saving += "\t</Key>\n";
                }
                //saving = "";
                //writer.append(saving);
            }
            writer.write(saving);

        }

        writer.close();
    }

}
