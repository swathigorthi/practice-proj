package package2;

import package1.Class1;

public class Subclass1 extends Class1 {
    void printSomething(){
    	System.out.println("From Subclass1");
    }
    public static void printAnything(){
  	  System.out.println("From  Subclass1");
    }
//    public final  void printAgain(){
//  	  System.out.println("From SubClass1");
//    }
    @Override
    protected void printPrint(){
//    	super.printPrint(); this works
    	System.out.println("From  Subclass1");
    }
}
