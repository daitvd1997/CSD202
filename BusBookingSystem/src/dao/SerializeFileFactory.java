/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template SerializeFileFactory, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bus;
import entity.Customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import node.Node;
import node.SinglyLinkedList;

/**
 *
 * @author Trinh Dai
 */
public class SerializeFileFactory {

    public static boolean saveDataBus(SinglyLinkedList<Bus> list, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            Node<Bus> node = list.getHead();
            while (node != null) {
                bw.write(node.getData().toString());
                bw.newLine();
                node = node.getNext();
            }
            bw.close();
            osw.close();
            fos.close();
            System.out.println("Successfully uploaded book data");
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean saveDataCustomer(SinglyLinkedList<Customer> list, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            Node<Customer> node = list.getHead();
            while (node != null) {
                bw.write(node.getData().toString());
                bw.newLine();
                node = node.getNext();
            }
            bw.close();
            osw.close();
            fos.close();
            System.out.println("Successfully uploaded reader data");
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static SinglyLinkedList<Bus> readDataBus(String path) {
        SinglyLinkedList<Bus> list = new SinglyLinkedList();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                try {
                    String line = br.readLine().replace("\n", "");
                    StringTokenizer st = new StringTokenizer(line, "|");
                    String bcode = st.nextToken().trim();
                    String busName = st.nextToken().trim();
                    int seat = Integer.parseInt(st.nextToken().trim());
                    int booked = Integer.parseInt(st.nextToken().trim());
                    double departTime = Double.parseDouble(st.nextToken().trim());
                    double arrivalTime = Double.parseDouble(st.nextToken().trim());
                    Bus bus = new Bus(bcode, busName, seat, booked, departTime, arrivalTime);
                    list.inserToTail(bus);
                } catch (Exception ex) {
                    break;
                }
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            System.err.println("File err");;
            return null;
        }
        System.out.println("Successfully loaded file to data");
        return list;
    }

    public static SinglyLinkedList<Customer> readCustumerData(String path) {
        SinglyLinkedList<Customer> list = new SinglyLinkedList();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            while (true) {
                try {
                    String line = br.readLine().replaceAll("  ", " ");
                    StringTokenizer st = new StringTokenizer(line, "|");
                    String ccode = st.nextToken().trim();
                    String cusName = st.nextToken().trim();
                    String phone = st.nextToken().trim();
                    Customer cus = new Customer(ccode, cusName, phone);
                    list.inserToTail(cus);
                } catch (Exception ex) {
                    break;
                }
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception ex) {
            System.err.println("File err");;
            return null;
        }
        System.out.println("Successfully loaded file to data");
        return list;
    }
    
}
