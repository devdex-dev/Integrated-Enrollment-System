package Design;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPage extends JFrame {

	public JPanel contentPane;
	private JTable table;
	private JTextField textField_Fname;
	private JTextField textField_1_Lname;
	private JComboBox ComboSex;
	private JTextField textField_3_phone;
	private JTextField textField_2_email;
	private JTextField textField_5_address;
	public static  JComboBox ComboSchool_1;

	/**
	 * Launch the application.
	 */
	public static void admin() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	
	public AdminPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
			}
		});
		setTitle("Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPage.class.getResource("/source/LOGO.png")));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1062, 564);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enroll en = new Enroll();
				en.setVisible(true);
				en.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		
		
		
		
		
		
		JComboBox ComboSchool_1 = new JComboBox();
		ComboSchool_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		ComboSchool_1.setModel(new DefaultComboBoxModel(new String[] {"", "DNSC - Davao Del Norte State College", "University of Southeastern Philippines - Tagum-Mabini Campus", "Kolehiyo ng Pantukan", "Kapalong College of Agriculture Sciences and Technology", "CMDI - Card MRI Development Institute", "St. Mary's College of Tagum", "University of Mindanao - Tagum ", "University of Mindanao - Panabo", "Tagum City College of Science and Technology Foundation", "Aces Tagum College", "STI College - Tagum", "North Davao College -Tagum Foundation Inc.", "Arriesgado College Foundation", "Philippine Baptist Christian College of Mindanao Inc."}));
		ComboSchool_1.setBackground(Color.WHITE);
		ComboSchool_1.setBounds(127, 354, 215, 36);
		panel.add(ComboSchool_1);
//		Address
		textField_5_address = new JTextField();
		textField_5_address.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_5_address.setColumns(10);
		textField_5_address.setBorder(null);
		textField_5_address.setBounds(127, 262, 217, 36);
		panel.add(textField_5_address);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Address");
		lblNewLabel_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_2_1.setBounds(58, 269, 71, 20);
		panel.add(lblNewLabel_2_1_2_1);
		
		
		
		
		//Delete
		JButton btnDelete_1 = new JButton("DELETE");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
						
				DefaultTableModel tbmodel = (DefaultTableModel) table.getModel();
		        String driver = "com.mysql.jdbc.Driver";
		        String url = "jdbc:mysql://localhost:3306/enrollment";
		        String username = "root";
		        String password = null;

		        try {
		           
		            int dialog = JOptionPane.showConfirmDialog(null, "Do you want to delete the record ?", "Warning", JOptionPane.YES_NO_OPTION);

		            if (dialog == JOptionPane.YES_OPTION) {
		                Class.forName(driver);
		                Connection con = DriverManager.getConnection(url, username, password);
		                
		                String id = textField_Fname.getText();
		                String sql="DELETE FROM enroll WHERE FirstName ='"+id+"'";

		                PreparedStatement statement = con.prepareStatement(sql);

		                statement.executeUpdate();
		                textField_Fname.grabFocus();
		                Update();
		                
		                textField_1_Lname.setText("");
		                textField_2_email.setText("");
		                textField_3_phone.setText("");
		                textField_5_address.setText("");
		                ComboSex.setSelectedItem("");
		                ComboSchool_1.setSelectedItem("");
		              
		                Update();
		                
		                
		              
		                con.close();
		            }
		        } catch (Exception e1) {
		        	System.out.println(e1);
		        }
				
			}
		});
		btnDelete_1.setName("");
		btnDelete_1.setForeground(Color.DARK_GRAY);
		btnDelete_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnDelete_1.setFocusable(false);
		btnDelete_1.setBorder(null);
		btnDelete_1.setBackground(Color.WHITE);
		btnDelete_1.setBounds(290, 413, 63, 24);
		panel.add(btnDelete_1);
		
		
		//Update
				JButton btnUupdate = new JButton("UPDATE");
				btnUupdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						btnUupdate.setEnabled(true);
				        try {

				            int dialog = JOptionPane.showConfirmDialog(null, "Do you want to update the record ?", "Warning", JOptionPane.YES_NO_OPTION);

				            if (dialog == JOptionPane.YES_OPTION) {

				                String driver = "com.mysql.jdbc.Driver";
				                String url = "jdbc:mysql://localhost:3306/enrollment";
				                String username = "root";
				                String password = null;

				                Class.forName(driver);
				                Connection con = DriverManager.getConnection(url, username, password);

				                String Fname = textField_Fname.getText();
				                String Lname =  textField_1_Lname.getText();
				                String Email = textField_2_email.getText();
				                String Phone = textField_3_phone.getText();
				                String Address =  textField_5_address.getText();
				                String Sex = ComboSex.getSelectedItem().toString();
				                String School = ComboSchool_1.getSelectedItem().toString();

				                String sql = "UPDATE enroll SET LastName = '" + Lname + "',Email ='" + Email + "' ,Phone ='" + Phone + "' ,Address ='" + Address + "' ,Sex ='" + Sex + "' ,School ='" + School + "' WHERE FirstName = '" + Fname + "' ";
				                PreparedStatement statement = con.prepareStatement(sql);

				                statement.executeUpdate();
				                DefaultTableModel tbmodel = (DefaultTableModel) table.getModel();
				                tbmodel.setRowCount(0);
				                Update();
				                
				                if (dialog == 0) {
				                    JOptionPane.showMessageDialog(null, "Data has been updated ...");

				                }

				                con.close();
				            }
				        } catch (Exception e1) {
				        	System.out.println(e1);
				           

				        }
						
					}
				});
				btnUupdate.setName("");
				btnUupdate.setForeground(Color.DARK_GRAY);
				btnUupdate.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
				btnUupdate.setFocusable(false);
				btnUupdate.setBorder(null);
				btnUupdate.setBackground(Color.WHITE);
				btnUupdate.setBounds(144, 413, 63, 24);
				panel.add(btnUupdate);
		
		
		
		
		
		//view
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String driver = "com.mysql.jdbc.Driver";
		        String url = "jdbc:mysql://localhost:3306/enrollment";
		        String username = "root";
		        String password = null;
		        try {
		            Class.forName(driver);
		            Connection con = DriverManager.getConnection(url, username, password);
		            Statement st = con.createStatement();

		            String sql = "SELECT * FROM enroll ";
		            ResultSet rs = st.executeQuery(sql);

		            while (rs.next()) {
		                String Fname = rs.getString("FirstName");
		                String Lname = rs.getString("LastName");
		                String Email = rs.getString("Email");
		                String Phone = rs.getString("Phone");
		                String Address = rs.getString("Address");
		                String Sex = rs.getString("Sex");
		                String School = rs.getString("School");

		                DefaultTableModel tbmodel = (DefaultTableModel) table.getModel();
		                
		                String tbData[] = {Fname, Lname,Email, Phone,Address, Sex,  School};

		                tbmodel.addRow(tbData);

		                btnView.setEnabled(false);
		                
		              

		            }
		        } catch (Exception e1) {
		           

		        }
				
		        
			}
		});
		btnView.setName("");
		btnView.setForeground(Color.DARK_GRAY);
		btnView.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnView.setFocusable(false);
		btnView.setBorder(null);
		btnView.setBackground(Color.WHITE);
		btnView.setBounds(69, 413, 63, 24);
		panel.add(btnView);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("School");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(69, 360, 59, 20);
		panel.add(lblNewLabel_2_1_1_1);
		
