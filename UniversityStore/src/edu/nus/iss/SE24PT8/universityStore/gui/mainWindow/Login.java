/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nus.iss.SE24PT8.universityStore.gui.mainWindow;

import javax.swing.JOptionPane;

import edu.nus.iss.SE24PT8.universityStore.gui.framework.SubjectManager;
import edu.nus.iss.SE24PT8.universityStore.main.Store;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author THIRILWIN
 * @date 2016-04-03
 */
public class Login extends javax.swing.JFrame {

	private String userID = "";
    /**
     * Creates new form Login
     */
	
	public void ShowLogIn(Boolean isLoggedOut) {
		if (isLoggedOut) {
			userID = "";
			jLogoutMessage.setText("You have successfully logged out.");
		}
		else {
			jLogoutMessage.setText("");
		}
		
		setVisible(true);
	}
	
	public void HideLogIn() {
		setVisible(false);
	}
	
	public String getID() {
		return userID;
	}
	
    public Login() {
    	setPreferredSize(new Dimension(330, 200));
    	
        initComponents();
        
        ShowLogIn(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	jPanelTop = new javax.swing.JPanel();
        jLogoutMessage = new javax.swing.JLabel();
        jLogoutMessage.setText("You have successfully logged out.");
        new javax.swing.JLabel();
        LoginPanel = new javax.swing.JPanel();
        StoreKeeperLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtUserPassword = new JPasswordField();
        Login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("University Souvenir Store - Login");
        setAlwaysOnTop(true);
        setLocation(300, 200);

        jPanelTop.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLogoutMessage.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanelTop.setVisible(true);
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StoreKeeperLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        StoreKeeperLabel.setForeground(new java.awt.Color(0, 51, 255));
        StoreKeeperLabel.setText("Staff ID:");
        StoreKeeperLabel.setToolTipText("");

        PasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(0, 51, 255));
        PasswordLabel.setText("Password:");

        Login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Login.setForeground(new java.awt.Color(0, 51, 255));
        Login.setText("Login");
        
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        
        txtUserName.addKeyListener(new KeyAdapter(){
          public void keyPressed(KeyEvent e)
          {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
            	Login();
            }
          }
        });
        
        txtUserPassword.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e)
            {
              if (e.getKeyCode() == KeyEvent.VK_ENTER)
              {
              	Login();
              }
            }
          });
        
        jLogoutMessage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLogoutMessage.setForeground(new java.awt.Color(255, 51, 102));
        //jLogoutMessage.setText("logoutStatus");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanelLayout.setHorizontalGroup(
        	LoginPanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(LoginPanelLayout.createSequentialGroup()
        			.addGroup(LoginPanelLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(LoginPanelLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(Login, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
        				.addGroup(LoginPanelLayout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jLogoutMessage, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        					.addGroup(LoginPanelLayout.createSequentialGroup()
        						.addContainerGap()
        						.addGroup(LoginPanelLayout.createParallelGroup(Alignment.LEADING)
        							.addComponent(StoreKeeperLabel)
        							.addComponent(PasswordLabel))
        						.addGap(18)
        						.addGroup(LoginPanelLayout.createParallelGroup(Alignment.LEADING)
        							.addComponent(txtUserPassword)
        							.addComponent(txtUserName, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))))
        			.addContainerGap())
        );
        LoginPanelLayout.setVerticalGroup(
        	LoginPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(LoginPanelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLogoutMessage, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(LoginPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(StoreKeeperLabel)
        				.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(14)
        			.addGroup(LoginPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(PasswordLabel)
        				.addComponent(txtUserPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(Login, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        LoginPanel.setLayout(LoginPanelLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(LoginPanel, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(LoginPanel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(31, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                          

    private void Login(){
    	String storeKeeperName = txtUserName.getText();
		String password=txtUserPassword.getText();
		try
		{
			if(Store.getInstance().getMgrStoreKeeper().checkPassword(storeKeeperName, password))
			{
				userID = storeKeeperName;
				SubjectManager.getInstance().Update("Top", "Login", "Success");
			}
			else{
				JOptionPane.showMessageDialog(getRootPane(),"Login Failed!","Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(getRootPane(),ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		finally{
			txtUserName.setText("");
			txtUserPassword.setText("");
			txtUserName.requestFocus();
		}
    }
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {    
    	Login();
    }                                     

    // Variables declaration - do not modify                     
    private javax.swing.JButton Login;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel StoreKeeperLabel;
    private javax.swing.JTextField txtUserName;
    private JPasswordField txtUserPassword;
    private javax.swing.JLabel jLogoutMessage;
    private javax.swing.JPanel jPanelTop;
}
