package Design;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Front extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Front frame = new Front();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Front() {
		setType(Type.UTILITY);
		setUndecorated(true);
		setName("frame1");
		setResizable(false);
		setTitle("IES: Integrated Enrollment System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Front.class.getResource("/source/LOGO.png")));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-15, 0, 406, 642);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Get Started!");
		btnNewButton.setName("");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Enroll nw = new Enroll();
				nw.setVisible(true);
				nw.setLocationRelativeTo(null);
				dispose();
				
				
			}
			
		});
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setName("");
		btnExit.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnExit.setFocusable(false);
		btnExit.setBorder(null);
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(168, 503, 63, 24);
		panel.add(btnExit);
		
		btnNewButton.setPressedIcon(null);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(128, 457, 138, 35);
		panel.add(btnNewButton);
		lblNewLabel.setIcon(new ImageIcon(Front.class.getResource("/source/FrontPage.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 396, 619);
		panel.add(lblNewLabel);
		
	}
	
	protected static void HIDE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}


