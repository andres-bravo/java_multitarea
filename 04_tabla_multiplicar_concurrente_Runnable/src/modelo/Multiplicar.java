package modelo;

public class Multiplicar implements Runnable {
	private int numero;
	public Multiplicar(int numero) {
		this.numero=numero;
	}
	@Override
	public void run() {
		for(int i = 1; i<10;i++) {
			System.out.println(this.numero + "x" + i + " = " + (this.numero*i));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
	
}
