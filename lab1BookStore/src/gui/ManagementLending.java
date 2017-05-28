/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.SerializeFileFactory;
import entity.Book;
import entity.InputLending;
import entity.Lending;
import entity.Reader;
import java.util.Scanner;
import node.Node;
import node.SinglyLinkedList;
import valid.Validate;

/**
 *
 * @author Lyser
 */
public class ManagementLending {

    private SinglyLinkedList<Lending> list;

    public SinglyLinkedList<Lending> getList() {
        return list;
    }

    public void setList(SinglyLinkedList<Lending> list) {
        this.list = list;
    }

    public ManagementLending(SinglyLinkedList<Lending> lend) {
        this.list = lend;
    }

    public ManagementLending() {
        list = new SinglyLinkedList<>();
    }

    public void manageLending(SinglyLinkedList<Book> listBook, SinglyLinkedList<Reader> listReader) {
        int choice;
        Validate valid = new Validate();
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        InputLending input = new InputLending();
        while (true) {
            menu.prinMenuLend();
            choice = (int) valid.getNumber("Enter your choice: ", "Not correcct choice", 0, 3);
            switch (choice) {
                case 1:
                    Lending lend = new Lending();
                    lend = input.inputLendingData(list, listBook, listReader);
                    if (lend != null) {
                        list.insertToHead(lend);
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
        Node<Book> qNode = list.getHead();
        Node<Book> kNode = qNode.getNext();
        while (qNode.getNext() != null) {
            while (kNode != null) {
                if (qNode.getData().getBcode().compareToIgnoreCase(kNode.getData().getBcode()) > 0) {
                    Book temp = new Book();
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
