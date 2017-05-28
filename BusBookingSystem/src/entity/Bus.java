/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lyser
 */
public class Bus {
    private String bcode;
    private String busName;
    private int seat;
    private int booked;
    private double departTime;
    private double arrivalTime;

    public Bus(String bcode, String busName, int seat, int booked, double departTime, double arrivalTime) {
        this.bcode = bcode;
        this.busName = busName;
        this.seat = seat;
        this.booked = booked;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
    }

    public Bus() {
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepartTime() {
        return departTime;
    }

    public void setDepartTime(double departTime) {
        this.departTime = departTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    
}
