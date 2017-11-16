/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author calvinespinoza
 */
public class BTree {

    private int orden;
    //private int numeroLLaves;
    private ArrayList<BTree> nodos = new ArrayList();
    private ArrayList<Integer> llaves = new ArrayList();
    boolean hoja;

    public BTree(int orden, boolean hoja) {
        this.orden = orden;
        this.hoja = hoja;
    }

    public BTree() {
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public ArrayList getBTree() {
        return nodos;
    }

    public void setBTree(ArrayList BTree) {
        this.nodos = BTree;
    }

    public void addBTree(BTree BTree) {
        nodos.add(BTree);
    }

    public ArrayList getLlaves() {
        return llaves;
    }

    public void setLlaves(ArrayList llaves) {
        this.llaves = llaves;
    }

    public void addLlave(int llave) {
        llaves.add(llave);
    }

    public boolean isHoja() {
        return hoja;
    }

    public void setHoja(boolean hoja) {
        this.hoja = hoja;
    }

    public void recorrido() {
        int i;
        for (i = 0; i < llaves.size(); i++) {
            if (!hoja) {
                nodos.get(i).recorrido();
                System.out.println(" " + llaves.get(i));
            }
        }

        if (!hoja) {
            nodos.get(i).recorrido();
        }
    }

    public BTree busqueda(int llave) {
        int i = 0;
        
        while (i < llaves.size() && llave > llaves.get(i))
        {
            i++;
        }
        
        if (llaves.get(i) == llave)
        {
            return this;
        }
        
        if (hoja)
        {
            return null;
        }
        
        return nodos.get(i).busqueda(llave);
    }
    
    
}
