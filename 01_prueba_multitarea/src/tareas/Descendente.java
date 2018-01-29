package tareas;

public class Descendente extends Thread {
	//sobrescribimos método run
	@Override
	public void run() {
		for(int i = 100; i>0;i--) {
			System.out.println("Descendente: " + i);
			try {
				this.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
