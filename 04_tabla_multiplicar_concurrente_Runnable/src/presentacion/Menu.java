package presentacion;

import java.util.Scanner;

import modelo.Multiplicar;

public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero1 = 0;
		int numero2 = 0;
		int numero3 = 0;
		
		for(int i=1; i<4;i++) {
			System.out.println("Introduce un numero:");
			switch(i) {
			case 1:
				numero1=sc.nextInt();
				break;
			case 2:
				numero2=sc.nextInt();
				break;
			case 3:
				numero3=sc.nextInt();
				break;
			}
		}
		Multiplicar t1 = new Multiplicar(numero1);
		Multiplicar t2 = new Multiplicar(numero2);
		Multiplicar t3 = new Multiplicar(numero3);
		Thread h1 = new Thread(t1);
		Thread h2 = new Thread(t2);
		Thread h3 = new Thread(t3);
		h1.start();
		h2.start();
		h3.start();
	}
}
