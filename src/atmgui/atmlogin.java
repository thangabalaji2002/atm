package atmgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class atmlogin {

	JFrame atmlogin;
	private JTextField acclog;
	private JPasswordField pinlog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atmlogin window = new atmlogin();
					window.atmlogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public atmlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atmlogin = new JFrame();
		atmlogin.setBounds(100, 100, 782, 429);
		atmlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atmlogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 766, 390);
		atmlogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 756, 85);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAtmManagementSystem = new JLabel("ATM MANAGEMENT SYSTEM");
		lblAtmManagementSystem.setBounds(255, 25, 355, 26);
		lblAtmManagementSystem.setForeground(new Color(240, 248, 255));
		lblAtmManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_1.add(lblAtmManagementSystem);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("X");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmtuto a=new atmtuto();
				a.atmtuto.setVisible(true);
				atmlogin.dispose();
			}
		});
		lblNewLabel_1_1_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(732, 0, 24, 50);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(0, 0, 128));
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblLogin.setBounds(349, 96, 97, 26);
		panel.add(lblLogin);
		
		JLabel lblAccountNo = new JLabel("ACCOUNT NO:");
		lblAccountNo.setForeground(new Color(0, 0, 128));
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAccountNo.setBounds(26, 151, 186, 26);
		panel.add(lblAccountNo);
		
		JLabel lblPinNo = new JLabel("PIN NO:");
		lblPinNo.setForeground(new Color(0, 0, 128));
		lblPinNo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPinNo.setBounds(31, 240, 155, 26);
		panel.add(lblPinNo);
		
		acclog = new JTextField();
		acclog.setForeground(Color.RED);
		acclog.setBounds(311, 158, 246, 20);
		panel.add(acclog);
		acclog.setColumns(10);
		
		pinlog = new JPasswordField();
		pinlog.setBounds(311, 247, 246, 20);
		panel.add(pinlog);
		
		JButton btnLogin = new JButton("LOGIN");
		Connection con =null;
		PreparedStatement pst =null;
		ResultSet rs =null;
		Statement st= null;
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String query="select * from atmtbl where pin ="+pinlog.getText()+" and accnum= "+acclog.getText()+"";
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(rs.next()) {
						atmmain main =new atmmain(rs.getInt(1));
						main.atmmain.setVisible(true);
						
						atmlogin.dispose();
						
						
					}
					else {
						JOptionPane.showMessageDialog(atmlogin,"invalid accnum or password");
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(atmlogin,e1);
				}
			
			
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(334, 289, 152, 37);
		panel.add(btnLogin);
		
		JButton btnsignup = new JButton("SIGNUP");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atmsignup sign =new atmsignup();
				sign.atmsignup.setVisible(true);
				atmlogin.dispose();
				
				
			}

			
		});
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsignup.setBounds(334, 337, 152, 37);
		panel.add(btnsignup);
		
		JLabel lblNewUser = new JLabel("NEW USER??");
		lblNewUser.setForeground(new Color(0, 0, 128));
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewUser.setBounds(31, 337, 155, 26);
		panel.add(lblNewUser);
	}
}
