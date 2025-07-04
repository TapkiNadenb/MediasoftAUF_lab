import java.time.LocalDateTime;
import java.util.Random;

public class BankAccount
{
    private String Name;

    private int Balance;

    private LocalDateTime OpeningDate;

    private boolean Block;

    private String numbwer;

    public BankAccount(String Name){
        this.Name = Name;
        this.Balance = 0;
        this.OpeningDate = LocalDateTime.now();
        this.Block = false;
          
    }

    public boolean deposit(int Amount){
        if (Block == true && Amount <= 0){
            return false;
        }
        Balance += Amount;
        return true;
    }

    public boolean withdraw(int Amount){
        if (Block == true && Amount <= 0){
            return false;
        }
        Balance -= Amount;
        return true;
    }

    public boolean transfer (BankAccount otherAccoubnt, int Amount){
        if (Block == true || otherAccoubnt.Block == true || Amount <= 0 ){
            return false;
        }
        this.Balance -= Amount;
        otherAccoubnt.Balance += Amount;
        return true;
    }
    public int getBalance() {
        return Balance;
    }

    public String getName() {
        return Name;
    }

    public boolean isBlocked() {
        return Block;
    }

    public void setBlocked(boolean blocked) {
        Block = blocked;
    }

    public String toString(){
        return "Банковский акк(" + "Владелец:" + Name + "Баланс:" + Balance + "Дата открытия счета:" + OpeningDate + "Статус болокировки:" + Block + ")";
    }



}
