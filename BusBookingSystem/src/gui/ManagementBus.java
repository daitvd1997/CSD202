/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.SerializeFileFactory;
import entity.Bus;
import entity.InputData;
import java.util.Scanner;
import node.Node;
import node.SinglyLinkedList;
import valid.Validate;

/**
 *
 * @author Lyser
 */
public class ManagementBus {

    private Scanner in = new Scanner(System.in);
    private Validate valid = new Validate();
    private Menu menu = new Menu();
    private SinglyLinkedList<Bus> list;
    private InputData inputData = new InputData();

    public ManagementBus() {
        list = new SinglyLinkedList<>();
    }

    public SinglyLinkedList<Bus> getList() {
        return list;
    }

    public void setList(SinglyLinkedList<Bus> list) {
        this.list = list;
    }

    public void manage() {
        int choice;
        while (true) {
            menu.prinBus();
            choice = (int) valid.getNumber("Enter your choice: ", "Not correcct choice", 1, 10);
            switch (choice) {
                case 1:
                    list = SerializeFileFactory.readDataBus("bus.txt");
                    break;
                case 2:
                    list.inserToTail(inputData.inputBus(list));
                    break;
                case 3:
                    System.out.println("bcode|Bus_name|Seat|booked|depart_time|arrival_time|travel_time");
                    list.traverse();
                    break;
                case 4:
                    SerializeFileFactory.saveDataBus(list, "bus.txt");
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
                    addBeforePosition();
                    break;
                case 9:
                    list.deleteBeforeNode(searchByCode());
                    System.out.println("Successfully deleted");
                    break;
                case 10:
                    return;
            }
        }
    }

    public Node<Bus> searchByCode() {
        Node<Bus> node = list.getHead();
        System.out.print("\nEnter code :");
        String bcode = new Scanner(System.in).nextLine().trim();
        while (node != null) {
            if (node.getData().getBcode().equalsIgnoreCase(bcode)) {
                System.out.println(node.getData().toString());
                return node;
            }
            node = node.getNext();
        }
        System.out.println("Not found bus having code: " + bcode);
        return null;
    }

    public void deleteByCode() {
        Node<Bus> node = list.getHead();
        System.out.print("\nEnter code :");
        String bcode = new Scanner(System.in).nextLine().trim();
        while (node != null) {
            if (node.getData().getBcode().equalsIgnoreCase(bcode)) {
                list.delateNode(node);
                System.out.println("Successfullu deleted");
                return;
            }
            node = node.getNext();
        }
        System.out.println("Not found bus having code: " + bcode);
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
        System.out.println("Sucessfully sorted");
    }

    public void addBeforePosition() {
        int posit = (int) valid.getNumber("Enter postition: ", "invalid postition", 0, list.countNode());
        Bus bus = new Bus();
        bus = inputData.inputBus(list);
        int index = 0;
        Node<Bus> node;
        node = list.getHead();
        while (node != null) {
            index++;
            if(index == posit) {
                list.insertBeforeNode(node, bus);
                System.out.println("Successfully add");
                return;
            }
            node = node.getNext();
        }
        System.out.println("Successfully inserted");
    }
    public static void main(String[] args) {
        ManagementBus bus = new ManagementBus();
        bus.manage();
    }
}
