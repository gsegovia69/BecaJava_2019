package useless_junk;

public class ElementComparator {

	public static void main(String... args) {
		System.out.println("5 == 5 " + (5 == 5));
		System.out.println("new Integer(5) == new Integer(5) " + (new Integer(5) == new Integer(5)));
		System.out.println("Integer.valueOf(5) == Integer.valueOf(5) " + (Integer.valueOf(5) == Integer.valueOf(5)));
		System.out.println();
		System.out.println("\"pepe\" == \"pepe\" " + ("pepe" == "pepe"));
		System.out.println("new String(\"pepe\") == new String(\"pepe\") " + (new String("pepe") == new String("pepe")));
		System.out.println("new String(\"pepe\").equals(new String(\"pepe\")) " + (new String("pepe").equals(new String("pepe"))));
		
		System.out.println();
		System.out.println("new MyObjectWithIdNotEquals(1) == new MyObjectWithIdNotEquals(1) " + (new MyObjectWithIdNotEquals(1) == new MyObjectWithIdNotEquals(1)));
		System.out.println("new MyObjectWithIdEquals(1) == new MyObjectWithIdEquals(1) " + (new MyObjectWithIdEquals(1) == new MyObjectWithIdEquals(1)));
		System.out.println("new MyObjectWithIdNotEquals(1).equals(new MyObjectWithIdNotEquals(1)) " + (new MyObjectWithIdNotEquals(1).equals(new MyObjectWithIdNotEquals(1))));
		System.out.println("new MyObjectWithIdEquals(1).equals(new MyObjectWithIdEquals(1)) " + (new MyObjectWithIdEquals(1).equals(new MyObjectWithIdEquals(1))));

	}
}
