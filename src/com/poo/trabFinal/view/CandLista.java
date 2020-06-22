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
	private JTextField textField_2;

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
		
		JLabel lblNewLabel_4 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 111, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);
		
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
		
		if(retorno.dataList == null)
		{
			lblNewLabel_4.setText("Não há nenhum candidato cadastrado");
		}
		else
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
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, textField);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 20, SpringLayout.WEST, lblNewLabel_4);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(Integer.toString(cand.getIdade()));
			
			JLabel lblNewLabel_1 = new JLabel("Idade");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 20, SpringLayout.WEST, lblNewLabel_4);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Email");
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 105, SpringLayout.EAST, lblNewLabel_1);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, lblNewLabel);
			contentPane.add(lblNewLabel_2);
			
			textField_2 = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, textField);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 21, SpringLayout.EAST, textField_1);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			textField_2.setText(cand.getEmail());
			
			north = north + 40;
		}
	}
}
