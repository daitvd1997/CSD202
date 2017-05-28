/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template SerializeFileFactory, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Book;
import entity.Reader;
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

    public static boolean saveDataBook(SinglyLinkedList<Book> list, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            Node<Book> node = list.getHead();
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
    
    public static boolean saveDataReader(SinglyLinkedList<Reader> list, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            Node<Reader> node = list.getHead();
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

    public static SinglyLinkedList<Book> readBookData(String path) {
        SinglyLinkedList<Book> list = new SinglyLinkedList();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                try {
                    String line = br.readLine().replace("\n", "");
                    StringTokenizer st = new StringTokenizer(line, "|");
                    String bcode = st.nextToken().trim();
                    String title = st.nextToken().trim();
                    int quanity = Integer.parseInt(st.nextToken().trim());
                    st.nextToken().trim();
                    double price = Double.parseDouble(st.nextToken().trim());
                    Book book = new Book(bcode, title, quanity, 0, price);
                    list.inserToTail(book);
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

    public static SinglyLinkedList<Reader> readReaderData(String path) {
        SinglyLinkedList<Reader> list = new SinglyLinkedList();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            while (true) {
                try {
                    String line = br.readLine().replaceAll("  ", " ");
                    StringTokenizer st = new StringTokenizer(line, "|");
                    String rcode = st.nextToken().trim();
                    String name = st.nextToken().trim();
                    int ryear = Integer.parseInt(st.nextToken().trim());
                    Reader reader = new Reader(rcode, name, ryear);
                    list.inserToTail(reader);
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
