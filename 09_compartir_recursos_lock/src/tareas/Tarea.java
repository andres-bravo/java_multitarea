package tareas;

import java.util.concurrent.locks.Lock;

import beans.Contador;

public class Tarea implements Runnable {
	
	private Contador contador;
	Lock lc;
		
	public Tarea(Contador c, Lock lc) {
		//Se lo paso al constructor para que todas las tareas lo compartan igual
		//que el recurso.
		contador=c;
		this.lc=lc;
	}

	@Override
	public void run() {
		try {
			lc.lock();
			int n=contador.getValor();
			n++;
			Thread.sleep(30);
			contador.setValor(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {	
			lc.unlock();
		}
	}

}
