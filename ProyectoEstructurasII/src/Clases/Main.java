/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Scanner;

/**
 *
 * @author calvinespinoza
 */
public class Main {

    public static void main(String[] args)
    {
       // System.out.println("Insert key: ");
        Scanner sc = new Scanner(System.in);
        //String key = sc.nextLine();

        BTree bt = new BTree(5);

        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(7);
        bt.insert(8);

        bt.imprimir();
    }
}
