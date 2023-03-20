package service;

import datastr.MyHeap;

public class MainService {

	public static void main(String[] args) {
		try
		{
		MyHeap intHeap = new MyHeap<>();
		intHeap.add(3); //P: 3
		intHeap.add(7); //P: 7, L: 3
		intHeap.add(10);//P: 10, L:3, R:7
		intHeap.add(11);//P: 11, L: 10, R: 7, P:10, L:3
		System.out.println("\n----------------------------------------");
		intHeap.print();
		System.out.println("\n----------------------------------------");
		intHeap.printByPrefix();
		
		System.out.println("\n----------------------------------------");
		System.out.println(intHeap.remove());//11
		System.out.println("\n----------------------------------------");
		intHeap.printByPrefix();//P: 10
		}
		catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
