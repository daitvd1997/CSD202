/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import valid.Validate;
import dao.SerializeFileFactory;
import entity.Book;
import java.io.Serializable;
import java.util.Scanner;
import node.Node;
import node.SinglyLinkedList;

/**
 *
 * @author Lyser
 */
public class ManagementBook extends Book {

    private SinglyLinkedList<Book> list;

    public ManagementBook(SinglyLinkedList<Book> list) {
        this.list = list;
    }

    public ManagementBook() {
        list = new SinglyLinkedList<>();
    }

    public SinglyLinkedList<Book> getList() {
        return list;
    }

    public void setList(SinglyLinkedList<Book> list) {
        this.list = list;
    }

    public void manageBook() {
        int choice;
        Validate valid = new Validate();
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        while (true) {
            menu.prinMenuBook();
            choice = (int) valid.getNumber("Enter your choice: ", "Not correcct choice", 0, 11);
            switch (choice) {
                case 1:
                    list = SerializeFileFactory.readBookData("demo.txt");
                    break;
                case 2:
                    list.inserToTail(inputBook());
                    break;
                case 3:
                    System.out.println("code|   Title |Quantity|Lended|Price|Value ");
                    list.traverse();
                    break;
                case 4:
                    SerializeFileFactory.saveDataBook(list, "demo.txt");
                    break;
                case 5:
                    searchByCode();
                    break;
                case 6:
                    deleteByCode();
                    break;
                case 7:
                    sortByCode();
                    break;
                case 8:
                    list.inserToTail(inputBook());
                    break;
                case 9:
                    list.inserAfterQ(searchByCode(), inputBook());
                    break;
                case 10:
                    list.deleteAfterQ(searchByCode());
                    break;
                case 11:
                    return;
            }
        }
    }

    //dong nay check xem code da luu ton tai hay chua neu tồn tại return flase
    public boolean isCode(String code) {
        Node<Book> node;
        node = list.getHead();
        while (node != null) {
            if (node.getData().getBcode().equalsIgnoreCase(code)) {
                System.out.println("Code is existed!!");
                return false;
            }
            node = node.getNext();
        }
        return true;
    }

    //nhap thong tin 1 quan sach
    public Book inputBook() {
        Scanner in = new Scanner(System.in);
        Validate valid = new Validate();
        String bcode;
        do {
            System.out.print("Enter the code of the book :");
            bcode = in.nextLine().trim();
        } while (!isCode(bcode));
        System.out.print("Enter titile: ");
        String title = in.nextLine();
        int quantity = (int) valid.getNumber("Enter quanity: ", "Try it again", 0, Double.MAX_VALUE);
        int lended = 0;
        double price = valid.getNumber("Enter price: ", "try it again", 0, Double.MAX_VALUE);
        Book book = new Book(bcode, title, quantity, lended, price);
        return book;
    }

    //
    public Node<Book> searchByCode() {
        Node<Book> node = list.getHead();
        System.out.print("\nEnter code :");
        String bcode = new Scanner(System.in).nextLine().trim();
        while (node != null) {
            if (node.getData().getBcode().equalsIgnoreCase(bcode)) {
                node.getData().toString();
                return node;
            }
            node = node.getNext();
        }
        System.out.println("Not found book having code: " + bcode);
        return null;
    }

    public void deleteByCode() {
        Node<Book> node = list.getHead();
        System.out.print("\nEnter code :");
        String bcode = new Scanner(System.in).nextLine().trim();
        while (node != null) {
            if (node.getData().getBcode().equalsIgnoreCase(bcode)) {
                list.delateNode(node);
                return;
            }
            node = node.getNext();
        }
        System.out.println("Not found book having code: " + bcode);
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
