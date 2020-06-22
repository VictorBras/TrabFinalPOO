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
import com.poo.trabFinal.controller.CandidatoVagaController;
import com.poo.trabFinal.controller.EmpresaController;
import com.poo.trabFinal.controller.VagaController;
import com.poo.trabFinal.models.Candidato;
import com.poo.trabFinal.models.CandidatoVaga;
import com.poo.trabFinal.models.Empresa;
import com.poo.trabFinal.models.Vaga;
import com.poo.trabFinal.view.SuasVagasEmp;

public class VagasLista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public VagasLista(Candidato cand) {
		setTitle("Vagas");
		setVisible(true);
		setBounds(300, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel_4 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 111, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);
		
		VagaController controller = new VagaController();
		Retorno<Vaga> retorno = new Retorno<Vaga>();
		
		try {
			retorno = controller.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int north = 6;
		if(retorno.dataList == null)
		{
			lblNewLabel_4.setText("Não há nenhuma vaga cadastrada");
		}
		else
		for(Vaga vaga:retorno.dataList)
		{
			
			CandidatoVagaController controller2 = new CandidatoVagaController();
			CandidatoVaga candVaga = new CandidatoVaga();
			Retorno<CandidatoVaga> retorno2 = new Retorno<CandidatoVaga>();
			
			candVaga.setIdCandidato(cand.getId());
			candVaga.setIdVaga(vaga.getId());
			
			JLabel lblNewLabel = new JLabel("Cargo");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField, north, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setText(vaga.getCargo());
			
			JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel);
			contentPane.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, textField_1);
			sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, textField);
			sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 19, SpringLayout.EAST, textField);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(vaga.getDescricao());
			
			JLabel lblNewLabel_2 = new JLabel("");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, textField_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 191, SpringLayout.WEST, contentPane);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, textField_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 183, SpringLayout.WEST, contentPane);
			contentPane.add(lblNewLabel_3);
			
			north = north + 20;
			
			try {
				retorno2 = controller2.find(candVaga.getIdCandidato(), candVaga.getIdVaga());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			candVaga = retorno2.data;
			
			if(retorno2.success == false)
			{
				JButton btnNewButton = new JButton("Candidatar-se");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
						CandidatoVaga candVaga = new CandidatoVaga();
						
						candVaga.setIdCandidato(cand.getId());
						candVaga.setIdVaga(vaga.getId());
						
						try {
							retorno = controller2.insert(candVaga);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(retorno.success == true)
						{
							setVisible(false);
							VagasLista vagas = new VagasLista(cand);
						}
						else
						{
							lblNewLabel_3.setText(retorno.mensagem);
						}
					}
				});
				sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, north, SpringLayout.NORTH, contentPane);
				sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 270, SpringLayout.WEST, contentPane);
				contentPane.add(btnNewButton);
			}
			else
			{
				JButton btnNewButton = new JButton("Cancelar Candidatura");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
						CandidatoVaga candVaga = new CandidatoVaga();
						Retorno<CandidatoVaga> retorno2 = new Retorno<CandidatoVaga>();
						
						candVaga.setIdCandidato(cand.getId());
						candVaga.setIdVaga(vaga.getId());
						
						try {
							retorno2 = controller2.find(candVaga.getIdCandidato(), candVaga.getIdVaga());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						candVaga = retorno2.data;
						
						try {
							retorno = controller2.delete(candVaga.getId());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(retorno.success == true)
						{
							setVisible(false);
							VagasLista vagas = new VagasLista(cand);
						}
						else
						{
							lblNewLabel_3.setText(retorno.mensagem);
						}
					}
				});
				sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, north, SpringLayout.NORTH, contentPane);
				sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 270, SpringLayout.WEST, contentPane);
				contentPane.add(btnNewButton);
			}
			
			
			north = north + 20;
		}
		
		
	}
}
