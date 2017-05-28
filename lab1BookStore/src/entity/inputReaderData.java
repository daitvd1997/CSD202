/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import valid.Validate;
import java.util.Scanner;
import node.Node;
import node.SinglyLinkedList;

/**
 *
 * @author Lyser
 */
public class inputReaderData {

    public Reader inputReader(SinglyLinkedList<Reader> list) {
        Scanner in = new Scanner(System.in);
        Validate valid = new Validate();
        String rcode;
        do {
            System.out.print("Enter reader code: ");
            rcode = in.nextLine();
        } while (!isRcode(list, rcode));
        String name;
        System.out.print("Enter reader name: ");
        name = in.nextLine();
        int byear = (int) valid.getNumber("Enter birth: ", "Year is not valid", 1900, 2020);
        Reader reader = new Reader(rcode, name, byear);
        return reader;

    }

    public boolean isRcode(SinglyLinkedList<Reader> list, String rcode) {
        Node<Reader> node;
        node = list.getHead();
        while (node != null) {
            if (node.getData().getRcode().equalsIgnoreCase(rcode)) {
                System.out.println("Code is existed!!");
                return false;
            }
            node = node.getNext();
        }
        return true;
    }
}
