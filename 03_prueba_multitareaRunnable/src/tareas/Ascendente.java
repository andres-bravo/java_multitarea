package tareas;

public class Ascendente implements Runnable {
	//sobrescribimos m�todo run
	@Override
	public void run() {
		for(int i = 1; i<100;i++) {
			System.out.println("Ascendente: "+ i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
