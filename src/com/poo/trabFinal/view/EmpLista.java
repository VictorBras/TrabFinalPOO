package com.poo.trabFinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.controller.CandidatoController;
import com.poo.trabFinal.controller.EmpresaController;
import com.poo.trabFinal.models.Candidato;
import com.poo.trabFinal.models.Empresa;

import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EmpLista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EmpLista() {
		setVisible(true);
		setTitle("Empresas");
		setBounds(300, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		EmpresaController controller = new EmpresaController();
		Retorno<Empresa> retorno = new Retorno<Empresa>();
		
		try {
			retorno = controller.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int north = 26;
		int south = -2;
		
		for(Empresa emp:retorno.dataList)
		{
			textField = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField, north, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, contentPane);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setText(emp.getNome());
			
			JLabel lblNewLabel = new JLabel("Nome");
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, textField);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, south, SpringLayout.NORTH, textField);
			contentPane.add(lblNewLabel);
			south = south +2;
			
			
			north = north + 40;
		}
	}
}
