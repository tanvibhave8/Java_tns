package inheritance;

class BankAccount{
    String accountholder;

    BankAccount(String accountholder){
        this.accountholder=accountholder;
    }

    void displaydetails(){
        System.out.println("Account Holder :" + accountholder);
    }
}

class SavingsAccount extends  BankAccount{
    double InterestRate =4.5;

    SavingsAccount(String accountholder){
        super(;)
    }
    @

}