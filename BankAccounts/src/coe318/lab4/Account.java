/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab4;

/**
 *
 * @author i2wahid
 */
public class Account {
    //instance variables:
    private String name; //owner's name
    private double balance; // owner's current balance
    private int number; // owner's account number
    
    public Account (String name, int number, double initialBalance) { //contructor will give initial values to the instance variables
        this.name=name;
        this.balance=initialBalance;
        this.number=number;
    }
    
    /**
    * @return the name of the owner
    */
    public String getName(){
        return name;
    }
    
    /**
    * @return the current balance of the owner
    */
    public double getBalance(){
        return balance;
    }

    /**
    * @return the owner's account number
    */
    public int getNumber(){
        return number;
    }
    
    
    /**
    * According to the amount being deposited, return  a boolean result
    * Successful deposit should update the account balance.
    */
    public boolean deposit(double amount){
        //User is not allowed to make a deposit of a negative or zero value.
        if(amount<=0){
            return false;
        }
        else{
            balance = balance + amount;
            return true;
        }
        
    }
    
    /**
    * According to the amount being withdrawn, return  a boolean result
    * Successful withdrawal should update the account balance.
    */
    public boolean withdraw(double amount){
        // Furthermore, they will not be allowed to withdraw more money than they have in the account.
        
        if(amount<=0){ // if amount is smaller than or equal to zero, then return false
            return false;
        }
        else { //otherwise...
            if(amount<=balance){ // check if the amount being withdrawn is smaller than or equal to the balance
                balance = balance - amount;
                return true; // if it is then return true
            }
            else{
                return false; // otherwise false
            }
        }
    }
    
    @Override
    public String toString() {//DO NOT MODIFY
       return "(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")";
    }
    
    /*
    checking:
    public static void main (String [] args){
        Account ob = new Account ("Iqraa", 30, 90.1);
        System.out.println(ob);
    }*/
}