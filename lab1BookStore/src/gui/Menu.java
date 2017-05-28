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

    public void prinMenuBook() {
        System.out.println("1.1.      Load data from file\n"
                + "1.2.      Input & add to the end\n"
                + "1.3.      Display data\n"
                + "1.4.      Save book list to file\n"
                + "1.5.      Search by bcode\n"
                + "1.6.      Delete by bcode\n"
                + "1.7.      Sort by bcode\n"
                + "1.8.      Input & add to beginning\n"
                + "1.9.      Add after position  k\n"
                + "1.10.     Delete position k\n"
                + "1.11.     Back\n");
    }

    public void prinMenuReader() {
        System.out.println("2.1.      Load data from file\n"
                + "2.2.      Input & add to the end\n"
                + "2.3.      Display data\n"
                + "2.4.      Save reader list to file\n"
                + "2.5.      Search by rcode\n"
                + "2.6.      Delete by rcode\n"
                + "2.7.      Back\n");
    }

    public void prinMenuLend() {
        System.out.println("3.1.      Input data\n"
                + "3.2.      Display data\n"
                + "3.3.      Sort  by bcode + rcode\n"
                + "3.4       Back\n");
    }

    public void prinMenuMain() {
        System.out.println("==============================");
        System.out.println("1. Book");
        System.out.println("2. Reader");
        System.out.println("3. Lending");
        System.out.println("4. Exits\n");
    }

}
