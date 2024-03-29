/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nus.iss.SE24PT8.universityStore.gui.mainWindow;
import edu.nus.iss.SE24PT8.universityStore.gui.components.DiscountPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.components.MemberPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.components.ProductPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.components.StoreKeeperPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.components.Checkout.CheckInventoryPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.components.Checkout.CheckoutPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.components.category.CategoryPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.components.report.ReportPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.components.vendor.VendorPanel;
import edu.nus.iss.SE24PT8.universityStore.gui.framework.SubjectManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;


/**
 * MainWindow to host all sub panels
 * 
 * @author SE24PT8
 */
public class MainWindow extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer = null;
    private JPanel currentView = null;
    private ProductPanel productView = null;
    private CategoryPanel catView = null;
    private VendorPanel vendorView = null;
    private DiscountPanel discountView = null;
    private CheckoutPanel checkoutView = null; 
    private ReportPanel reportView = null;
    private MemberPanel memberView = null;
    private StoreKeeperPanel storeKeeperView= null;
    private static MainWindow instance;
    
    private static CheckInventoryPanel inventoryView  = null;
   
    public void ShowMainWindow(String storeKeeperName ){
    	jLabelStoreKeeperName.setText(storeKeeperName);
    	jToggleButtonCheckOut.setSelected(true);
        jToggleButtonCheckOutActionPerformed(null);
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - instance.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - instance.getHeight()) / 2);
        instance.setLocation(x, y);
    	setVisible(true);
    }
    
    public void HideMainWindow() {
    	setVisible(false);
    }
    
    /**
     * Creates new form MainWindow
     */
    private MainWindow() {
    	setPreferredSize(new Dimension(980, 580));
        
        setLookAndFeel("Nimbus");

        initComponents();

        setButtonGroupForLeftMenu(); 
        
        initialiseTimer();
                
        SubjectManager.getInstance().addSubject("MainWindow", "MenuClicked");        
    }

    public static MainWindow getInstance() {
        if(instance == null){
            instance = new MainWindow();
            
        }
        return instance;
	}
    /**
     * To Switch to the new view
     *  1. hide the current view
     *  2. switch to the new view
     * @param newView 
     */
    private void switchView(JPanel newView) {
        jPanelDock.setVisible(false);
        if (currentView != null) {
            jPanelDock.remove(currentView);
        }
        jPanelDock.add(newView);
        currentView = newView;
        jPanelDock.setVisible(true);        
    }

    /**
     * For UI Look and feel to Nimbus
     * @param theLookAndFeel "Nimbus"
     */
    private void setLookAndFeel(String theLookAndFeel)
    {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (theLookAndFeel.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setButtonGroupForLeftMenu(){
        buttonGroup.add(jToggleButtonCheckOut);
        buttonGroup.add(jToggleButtonMembers);
        buttonGroup.add(jToggleButtonProducts);
        buttonGroup.add(jToggleButtonCategories);
        buttonGroup.add(jToggleButtonVendors);
        buttonGroup.add(jToggleButtonDiscounts);
        buttonGroup.add(jToggleButtonStoreKeepers);
        buttonGroup.add(jToggleButtonReport);
        buttonGroup.add(jToggleButtonCheckInventory);
        buttonGroup.add(jToggleButtonLogOut);
    }
    
    /**
     * initialize timer for Timer update
     */
    private void initialiseTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
          @Override
          public void run() {
            jLabelTime.setText( new SimpleDateFormat("dd MMMM, yyyy HH:mm:ss").format(new Date()));
          }
        }, 0, 1000 ); // Infinite loop with 1 sec interval
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new ButtonGroup();
        jPanelTop = new JPanel();
        jLabel1 = new JLabel();
        jLabelTime = new JLabel();
        jLabelStoreKeeperName = new JLabel();
        jScrollPaneLeft = new JScrollPane();
        jPanelLeft = new JPanel();
        jToggleButtonCheckOut = new JToggleButton();
        jToggleButtonMembers = new JToggleButton();
        jToggleButtonProducts = new  JToggleButton();
        jToggleButtonCheckInventory = new JToggleButton();
        jToggleButtonCategories = new javax.swing.JToggleButton();
        jToggleButtonVendors = new javax.swing.JToggleButton();
        jToggleButtonDiscounts = new javax.swing.JToggleButton();
        jToggleButtonStoreKeepers = new javax.swing.JToggleButton();
        jToggleButtonReport = new JToggleButton();
        jToggleButtonLogOut = new JToggleButton();
        jPanelMain = new JPanel();
        jScrollPaneMain = new JScrollPane();
        jPanelDock = new JPanel();
        jScrollPaneBottom = new JScrollPane();
        jPanelStatus = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("University Souvenir Store Application");
        setLocation(300, 200);

        jPanelTop.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("University Souvenir Store");

        jLabelTime.setText("09 April, 2016  09:10:21 AM");

        jLabelStoreKeeperName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelStoreKeeperName.setText("StoreKeeper Name");
        
        JLabel lblUser = new JLabel("Welcome ");

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTopLayout.setHorizontalGroup(
        	jPanelTopLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanelTopLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanelTopLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabelTime)
        				.addGroup(jPanelTopLayout.createSequentialGroup()
        					.addComponent(lblUser)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabelStoreKeeperName)))
        			.addPreferredGap(ComponentPlacement.RELATED, 527, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addContainerGap())
        );
        jPanelTopLayout.setVerticalGroup(
        	jPanelTopLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanelTopLayout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(jPanelTopLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanelTopLayout.createSequentialGroup()
        					.addGroup(jPanelTopLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabelTime))
        					.addGap(19))
        				.addGroup(Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
        					.addGroup(jPanelTopLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabelStoreKeeperName)
        						.addComponent(lblUser))
        					.addContainerGap())))
        );
        jPanelTop.setLayout(jPanelTopLayout);

        jScrollPaneLeft.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneLeft.setMinimumSize(new Dimension(23, 200));

        jToggleButtonCheckOut.setText("Checkout");
        jToggleButtonCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCheckOutActionPerformed(evt);
            }
        });

        jToggleButtonMembers.setText("Members");
        jToggleButtonMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonMembersActionPerformed(evt);
            }
        });


        jToggleButtonProducts.setText("Products");
        jToggleButtonProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonProductsActionPerformed(evt);
            }
        });
        
        
        //check inventory
        jToggleButtonCheckInventory.setText("Inventory");
        jToggleButtonCheckInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCheckInventoryActionPerformed(evt);
            }
        });

        jToggleButtonCategories.setText("Categories");
        jToggleButtonCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCategoriesActionPerformed(evt);
            }
        });

        jToggleButtonVendors.setText("Vendors");
        jToggleButtonVendors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jToggleButtonVendorsActionPerformed(evt);
            }
        });

        jToggleButtonDiscounts.setText("Discounts");
        jToggleButtonDiscounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonDiscountsActionPerformed(evt);
            }
        });

        jToggleButtonStoreKeepers.setText("Store Keepers");
        jToggleButtonStoreKeepers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	jToggleButtonStoreKeepersActionPerformed(evt);
        }
        });
		jToggleButtonReport.setText("Report");
        jToggleButtonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonReportsActionPerformed(evt);
            }
        });

        jToggleButtonLogOut.setText("Log Out");
        jToggleButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonLogOutActionPerformed(evt);
            }
        });

        jScrollPaneLeft.setViewportView(jPanelLeft);
        GroupLayout gl_jPanelLeft = new GroupLayout(jPanelLeft);
        gl_jPanelLeft.setHorizontalGroup(
        	gl_jPanelLeft.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelLeft.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelLeft.createParallelGroup(Alignment.LEADING)
        				.addComponent(jToggleButtonCheckOut, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonMembers, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonProducts, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonCategories, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonVendors, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonDiscounts, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonStoreKeepers, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonReport, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonCheckInventory, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButtonLogOut, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_jPanelLeft.setVerticalGroup(
        	gl_jPanelLeft.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelLeft.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jToggleButtonCheckOut)
        			.addGap(7)
        			.addComponent(jToggleButtonMembers)
        			.addGap(6)
        			.addComponent(jToggleButtonProducts)
        			.addGap(6)
        			.addComponent(jToggleButtonCategories)
        			.addGap(6)
        			.addComponent(jToggleButtonVendors)
        			.addGap(6)
        			.addComponent(jToggleButtonDiscounts)
        			.addGap(6)
        			.addComponent(jToggleButtonStoreKeepers)
        			.addGap(6)
        			.addComponent(jToggleButtonReport)
        			.addGap(6)
        			.addComponent(jToggleButtonCheckInventory)
        			.addGap(39)
        			.addComponent(jToggleButtonLogOut)
        			.addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelLeft.setLayout(gl_jPanelLeft);

        jPanelDock.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPaneMain.setViewportView(jPanelDock);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneMain)
        );

        jPanelStatus.setPreferredSize(new java.awt.Dimension(641, 10));
        
        JLabel lblDevelopers = new JLabel("developed by SE24PT8");

        javax.swing.GroupLayout jPanelStatusLayout = new javax.swing.GroupLayout(jPanelStatus);
        jPanelStatusLayout.setHorizontalGroup(
        	jPanelStatusLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanelStatusLayout.createSequentialGroup()
        			.addContainerGap(891, Short.MAX_VALUE)
        			.addComponent(lblDevelopers)
        			.addContainerGap())
        );
        jPanelStatusLayout.setVerticalGroup(
        	jPanelStatusLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanelStatusLayout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(lblDevelopers)
        			.addContainerGap())
        );
        jPanelStatus.setLayout(jPanelStatusLayout);

        jScrollPaneBottom.setViewportView(jPanelStatus);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(5)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jPanelTop, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(jScrollPaneLeft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jPanelMain, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)))
        					.addGap(10))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(jScrollPaneBottom, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(jPanelTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(6)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanelMain, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        				.addComponent(jScrollPaneLeft, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPaneBottom, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCheckOutActionPerformed
       if (checkoutView == null) {
    		checkoutView = new CheckoutPanel();
        }
        switchView(checkoutView);
        SubjectManager.getInstance().Update("MainWindow", "MenuClicked", "Checkout");
    }//GEN-LAST:event_jToggleButtonCheckOutActionPerformed
    
    //check inventory
    private void jToggleButtonCheckInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonProductsActionPerformed
        if (inventoryView == null) {
        	inventoryView = new CheckInventoryPanel();
        }
        switchView(inventoryView);
        SubjectManager.getInstance().Update("MainWindow", "MenuClicked", "CheckInventory");
    } 
    
    
    private void jToggleButtonProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonProductsActionPerformed
        if (productView == null) {
            productView = new ProductPanel();
        }
        switchView(productView);
        SubjectManager.getInstance().Update("MainWindow", "MenuClicked", "Product");
    }//GEN-LAST:event_jToggleButtonProductsActionPerformed

    
    private void jToggleButtonReportsActionPerformed(java.awt.event.ActionEvent evt) {
    	if (reportView == null) {
    		reportView = new ReportPanel();
        }
        switchView(reportView);
    }
    
    private void jToggleButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonLogOutActionPerformed
    	SubjectManager.getInstance().Update("Top", "MainWindow", "LogOut");
    }//GEN-LAST:event_jToggleButtonLogOutActionPerformed

    private void jToggleButtonCategoriesActionPerformed(ActionEvent evt) {

    	if (catView == null) {
    		catView = new CategoryPanel();
        }
        switchView(catView);
        SubjectManager.getInstance().Update("MainWindow", "MenuClicked", "Categories");
    }
    private void jToggleButtonVendorsActionPerformed(ActionEvent evt) {
    	if (vendorView == null) {
    		vendorView = new VendorPanel();
        }
        switchView(vendorView);
        SubjectManager.getInstance().Update("MainWindow", "MenuClicked", "Vendors");
    }
       
	private void jToggleButtonDiscountsActionPerformed(ActionEvent evt) {
		if (discountView == null) {
			discountView = new DiscountPanel();
		    SubjectManager.getInstance().Update("MainWindow", "MenuClicked", "Discount");
		}
	switchView(discountView);
        
        
    }//GEN-LAST:event_jToggleButtonCategoriesActionPerformed

    private void jToggleButtonMembersActionPerformed(ActionEvent evt) {
    	if (memberView == null) {
    		memberView = new MemberPanel();
        }
        switchView(memberView);
        SubjectManager.getInstance().Update("MainWindow", "MenuClicked", "Members");
    }
    
    private void jToggleButtonStoreKeepersActionPerformed(ActionEvent evt) {
    	if (storeKeeperView == null) {
    		storeKeeperView = new StoreKeeperPanel();
        }
        switchView(storeKeeperView);
        SubjectManager.getInstance().Update("MainWindow", "MenuClicked", "StoreKeepers");
    }
    
  	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelStoreKeeperName;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanelDock;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelStatus;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPaneBottom;
    private javax.swing.JScrollPane jScrollPaneLeft;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JToggleButton jToggleButtonCategories;
    private javax.swing.JToggleButton jToggleButtonCheckOut;
    private javax.swing.JToggleButton jToggleButtonDiscounts;
    private javax.swing.JToggleButton jToggleButtonLogOut;
    private javax.swing.JToggleButton jToggleButtonMembers;
    private javax.swing.JToggleButton jToggleButtonProducts;
    private javax.swing.JToggleButton jToggleButtonCheckInventory;
    private javax.swing.JToggleButton jToggleButtonReport;
    private javax.swing.JToggleButton jToggleButtonStoreKeepers;
    private javax.swing.JToggleButton jToggleButtonVendors;
}
