
public class BankAccount {

	private double overdraftLimit;
	private double balance;
	private String PIN;
	
	//Enter initial balance and overdraftlimit
	public BankAccount(double balance, double overdraftAmount, String pin) throws Exception{
		if(balance<0){
			throw new Exception("Initial balance must be greater than or equal to £0");
		}
		if(overdraftAmount<0){
			throw new Exception("Overdraft limit must be non-negative.");
		}
		if(pin.length()!=4){
			int PINVal = Integer.parseInt(pin);
			//If the line above works it implies the pin entered contains only digits, not letters.
			throw new Exception("PIN must be 4 digits.");
		}
		this.PIN = pin;
		this.balance = balance;
		this.overdraftLimit = overdraftAmount;
	}
	
	//Returns new balance after deposit.
	public double deposit(double amount){
		this.balance += amount;
		return this.balance;
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public String getPIN(){
		return this.PIN;
	}
	
	public void reduceBalance(double amount) throws Exception{
		if(this.balance - amount<0){
			throw new Exception("Insufficient funds.");
		}
		this.balance -= amount;
	}
	
	
	public static void main(String[] args){
		try{
			/*BankAccount instance (Creating a new bank account with...
			 * balance £2010, 
			 * overdraft limit: £100
			 * PIN: 3191
			 */
			BankAccount currentAcc = new BankAccount(2010, 100, "3191");
			System.out.println(currentAcc.getBalance());
			currentAcc.deposit(1000);
			System.out.println(currentAcc.getBalance());
			
			//ATM Object 
			ATM localAtm = new ATM(new int[]{100, 200, 100, 50});
			/*withdrawing £4000 from currentAccount. Exception will occur 
			 * as £4000 is greater than current account balance.
			 */
			localAtm.withdraw(currentAcc, 4000);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	
	
	
	
}
