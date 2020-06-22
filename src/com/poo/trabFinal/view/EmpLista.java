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
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JLabel lblNewLabel_4 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 111, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);
		
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
		int north_2 =0;
		
		if(retorno.dataList == null)
		{
			lblNewLabel_4.setText("Não há nenhuma empresa cadastrada");
		}
		else
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
			
			JLabel lblEndereo = new JLabel("Endere\u00E7o");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblEndereo, north_2, SpringLayout.NORTH, lblNewLabel_4);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblEndereo, 20, SpringLayout.WEST, lblNewLabel_4);
			contentPane.add(lblEndereo);
			
			textField_2 = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, textField);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 20, SpringLayout.WEST, lblNewLabel_4);
			textField_2.setText((String) null);
			textField_2.setColumns(10);
			contentPane.add(textField_2);
			textField_2.setText(emp.getEndereco());
			
			textField_3 = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 15, SpringLayout.EAST, textField_2);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_3, 0, SpringLayout.SOUTH, textField);
			textField_3.setText((String) null);
			textField_3.setColumns(10);
			contentPane.add(textField_3);
			textField_3.setText(emp.getEmail());
			
			JLabel lblNewLabel_1_1 = new JLabel("Email");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, north_2, SpringLayout.NORTH, lblNewLabel_4);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, textField_3);
			contentPane.add(lblNewLabel_1_1);
			south = south +2;
			north_2 = north_2 +40;
			
			
			north = north + 40;
		}
	}
}
