/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.Booking;
import entity.Bus;
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
public class ManagementBooking {

    private SinglyLinkedList<Booking> list;

    public ManagementBooking() {
        list = new SinglyLinkedList<>();
    }

    public SinglyLinkedList<Booking> getList() {
        return list;
    }

    public void setList(SinglyLinkedList<Booking> list) {
        this.list = list;
    }

    public void manageBooking(SinglyLinkedList<Bus> listBus, SinglyLinkedList<Customer> listCustomer) {
        int choice;
        Validate valid = new Validate();
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        InputData input = new InputData();
        while (true) {
            menu.prinBooking();
            choice = (int) valid.getNumber("Enter your choice: ", "Not correcct choice", 0, 3);
            switch (choice) {
                case 1:
                    Booking book = new Booking();
                    book = input.inputDataBooking(listCustomer, listBus);
                    if (book != null) {
                        list.insertToHead(book);
                    }
                    break;
                case 2:
                    list.traverse();
                    break;
                case 3:
                    sortByCode();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void sortByCode() {
        if (list.getHead() == null) {
            System.out.println("List is empty");
            return;
        }
        if (list.getHead() == list.getTail()) {
            return;
        }
        Node<Bus> qNode = list.getHead();
        Node<Bus> kNode = qNode.getNext();
        while (qNode.getNext() != null) {
            while (kNode != null) {
                if (qNode.getData().getBcode().compareToIgnoreCase(kNode.getData().getBcode()) > 0) {
                    Bus temp = new Bus();
                    temp = qNode.getData();
                    qNode.setData(kNode.getData());
                    kNode.setData(temp);
                }
                kNode = kNode.getNext();
            }
            qNode = qNode.getNext();
            kNode = qNode.getNext();
        }
    }
}
