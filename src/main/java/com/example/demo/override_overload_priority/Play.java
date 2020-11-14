package com.example.demo.override_overload_priority;
//source: https://blog.csdn.net/jason_cuijiahui/article/details/78136373
/*
    Overload is not involved in fact
    Example: a2.show(b)
    Rule(Chinese from source):
    1. 因为引用变量test是类型A，找A中的方法看有没有匹配void show(B)的，没有则下一步
    2. A向上找父类中看有没有方法void show(B)（直至到达尽头），没有则下一步
    3. 找A中的方法有没有匹配void show(super(B))(直到尽头)，没有则出错；这时找到A中有方法void show(A)，对该方法进行调用，又因为A引用的是B类型，由于动态多态（要函数名+参数列表都要对上），可以知道实际上调用的是B类型中的void show(A)函数，结果为“B and A”

    Translated:
    1. since a2 is of type A, look for methods that match show(B) in class A, if not, then
    2. Look for show(B) methods in A's superclasses until the end, if not, then
    3. Look for methods that accept b's super types, until the end, if not found, report an error, found show(A) in class A
    4. Since a2 is a B object and it also has show(A) method, it overrides A's show(A) method, it is called and result is "B and A"

    Summary:
    exact method matches (show(B) method )
        current class matches >(overrides) parent class matches
    method that accept parameter type's super types (show(A))
        closer > further (for example, for show(C), show(B) is closer than show(A))
    if a method is found show(A) is found in class A
        run-time type or actual type's method overrides compile-time type or declared type
            for example, since a2's actual type is B, B's show(A) overrides A's show(A)
 */
public class Play{
    public static void main(String[] args){
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        //==================================

        //questions:
        //add answers after "//"
        System.out.println(a1.show(b));//
        System.out.println(a1.show(c));//
        System.out.println(a1.show(d));//
        System.out.println();

        System.out.println(a2.show(b));//
        System.out.println(a2.show(c));//
        System.out.println(a2.show(d));//
        System.out.println();

        System.out.println(b.show(b));//
        System.out.println(b.show(c));//
        System.out.println(b.show(d));//

        System.out.println("=========================");
        //answers

        System.out.println(a1.show(b));//AA
        System.out.println(a1.show(c));//AA
        System.out.println(a1.show(d));//AD
        System.out.println();

        System.out.println(a2.show(b));//BA
        System.out.println(a2.show(c));//BA
        System.out.println(a2.show(d));//AD
        System.out.println();

        System.out.println(b.show(b));//BB
        System.out.println(b.show(c));//BB
        System.out.println(b.show(d));//AD
    }


}
