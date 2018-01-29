package presentacion.graficos;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JVentana extends JFrame {
	public JVentana() {
		//definición de título para la ventana heredado de
		//constructor de JFrame
		super("Primera Ventana");
		//Especificamos que se cierre realmente si se cierra la ventana
		//para que finalize el programa.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//posicionamiento desde posicion 100,100 Ancho y Alto 800,400
		this.setBounds(100, 100, 800, 400);
		//realizamos creación y colocacion de 
		//componentes gráficos
		iniciarComponentes();
		this.setVisible(true);
	}
	private void iniciarComponentes() {
		//Por defecto los componentes son mostrados ocupando todo el frame y unos encima de otros
		//Anulo este comportamiento, podría definir distintos comportamientos, en este caso lo anulo.
		getContentPane().setLayout(null);
		//Se saca a un metodo ya que tiene muchas instrucciones para mostrar todos los controles
		//Se le llama en el constructor antes de visualizar la ventana setVisible(true).
		JButton bt = new JButton("Pulsar");
		JButton bt2 = new JButton("Pulsar");
		JLabel lb = new JLabel("Mensaje");
		JTextField tx1 = new JTextField();
		JTextField tx2 = new JTextField();
	
		//Posicionamiento del ojeto
		tx1.setBounds(100, 50, 500, 50);
		tx2.setBounds(100, 150, 500, 50);
		bt.setBounds(150, 200, 120, 50);
		bt2.setBounds(500, 200, 120,50);
		lb.setBounds(300, 300, 120,50);
		//añadir control a la ventana
		getContentPane().add(bt);
		getContentPane().add(bt2);
		getContentPane().add(lb);
		getContentPane().add(tx1);
		getContentPane().add(tx2);
		
		JLabel lblTime = new JLabel("New label");
		lblTime.setBounds(66, 11, 99, 14);
		getContentPane().add(lblTime);
			
		//listeners
		//Implemento el interfaz ActionListener método actionPerformed con expresión lambda.
		ActionListener lst=e->lb.setText(String.valueOf(((Double.parseDouble(tx1.getText()))+Double.parseDouble(tx2.getText()))));
		ActionListener lst2=e->lb.setText(String.valueOf(((Double.parseDouble(tx1.getText()))*Double.parseDouble(tx2.getText()))));
		/*Implementación con clase anonima.
		ActionListener lst=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lb.setText("Bienvenido a swing");
				
			}
		};*/
		//LocalTime lt = LocalTime.now();
		/*
		Runnable r1=()->{
			while (true) {				
				LocalTime lt=LocalTime.now();
				lblTime.setText(lt.toString());
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		Thread th1=new Thread(r1);
		th1.start();*/
		Timer temp=new Timer();
		temp.schedule(new TimerTask() {
			@Override
			public void run() {
				LocalTime lt=LocalTime.now();
				lblTime.setText(lt.toString());
			}
		},0,300);		
		bt.addActionListener(lst);
		bt2.addActionListener(lst2);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				temp.cancel();
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
