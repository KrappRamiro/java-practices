public class Main {
	public static void main(String[] args) {
		PaymentTerminal unicafeExactum = new PaymentTerminal();
		PaymentCard annesCard = new PaymentCard(16);
		System.out.println("\n\n### --- TESTING normal payment usage --- ###\n");
		unicafeExactum.buyMeal("heartly", 5);
		unicafeExactum.buyMeal("heartly", 1);
		unicafeExactum.buyMeal("heartly", 0);
		unicafeExactum.buyMeal("heartly", -1);
		unicafeExactum.buyMeal("affordable", 5);
		unicafeExactum.buyMeal("affordable", 1);
		unicafeExactum.buyMeal("affordable", 0);
		unicafeExactum.buyMeal("affordable", -1);
		unicafeExactum.buyMeal("supermeal", 5);

		System.out.println("\n\n### --- TESTING PaymentCard usage --- ###\n");
		unicafeExactum.buyMeal("heartly", annesCard);
		unicafeExactum.buyMeal("heartly", annesCard);
		unicafeExactum.buyMeal("heartly", annesCard);
		unicafeExactum.buyMeal("heartly", annesCard);

		unicafeExactum.buyMeal("affordable", annesCard);
		unicafeExactum.buyMeal("affordable", annesCard);
		System.out.println(unicafeExactum);
	}
}