//		email
		textField_2_email = new JTextField();
		textField_2_email.setBorder(null);
		textField_2_email.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_2_email.setColumns(10);
		textField_2_email.setBounds(127, 164, 215, 36);
		panel.add(textField_2_email);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Email");
		lblNewLabel_2_1_3.setForeground(Color.WHITE);
		lblNewLabel_2_1_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_3.setBounds(77, 169, 49, 20);
		panel.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Phone");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_2.setBounds(67, 218, 60, 20);
		panel.add(lblNewLabel_2_1_2);
		
		//phone
		textField_3_phone = new JTextField();
		textField_3_phone.setBorder(null);
		textField_3_phone.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_3_phone.setColumns(10);
		textField_3_phone.setBounds(127, 211, 215, 36);
		panel.add(textField_3_phone);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Sex");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(87, 312, 41, 20);
		panel.add(lblNewLabel_2_1_1);
		
		//sex
		ComboSex = new JComboBox();
		ComboSex.setBackground(Color.WHITE);
		ComboSex.setBorder(null);
		ComboSex.setFont(new Font("Dialog", Font.PLAIN, 16));
		ComboSex.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		ComboSex.setSelectedIndex(0);
		ComboSex.setBounds(127, 307, 217, 36);
		panel.add(ComboSex);
		
		//lname
		textField_1_Lname = new JTextField();
		textField_1_Lname.setBorder(null);
		textField_1_Lname.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_1_Lname.setColumns(10);
		textField_1_Lname.setBounds(127, 117, 215, 36);
		panel.add(textField_1_Lname);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(42, 122, 84, 20);
		panel.add(lblNewLabel_2_1);
		
		//fname
		textField_Fname = new JTextField();
		textField_Fname.setBorder(null);
		textField_Fname.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_Fname.setBounds(127, 70, 215, 36);
		panel.add(textField_Fname);
		textField_Fname.setColumns(10);

		
		
		btnLogout.setName("");
		btnLogout.setForeground(Color.DARK_GRAY);
		btnLogout.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnLogout.setFocusable(false);
		btnLogout.setBorder(null);
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(874, 529, 63, 24);
		panel.add(btnLogout);
		
		JButton btnLogoutExit = new JButton("LOGOUT & EXIT");
		btnLogoutExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EXITprompt nw = new EXITprompt();
				nw.setVisible(true);
				nw.setLocationRelativeTo(null);
			}
		});
		btnLogoutExit.setName("");
		btnLogoutExit.setForeground(Color.WHITE);
		btnLogoutExit.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnLogoutExit.setFocusable(false);
		btnLogoutExit.setBorder(null);
		btnLogoutExit.setBackground(Color.RED);
		btnLogoutExit.setBounds(947, 529, 90, 24);
		panel.add(btnLogoutExit);
		
		JLabel lblNewLabel_2_2 = new JLabel("ADMINISTRATOR");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 39));
		lblNewLabel_2_2.setBounds(290, 11, 468, 36);
		panel.add(lblNewLabel_2_2);
		
		
		
		
		//Search
				JButton btnSearch = new JButton("SEARCH");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						String driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3306/enrollment";
				        String username = "root";
				        String password = null;

				        try {

				            int dialog = JOptionPane.showConfirmDialog(null, "Do you want to search it ?", "Warning", JOptionPane.YES_NO_OPTION);

				            if (dialog == JOptionPane.YES_OPTION) {
				                Class.forName(driver);
				                Connection con = DriverManager.getConnection(url, username, password);

				                String sql = "SELECT * FROM enroll WHERE LastName =?";
				                PreparedStatement statement = con.prepareStatement(sql);
				 
				                statement.setString(1, textField_1_Lname.getText());

				                ResultSet rs = statement.executeQuery();
				             
		
				                if (rs.next()) {
				                 
				                    JOptionPane.showMessageDialog(null, "Record  Found");
				                 
				                    textField_Fname.setText(rs.getString("FirstName"));
				                        textField_1_Lname.setText(rs.getString("LastName"));
				                        textField_2_email.setText(rs.getString("Email"));
				                          textField_3_phone.setText(rs.getString("Phone"));
				                          textField_5_address.setText(rs.getString("Address"));
				                          ComboSex.getSelectedItem().toString();
				                          ComboSchool_1.getSelectedItem().toString();
				                        
				                    
				                }else{
				                       JOptionPane.showMessageDialog(null, "Record NOt Found");
				                }
				                DefaultTableModel tbmodel = (DefaultTableModel) table.getModel();
				      
				                Update();
				                
				                con.close();
				            }
				        } catch (Exception e1) {
				            JOptionPane.showMessageDialog(null, e1);
				        }
						
					}
				});
				btnSearch.setName("");
				btnSearch.setForeground(Color.DARK_GRAY);
				btnSearch.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
				btnSearch.setFocusable(false);
				btnSearch.setBorder(null);
				btnSearch.setBackground(Color.WHITE);
				btnSearch.setBounds(217, 413, 63, 24);
				panel.add(btnSearch);
		
		
		
		
		
		//Table is Here HEHEEHEHE
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel tbmodel = (DefaultTableModel) table.getModel();
		        int SelectedRows = table.getSelectedRow();

		         textField_Fname.setText(tbmodel.getValueAt(SelectedRows, 0).toString());
		        textField_1_Lname.setText(tbmodel.getValueAt(SelectedRows, 1).toString());
		        textField_2_email.setText(tbmodel.getValueAt(SelectedRows, 2).toString());
		        textField_3_phone.setText(tbmodel.getValueAt(SelectedRows, 3).toString());
		         textField_5_address.setText(tbmodel.getValueAt(SelectedRows, 4).toString());
		         ComboSex.setSelectedItem(tbmodel.getValueAt(SelectedRows, 5).toString());
		         ComboSchool_1.setSelectedItem(tbmodel.getValueAt(SelectedRows, 6).toString());
		   
		    }
		});
		scrollPane.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(366, 58, 671, 460);
		panel.add(scrollPane);
		
		
		
		
		
		
