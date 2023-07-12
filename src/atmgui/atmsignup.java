package atmgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class atmsignup {

	JFrame atmsignup;
	private JTextField acctbl;
	private JTextField nametbl;
	private JTextField fanametbl;
	private JTextField pintbl;
	private JTextField occtbl;
	private JTextField phtbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atmsignup window = new atmsignup();
					window.atmsignup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public atmsignup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atmsignup = new JFrame();
		atmsignup.setBounds(100, 100, 792, 505);
		atmsignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atmsignup.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 776, 455);
		atmsignup.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain a =new atmmain();
				a.atmmain.setVisible(true);
				atmsignup.dispose();
			}
		});
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 776, 57);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAtmManagementSystem = new JLabel("ATM MANAGEMENT SYSTEM");
		lblAtmManagementSystem.setBounds(249, 21, 267, 26);
		lblAtmManagementSystem.setForeground(new Color(240, 248, 255));
		lblAtmManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_1.add(lblAtmManagementSystem);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("X");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmtuto a=new atmtuto();
				a.atmtuto.setVisible(true);
				atmsignup.dispose();
			}
		});
		lblNewLabel_1_1_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(742, -4, 24, 50);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(26, 157, 171, -38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ACCOUNT  NO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(36, 99, 134, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(34, 146, 119, 35);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("FATHER NAME");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(36, 192, 141, 35);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ADDRESS");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(36, 256, 134, 35);
		panel.add(lblNewLabel_1_3);
		
		acctbl = new JTextField();
		acctbl.setBounds(200, 108, 177, 20);
		panel.add(acctbl);
		acctbl.setColumns(10);
		
		nametbl = new JTextField();
		nametbl.setColumns(10);
		nametbl.setBounds(200, 154, 177, 20);
		panel.add(nametbl);
		
		fanametbl = new JTextField();
		fanametbl.setColumns(10);
		fanametbl.setBounds(200, 201, 177, 20);
		panel.add(fanametbl);
		
		final JTextArea addtbl = new JTextArea();
		addtbl.setBounds(202, 240, 175, 91);
		panel.add(addtbl);
		
		JLabel lblSignUpForm = new JLabel("SIGN UP FORM");
		lblSignUpForm.setForeground(new Color(0, 0, 128));
		lblSignUpForm.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSignUpForm.setBounds(305, 68, 267, 26);
		panel.add(lblSignUpForm);
		
		JLabel lblNewLabel_1_4 = new JLabel("PIN");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(438, 99, 134, 35);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("EDUCATION");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(438, 146, 134, 35);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("OCCUPATION");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(438, 192, 134, 35);
		panel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("PHONE NO:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7.setBounds(438, 256, 134, 35);
		panel.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("DOB");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5_1.setBounds(438, 302, 134, 35);
		panel.add(lblNewLabel_1_5_1);
		
		pintbl = new JTextField();
		pintbl.setColumns(10);
		pintbl.setBounds(569, 108, 177, 20);
		panel.add(pintbl);
		
		occtbl = new JTextField();
		occtbl.setColumns(10);
		occtbl.setBounds(569, 201, 177, 20);
		panel.add(occtbl);
		
		phtbl = new JTextField();
		phtbl.setColumns(10);
		phtbl.setBounds(569, 265, 177, 20);
		panel.add(phtbl);
		
		final JComboBox edutbl = new JComboBox();
		edutbl.setModel(new DefaultComboBoxModel(new String[] {"SCHOOL/NOT STUDIED", "UG", "PG", "PHD"}));
		edutbl.setBounds(569, 154, 177, 22);
		panel.add(edutbl);
		
		final JDateChooser dobtbl = new JDateChooser();
		dobtbl.setBounds(569, 302, 177, 26);
		panel.add(dobtbl);
		
		JButton subbtn = new JButton("Submit");
		subbtn.addMouseListener(new MouseAdapter() {
		
			Connection con =null;
			PreparedStatement pst =null;
			ResultSet rs =null;
			Statement st= null;
			private void clear() {
			
			acctbl.setText("");
			nametbl.setText("");
			fanametbl.setText("");
		
			phtbl.setText("");
			addtbl.setText("");
		
			occtbl.setText("");
			pintbl.setText("");
			
			}	
			@Override
		public void mouseClicked(MouseEvent e) {
			if(acctbl.getText().isEmpty() || nametbl.getText().isEmpty() || fanametbl.getText().isEmpty() || addtbl.getText().isEmpty()||pintbl.getText().isEmpty()||occtbl.getText().isEmpty()||phtbl.getText().isEmpty()) {
					//addtbl is assigned to final at 127
					JOptionPane.showMessageDialog(null," missing data ");
					
				}else {
					try {
						Connection con =DriverManager.getConnection("jdbc:mysql://localhost/atmdb","root","");
						PreparedStatement pst =con.prepareStatement("insert into atmtbl values (?,?,?,?,?,?,?,?,?,?)");
						pst.setInt(1,Integer.valueOf(acctbl.getText()));
						pst.setString(2,nametbl.getText());
						pst.setString(3,fanametbl.getText());
						pst.setString(4,dobtbl.getDate().toString());
						pst.setString(5,phtbl.getText());
						pst.setString(6,addtbl.getText());
						pst.setString(7,edutbl.getSelectedItem().toString());
						pst.setString(8,occtbl.getText());
						pst.setInt(9,Integer.valueOf(pintbl.getText()));
						pst.setInt(10, 2000);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Account saved");
						 clear();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
				}
				
				
				
			}
		});
		subbtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		subbtn.setBounds(305, 379, 152, 23);
		panel.add(subbtn);
		
		JLabel lblNewLabel_1_8 = new JLabel("SIGN UP");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_8.setBounds(345, 413, 84, 35);
		panel.add(lblNewLabel_1_8);
	}

	
}
