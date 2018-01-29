package tareas;

public class Descendente implements Runnable {
	//sobrescribimos método run
	@Override
	public void run() {
		for(int i = 100; i>0;i--) {
			System.out.println("Descendente: " + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