//		table is hereee poooo
		table = new JTable();
		table.setGridColor(Color.WHITE);
		table.setBorder(null);
		table.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"FirstName", "LastName", "Email", "Phone", "Address", "Sex", "School"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(1).setPreferredWidth(119);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setPreferredWidth(108);
		table.getColumnModel().getColumn(4).setPreferredWidth(158);
		table.getColumnModel().getColumn(5).setPreferredWidth(59);
		table.getColumnModel().getColumn(6).setPreferredWidth(227);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminPage.class.getResource("/source/Cover4.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(794, -3, 268, 567);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(42, 77, 84, 20);
		panel.add(lblNewLabel_2);
		
		
		JButton btnClear_1 = new JButton("CLEAR");
		btnClear_1.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
		    textField_Fname.setText("");
			textField_1_Lname.setText("");
            textField_2_email.setText("");
            textField_3_phone.setText("");
            textField_5_address.setText("");
            ComboSex.setSelectedItem("");
            ComboSchool_1.setSelectedIndex(0);
			}
		});
		btnClear_1.setName("");
		btnClear_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 10));
		btnClear_1.setFocusable(false);
		btnClear_1.setBorder(null);
		btnClear_1.setBackground(Color.WHITE);
		btnClear_1.setBounds(180, 448, 63, 24);
		panel.add(btnClear_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminPage.class.getResource("/source/Cover4.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-47, 0, 882, 564);
		panel.add(lblNewLabel);
	
	}
	public void Update() {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/enrollment";
        String username = "root";
        String password = null;
	
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement statement = con.prepareStatement("SELECT * FROM enroll");

            ResultSet rs = statement.executeQuery();
            ResultSetMetaData stdata = rs.getMetaData();
            int q = stdata.getColumnCount();
            DefaultTableModel tbmodel = (DefaultTableModel) table.getModel();
            tbmodel.setRowCount(0);

            while (rs.next()) {
                int i;
                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("FirstName"));
                    columnData.add(rs.getString("LastName"));
                    columnData.add(rs.getString("Email"));
                    columnData.add(rs.getString("Phone"));
                    columnData.add(rs.getString("Address"));
                    columnData.add(rs.getString("Sex"));
                    columnData.add(rs.getString("School"));
                }
                tbmodel.addRow(columnData);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }	
	}
}
