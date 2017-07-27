package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

import logica.ColeccionNiños;
import logica.Consulta;
import logica.Vacuna;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class IngresoVacuna extends JFrame {
	private ColeccionNiños niños;

	private JPanel contentPane;
	private JTextField textNombreVac;
	private JTextField textDosis;
	private JTextField textComentario;
	private JRadioButton rdbtnObliSi;
	private JRadioButton rdbtnObliNo;
	private JCalendar  fechaVac;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public IngresoVacuna(ColeccionNiños n) {
		this.niños = n;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresoVacuna = new JLabel("INGRESO VACUNA");
		lblIngresoVacuna.setBounds(146, 11, 102, 14);
		contentPane.add(lblIngresoVacuna);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 52, 46, 14);
		contentPane.add(lblNombre);
		
		textNombreVac = new JTextField();
		textNombreVac.setBounds(112, 49, 86, 20);
		contentPane.add(textNombreVac);
		textNombreVac.setColumns(10);
		
		JLabel lblDsis = new JLabel("Dosis:");
		lblDsis.setBounds(10, 95, 46, 14);
		contentPane.add(lblDsis);
		
		textDosis = new JTextField();
		textDosis.setBounds(112, 92, 86, 20);
		contentPane.add(textDosis);
		textDosis.setColumns(10);
		
		JLabel lblObligatoria = new JLabel("Obligatoria:");
		lblObligatoria.setBounds(10, 138, 78, 14);
		contentPane.add(lblObligatoria);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 178, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblNewLabel = new JLabel("Comentario:");
		lblNewLabel.setBounds(10, 359, 78, 14);
		contentPane.add(lblNewLabel);
		
		textComentario = new JTextField();
		textComentario.setBounds(112, 359, 218, 44);
		contentPane.add(textComentario);
		textComentario.setColumns(10);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Tomar datos ingresados por el usuario
				String nomVac = textNombreVac.getText();
				 int dosis = Integer.parseInt(textDosis.getText()); 
				 char obligatoria;
					if(rdbtnObliSi.isSelected())
						obligatoria = 'S';
					else
						obligatoria = 'N';
				Calendar fechaVac = Calendar.getInstance();
				String comentarioVac = textComentario.getText();
				Vacuna v = new Vacuna(fechaVac,comentarioVac,nomVac,dosis,obligatoria); 
			}
		});
		btnIngresar.setBounds(241, 414, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(335, 414, 89, 23);
		contentPane.add(btnVolver);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(112, 178, 184, 153);
		contentPane.add(calendar);
		
		JRadioButton rdbtnObliSi = new JRadioButton("Si");
		buttonGroup.add(rdbtnObliSi);
		rdbtnObliSi.setBounds(112, 134, 38, 23);
		contentPane.add(rdbtnObliSi);
		
		JRadioButton rdbtnObliNo = new JRadioButton("No");
		buttonGroup.add(rdbtnObliNo);
		rdbtnObliNo.setBounds(152, 134, 46, 23);
		contentPane.add(rdbtnObliNo);
	}
}
