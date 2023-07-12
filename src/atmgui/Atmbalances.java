package atmgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Atmbalances {

	JFrame atmbalances;
	private JTextField accbal;
	private JTextField baltbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atmbalances window = new Atmbalances();
					window.atmbalances.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Atmbalances() {
		initialize();
	}

	int acc_n = 0;
	int oldbalance = 0;

	public Atmbalances(int b) {
		initialize();
		acc_n = b;
		getbalance();
		
	accbal.setText(String.valueOf(acc_n));
		baltbl.setText(String.valueOf(oldbalance));
	
	}

	public void getbalance() {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st = null;
		String query = "select balance from atmtbl where accnum = " + acc_n + "";

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/atmdb", "root", "");
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(query);
			if (rs1.next()) {
				oldbalance = rs1.getInt(1);

			}
		} catch (Exception e1) {
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atmbalances = new JFrame();
		atmbalances.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 816, 432);
		atmbalances.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 813, 78);
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
		lblNewLabel_1_1_1_1.setBounds(789, 0, 24, 50);
		panel_1.add(lblNewLabel_1_1_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(0, 412, 813, 20);
		panel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("BALANCES");
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 18));
		lblNewLabel_1.setBounds(342, 89, 198, 51);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ACCOUNT NO :");
		lblNewLabel_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(131, 173, 190, 35);
		panel.add(lblNewLabel_1_1);

		accbal = new JTextField();
		accbal.setColumns(10);
		accbal.setBounds(350, 182, 190, 20);
		panel.add(accbal);

		JLabel lblNewLabel_1_1_1 = new JLabel("BACK");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atmmain a =new atmmain();
				a.atmmain.setVisible(true);
				atmbalances.dispose();
			}
		});
		lblNewLabel_1_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(370, 324, 70, 35);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("BALANCE");
		lblNewLabel_1_1_2.setFont(new Font("Century", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(131, 224, 125, 35);
		panel.add(lblNewLabel_1_1_2);

		baltbl = new JTextField();
		baltbl.setColumns(10);
		baltbl.setBounds(350, 233, 190, 20);
		panel.add(baltbl);
	}
}
