import java.util.ArrayList;

public class PaymentTerminal {
	private double money; // amount of cash

	private ArrayList<Meal> listOfMeals = new ArrayList<>();

	public PaymentTerminal() {
		// register initially has 1000 euros of money
		this.money = 1000;
		listOfMeals.add(new Meal("affordable", 2.50));
		listOfMeals.add(new Meal("heartly", 4.30));
	}

	public void addMoneyToCard(PaymentCard card, double amount) {
		money += amount;
		card.depositMoney(amount);
	}

	public boolean buyMeal(String mealName, PaymentCard card) {
		Meal meal = Meal.findMealInArrayList(mealName, listOfMeals);
		// check existence of meal
		if (meal.name.equals("notfound")) {
			return false;
		}
		// check if the payment is enough
		if (card.getBalance() < meal.price) {
			System.out.printf("ERROR: Not enough money for meal '%s'\n", meal.name);
			return false;
		}
		card.withdrawMoney(meal.price);
		meal.count++;
		money += meal.price;
		System.out.printf("Bought a %s meal for %.2f euros using a PaymentCard\n", meal.name, meal.price);
		return true;
	}

	public double buyMeal(String mealName, double payment) {
		Meal meal = Meal.findMealInArrayList(mealName, listOfMeals);
		// check existence of meal
		if (meal.name.equals("notfound")) {
			return payment;
		}
		// check if the payment is enough
		if (payment < meal.price) {
			System.out.printf("ERROR: Not enough money for meal '%s'\n", meal.name);
			return payment;
		}
		// Actions to take when buying the meal
		double change = payment - meal.price;
		meal.count++;
		money += meal.price;
		System.out.printf("Bought a %s meal for %.2f euros, returning %.2f\n", meal.name, meal.price, change);
		return change;
	}

	public String toString() {
		String soldMeals = "";
		for (Meal meal : listOfMeals) {
			soldMeals += "\n" + meal.name + " meals sold:\t" + meal.count;
		}
		return String.format("PaymentTerminal information: Money: %.2f %s", money, soldMeals);
	}
}
