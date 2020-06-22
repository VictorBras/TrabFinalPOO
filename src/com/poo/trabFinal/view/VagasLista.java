package com.poo.trabFinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.controller.EmpresaController;
import com.poo.trabFinal.controller.VagaController;
import com.poo.trabFinal.models.Empresa;
import com.poo.trabFinal.models.Vaga;
import com.poo.trabFinal.view.SuasVagasEmp;

public class VagasLista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public VagasLista() {
		setTitle("Vagas");
		setVisible(true);
		setBounds(300, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		VagaController controller = new VagaController();
		Retorno<Vaga> retorno = new Retorno<Vaga>();
		
		try {
			retorno = controller.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int north = 6;
		for(Vaga vaga:retorno.dataList)
		{
			JLabel lblNewLabel = new JLabel("Cargo");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField, north, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setText(vaga.getCargo());
			
			JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel);
			contentPane.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, textField_1);
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, textField);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 19, SpringLayout.EAST, textField);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(vaga.getDescricao());
			
			JLabel lblNewLabel_2 = new JLabel("");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, textField_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 191, SpringLayout.WEST, contentPane);
			contentPane.add(lblNewLabel_2);
			
			north = north + 20;
			JButton btnNewButton = new JButton("Candidatar-se");
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, north, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 270, SpringLayout.WEST, contentPane);
			contentPane.add(btnNewButton);
			
			north = north + 20;
		}
		
	}
}
