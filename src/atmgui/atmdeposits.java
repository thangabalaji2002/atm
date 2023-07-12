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

public class atmdeposits {

	JFrame atmdeposits;
	private final JPanel panel_1 = new JPanel();
	private JTextField amtdpt;
	int oldbalance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atmdeposits window = new atmdeposits();
					window.atmdeposits.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public atmdeposits() {
		initialize();
	}
	int account_num=0;
	public atmdeposits(int no) {
		account_num=no;
		initialize();
	}
	
	
	
	private void deposits() {
		Connection con1 =null;
		PreparedStatement pst1 =null;
		ResultSet rs =null;
		Statement st= null;
		String query="insert into transactiontbl values(?,?,?,?)";
		
		try {
			con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
		PreparedStatement pst11=con1.prepareStatement(query);
			pst11.setInt(1,1);
			pst11.setInt(2, account_num);
			pst11.setString(3, "deposit");
			pst11.setInt(4,Integer.valueOf(amtdpt.getText()));
		
			pst11.executeUpdate();
			
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1);
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atmdeposits = new JFrame();
		atmdeposits.setBounds(100, 100, 805, 443);
		atmdeposits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atmdeposits.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 789, 404);
		atmdeposits.getContentPane().add(panel);
		panel.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 789, 78);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
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
				System.exit(1);
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
		
		JLabel lblNewLabel_1 = new JLabel("DEPOSITS");
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 18));
		lblNewLabel_1.setBounds(322, 90, 198, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AMOUNT IN RUPEES");
		lblNewLabel_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(131, 173, 190, 35);
		panel.add(lblNewLabel_1_1);
		
		amtdpt = new JTextField();
		amtdpt.setBounds(350, 182, 190, 20);
		panel.add(amtdpt);
		amtdpt.setColumns(10);
		
		
		
		
		JButton dptbtn = new JButton("DEPOSIT");
		dptbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(amtdpt.getText().isEmpty()||Integer.valueOf(amtdpt.getText())==0) {
					JOptionPane.showMessageDialog(null, "enter the valid amount");
				}
				
				
				getbalance();
			Connection con1 =null;
			PreparedStatement pst1 =null;
			ResultSet rs =null;
			Statement st= null;
			String query="update atmtbl set balance =? where accnum=?";
			
			try {
				con1 = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
				PreparedStatement pst11=con1.prepareStatement(query);
				pst11.setInt(1,oldbalance+Integer.valueOf(amtdpt.getText()));
				pst11.setInt(2, account_num);
				int n=pst11.executeUpdate();
				if(n==1) {
					JOptionPane.showMessageDialog(null, "balance updated");
					deposits();
					atmmain main =new atmmain();
					main.atmmain.setVisible(true);
					
					atmdeposits.dispose();
				}
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1);
			}
		
			}
			
			public void getbalance() {
			
				Connection con =null;
				PreparedStatement pst =null;
				ResultSet rs =null;
				Statement st= null;
				String query="select balance from atmtbl where accnum = "+account_num+"";
			
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
					Statement st1=con.createStatement();
					ResultSet rs1=st1.executeQuery(query);
					if(rs1.next()) {
					oldbalance= rs1.getInt(1);
						
						
						
						
					}
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				
				}
				
				
				
			}
		});
		dptbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dptbtn.setBounds(308, 270, 147, 35);
		panel.add(dptbtn);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("BACK");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain b =new atmmain();
				b.atmmain.setVisible(true);
				atmdeposits.dispose();
			}
		});
		lblNewLabel_1_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(350, 327, 70, 35);
		panel.add(lblNewLabel_1_1_1);
	}

}
