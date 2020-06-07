package com.poo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class HomeEmp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeEmp frame = new HomeEmp();
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
	public HomeEmp() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Empresa Teste");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Suas Vagas");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 35, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -256, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Criar Vagas");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 27, SpringLayout.EAST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 180, SpringLayout.EAST, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Atualizar Vagas");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 30, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 5, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, btnNewButton);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dados");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 25, SpringLayout.SOUTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, btnNewButton);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(SystemColor.activeCaption);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_4, -4, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_4, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Excluir Vagas");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_5, 0, SpringLayout.NORTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_5, 0, SpringLayout.WEST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_5, -76, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_5);
	}

}
