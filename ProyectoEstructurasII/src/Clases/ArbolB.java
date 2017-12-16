/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author calvinespinoza
 */

public class ArbolB { 

    private BNode raiz;
    private int T;

    public ArbolB() {
    }

    public ArbolB(int T) {
        this.raiz = null;
        this.T = T;
    }

    public BNode getRoot() {
        return raiz;
    }

    public void setRoot(BNode root) {
        this.raiz = root;
    }

    public int getT() {
        return T;
    }

    public void setT(int T) {
        this.T = T;
    }


    public void insert(int key) {
        if (raiz == null) {
            raiz = new BNode(T, true);
            raiz.getLlaves().set(0, key);
            //raiz.number_keys = 1;

        } else if (raiz.keyCount() == 2 * T - 1) {
            BNode nodo = new BNode(T, false);

            nodo.getNodos().set(0, raiz);
            nodo.split(0, raiz);


            int cont = 0;
            if ((int) nodo.getLlaves().get(0) < key) {
                cont++;
            }


            nodo.getNodos().get(cont).insertar2(key);//nodos.get(cont)

            //nodo.getNodos().get(0).insertar2(key);

            raiz = nodo;
        } else {
            raiz.insertar2(key);
        }

    }

    public void imprimir() {
        if (raiz != null) {
            System.out.println("Recorrido del arbol: ");
            raiz.recorrido();
        }
    }
}
