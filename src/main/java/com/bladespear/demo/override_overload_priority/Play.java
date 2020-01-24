package com.bladespear.demo.override_overload_priority;

public class Play {
	public static void main(String[] args){
		A a1 = new A();  
        A a2 = new B();  
        B b = new B();  
        C c = new C();   
        D d = new D();   
        System.out.println(a1.show(b));  //AA
        System.out.println(a1.show(c));  //AA
        System.out.println(a1.show(d));  //AD
        System.out.println();

        System.out.println(a2.show(b));  //BB wrong BA, B's method show(B) doesn't override A
        System.out.println(a2.show(c));  //BA
        System.out.println(a2.show(d));  //AD
        System.out.println();

        System.out.println(b.show(b));  //BB
        System.out.println(b.show(c));  //BB
        System.out.println(b.show(d));  //BB wrong, overload > orverride AD
	}
	
	
	
	
}
