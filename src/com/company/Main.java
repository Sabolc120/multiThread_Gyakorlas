package com.company;
import java.io.*;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Scanner;
class myData {
   synchronized public void ATM(String costumer, int balance, int cash) {
        System.out.println("Hello, " + costumer + " !");
        System.out.println("Please choose one from these options.");
        System.out.println("1. Check my balance");
        System.out.println("2. Deposit my money");
        System.out.println("3. Withdraw my money");
        System.out.print(">: ");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                System.out.println(costumer + " balance's: " + balance);
                break;
            case 2:
                System.out.println("Your cash: " + cash);
                System.out.println("How much money would you like to deposit, " + costumer + " ?");
                System.out.print(">: ");
                int deposit = scanner.nextInt();
                if (deposit < cash) {
                    System.out.println("Deposit was successfull.");
                } else {
                    System.out.println("Not enough cash.");
                }
                break;
            case 3:
                System.out.println("Your balance: " + balance);
                System.out.println("How much money would you like to withdraw, " + costumer + " ?: ");
                System.out.print(">: ");
                int withdraw = scanner.nextInt();
                if (withdraw < balance) {
                    System.out.println("Withdraw was successful!");
                } else {
                    System.out.println("Not enough balance.");
                }
                break;
        }
    }
}
class customerOne extends Thread{
    myData d;

    public customerOne(myData d) {
        this.d = d;
    }
    public void run(){
        d.ATM("Sabolc",5000,7000);
    }
}
class customerTwo extends Thread{
    myData d;

    public customerTwo(myData d) {
        this.d = d;
    }
    public void run(){
        d.ATM("EgeresFickó",98000,70040);
    }
}
public class Main {
    public static void main(String[] args){
        myData d = new myData();
        customerOne elso = new customerOne(d);
        customerTwo masodik = new customerTwo(d);
        elso.start();
        masodik.start();
    }
}
//balance, withdraw, deposit.
//only one class is able to use it, one thread.