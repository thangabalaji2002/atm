package atmgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class atmmain {

	JFrame atmmain;
	private JTextField accmain;
	int bal_acc=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atmmain window = new atmmain();
					window.atmmain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public atmmain() {
		initialize();
	}
	public atmmain(int num) {
		initialize();
		String numb =String.valueOf(num);
		accmain.setText(numb);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atmmain = new JFrame();
		atmmain.setBounds(100, 100, 801, 430);
		atmmain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atmmain.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 785, 391);
		atmmain.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 775, 106);
		panel_1.setBackground(new Color(0, 0, 128));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHINNASALEM BANK");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(286, 33, 228, 37);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("X");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmtuto atm =new atmtuto();
				atm.atmtuto.setVisible(true);
				atmmain.dispose();
			}
		});
		lblNewLabel_1_1_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(751, 6, 24, 50);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("ACCOUNT NUMBER :");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(50, 117, 203, 50);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("DEPOSIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmdeposits dpt=new atmdeposits(Integer.valueOf(accmain.getText()));
				dpt.atmdeposits.setVisible(true);
				atmmain.dispose();
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(63, 199, 152, 23);
		panel.add(btnNewButton);
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con =null;
				PreparedStatement pst =null;
				ResultSet rs =null;
				Statement st= null;
			String query="select balance from atmtbl where accnum = "+accmain.getText()+"";
			
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
					Statement st1=con.createStatement();
					ResultSet rs1=st1.executeQuery(query);
					if(rs1.next()) {
					 bal_acc= rs1.getInt(1);
						
						
						
						
					}
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				
				}
				Withdraw wt =new Withdraw(bal_acc,Integer.valueOf(accmain.getText()));
				wt.withdraw.setVisible(true);
				atmmain.dispose();
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnWithdraw.setBounds(564, 199, 138, 23);
		panel.add(btnWithdraw);
		
		JButton btnMiniStatement = new JButton("MINI STATEMENT");
		btnMiniStatement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MINISTATEMENTS s= new MINISTATEMENTS(Integer.valueOf(accmain.getText()));
				s.ministm.setVisible(true);
				atmmain.dispose();
				
			}
			
		});
		btnMiniStatement.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMiniStatement.setBounds(564, 268, 138, 23);
		panel.add(btnMiniStatement);
		
		JButton btnFastcash = new JButton("FASTCASH");
		btnFastcash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fastcash fc=new Fastcash(Integer.valueOf(accmain.getText()));
				fc.fastcash.setVisible(true);
				atmmain.dispose();
				
			}
		});
		btnFastcash.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFastcash.setBounds(63, 268, 152, 23);
		panel.add(btnFastcash);
		
		JButton btnChangepin = new JButton("CHANGEPIN");
		btnChangepin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Changepin chpin =new Changepin(Integer.valueOf(accmain.getText()));
				chpin.changepin.setVisible(true);
				atmmain.dispose();
			}
		});
		btnChangepin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnChangepin.setBounds(63, 328, 152, 23);
		panel.add(btnChangepin);
		
		JButton btnBalance = new JButton("BALANCE");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atmbalances atm_balances = new Atmbalances(Integer.valueOf(accmain.getText()));
				atm_balances.atmbalances.setVisible(true);
				atmmain.dispose();
			}
		});
		btnBalance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBalance.setBounds(564, 328, 138, 23);
		panel.add(btnBalance);
		
		JLabel lblNewLabel_2 = new JLabel("CHINNASALEM BANK");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(297, 349, 316, 42);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("LOG OUT");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmsignup a =new atmsignup();
				a.atmsignup.setVisible(true);
				atmmain.dispose();
			}
		});
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(351, 312, 203, 50);
		panel.add(lblNewLabel_1_1);
		
		accmain = new JTextField();
		accmain.setBounds(233, 134, 228, 20);
		panel.add(accmain);
		accmain.setColumns(10);
	}
}
