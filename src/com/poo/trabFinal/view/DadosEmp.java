package com.poo.trabFinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.controller.CandidatoController;
import com.poo.trabFinal.controller.EmpresaController;
import com.poo.trabFinal.models.Candidato;
import com.poo.trabFinal.models.Empresa;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DadosEmp extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public DadosEmp(Empresa emp) {
		setVisible(true);
		setTitle("Dados");
		setBounds(300, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 27, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -205, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 1, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(emp.getNome());
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -23, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 130, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Atualizar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 170, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -50, SpringLayout.SOUTH, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EmpresaController controller = new EmpresaController();
				Empresa empresa = new Empresa();
				Retorno retorno = new Retorno();
				
				
				empresa.setId(emp.getId());
				empresa.setNome(textField_1.getText());
				empresa.setEndereco(textField.getText());
				empresa.setEmail(textField_2.getText());
				
				try {
					retorno = controller.update(emp.getId(), empresa);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				lblNewLabel_2.setText(retorno.mensagem);
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Endere\u00E7o");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 6, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel_1);
		textField.setText((String) null);
		textField.setColumns(10);
		contentPane.add(textField);
		textField.setText(emp.getEndereco());
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 6, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, lblNewLabel_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField_1);
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		textField_2.setText(emp.getEmail());
		
		
		
	}
}
