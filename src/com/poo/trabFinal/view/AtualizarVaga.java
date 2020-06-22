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
import com.poo.trabFinal.controller.VagaController;
import com.poo.trabFinal.models.Empresa;
import com.poo.trabFinal.models.Vaga;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;

public class AtualizarVaga extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AtualizarVaga(Vaga vaga,Empresa emp) {
		setVisible(true);
		setTitle("Atualizar Vaga");
		setBounds(300, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Cargo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(vaga.getCargo());
		
		JLabel lblNewLabel_1 = new JLabel("Descricao");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 22, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, 61, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, 291, SpringLayout.EAST, textField);
		contentPane.add(textArea);
		textArea.setText(vaga.getDescricao());
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 118, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Atualizar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 17, SpringLayout.SOUTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 20, SpringLayout.SOUTH, btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VagaController controller = new VagaController();
				Retorno retorno = new Retorno();
				
				vaga.setCargo(textField.getText());
				vaga.setDescricao(textArea.getText());
				
				try {
					retorno = controller.update(vaga.getId(), vaga);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lblNewLabel_2.setText(retorno.mensagem);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 158, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, -4, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, textArea);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				SuasVagasEmp vagas = new SuasVagasEmp(emp);
			}
		});
		btnNewButton_1.setBackground(SystemColor.controlShadow);
		contentPane.add(btnNewButton_1);
		
	}
}
