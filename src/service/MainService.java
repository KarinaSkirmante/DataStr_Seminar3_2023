package service;

import javax.sound.midi.Patch;

import datastr.MyHeap;
import model.Patient;

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
		
		
		System.out.println("\n-----------------------------------");
		MyHeap<Patient> hospital = new MyHeap<>();
		hospital.add(new Patient("Janis", "Berzins", 1));
		hospital.add(new Patient("Līga", "Berzina", 6));
		hospital.add(new Patient("Baiba", "Berzina", 3));
		hospital.add(new Patient("Dace", "Berzina", 10));
		
		System.out.println(hospital.remove());//Dace
		System.out.println(hospital.remove());//Līga
		System.out.println(hospital.remove());//Baiba
		System.out.println(hospital.remove());//Janis
		
		
		
		
		
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
