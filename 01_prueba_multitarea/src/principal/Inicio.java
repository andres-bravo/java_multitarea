package principal;

import tareas.Ascendente;
import tareas.Descendente;

public class Inicio {

	public static void main(String[] args) {
		//iniciar tareas en ejecución concurrente
		Ascendente t1= new Ascendente();
		Descendente t2=new Descendente();
		t1.start();
		t2.start();
		for(int i=1;i<100;i++) {
			System.out.println("Codigo del thread main");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
