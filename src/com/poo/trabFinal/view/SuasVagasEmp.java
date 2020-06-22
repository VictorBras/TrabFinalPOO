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
import com.poo.trabFinal.controller.EmpresaController;
import com.poo.trabFinal.controller.VagaController;
import com.poo.trabFinal.models.Empresa;
import com.poo.trabFinal.models.Vaga;
import com.poo.trabFinal.view.SuasVagasEmp;

public class SuasVagasEmp extends JFrame {

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
	public SuasVagasEmp(Empresa emp) {
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
			retorno = controller.getAllEmp(emp.getId());
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
			
			JButton btnNewButton_1 = new JButton("Excluir");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					VagaController controller = new VagaController();
					Retorno retorno = new Retorno();
					
					try {
						retorno = controller.delete(vaga.getId());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(retorno.success = true)
					{
						setVisible(false);
						SuasVagasEmp vagas = new SuasVagasEmp(emp);
					}
					else
					{
						lblNewLabel_2.setText(retorno.mensagem);
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, -1, SpringLayout.NORTH, textField);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_1_1 = new JButton("Atualizar");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					setVisible(false);
					AtualizarVaga atualizar = new AtualizarVaga(vaga,emp);
				}
			});
			sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 18, SpringLayout.EAST, btnNewButton_1_1);
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, -1, SpringLayout.NORTH, textField);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 18, SpringLayout.EAST, textField_1);
			contentPane.add(btnNewButton_1_1);
			
			north = north + 40;
		}
		
	}
}
