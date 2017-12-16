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
public class BNode {

    private int gradoMinimo;
    //private int numeroLLaves;
    private ArrayList<BNode> nodos = new ArrayList();
    private ArrayList<Integer> llaves = new ArrayList();
    boolean hoja;

    public BNode(int gradoMinimo, boolean hoja) {
        this.gradoMinimo = gradoMinimo;
        this.hoja = hoja;

        for (int i = 0; i < 2 * gradoMinimo - 1; i++) {
            llaves.add(null);
        }

        for (int i = 0; i < 2 * gradoMinimo; i++) {
            nodos.add(null);
        }
    }

    public BNode() {
    }

    public BNode(int gradoMinimo) {
        this.gradoMinimo = gradoMinimo;
    }

    public int getGradoMinimo() {
        return gradoMinimo;
    }

    public void setGradoMinimo(int gradoMinimo) {
        this.gradoMinimo = gradoMinimo;
    }

    public ArrayList getBTree() {
        return nodos;
    }

    public void setBTree(ArrayList BTree) {
        this.nodos = BTree;
    }

    public void addBTree(BNode BTree) {
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

    public ArrayList<BNode> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<BNode> nodos) {
        this.nodos = nodos;
    }

    public void addNodo(BNode nodo) {
        nodos.add(nodo);
    }

    public int keyCount() {
        int count = 0;
        for (int i = 0; i < llaves.size(); i++) {
            if (llaves.get(i) != null) {
                count++;
            }
        }
        // System.out.println("llaves: " + llaves);
        return count;
    }

    public void recorrido() {
        int i;
        for (i = 0; i < keyCount(); i++) {
            if (!hoja) {
                if (nodos.get(i) != null) {
                    nodos.get(i).recorrido();
                }
            }
            System.out.print(" " + llaves.get(i).toString());
        }

        if (!hoja) {
            nodos.get(i).recorrido();
        }
        System.out.println("");
    }

    public BNode busqueda(int llave) {
        int i = 0;

        while (i < llaves.size() && llave > llaves.get(i)) {
            i++;
        }

        if (llaves.get(i) == llave) {
            return this;
        }

        if (hoja) {
            return null;
        }

        return nodos.get(i).busqueda(llave);
    }

    public void insertar2(int llave) {
        int indice = keyCount() - 1;

        if (hoja) {
            while (indice >= 0 && llaves.get(indice) > llave) {
                llaves.set(indice + 1, llaves.get(indice));//faltaba esto 
                indice--;
            }
            llaves.set(indice + 1, llave);

        } else {
            while (indice >= 0 && llaves.get(indice) > llave) {
                indice--;
            }

            if (nodos.get(indice + 1).keyCount() == 2 * gradoMinimo - 1) {
                split(indice + 1, nodos.get(indice + 1));

                if (llaves.get(indice + 1) < llave) {
                    indice++;
                }
            }
            //System.out.println(nodos);
            nodos.get(indice + 1).insertar2(llave);
        }

    }

    public void split(int indice, BNode nodo) {
        BNode nodo2 = new BNode(nodo.getGradoMinimo(), nodo.isHoja());
        // nodo2.getLlaves().size();

        for (int i = 0; i < gradoMinimo - 1; i++) {
            nodo2.getLlaves().set(i, nodo.getLlaves().get(i + gradoMinimo));
        }

        if (!nodo.isHoja()) {
            for (int i = 0; i < gradoMinimo; i++) {
                nodo2.getNodos().set(i, nodo.getNodos().get(i + gradoMinimo));
            }
        }

        //nodo.getLlaves().size();
        for (int i = keyCount(); i >= indice + 1; i--) {
            nodos.set(i + 1, nodos.get(i));
        }

        nodos.set(indice + 1, nodo2);

        for (int i = keyCount() - 1; i >= indice; i--) {
            llaves.set(i + 1, llaves.get(i));
        }

        llaves.set(indice, (Integer) nodo.getLlaves().get(gradoMinimo - 1));

    }

}
