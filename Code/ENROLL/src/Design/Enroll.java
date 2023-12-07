package Design;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Enroll extends JFrame {

	private JPanel contentPane;
	public static  JTextField textField_Fname;
	public static JTextField textField_1_Lname;
	public static  JTextField textField_2_email;
	public static  JTextField textField_3_phone;
	public static  JComboBox ComboSex;
	public static  JTextField textField_5_address;
	public static  JComboBox ComboSchool;

	/**
	 * Launch the application.
	 */
	public static void LogIn() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Enroll frame = new Enroll();
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
	public Enroll() {
		setTitle("IES: Integrated Enrollment System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Enroll.class.getResource("/source/LOGO.png")));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(298, 0, 795, 672);
		contentPane.add(panel_2);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminLogIn ad = new AdminLogIn();
				ad.setVisible(true);
				ad.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		
		ComboSchool = new JComboBox();
		ComboSchool.setModel(new DefaultComboBoxModel(new String[] {"", "DNSC - Davao Del Norte State College", "University of Southeastern Philippines - Tagum-Mabini Campus", "Kolehiyo ng Pantukan", "Kapalong College of Agriculture Sciences and Technology", "CMDI - Card MRI Development Institute", "St. Mary's College of Tagum", "University of Mindanao - Tagum ", "University of Mindanao - Panabo", "Tagum City College of Science and Technology Foundation", "Aces Tagum College", "STI College - Tagum", "North Davao College -Tagum Foundation Inc.", "Arriesgado College Foundation", "Philippine Baptist Christian College of Mindanao Inc"}));
		ComboSchool.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		ComboSchool.setBorder(null);
		ComboSchool.setBounds(218, 397, 364, 36);
		panel_2.add(ComboSchool);
		
		
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBounds(568, 11, 63, 24);
		panel_2.add(btnAdmin);
		btnAdmin.setName("");
		btnAdmin.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnAdmin.setFocusable(false);
		btnAdmin.setBorder(null);
		btnAdmin.setBackground(Color.GRAY);
		
		JButton btnEnroll = new JButton("ENROLL!");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String fname = textField_Fname.getText();
			        String lname = textField_1_Lname.getText();
			        String email = textField_2_email.getText();
			        String phone = textField_3_phone.getText();
			        String addr = textField_5_address.getText();
			        String sex = (String) ComboSex.getSelectedItem();
			        String school = (String) ComboSchool.getSelectedItem();
		        try {
		        	String driver = "com.mysql.jdbc.Driver";
			        String url = "jdbc:mysql://localhost:3306/enrollment";
			        String username = "root";
			        String password = null;
		            Class.forName(driver);
		            Connection con = DriverManager.getConnection(url, username, password);
		           

		           
		           
		            if(fname.equals("") && lname.equals("") && email.equals("") && phone.equals("") && addr.equals("") && sex.equals("") && school.equals("")) 
		            {
		            EnrollFailed fld = new EnrollFailed();
		            fld.setVisible(true);
		            fld.setLocationRelativeTo(null);
	
		            }
		            	
		            else {
		            
		            	String sql = "INSERT INTO `enroll`(`FirstName`, `LastName`, `Email`, `Phone`, `Address`, `Sex`, `School`) "
			            		+ " VALUES ('"+ fname +"','"+lname+"','"+email+"','"+phone+"','"+addr+"','"+sex+"','"+school+"')";
		           	
		            	PreparedStatement statement = con.prepareStatement(sql);
			            int rowsUpdated = statement.executeUpdate();
					if (rowsUpdated > 0) {
						EnrollSuccess fns = new EnrollSuccess();
						fns.setVisible(true);
						fns.setLocationRelativeTo(null);
					}
					else System.out.println("No update was done.");
					
		            }
					
		           


		            
		        } catch (Exception e1) {
		            System.out.println("Warning: " + e1.getMessage());

		        }
				
				
		        Enroll.textField_Fname.setText("");
				Enroll.textField_1_Lname.setText("");
				Enroll.textField_2_email.setText("");
				Enroll.textField_3_phone.setText("");
				Enroll.textField_5_address.setText("");
				Enroll.ComboSchool.setSelectedItem("");
				Enroll.ComboSex.setSelectedItem("");
				
				
				
				
			}
		});
		btnEnroll.setBounds(246, 514, 117, 36);
		panel_2.add(btnEnroll);
		btnEnroll.setName("");
		btnEnroll.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		btnEnroll.setFocusable(false);
		btnEnroll.setBorder(null);
		btnEnroll.setBackground(Color.WHITE);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				
			CLEARprompt ask = new CLEARprompt();
			ask.setVisible(true);
			ask.setLocationRelativeTo(null);
				
				
				
				
				
				
				
				
			}
		});
		btnClear.setName("");
		btnClear.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnClear.setFocusable(false);
		btnClear.setBorder(null);
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(568, 511, 63, 24);
		panel_2.add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			EXITprompt ex = new EXITprompt();
			ex.setVisible(true);
			ex.setLocationRelativeTo(null);
			
			}
		});
		btnExit.setName("");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnExit.setFocusable(false);
		btnExit.setBorder(null);
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(568, 538, 63, 24);
		panel_2.add(btnExit);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("School To Enroll");
		lblNewLabel_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1_1_1.setBounds(10, 397, 198, 36);
		panel_2.add(lblNewLabel_2_1_1_1_1_1);
		
		textField_5_address = new JTextField();
		textField_5_address.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_5_address.setColumns(10);
		textField_5_address.setBorder(new LineBorder(Color.WHITE, 3, true));
		textField_5_address.setBounds(218, 296, 364, 36);
		panel_2.add(textField_5_address);
		
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Address");
		lblNewLabel_2_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1_2.setBounds(60, 295, 173, 36);
		panel_2.add(lblNewLabel_2_1_1_1_2);
		
		ComboSex = new JComboBox();
		ComboSex.setBorder(new EmptyBorder(0, 0, 4, 0));
		ComboSex.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		ComboSex.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE"}));
		ComboSex.setBounds(218, 350, 130, 36);
		panel_2.add(ComboSex);
		
		
		textField_3_phone = new JTextField();
		textField_3_phone.setBorder(new LineBorder(Color.WHITE, 3, true));
		textField_3_phone.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_3_phone.setColumns(10);
		textField_3_phone.setBounds(219, 233, 364, 36);
		panel_2.add(textField_3_phone);
		
		
		
				
		
		textField_2_email = new JTextField();
		textField_2_email.setBorder(new LineBorder(Color.WHITE, 3, true));
		textField_2_email.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_2_email.setColumns(10);
		textField_2_email.setBounds(219, 179, 364, 36);
		panel_2.add(textField_2_email);
		
		
		textField_1_Lname = new JTextField();
		textField_1_Lname.setBorder(new LineBorder(Color.WHITE, 3, true));
		textField_1_Lname.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_1_Lname.setColumns(10);
		textField_1_Lname.setBounds(219, 122, 364, 36);
		panel_2.add(textField_1_Lname);
		
		
		textField_Fname = new JTextField();
		textField_Fname.setBorder(new LineBorder(Color.WHITE, 3, true));
		textField_Fname.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_Fname.setBounds(219, 63, 364, 36);
		panel_2.add(textField_Fname);
		textField_Fname.setColumns(10);
		
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Sex");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1_1.setBounds(96, 350, 163, 36);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Phone");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(77, 232, 173, 36);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(77, 176, 173, 36);
		panel_2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(40, 122, 194, 36);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(40, 62, 194, 36);
		panel_2.add(lblNewLabel_2);
		
		JLabel backgroud2 = new JLabel(" ");
		backgroud2.setAlignmentY(0.0f);
		backgroud2.setHorizontalTextPosition(SwingConstants.CENTER);
		backgroud2.setIcon(new ImageIcon(Enroll.class.getResource("/source/Cover4.png")));
		backgroud2.setHorizontalAlignment(SwingConstants.CENTER);
		backgroud2.setBounds(-246, -71, 1010, 650);
		panel_2.add(backgroud2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-39, 0, 457, 700);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel background1 = new JLabel("");
		background1.setIcon(new ImageIcon(Enroll.class.getResource("/source/Cover.png")));
		background1.setHorizontalAlignment(SwingConstants.CENTER);
		background1.setBounds(21, -42, 375, 670);
		panel_1.add(background1);
	}
}
