package com.poo.trabFinal.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.controller.CandidatoController;
import com.poo.trabFinal.controller.EmpresaController;
import com.poo.trabFinal.models.Candidato;
import com.poo.trabFinal.models.Empresa;
import com.poo.trabFinal.view.HomeCand;
import com.poo.trabFinal.view.Login;
import com.poo.trabFinal.classes.Retorno;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -210, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String senha = passwordField.getText();
				String id_txt = textField.getText();
				int id = Integer.parseInt(id_txt);
				CandidatoController controller = new CandidatoController();
				EmpresaController controller2 = new EmpresaController();
				Retorno retorno = new Retorno();
				Candidato cand = new Candidato();
				Empresa emp = new Empresa();

				try {
					retorno = controller.find(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(retorno.mensagem.equals("Dados retornados com sucesso"))
				{
					if(senha.equals("1234567"))
					{
						cand = (Candidato)retorno.data;
						HomeCand homeCand = new HomeCand(cand);
						setVisible(false);
					}
					else
					{
						lblNewLabel_2.setText("Senha incorreta!!");
					}
				}
				else
				{
					try {
						retorno = controller2.find(id);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(retorno.mensagem.equals("Dados retornados com sucesso"))
					{
						if(senha.equals("1234567"))
						{
							emp = (Empresa)retorno.data;
							HomeEmp homeEmp = new HomeEmp(emp);
							setVisible(false);
						}
						else
						{
							lblNewLabel_2.setText("Senha incorreta!!");
						}
					}
					else
					{
						lblNewLabel_2.setText("ID inválido!!");
					}
				}
				
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 164, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -68, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -155, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, passwordField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 99, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -289, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, passwordField);
		contentPane.add(passwordField);
		
		lblNewLabel_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 160, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -25, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Novo Candidato");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -128, SpringLayout.EAST, contentPane);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				CriarCand criar = new CriarCand();
			}
		});
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Nova Empresa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				CriarEmp criar = new CriarEmp();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 6, SpringLayout.EAST, btnNewButton_1);
		contentPane.add(btnNewButton_2);
		
	}
}
