package principal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tareas.TareaSumador;

public class Inicio {

	public static void main(String[] args) {
		//creación ExecutorService
		ExecutorService srv= Executors.newFixedThreadPool(3);
		//creamos el objeto Callable
		Callable<Long> cb = new TareaSumador(50);
		//ponemos en ejecución la tarea
		//Recogemos el resultado en un objeto Future 
		Future<Long> ft = srv.submit(cb);
		while (!ft.isDone()) {
			System.out.println("Esperando resultado");
		}
		try {
			System.out.println("Resultado final:"+ft.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Libera el ExecutorService vaciando el pool.
		//No se puede hacer con un try con recursos ya que no es el método close
		//try con recursos 
		srv.shutdown();
	}

}
