/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.util.Scanner;

/**
 *
 * @author calvinespinoza
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTreeWeb tree = new BTreeWeb();
        tree.put("13", "Kullo");
        System.out.println("Do you want to search s/n");
        String resp = sc.nextLine();
        while (resp == "s" || resp == "S") {
            sc = new Scanner(System.in);
            System.out.println("Which key do you want to get?");
            String key = sc.nextLine();
            tree.get(resp);
        }
    }
}
