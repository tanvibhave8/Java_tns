package oops;


class BankAccount{
  int balance;
  int withdrawal;
  int deposit;


BankAccount(int balance, int withdrawal, int deposit){
    this.balance=balance;
    this.withdrawal=withdrawal;
    this.deposit=deposit;
}

void current_balance(){
    System.out.println("Current Balance : " + balance);
}

void withdraw(){
    if(withdrawal>=balance){
        System.out.println("Sorry ! your balance is less , you cannot withdraw money.");
        System.out.println("Current Balance = " + balance );
    }
    else if(withdrawal < balance){
        balance=balance-withdrawal;
        System.out.println(withdrawal + "rs withdrawn.");
        System.out.println("Current Balance : "+ balance);
    }
    

}

void deposit(){
    System.out.println(deposit + " amount deposited.");
    balance=deposit+balance;
    System.out.println("Current Balance : "+balance);
}

}
public class bank_constructor {
    public static void main(String[]args){
    BankAccount b1=new BankAccount(100, 120,200);
    b1.current_balance();
    b1.withdraw();
    //b1.deposit();
    }
}