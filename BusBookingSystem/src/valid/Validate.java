/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import node.Node;
import node.SinglyLinkedList;

/**
 *
 * @author Trinh Dai
 */
//check number input
public class Validate {

    public boolean isNumber(String s) {
        while (true) {
            try {
                double number = Double.parseDouble(s);
                return true;
            } catch (NumberFormatException n) {
                System.out.println("Not a number");
                return false;
            }
        }
    }

//    check year input
    public boolean isYear(int year, int num) {
        int now = Calendar.getInstance().get(Calendar.YEAR);
        if (num >= year && num <= now) {
            return true;
        }
        return false;
    }

//    check phonenumber minmun > 10 interger 
    public boolean isPhone(String s) {
        if (s.length() < 10 || s.length() > 12) {
            System.out.println("Invalid phone number");
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                System.out.println("Invalid phone number");
                return false;
            }
        }
        return true;
    }

    public boolean isEmail(String s) {
        s = s.trim();
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,6}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(s);
        if (m.matches()) {
            return true;
        }
        System.out.println("Invalid email address");
        return false;
    }

    public double getNumber(String mes, String err, double min, double max) {
        String s;
        double number;
        Scanner in = new Scanner(System.in);
        while (true) {
            Validate validate = new Validate();
            System.out.print(mes);
            s = in.nextLine();
            s = s.trim();
            if (validate.isNumber(s)) {
                number = Double.parseDouble(s);
                if (number < min || number > max) {
                    System.out.println(err);
                } else {
                    return number;
                }
            } else {
                System.out.println(err);
            }
        }
    }

    public boolean pressYN() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String s;
        System.out.print("Do you want to continue?(press y to continue)");
        s = in.nextLine().trim();
        if (s.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }
}
