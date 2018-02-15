package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import beans.Contador;
import tareas.Tarea;

public class Inicio {

	public static void main(String[] args) {
		Contador conta=new Contador(0);
		Lock lc= new ReentrantLock();
		Tarea t1=new Tarea(conta,lc);
		Tarea t2=new Tarea(conta,lc);
		Tarea t3=new Tarea(conta,lc);
		//El ExecutorService gestiona el pool de Threads.
		ExecutorService ex= Executors.newFixedThreadPool(3);
		Future ft1 = ex.submit(t1);
		Future ft2 = ex.submit(t2);
		Future ft3 = ex.submit(t3);
		/*ex.submit(t1);
		ex.submit(t2);
		ex.submit(t3);		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		while (!ft1.isDone() || !ft2.isDone() || !ft3.isDone()) {//No hago nada sólo espero
		}
		System.out.println(conta.getValor());
		ex.shutdown();
	}
}
