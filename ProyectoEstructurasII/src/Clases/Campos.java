/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;
import java.util.Scanner;

public class Campos {

    String name;
    String type; //No se a que se refiere con tipo
    String description;
    int length;
    boolean key; //Llave primaria

    public Campos() {
    }

    public Campos(String name, String type, String description, int length, boolean key) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.length = length;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
    
    
    
}
