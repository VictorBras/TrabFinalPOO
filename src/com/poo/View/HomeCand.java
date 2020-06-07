package com.poo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class HomeCand extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeCand frame = new HomeCand();
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
	public HomeCand() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Gabriel Nunes");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 12, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 12, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Todas as Vagas");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dados");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -18, SpringLayout.NORTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -337, SpringLayout.EAST, contentPane);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Vagas Candidatadas");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 2, SpringLayout.EAST, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 60, SpringLayout.SOUTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 38, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_3);
	}
}
