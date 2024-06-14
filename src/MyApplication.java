
public class MyApplication {

	public static void main(String[] args) {
		Cat cat1 = new Cat("Horatio");
		Cat cat2 = new Cat("Matilda");
		
		System.out.println(cat1.getName());
		System.out.println(cat2.getName());
		
		System.out.println(Cat.getCount());
	}

}
