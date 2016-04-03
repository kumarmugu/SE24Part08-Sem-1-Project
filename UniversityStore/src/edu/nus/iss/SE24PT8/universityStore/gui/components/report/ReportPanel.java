package edu.nus.iss.SE24PT8.universityStore.gui.components.report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.GroupLayout.Group;
import javax.swing.table.DefaultTableModel;

import edu.nus.iss.SE24PT8.universityStore.gui.common.BaseTable;
import edu.nus.iss.SE24PT8.universityStore.gui.framework.INotificable;
import edu.nus.iss.SE24PT8.universityStore.gui.framework.SubjectManager;
import edu.nus.iss.SE24PT8.universityStore.main.Store;
import edu.nus.iss.SE24PT8.universityStore.util.Constants;
import edu.nus.iss.SE24PT8.universityStore.util.Item;
/**
*
* @author Mugunthan
*/
public class ReportPanel extends JPanel implements INotificable {

	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JScrollPane reportPane;
	private Store manager = Store.getInstance();
	private JComboBox<Item<String>> reportTypes;
	private DefaultTableModel dataModel;
	
	private static final String CAT_LIST = "catList";
	private static final String PRODUCT_LIST = "productList";
	private static final String TXN_LIST = "txnList";
	private static final String MEMBER_LIST = "memList";
	
	public ReportPanel() {
		super();
		SubjectManager.getInstance().addNotification("ReportPanel", "Report", this);
		initComponents();
	}
	
	protected void initComponents() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent) this);
			this.setLayout(thisLayout);
			setLocation(500, 500);
			this.setPreferredSize(new java.awt.Dimension(500, 491));
			titleLabel = new JLabel();
			titleLabel.setText("Reports");
			titleLabel.setVerifyInputWhenFocusTarget(false);
			titleLabel.setForeground(Constants.STORE_APP_TITLE_COLOR);
			titleLabel.setFont(Constants.STORE_APP_TITLE_FONT);

			JLabel reportTypeLabel = new JLabel();
			reportPane = new JScrollPane();
			reportTypeLabel.setText("Report Types");
			reportTypes = new JComboBox<Item<String>>();
			reportTypes.addActionListener (new ActionListener () {
			    public void actionPerformed(ActionEvent e) {
			    	Item reportType = (Item)reportTypes.getSelectedItem();
			        populateData(reportType.getValue().toString());
			    }
			});
			addReportTypes();
			//JScrollPane dataPane = addList();
			Group group1 = thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(titleLabel,
					GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
					GroupLayout.PREFERRED_SIZE);
			Group reportGroup = thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(reportTypeLabel,
					GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
					GroupLayout.PREFERRED_SIZE).addComponent(reportTypes);

			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup().addContainerGap().addGroup(group1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(reportGroup).addGap(20).addComponent(reportPane, 0, 440, Short.MAX_VALUE));

			Group group3 = thisLayout.createSequentialGroup().addGap(102).addComponent(titleLabel,
					GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addGap(152);
			Group group4 = thisLayout.createSequentialGroup();
			Group hReportGroup = thisLayout.createSequentialGroup().addComponent(reportTypeLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(25).addComponent(reportTypes, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE);
			thisLayout.setHorizontalGroup(thisLayout.createParallelGroup()
					.addComponent(reportPane, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 500,
							GroupLayout.PREFERRED_SIZE)
					.addGroup(GroupLayout.Alignment.LEADING, group3).addGroup(GroupLayout.Alignment.CENTER, hReportGroup).addGroup(GroupLayout.Alignment.CENTER, group4));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void populateData(String reportType){
		if(reportType.equals(CAT_LIST)){
			String[] columnNames = { "Category Code", "Category Name" };
			Object[][] categories = manager.getMgrCategory().prepareCategoryTableModel();
			dataModel = new DefaultTableModel(categories, columnNames);
			dataModel.setDataVector(categories, columnNames);
			reportPane.setViewportView(new BaseTable(dataModel));			
		} else if (reportType.equals(PRODUCT_LIST)){
			String[] columnNames = { "Product Id", "Prodcut Name", "BarCode " ,"Product Desc" ,"Category Name" ,"Price" ,"Quantity" };
			Object[][] products = manager.getMgrProduct().prepareProductTableModel();
			dataModel = new DefaultTableModel(products, columnNames);
			dataModel.setDataVector(products, columnNames);
			reportPane.setViewportView(new BaseTable(dataModel));
			
		} else if (reportType.equals(TXN_LIST)){
			
		} else if (reportType.equals(MEMBER_LIST)){
			String[] columnNames = {"MemberName","MemberID"};
			Object[][] members = manager.getMgrMember().prepareMemberTableModel();
			dataModel = new DefaultTableModel(members, columnNames);
			dataModel.setDataVector(members, columnNames);
			reportPane.setViewportView(new BaseTable(dataModel));			
		}
	}
	
	private void addReportTypes() {
		Item<String> report1 = new Item<String>(CAT_LIST, "All Categories");
		Item<String> report2 = new Item<String>(PRODUCT_LIST, "All Products");
		Item<String> report3 = new Item<String>(TXN_LIST, "Transcations");
		Item<String> report4 = new Item<String>(MEMBER_LIST, "All Members");
		reportTypes.addItem(report1);
		reportTypes.addItem(report2);		
		reportTypes.addItem(report3);		
		reportTypes.addItem(report4);				
	}

	protected JScrollPane addList(){
		manager = Store.getInstance();
		{	
//			dataModel = new DefaultTableModel(categories, columnNames);
//			dataModel.setDataVector(categories, columnNames);
//			catList = new BaseTable(dataModel);
//			catPane.setViewportView(catList);
		}
		return reportPane;
	}

	@Override
	public void update(String group, String topic, String data) {
		// TODO Auto-generated method stub
		
	}

}