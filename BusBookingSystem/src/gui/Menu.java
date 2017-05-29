/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Lyser
 */
public class Menu {

    public void prinBus() {
        System.out.println("1.      Load data from file\n"
                + "2.      Input & add to the head\n"
                + "3.      Display data\n"
                + "4.      Save bus list to file\n"
                + "5.      Search by bcode\n"
                + "6.      Delete by bcode\n"
                + "7.      Sort by bcode\n"
                + "8.      Add before position  k\n"
                + "9.      Delete the node before the node having bcode = xCode\n"
                + "10.     Back\n");
    }

    public void prinCustomer() {
        System.out.println("1.      Load data from file\n"
                + "2.      Input & add to the end\n"
                + "3.      Display data\n"
                + "4.      Save customer list to file\n"
                + "5.      Search by ccode\n"
                + "6.      Delete by ccode\n"
                + "7.      Back\n");
    }

    public void prinBooking() {
        System.out.println("1.      Input data\n"
                + "2.      Display data width travel time\n"
                + "3.      Sort  by bcode + ccode\n"
                + "4.      Back\n"
        );
    }
    
    public void prinMenuMain() {
        System.out.println("=================================");
        System.out.println("1.      Bus");
        System.out.println("2.      Customer");
        System.out.println("3.      Booking");
        System.out.println("4.      Back");
    }
}
