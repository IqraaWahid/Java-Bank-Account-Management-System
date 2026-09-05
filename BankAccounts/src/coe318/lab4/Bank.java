/**
 *
 * @author i2wahid
 */
package coe318.lab4;

public class Bank {
    private String name;
    /**
     * An array of Accounts managed by
     * this bank.
     */
    private Account [] accounts;
    private int numAccounts;//number of active accounts

    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        accounts = new Account[maxNumberAccounts];
        numAccounts = 0;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the numAccounts
     */
    public int getNumAccounts() {
        return numAccounts;
    }


    public Account[] getAccounts() {
        return accounts;
    }

    /**
     * Return true if the Bank already has an account
     * with this number; otherwise false.
     * @param accountNumber
     * @return
     */
    public boolean hasAccountNumber(int accountNumber) {
        //looping through every spot in the accounts array (which stores all existing bank accounts).
        for (int i=0;i<accounts.length; i++) {
            Account account = accounts[i];
            if (account != null && account.getNumber() == accountNumber) { //checking if there is empty space and is number is exists
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the specified account to the Bank if possible. If the account number
     * already exists or the Bank has reached its maximum
     * number of accounts, return false and do not add it; otherwise,
     * add it and return true.
     * @param account
     * @return true if successful
     */
    //trying to add account to the array if the account doesnt already exist and if there is space available
    public boolean add(Account account) {
        if(hasAccountNumber(account.getNumber())) { // checking if accounts already exists
            return false;//if account exits return false
        }
        
        else {//else if account doesnt exist
            for (int i = 0; i < accounts.length; i++) {
                if(accounts[i] == null) { //if there is an empty spot in the array
                    accounts[i] = account;
                    numAccounts++; //updating
                    break; //will stop right there 
                }
            }
            return true;
        }
    }

    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}