/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import valid.Validate;
import dao.SerializeFileFactory;
import entity.Book;
import entity.Reader;
import entity.inputReaderData;
import java.util.Scanner;
import javax.naming.ldap.ManageReferralControl;
import node.Node;
import node.SinglyLinkedList;

/**
 *
 * @author Lyser
 */
public class ManagementReader {

    private SinglyLinkedList<Reader> list;

    public ManagementReader() {
        list = new SinglyLinkedList<>();
    }

    public SinglyLinkedList<Reader> getList() {
        return list;
    }

    public void setList(SinglyLinkedList<Reader> list) {
        this.list = list;
    }

    public void manageReader() {
        inputReaderData input = new inputReaderData();
        int choice;
        Validate valid = new Validate();
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        while (true) {
            menu.prinMenuReader();
            choice = (int) valid.getNumber("Enter your choice: ", "Not correcct choice", 1, 7);
            switch (choice) {
                case 1:
                    list = SerializeFileFactory.readReaderData("demo2.txt");
                    break;
                case 2:
                    Reader reader = input.inputReader(list);
                    list.inserToTail(reader);
                    break;
                case 3:
                    System.out.println("Code |  Name  |  Birth");
                    list.traverse();
                    break;
                case 4:
                    SerializeFileFactory.saveDataReader(list, "demo.txt");
                    break;
                case 5:
                    searchByCode();
                    break;
                case 6:
                    deleteByCode();
                    break;
                case 7:
                    return;
            }
        }
    }

    public Node<Reader> searchByCode() {
        Node<Reader> node = list.getHead();
        System.out.print("\nEnter code :");
        String rcode = new Scanner(System.in).nextLine().trim();
        while (node != null) {
            if (node.getData().getRcode().equalsIgnoreCase(rcode)) {
                System.out.println(node.getData().toString());
                return node;
            }
            node = node.getNext();
        }
        System.out.println("Not found book having code: " + rcode);
        return null;
    }

    public void deleteByCode() {
        Node<Reader> node = list.getHead();
        System.out.print("\nEnter code :");
        String rcode = new Scanner(System.in).nextLine().trim();
        while (node != null) {
            if (node.getData().getRcode().equalsIgnoreCase(rcode)) {
                list.delateNode(node);
                System.out.println("Successlly deleted!");
                return;
            }
            node = node.getNext();
        }
        System.out.println("Not found book having code: " + rcode);
    }
}
