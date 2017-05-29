/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.SerializeFileFactory;
import entity.Customer;
import entity.InputData;
import java.util.Scanner;
import node.Node;
import node.SinglyLinkedList;
import valid.Validate;

/**
 *
 * @author Lyser
 */
public class ManagementCustomer {

    private SinglyLinkedList<Customer> list;

    public ManagementCustomer() {
        list = new SinglyLinkedList<>();
    }

    public SinglyLinkedList<Customer> getList() {
        return list;
    }

    public void setList(SinglyLinkedList<Customer> list) {
        this.list = list;
    }

    public void manageCustomer() {
        InputData input = new InputData();
        int choice;
        Validate valid = new Validate();
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        while (true) {
            menu.prinCustomer();
            choice = (int) valid.getNumber("Enter your choice: ", "Not correcct choice", 1, 7);
            switch (choice) {
                case 1:
                    list = SerializeFileFactory.readCustumerData("customer.txt");
                    break;
                case 2:
                    Customer customer = input.inputCus(list);
                    list.inserToTail(customer);
                    break;
                case 3:
                    System.out.println("Code |  Name  |  Phone");
                    list.traverse();
                    break;
                case 4:
                    SerializeFileFactory.saveDataCustomer(list, "customer.txt");
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

    public Node<Customer> searchByCode() {
        Node<Customer> node = list.getHead();
        System.out.print("\nEnter code :");
        String ccode = new Scanner(System.in).nextLine().trim();
        while (node != null) {
            if (node.getData().getCcode().equalsIgnoreCase(ccode)) {
                System.out.println(node.getData().toString());
                return node;
            }
            node = node.getNext();
        }
        System.out.println("Not found customer having code: " + ccode);
        return null;
    }

    public void deleteByCode() {
        Node<Customer> node = list.getHead();
        System.out.print("\nEnter code :");
        String rcode = new Scanner(System.in).nextLine().trim();
        while (node != null) {
            if (node.getData().getCcode().equalsIgnoreCase(rcode)) {
                list.delateNode(node);
                System.out.println("Successlly deleted!");
                return;
            }
            node = node.getNext();
        }
        System.out.println("Not customer book having code: " + rcode);
    }

    public static void main(String[] args) {
        ManagementCustomer cus = new ManagementCustomer();
        cus.manageCustomer();
    }
}
