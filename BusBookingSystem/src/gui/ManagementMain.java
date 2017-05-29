/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Scanner;
import valid.Validate;

/**
 *
 * @author Lyser
 */
public class ManagementMain {

    public static void main(String[] args) {
        Menu menu = new Menu();
        ManagementBooking books = new ManagementBooking();
        ManagementBus bus = new ManagementBus();
        ManagementCustomer cus = new ManagementCustomer();
        int choice;
        Validate valid = new Validate();
        Scanner in = new Scanner(System.in);
        while (true) {
            menu.prinMenuMain();
            choice = (int) valid.getNumber("Enter your choice: ", "Not correcct choice", 1, 4);
            switch (choice) {
                case 1:
                    bus.manage();
                    break;
                case 2:
                    cus.manageCustomer();
                    break;
                case 3:
                    books.manageBooking(bus.getList(), cus.getList());
                    break;
                case 4:
                    return;
            }
        }
    }
}
