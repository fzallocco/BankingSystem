import java.util.*;
class BankingSystemManagement {

	//Bank Account class data
	class BankAccount{

		private String accountId;
		private double amount;

		BankAccount(String accountId, double amount){

			this.accountId = accountId;
			this.amount = amount;
		}

		//setters
		public void setAmount(double amount){
		
			try{

				if(amount>=0.00){
				
					double newAmount = amount;
					this.amount += newAmount;
				}
			}catch(Exception e){
	
				System.out.println("amount must be greater than or equal $0.00\n");
			}
		}

		//getters

		public double getAmount(){

			return amount;
		}
	
	}
	
	//Banking System class data
	class BankingSystem{
		
		private Map<String, BankAccount> bankAccounts;

		public BankingSystem() {
		
			this.bankAccounts = new HashMap<>();	
		}

		//setters
		public void addAccount(String accountId, double amount){

			if(!bankAccounts.containsKey(accountId)){

				BankAccount newAcc = new BankAccount(accountId, amount);
				bankAccounts.put(accountId, newAcc);
				System.out.println("account created and added to system\n");
			} else { 

				System.out.println(String.format("account: %s already exists\n", accountId));
			}

		}

		public void removeAccount(String accountId){

			if(bankAccounts.containsKey(accountId)){

				bankAccounts.remove(accountId);
				System.out.println(String.format("account: %s removed\n", accountId));
				
			} else { 

				System.out.println("bank account does not exist\n");
			}
		}

		public void depositAmount(String accountId, double amount){

			if(bankAccounts.containsKey(accountId)){

				BankAccount acc = bankAccounts.get(accountId);
				acc.setAmount(amount);
				System.out.println(String.format("account: %s 's current balance is: %.2f\n", acc.accountId, acc.amount));

			} else { 

				System.out.println(String.format("account: %s not found\n", accountId));
			}

		}

		public void withdrawAmount(String accountId, double amount){

			if(bankAccounts.containsKey(accountId)){

				BankAccount acc = bankAccounts.get(accountId);
				double amountWithdrawn = amount;
				double currentBalance = acc.getAmount();
				try{

					if(currentBalance>=amountWithdrawn){
				
						acc.amount -= amountWithdrawn;
						/*acc.setAmount(updatedBalance);*/
						System.out.println(String.format("account: %s 's current balance: %.2f\n", acc.accountId, acc.amount));

					}

				}catch(Exception e){

					System.out.println(String.format("insufficient balance: %.2f\n", acc.amount));
					
				}

			}else{

				System.out.println(String.format("account: %s not found\n", accountId));
			}	

		}

		public void transferAmount(String sourceAccountId, String destinationAccountId, double amount){

			if(bankAccounts.containsKey(sourceAccountId) && bankAccounts.containsKey(destinationAccountId)){

				BankAccount sourceAcc = bankAccounts.get(sourceAccountId);
				BankAccount destinationAcc = bankAccounts.get(destinationAccountId);
				double transferAmount = amount;
				double sourceBalance = sourceAcc.getAmount();
				double destinationBalance = destinationAcc.getAmount();

				try{

					if(sourceBalance>=transferAmount){
				
						sourceAcc.amount -= transferAmount;
						/*sourceAcc.setAmount(sourceBalance);*/
						destinationAcc.amount += transferAmount;
						System.out.println("Successful transfer!\n");
						System.out.println(String.format("account: %s 's current balance is: %.2f\n", sourceAcc.accountId, sourceAcc.amount));
						System.out.println(String.format("account: %s 's current balance is: %.2f\n", destinationAcc.accountId, destinationAcc.amount));
					}else{ System.out.println("insufficient balance\n"); }

				}catch(Exception e){

					System.out.println("insufficient balance\n");
				}

			}else if(!bankAccounts.containsKey(destinationAccountId)){

				System.out.println(String.format("destination account: %s not found\n", destinationAccountId));
				
			}else{
				
				System.out.println("Transfer failed because one or more accounts do not exist\n");
			}

		}
	
		//getters
		public void getAccount(String accountId){
			if(bankAccounts.containsKey(accountId))
			{
				BankAccount currentAccount = bankAccounts.get(accountId);
				System.out.println(String.format("account: %s has balance: %.2f\n", currentAccount.accountId, currentAccount.amount));
			}else{
				
				System.out.println(String.format("account: %s is not in the system\n", accountId));
			}
		}
		
		public void getAllAccounts(){
			System.out.println("All accounts in Banking System:\n");
			for(BankAccount acc : bankAccounts.values()) {
				System.out.println(String.format("account: %s has current balance of: %.2f\n", acc.accountId, acc.amount));
				System.out.println("");
			}	
		}
	}
	
}