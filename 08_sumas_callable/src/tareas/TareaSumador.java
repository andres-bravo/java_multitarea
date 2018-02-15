package tareas;

import java.util.concurrent.Callable;

public class TareaSumador implements Callable<Long> {
	private int n;
	public TareaSumador(int n) {
		this.n=n;
	}
	
	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		long suma=0;
		for(int i=1;i<=n;i++) {
			suma=suma+i;
			//No tengo que poner el try catch porque lanza Exception el propio metodo.
			Thread.sleep(50);
		}
		return suma;
	}

}
