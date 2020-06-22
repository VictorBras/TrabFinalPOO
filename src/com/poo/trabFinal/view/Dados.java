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

public class Dados extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Dados(Candidato cand) {
		setTitle("Dados");
		setVisible(true);
		setBounds(300, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(cand.getNome());
		
		JLabel lblNewLabel_2 = new JLabel("Idade");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField_1);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(Integer.toString(cand.getIdade()));
		
		JLabel lblNewLabel_3 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 122, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -23, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CandidatoController controller = new CandidatoController();
				Candidato candidato = new Candidato();
				Retorno retorno = new Retorno();
				
				String idade_txt = textField_2.getText();
				int idade = Integer.parseInt(idade_txt);
				
				candidato.setId(cand.getId());
				candidato.setIdade(idade);
				candidato.setNome(textField_1.getText());
				candidato.setEmail(textField.getText());
				
				try {
					retorno = controller.update(cand.getId(), candidato);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lblNewLabel_3.setText(retorno.mensagem);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 166, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -57, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Email");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(cand.getEmail());
		
	}
}
