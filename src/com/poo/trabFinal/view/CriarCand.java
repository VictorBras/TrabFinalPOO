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
import com.poo.trabFinal.controller.CandidatoController;
import com.poo.trabFinal.models.Candidato;
import com.poo.trabFinal.view.Dados;
import java.awt.SystemColor;

public class CriarCand extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CriarCand() {
		setTitle("Registar");
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField_1);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 122, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Registrar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 169, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -38, SpringLayout.SOUTH, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CandidatoController controller = new CandidatoController();
				Candidato candidato = new Candidato();
				Retorno retorno = new Retorno();
				
				String idade_txt = textField.getText();
				int idade = Integer.parseInt(idade_txt);
				
				String id_txt = textField_1.getText();
				int id = Integer.parseInt(id_txt);
				
				candidato.setId(id);
				candidato.setIdade(idade);
				candidato.setNome(textField_2.getText());
				candidato.setEmail(textField_3.getText());
				
				try {
					retorno = controller.insert(candidato);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lblNewLabel_3.setText(retorno.mensagem);
			}
		});
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 122, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel_1);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Idade");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, -6, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, 0, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				Login login = new Login();
			}
		});
		btnNewButton_1.setBackground(SystemColor.controlShadow);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Email");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField_1);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
	}
}
