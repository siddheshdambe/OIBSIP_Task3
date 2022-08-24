import java.util.Scanner;

class BankAccount{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Username - ");
        this.userName = sc.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.accountNo = sc.nextLine();
        System.out.print("\nRegistration Completed.. Kindly Login");
    }
    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("\nEnter Your Username");
            String Username = sc.nextLine();
            if (Username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("\nEnter Your Password = ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.print("\nLogin successful!!");
                        isLogin = true;
                    } else {
                        System.out.println("\n Incorrect Password");
                    }
                }
            } else {
                System.out.println("\n Username not found.");
            }
        }
        return isLogin;
    }

    public void withdraw(){
        System.out.println("\n Enter amount to withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance>=amount){
                transactions+=1;
                balance -= amount;
                System.out.println("\n Withdrawal Successfull");
                String str = amount + "Rs Withdrawed \n";
                System.out.println(str);
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("\nInsufficient Balance");
            }
        }catch(Exception e){

        }
    }

    public void deposit(){
        System.out.println("\n Enter amount to deposit - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(amount<=100000){
                transactions+=1;
                balance += amount;
                System.out.println("\n Deposit Successfull");
                String str = amount + "Rs Deposited \n";
                System.out.println(str);
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("\nDeposit Limit Exceeded. Deposit Limit is 100000");
            }
        }catch(Exception e){
        }
    }

    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter Receipents's name - ");
        String receipent = sc.nextLine();
        System.out.println("\n Enter amount to transfer - ");
        float amount = sc.nextFloat();
        try{
            if(balance>=amount){
                if(amount<=50000){
                    transactions+=1;
                    balance -= amount;
                    System.out.println("\nSuccessfully transferred to "+receipent);
                    String str = amount + "Rs transferred to "+ receipent +"\n";
                    System.out.println(str);
                    transactionHistory = transactionHistory.concat(str);
                }else {
                    System.out.println("Limit Exceeded. Transfer limit is 50000.");
                }
            }else{
                System.out.println("\nInsufficient Funds");
            }
        }catch(Exception e){
        }
    }

    public void checkBalance(){
        System.out.println("\n" + balance + "Rs");
    }

    public void transHistory(){
        if(transactions==0){
            System.out.println("\n No transactions");
        }else{
            System.out.println(transactionHistory);
        }
    }
}


