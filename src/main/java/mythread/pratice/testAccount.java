package mythread.pratice;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/12
 */

/**
 * 不知道
 */
public class testAccount {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Account account = new Account();
        bank.setAccount(account);

        Person tom = new Person("Tom");
        Person jack = new Person("Jack");
        bank.window1.setClientele(tom);
        bank.window1.setClientele_money(1);

        bank.window2.setClientele(jack);
        bank.window2.setClientele_money(1);

        Thread thread1 = new Thread(bank.window1);
        Thread thread2 = new Thread(bank.window2);
        thread1.start();
        thread2.start();

    }
}

class Person {
    private final String name;
    private int cash = 1000000;

    public String getName() {
        return name;
    }

    Person(String name) {

        this.name = name;
    }

    int getCrash() {
        return cash;
    }

    boolean disburse(int money) {
        if (money == 0) {
            return false;
        } else {
            cash -= money;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                '}';
    }
}

class Account{
    private int allMoney = 0;

    @Override
    public String toString() {
        return "Account{" +
                "allMoney=" + allMoney +
                '}';
    }

    synchronized void saveMoney(int money){
        allMoney += money;
        System.out.println("当前银行账户余额：" + allMoney);
        System.out.println("-------------------------------");
    }

}

class Bank {
    private Account account;
    Window window1 = new Window();
    Window window2 = new Window();

    void setAccount(Account account) {
        this.account = account;
    }

    public class Window implements Runnable {
        private Person clientele;
        private int clientele_money;

        void setClientele(Person clientele) {
            this.clientele = clientele;
        }

        void setClientele_money(int clientele_money) {
            this.clientele_money = clientele_money;
        }

        @Override
        public void run() {
            w_saveMoney();
        }

        private void w_saveMoney() {
            while (clientele.getCrash() != 0){
                clientele.disburse(clientele_money);
                System.out.println("-------------------------------");
                System.out.println("操作人：["+clientele+"]");
                account.saveMoney(clientele_money);
            }
        }

        @Override
        public String toString() {
            return "Window{" +
                    "clientele=" + clientele +
                    ", clientele_money=" + clientele_money +
                    '}';
        }
    }

}
