/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;
import node.Node;
import node.SinglyLinkedList;
import valid.Validate;

/**
 *
 * @author Lyser
 */
public class InputData {

    public Bus inputBus(SinglyLinkedList<Bus> list) {
        Scanner in = new Scanner(System.in);
        Validate valid = new Validate();
        String bcode, busName;
        int seat, booked;
        double departTime, arrivalTime;
        
        do {
            System.out.print("Enter bus code: ");
            bcode = in.nextLine().trim();
        }while(!isBcode(list, bcode));
        System.out.print("Enter name of bus: ");
        busName = in.nextLine().trim();
        seat = (int) valid.getNumber("Enter seat: ", "Seat is invalid", 0, 50);
        booked = (int) valid.getNumber("Enter number booked: ", "Invalid number booked", 0, seat);
        departTime = valid.getNumber("Enter depart time: ", "Depart time is invalid", 0, Double.MAX_VALUE);
        arrivalTime = valid.getNumber("Enter arrival time : ", "Arrival time is invalid", departTime, Double.MAX_VALUE);
        Bus bus = new Bus(bcode, busName, seat, booked, departTime, arrivalTime);
        return bus;
    }

    public boolean isBcode(SinglyLinkedList<Bus> list, String bcode) {
        Node<Bus> node;
        node = list.getHead();
        while (node != null) {
            if (node.getData().getBcode().equalsIgnoreCase(bcode)) {
                System.out.println("Code is existed!!");
                return false;
            }
            node = node.getNext();
        }
        return true;
    }
}
