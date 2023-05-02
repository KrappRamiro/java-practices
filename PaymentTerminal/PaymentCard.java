public class PaymentCard {
	private double balance;

	private void alertBalance() {
		System.out.printf("account now has %.2f dollars\n", this.balance);
	}

	public PaymentCard(double balance) {
		System.out.printf("Creating payment card with %.2f dollars\n", balance);
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}

	public void depositMoney(double amount) {
		System.out.printf("Depositing %.2f dollars into the card, ", amount);
		this.balance += amount;
		alertBalance();
	}

	public boolean withdrawMoney(double amount) {
		if (this.balance >= amount) {
			System.out.printf("Success withdrawing %.2f dollars out of the card, ", amount);
			this.balance -= amount;
			alertBalance();
			return true;
		}
		System.out.printf("FAILURE withdrawing %.2f dollars out of the card: Insufficient money in the account\n",
				amount);
		return false;
	}

}
