/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Archivos {

    String name;
    ArrayList<Campos> campos = new ArrayList();
    ArrayList<String> registros = new ArrayList();

    public Archivos() {
    }

    public Archivos(String name) {
        this.name = name;
        File f = new File("./Archivos/" + name + ".txt");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Campos> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList<Campos> campos) {
        this.campos = campos;
    }

    public void addCampo(Campos c) {
        this.campos.add(c);
    }

    public ArrayList<String> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<String> registros) {
        this.registros = registros;
    }

    public void addRegistro(String r) {
        this.registros.add(r);
    }

    public void save() throws IOException {
        String path = "./Archivos/" + name + ".txt";
        File f = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        if (!campos.isEmpty()) {
            for (int i = 0; i < campos.size(); i++) {
                Campos c = campos.get(i);
                writer.append(c.toString() + ", ");
            }

        }
        try {
            if (!registros.isEmpty()) {
                writer.append("\n");
                for (int i = 0; i < registros.size(); i++) {
                    writer.append(registros.get(i) + "\n");
                }

            }
        } catch (Exception NullException) {

        }
        writer.close();
    }

    public void save2() throws IOException {
        String path = "./Archivos/" + name + ".txt";
        File f = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        if (!campos.isEmpty()) {
            for (int i = 0; i < campos.size(); i++) {
                writer.append(campos.get(i).getName() + ", ");
            }

        }
        if (!registros.isEmpty()) {
            for (int i = 0; i < registros.size(); i++) {
                writer.append(registros.get(i) + "\n");
            }
        }
        writer.close();
    }

    public Archivos read(String path) throws IOException {
        //String path = "./Archivos/" + name + ".txt";
        File f = new File(path);
        Archivos archivo = null;
        //BufferedReader reader = new BufferedReader(new FileReader(f));
        //Scanner sc = new Scanner(f);
        Scanner sc2 = new Scanner(f);

        String header = sc2.nextLine();
        //HEADER
        StringTokenizer token = new StringTokenizer(header, ",", true);
        while (token.hasMoreTokens()) {
            StringTokenizer token2 = new StringTokenizer(token.nextToken(), ":[]", true);
            String fieldname = token2.nextToken();
            String fieldtype = token2.nextToken().substring(1);
            int length = Integer.parseInt(token2.nextToken());
            archivo.addCampo(new Campos(fieldname, fieldtype, length, false));
        }
        //REGISTROS
        
        while (sc2.hasNextLine()) {
            String registry = sc2.nextLine();
            StringTokenizer token3 = new StringTokenizer(registry,"|",true);
            archivo.addRegistro(token3.nextToken());
        }

        archivo.setName(f.getName());

        return archivo;
    }

    public void listar() {
        for (int i = 0; i < campos.size(); i++) {
            System.out.println(campos);
        }
    }

}
