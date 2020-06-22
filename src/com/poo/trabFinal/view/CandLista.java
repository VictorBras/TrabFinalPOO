package com.poo.trabFinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.controller.CandidatoController;
import com.poo.trabFinal.models.Candidato;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CandLista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CandLista() {
		setVisible(true);
		setTitle("Candidatos");
		setBounds(300, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		CandidatoController controller = new CandidatoController();
		Retorno<Candidato> retorno = new Retorno<Candidato>();
		
		try {
			retorno = controller.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int north = 26;
		int south = -2;
		
		for(Candidato cand:retorno.dataList)
		{
			textField = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField, north, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, contentPane);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setText(cand.getNome());
			
			JLabel lblNewLabel = new JLabel("Nome");
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, textField);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, south, SpringLayout.NORTH, textField);
			contentPane.add(lblNewLabel);
			south = south +2;
			
			textField_1 = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 44, SpringLayout.EAST, textField);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_1, south, SpringLayout.SOUTH, textField);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(Integer.toString(cand.getIdade()));
			
			JLabel lblNewLabel_1 = new JLabel("Idade");
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 125, SpringLayout.EAST, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, south, SpringLayout.SOUTH, lblNewLabel);
			contentPane.add(lblNewLabel_1);
			
			north = north + 40;
		}
	}
}
