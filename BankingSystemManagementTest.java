import java.util.*;
class BankingSystemManagementTest {

	public static void main(String[] args){
	
		System.out.println("This is the Banking System Management Test\n");
		
		BankingSystemManagement bsm = new BankingSystemManagement();
		
		BankingSystemManagement.BankingSystem bs = bsm.new BankingSystem();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter any integer to proceed or -1 to end program\n");
		int userInput = scn.nextInt();
		while(userInput != -1)
		{
			System.out.println("Banking System: Enter any integer to proceed or -1 to end program\n");
			System.out.println("1) View account details\n");
			System.out.println("2) Deposit funds into account\n");
			System.out.println("3) Withdraw funds from account\n");
			System.out.println("4) Transfer funds to other account\n");
			System.out.println("5) Create new account\n");
			System.out.println("6) Delete account\n");
			System.out.println("7) View all accounts\n");
			System.out.println("-1) To close program\n");
			userInput = scn.nextInt();
			if(userInput == 1){
				/*display account info*/
				System.out.println("1. Please enter account id below:\n");
				String accountId = scn.next();
				bs.getAccount(accountId);
			}
			if(userInput == 2){ 
				/*deposit funds*/
				System.out.println("2. Please enter account id & amount below:\n");
				String accountId = scn.next();
				double balance = scn.nextDouble();
				bs.depositAmount(accountId, balance);
			}
			if(userInput == 3){ 
				/*withdraw funds*/
				System.out.println("3. Please enter account id & amount below:\n");
				String accountId = scn.next();
				double balance = scn.nextDouble();
				bs.withdrawAmount(accountId, balance);
				
			}
			if(userInput == 4){ 
				/*transfer funds*/
				System.out.println("4. Please enter source account id, destination account id, & amount in the following order below:\n");
				String sourceId = scn.next();
				String destinationId = scn.next();
				double balance = scn.nextDouble();
				bs.transferAmount(sourceId, destinationId, balance);
				/*System.out.println("transfer was successful\n");*/
			}
			if(userInput == 5){ 
				/*create new account*/
				System.out.println("5. Please enter account id & amount below:\n");
				System.out.println("Choose accountId:\n");
				String accountId = scn.next();
				System.out.println("Enter minimum balance $0.00\n");
				double balance = scn.nextDouble();
				bs.addAccount(accountId, balance);
			}
			if(userInput == 6){ 
				/*delete account*/
				System.out.println("6. Please enter account id\n");
				String accountId = scn.next();
				bs.removeAccount(accountId);
			}
			if(userInput == 7){ 
				/*view all accounts*/
				bs.getAllAccounts();
			}
		}
		
	}
}