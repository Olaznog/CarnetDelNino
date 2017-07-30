package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ColeccionNiņos;
import persistencia.PersistirNiņo;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {
	private ColeccionNiņos niņos;
	

	public VentanaMenu(ColeccionNiņos n) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Desea cerrar el sistema?");
				//el numero que retorna el metodo es el numero de la respuesta del usuario:
				//YES = 0
				//NO = 1
				//CANCEL = 2
				if(i == 0)
				{
					//ACA SE DEBERIA GUARDAR EN PERSISTENCIA LOS DATOS
					// Y DESPUED< SI< CERRAR LA VENTANA Y CERRAR EL SISTEMA
					PersistirNiņo.persistir(n, "C://DatosNiņo/datosNiņos.txt");
					System.exit(0);
				}
				//SI HACE FALTA IMPLEMENTAR EL COMPORTAMIENTO SI EL USUARIO SELECCIONA NO O CANECLAR, ESCRIBIR LOS ELSE
			}
		});
		niņos = n;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 525, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnIngresar = new JMenu("Ingresar");
		menuBar.add(mnIngresar);
		
		JMenuItem mnIngresarDatosNiņo = new JMenuItem("Datos del Ni\u00F1o");
		mnIngresarDatosNiņo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentNiņo();
			}
		});
		
		JMenu mnNuevoRegistro = new JMenu("Nuevo Registro");
		mnIngresar.add(mnNuevoRegistro);
		
		JMenuItem mnConsulta = new JMenuItem("Consulta");
		mnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentConsulta();
			}
		});
		mnNuevoRegistro.add(mnConsulta);
		
		JMenuItem mnControl = new JMenuItem("Control");
		mnControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentControl();
			}
		});
		mnNuevoRegistro.add(mnControl);
		
		JMenuItem mnVacuna = new JMenuItem("Vacuna");
		mnVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentVacuna();
			}
		});
		mnNuevoRegistro.add(mnVacuna);
		mnIngresar.add(mnIngresarDatosNiņo);
		
		JMenu mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listado de Ni\u00F1os");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				niņos.listarNiņos();
				mostrarVentListadoNiņos();
			}
		});
		mnConsultar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mostrar datos de un ni\u00F1o");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentDatosNiņosPorCI();
			}
			
		});
		mnConsultar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consulta M\u00E9dica por fecha");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentConsultasMedicas();
			}
		});
		mnConsultar.add(mntmNewMenuItem_2);
		
		/*JMenuItem mnListadoDeNios = new JMenu("Listado de ni\u00F1os");
		mnConsultar.add(mnListadoDeNios);
		
		JMenuItem mnNewMenu = new JMenu("Mostrar datos de un ni\u00F1o ");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentDatosNiņosPorCI();
			}
		});
		mnConsultar.add(mnNewMenu);
		
		JMenuItem mnConsultaMedicaPor = new JMenu("Consulta M\u00E9dica por Fecha");
		mnConsultaMedicaPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentConsultasMedicas();
			}
		});
		mnConsultar.add(mnConsultaMedicaPor);*/
		
		
	}
	private void mostrarVentVacuna()
	{
		IngresoVacuna Vacuna = new IngresoVacuna(niņos, this);
        Vacuna.setVisible(true);
	}
	private void mostrarVentControl()
	{
		IngresoControl Control = new IngresoControl(niņos, this);
		Control.setVisible(true);
	}
	private void mostrarVentConsulta()
	{
		IngresoConsulta Consulta = new IngresoConsulta(niņos, this);
		Consulta.setVisible(true);
	}
	private void mostrarVentNiņo()
	{
		IngresoNiņo Niņo = new IngresoNiņo(niņos, this);
		Niņo.setVisible(true);
	}
	private void mostrarVentConsultasMedicas()
	{
		ConsultaMedAntesDeFecha CuantasConsultas = new ConsultaMedAntesDeFecha(niņos, this);
		CuantasConsultas.setVisible(true);
	}
	private void mostrarVentDatosNiņosPorCI()
	{
		DatosNiņoPorCedula DatosNiņo = new DatosNiņoPorCedula(niņos, this);
		DatosNiņo.setVisible(true);
	}
	private void mostrarVentListadoNiņos()
	{
		ListadoDeNiņos ListaNiņo = new ListadoDeNiņos(niņos, this);
		ListaNiņo.setVisible(true);
	}
	
	
}
