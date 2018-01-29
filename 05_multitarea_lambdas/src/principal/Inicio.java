package principal;

import tareas.Ascendente;
import tareas.Descendente;

public class Inicio {

	public static void main(String[] args) {
		//iniciar tareas en ejecución concurrente
		Runnable t1=()->{
			for(int i = 1; i<100;i++) {
				System.out.println("Ascendente: "+ i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable t2=()->{
			for(int i = 100; i>0;i--) {
				System.out.println("Descendente: " + i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread h1=new Thread(t1);
		Thread h2=new Thread(t2);
		h1.start();
		h2.start();
		for(int i=1;i<100;i++) {
			System.out.println("Codigo del thread main...");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
}
