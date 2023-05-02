import java.util.ArrayList;

public class Meal {
	public String name;
	public double price;
	public int count;

	public Meal(String name, double price) {
		this.name = name;
		this.price = price;
		this.count = 0;
	}

	public static Meal findMealInArrayList(String mealName, ArrayList<Meal> listOfMeals) {
		for (Meal meal : listOfMeals) { // check if meal exists
			if (meal.name.equals(mealName)) {
				return meal;
			}
		}
		System.out.printf("ERROR: Meal '%s' not found\n", mealName);
		return new Meal("notfound", 0); // if there is no meal with that name, return a notfound meal
	}
}