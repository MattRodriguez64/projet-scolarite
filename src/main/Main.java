package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String filepath = "D:\\Java-EclipseIDE\\eclipse-workspace\\java-scolarite\\src\\main\\test.csv";
		
		
		@SuppressWarnings("resource")
		Scanner lire = new Scanner(System.in);
		String saisie = lire.nextLine();
		System.out.println("Text saisi : " + saisie);
		try {
			BufferedWriter buff = new BufferedWriter(new FileWriter(filepath));
			buff.write(saisie);
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BufferedReader buff = new BufferedReader(new FileReader(filepath));
			String ligne;
			
			try {
				while((ligne = buff.readLine()) != null)
					System.out.println("Ligne dans fichier : " + ligne);
				buff.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
