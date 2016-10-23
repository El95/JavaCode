import java.util.Scanner;

public class ATM {
	
	private int noOfFives;
	private int noOfTens;
	private int noOfTwenties;
	private int noOfFifties;
	private int totalAmount;
	
	/*Argument of constructor accepts a list of the quantities of each respective note, e.g
	 * [20, 200, 100, 50] ---> Quantity:(20 £5, 200 £10, 100 £20, 50 £50) = 
	 * ATM Holds: (20*5)+(200*10)+(100*20)+(50*50) = £6600.
	 																					*/
	public ATM(int[] amountOfNotes) throws Exception{
		for(int numberOfNotes : amountOfNotes){
			if(numberOfNotes < 0){
				throw new Exception("Must be 0 or more notes.");
			}
		}
		noOfFives = amountOfNotes[0];
		noOfTens = amountOfNotes[1];
		noOfTwenties = amountOfNotes[2];
		noOfFifties = amountOfNotes[3];
		totalAmount = (5*noOfFives)+(10*noOfTens)+(20*noOfTwenties)+(50*noOfFifties);
	}
	
	public void withdraw(BankAccount bankAccount, int amount) throws Exception{
		Scanner pinRequester = new Scanner(System.in);
		
		System.out.print("Enter PIN:");
		String userInputPin = pinRequester.nextLine();
		

		if(!userInputPin.toString().substring(0,4).equals(bankAccount.getPIN().substring(0,4))){
			throw new Exception("Invalid PIN. Please contact the bank.");
		}
		
		System.out.println("Correct PIN");
		
		if(bankAccount!=null){
			if(amount%5 != 0){
				throw new Exception("Must withdraw multiples of 5.");
			}else{
				if(totalAmount - amount<0){
					throw new Exception("ATM does not contain sufficient funds.");
				}
				this.totalAmount -= amount;
				bankAccount.reduceBalance(Double.parseDouble(amount+""));
				dispenseNotes(amount);
			}
			System.out.format("£5:%s, £10:%s, £20:%s, £50:%s", noOfFives, noOfTens, noOfTwenties, noOfFifties);
			
		}
	}
	
	//I'll finish the dispense notes method.
	private void dispenseNotes(int amount) throws Exception{
		int[] noteQuantity = {this.noOfFives, this.noOfTens, this.noOfTwenties, this.noOfFifties};
		if(amount>this.totalAmount){
			throw new Exception("Please withdraw a smaller amount");
		}
		/*
		if(amount){
			
		}
		*/
		
		
		
	}
	
	
	
	
}
