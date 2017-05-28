/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static java.util.Collections.list;
import java.util.Scanner;
import node.Node;
import node.SinglyLinkedList;

/**
 *
 * @author Lyser
 */
public class InputLending {

    public Lending inputLendingData(SinglyLinkedList<Lending> lend, SinglyLinkedList<Book> listBook,
            SinglyLinkedList<Reader> listReader) {
        Scanner in = new Scanner(System.in);
        String rcode, bcode;
        do {
            System.out.print("Enter reader code: ");
            rcode = in.nextLine().trim();
            if (rcode.equalsIgnoreCase("0")) {
                return null;
            }
        } while (isRcode(listReader, rcode));
        do {
            System.out.print("Enter book code: ");
            bcode = in.nextLine().trim();
            if (bcode.equalsIgnoreCase("0")) {
                return null;
            }
        } while (isCode(listBook, bcode));
        if (!isDulicate(lend, bcode, rcode)) {
            System.out.println("Reader have been lending!");
            return null;
        }
        Lending lending = new Lending();
        lending.setBcode(bcode);
        lending.setRcode(rcode);
        lending.setState(1);
        return lending;
    }

    public boolean isDulicate(SinglyLinkedList<Lending> lend, String bcode, String rcode) {
        Node<Lending> node;
        node = lend.getHead();
        while (node != null) {
            if (node.getData().getRcode().equalsIgnoreCase(rcode)
                    && node.getData().getBcode().equalsIgnoreCase(bcode)) {
                System.out.println("Lending is exist!!");
                return false;
            }
            node = node.getNext();
        }
        return true;
    }

    public boolean isRcode(SinglyLinkedList<Reader> list, String rcode) {
        Node<Reader> node;
        node = list.getHead();
        while (node != null) {
            if (node.getData().getRcode().equalsIgnoreCase(rcode)) {
                return false;
            }
            node = node.getNext();
        }
        System.out.println("Not found " + rcode + "in database");
        return true;
    }

    public boolean isCode(SinglyLinkedList<Book> list, String bcode) {
        Node<Book> node;
        node = list.getHead();
        while (node != null) {
            if (node.getData().getBcode().equalsIgnoreCase(bcode)) {
                return false;
            }
            node = node.getNext();
        }
        System.out.println("Not found " + bcode + "in database");
        return true;
    }
}
