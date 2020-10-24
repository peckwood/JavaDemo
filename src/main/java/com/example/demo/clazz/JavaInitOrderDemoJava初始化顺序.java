package com.example.demo.clazz;

//java 初始化顺序:
/*
	static field
	static block
	main
	while(a constructor is called){
		instantiate instance variable
		instance block
		constructor
	}
*/
public class JavaInitOrderDemoJava初始化顺序{
    static String b;//order 1
    String a;//order 4

    static{//order 2
        System.out.println("static block (runs only once per class)");
    }

    {//order 5
        System.out.println("instance block (runs");
    }

    //order 6
    public JavaInitOrderDemoJava初始化顺序(){//order 6
        System.out.println("constructor");
    }

    public static void main(String[] args){//order 3
        System.out.println("main");

        JavaInitOrderDemoJava初始化顺序 demo1 = new JavaInitOrderDemoJava初始化顺序();
        //JavaInitOrderDemo demo2 = new JavaInitOrderDemo();
    }
}
