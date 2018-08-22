/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplethreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unouser
 */
public class SimpleThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        BankAccount accountSerial = new BankAccount();

        accountSerial.deposit();
        accountSerial.deposit();
        accountSerial.printBalance();

        BankAccount accountParallel = new BankAccount();

        ThreadedDepositor AliceDepositor = new ThreadedDepositor(accountParallel);
        ThreadedDepositor BobDepositor = new ThreadedDepositor(accountParallel);

        Thread AliceThread = new Thread(AliceDepositor);
        Thread BobThread = new Thread(BobDepositor);

        AliceThread.start();
        BobThread.start();

        try {
            AliceThread.join();
            BobThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SimpleThreads.class.getName()).log(Level.SEVERE, null, ex);
        }

        accountParallel.printBalance();

    }

}
