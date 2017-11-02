/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivos {

    String name;
    ArrayList<Campos> campos = new ArrayList();

    public Archivos() {
        
    }
    
    

    public Archivos(String name) {
        this.name = name;
        File f = new File("./Archivos/"+ name +".txt");
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

    public void addCampos(Campos c) {
        this.campos.add(c);
    }

    public void save() throws IOException {
        String path = "./Archivos/" + name + ".txt";
        if (this.campos.isEmpty()) {
            System.out.println("You can't save yet");
        } else {
            File f = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            for (int i = 0; i < campos.size(); i++) {
                writer.append(campos.get(i).getName() + ": ");
            }
            writer.close();
        }
    }
    
    
}
