package atmgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;

public class atmtuto {

	 JFrame atmtuto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		atmtuto a =new atmtuto();
		a.atmtuto.setVisible(true);
		try {
			for (int i=0;i<=100;i++) {
				Thread.sleep(20);
			
				
			}
		}catch(Exception e){
			
		}
		atmlogin c =new atmlogin();
		c.atmlogin.setVisible(true);
		a.atmtuto.dispose();
		

	}

	/**
	 * Create the application.
	 */
	public atmtuto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atmtuto = new JFrame();
		atmtuto.setBounds(100, 100, 796, 408);
		atmtuto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atmtuto.getContentPane().setLayout(null);
		
		JPanel progress = new JPanel();
		progress.setBackground(new Color(0, 0, 128));
		progress.setForeground(new Color(0, 0, 255));
		progress.setBounds(0, 0, 780, 369);
		atmtuto.getContentPane().add(progress);
		progress.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(279, 64, 209, 261);
		progress.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Thangabalaji\\Downloads\\atm image new.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel("CHINNASALEM  BANK");
		lblNewLabel_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1.setFont(new Font("Papyrus", Font.BOLD, 18));
		lblNewLabel_1.setBounds(252, 25, 333, 28);
		progress.add(lblNewLabel_1);
		
		

		
	}
}
