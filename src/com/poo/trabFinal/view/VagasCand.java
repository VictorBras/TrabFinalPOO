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
import com.poo.trabFinal.controller.CandidatoVagaController;
import com.poo.trabFinal.controller.VagaController;
import com.poo.trabFinal.models.Candidato;
import com.poo.trabFinal.models.CandidatoVaga;
import com.poo.trabFinal.models.Vaga;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VagasCand extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VagasCand(Candidato cand) {
		setTitle("Vagas");
		setVisible(true);
		setBounds(300, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 111, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		CandidatoVagaController controller = new CandidatoVagaController();
		Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
		
		try {
			retorno = controller.getAll(cand.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int north = 10;
		if(retorno.dataList == null)
		{
			lblNewLabel_2.setText("Não há nenhuma vaga candidatada");
		}
		else
		for(CandidatoVaga candVaga:retorno.dataList)
		{
			VagaController controller2 = new VagaController();
			Retorno<Vaga> retorno2 = new Retorno<Vaga>();
			Vaga vaga = new Vaga();
			
			try {
				retorno2 = controller2.find(candVaga.getIdVaga());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			vaga = (Vaga)retorno2.data;
			
			JLabel lblNewLabel = new JLabel("Cargo");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, north, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, contentPane);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setText(vaga.getCargo());
			
			JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel);
			contentPane.add(lblNewLabel_1);

			JButton btnNewButton = new JButton("Cancelar Candidatura");
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, -1, SpringLayout.NORTH, textField);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
									
					try {
						retorno = controller.delete(candVaga.getId());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(retorno.success == true)
					{
						setVisible(false);
						VagasCand vagas = new VagasCand(cand);
					}
				}
			});
			contentPane.add(btnNewButton);
			
			textField_1 = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, textField_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 22, SpringLayout.EAST, textField_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, textField);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, textField);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(vaga.getDescricao());
			
			north = north +50;
			
		}
		
	}
}
