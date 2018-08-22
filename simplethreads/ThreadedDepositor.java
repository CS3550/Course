/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplethreads;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author unouser
 */
public class ThreadedDepositor implements Runnable{

    private final BankAccount bankAccount;  
    
    
    
    public ThreadedDepositor(BankAccount ba){
        this.bankAccount = ba;
    }

    @Override
    public void run() {
        bankAccount.deposit();
    }
    
}
