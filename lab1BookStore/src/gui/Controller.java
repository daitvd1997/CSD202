/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.SerializeFileFactory;
import java.util.Scanner;
import valid.Validate;

/**
 *
 * @author Lyser
 */
public class Controller {

    public static void main(String[] args) {
        ManagementBook books = new ManagementBook();
        ManagementReader readers = new ManagementReader();
        ManagementLending lends = new ManagementLending();
        int choice;
        Validate valid = new Validate();
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        while (true) {
            menu.prinMenuMain();
            choice = (int) valid.getNumber("Enter your choice: ", "Not correcct choice", 1, 4);
            switch (choice) {
                case 1:
                    books.manageBook();
                    break;
                case 2:
                    readers.manageReader();
                    break;
                case 3:
                    lends.manageLending(books.getList(), readers.getList());
                    break;
                case 4:
                    System.out.println(readers.getList());
                    return;
            }
        }
    }
}
