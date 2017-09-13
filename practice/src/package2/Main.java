package package2;

import package1.Class1;
import package1.ClassImpl;
import package1.ClassInterface;

public class Main {

	public static void main(String[] args) {
		Class1 c = new Class1();
		Class1 c2 = new Subclass1();
		Subclass1 c3 = new Subclass1();
		
		(c3).printPrint();
		((Subclass1)c2).printPrint();
		c.printAnything();
		c2.printAnything();
		((Subclass1)c2).printAnything();
		c3.printAnything();
		((Class1)c3).printAnything();
		
		c3.printSomething();
		
		ClassInterface ci = new ClassImpl();
		ClassInterface.doPrint();

	}

}
