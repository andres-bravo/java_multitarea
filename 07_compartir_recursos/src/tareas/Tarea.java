package tareas;

import beans.Contador;

public class Tarea implements Runnable {
	
	private Contador contador;
	public Tarea(Contador c) {
		contador=c;
	}

	@Override
	public void run() {
		synchronized(contador) {
			int n=contador.getValor();
			n++;
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contador.setValor(n);
		
		}

	}

}
