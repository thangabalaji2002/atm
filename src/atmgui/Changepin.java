package atmgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Changepin {

	JFrame changepin;
	private JTextField newpintb;
	private JTextField cpintb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Changepin window = new Changepin();
					window.changepin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Changepin() {
		initialize();
	}
	int acc_numb=0;
	public Changepin(int a) {
		initialize();
		acc_numb=a;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		changepin = new JFrame();
		changepin.setBounds(100, 100, 797, 441);
		changepin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changepin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 789, 404);
		changepin.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 789, 78);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("CHINNASALEM BANK");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(290, 0, 228, 37);
		panel_1.add(lblNewLabel);
		
		JLabel lblAtmManagementSystem = new JLabel("ATM MANAGEMENT SYSTEM");
		lblAtmManagementSystem.setForeground(new Color(240, 248, 255));
		lblAtmManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAtmManagementSystem.setBounds(261, 41, 355, 26);
		panel_1.add(lblAtmManagementSystem);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("X");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmsignup b =new atmsignup();
				b.atmsignup.setVisible(true);
				changepin.dispose();
				
			}
		});
		lblNewLabel_1_1_1_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(765, 0, 24, 50);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(0, 394, 789, 10);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("CHANGE YOUR PIN");
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 18));
		lblNewLabel_1.setBounds(308, 89, 198, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NEW PIN");
		lblNewLabel_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(131, 173, 190, 35);
		panel.add(lblNewLabel_1_1);
		
		newpintb = new JTextField();
		newpintb.setColumns(10);
		newpintb.setBounds(350, 182, 190, 20);
		panel.add(newpintb);
		
		JButton btnChangePin = new JButton("CHANGE PIN");
		btnChangePin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(newpintb.getText().equals(cpintb.getText())) {
				Connection con1 =null;
				PreparedStatement pst1 =null;
				ResultSet rs =null;
				Statement st= null;
				String query="update atmtbl set pin =? where accnum=?";
				
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
					PreparedStatement pst11=con1.prepareStatement(query);
					pst11.setInt(1,Integer.valueOf(cpintb.getText()));
					pst11.setInt(2,acc_numb);
					int b=pst11.executeUpdate();
					if (b==1) {
						JOptionPane.showMessageDialog(null, "pin changed");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
			else if(newpintb.getText().isEmpty()||cpintb.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "data missing");
			}
			else {
				JOptionPane.showMessageDialog(null, "data invalid");
			}
			}
		});
		btnChangePin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChangePin.setBounds(308, 281, 147, 35);
		panel.add(btnChangePin);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("BACK");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain a =new atmmain();
				a.atmmain.setVisible(true);
				changepin.dispose();
			}
		});
		lblNewLabel_1_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(336, 327, 70, 35);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CONFIRM PIN");
		lblNewLabel_1_1_2.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(131, 224, 155, 35);
		panel.add(lblNewLabel_1_1_2);
		
		cpintb = new JTextField();
		cpintb.setColumns(10);
		cpintb.setBounds(350, 233, 190, 20);
		panel.add(cpintb);
	}

}
