package mythread.pratice;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/12
 */

class Account2{
    double balance;

    Account2() {
    }

    void deposit(double amt){
        balance += amt;
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+" : "+balance);
    }

}

class Customer implements Runnable{
    private Account2 account2;

    Customer(Account2 account2){
        this.account2 = account2;
    }

    @Override
    public void run() {
        for (int i = 0; i< 3 ;++ i){
            account2.deposit(1000);
        }
    }
}

public class testAccount2 {
    public static void main(String[] args) {
        Account2 account2 = new Account2();
        Customer c1 =  new Customer(account2);
        Customer c2 =  new Customer(account2);

        Thread thread = new Thread(c1);
        Thread thread1 = new Thread(c2);

        thread.start();
        thread1.start();
    }
}
