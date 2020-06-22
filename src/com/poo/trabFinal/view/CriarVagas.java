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
import com.poo.trabFinal.controller.VagaController;
import com.poo.trabFinal.models.Candidato;
import com.poo.trabFinal.models.Empresa;
import com.poo.trabFinal.models.Vaga;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class CriarVagas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CriarVagas(Empresa emp) {
		setVisible(true);
		setTitle("Criar");
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
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 23, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 122, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -23, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 34, SpringLayout.SOUTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -15, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -107, SpringLayout.SOUTH, contentPane);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Criar Vaga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VagaController controller = new VagaController();
				Vaga vaga = new Vaga();
				Retorno retorno = new Retorno();
				
				vaga.setCargo(textField.getText());
				vaga.setDescricao(textArea.getText());
				vaga.setIdEmpresa(emp.getId());
				
				try {
					retorno = controller.insert(vaga);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lblNewLabel_2.setText(retorno.mensagem);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 166, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -57, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNewButton);
		
	}
}
