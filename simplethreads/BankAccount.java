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
public class BankAccount {

    int balance = 0;

    ReentrantLock lock = new ReentrantLock();

    public void printBalance() {
        System.out.println("The balance is: " + balance);
    }

    public void deposit() {
        for (int i = 0; i < 1000000; i++) {
            lock.lock();
            try {
                balance = balance + 1;
            } finally {
                lock.unlock();
            }
        }
    }

}
