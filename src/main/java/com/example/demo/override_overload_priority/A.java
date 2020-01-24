package com.example.demo.override_overload_priority;

class A {
	public String show(D obj){  
                return ("A and D");  
         }

	public String show(A obj){  return ("A and A"); }
}