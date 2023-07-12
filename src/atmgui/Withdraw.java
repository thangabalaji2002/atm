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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Withdraw {

	JFrame withdraw;
	private JTextField wd;
	private JTextField amtwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
					window.withdraw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Withdraw() {
		initialize();
	}
	int show_bal=0;
	int acc_no=0;
	public Withdraw(int b,int c) {
		initialize();
		show_bal=b;
		acc_no=c;
		amtwd.setText(String.valueOf(show_bal));
	
	}
	private void withdraws() {
		Connection con1 =null;
		PreparedStatement pst1 =null;
		ResultSet rs =null;
		Statement st= null;
		String query="insert into transactiontbl values(?,?,?,?)";
		
		try {
			con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
		PreparedStatement pst11=con1.prepareStatement(query);
			pst11.setInt(1,9);
			pst11.setInt(2, acc_no);
			pst11.setString(3, "withdrawn");
			pst11.setInt(4,Integer.valueOf(wd.getText()));
		
			pst11.executeUpdate();
			
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1);
		}}
		
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		withdraw = new JFrame();
		withdraw.setBounds(100, 100, 799, 443);
		withdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		withdraw.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 789, 404);
		withdraw.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain main =new atmmain();
				main.atmmain.setVisible(true);
				
				withdraw.dispose();
			}
		});
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
		lblNewLabel_1_1_1_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(765, 0, 24, 50);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(0, 394, 789, 10);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("WITHDRAW");
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 18));
		lblNewLabel_1.setBounds(315, 76, 198, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AMOUNT TO WITHDRAW");
		lblNewLabel_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(92, 196, 251, 35);
		panel.add(lblNewLabel_1_1);
		
		wd = new JTextField();
		wd.setColumns(10);
		wd.setBounds(353, 205, 190, 20);
		panel.add(wd);
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.valueOf(wd.getText())>Integer.valueOf(amtwd.getText())) {
					
					
					JOptionPane.showMessageDialog(null, "Invalid amount");
					
				}
				else {
					int old_balance =Integer.valueOf(amtwd.getText());
					int withdraw=Integer.valueOf(wd.getText());
					Connection con1 =null;
					PreparedStatement pst1 =null;
					ResultSet rs =null;
					Statement st= null;
					String query="update atmtbl set balance =? where accnum=?";
					
					try {
						con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
						PreparedStatement pst11=con1.prepareStatement(query);
						pst11.setInt(1,old_balance-withdraw);
						pst11.setInt(2, acc_no);
						int n=pst11.executeUpdate();
						if(n==1) {
							JOptionPane.showMessageDialog(null, "amount withdrawn");
							withdraws();
							
						}
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1);
					
					}
					
				}
				
				
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWithdraw.setBounds(290, 270, 147, 35);
		panel.add(btnWithdraw);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("LOGOUT");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain a =new atmmain();
				a.atmmain.setVisible(true);
				withdraw.dispose();
			}
		});
		lblNewLabel_1_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(327, 327, 110, 35);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("AMOUNT IN ACCOUNT:");
		lblNewLabel_1_1_2.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(165, 138, 251, 35);
		panel.add(lblNewLabel_1_1_2);
		
		amtwd = new JTextField();
		amtwd.setBounds(400, 147, 131, 20);
		panel.add(amtwd);
		amtwd.setColumns(10);
	}
}
