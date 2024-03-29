/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nus.iss.SE24PT8.universityStore.manager;

import edu.nus.iss.SE24PT8.universityStore.domain.Category;
import edu.nus.iss.SE24PT8.universityStore.domain.Product;
import edu.nus.iss.SE24PT8.universityStore.exception.BadProductException;
import edu.nus.iss.SE24PT8.universityStore.main.Store;
import edu.nus.iss.SE24PT8.universityStore.util.DataAdapter;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.TableModel;

/**
 *
 * @author misitesawn
 */
public class ProductManager {
    //test git

    private static ProductManager Instance = null;
    private ArrayList<Product> productList;

    private static CategoryManager categoryManager;
    
    private  static String[] inventoryCheckColumnNames = { "ProductID","ProdcutName", "Description" ,"Category Name" ,"Price"  ,"Quantity" ," Reorder Quantity (threshold) ", "Order Quantity" ,"Vendor" ,"Remark"};
    private  static String[] columnNames = { "Product Id", "ProdcutName", "BarCode " ,"Product Desc" ,"Category Name" ,"Price"  ,"Quantity" };

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public static ProductManager getInstance() {
        if (Instance == null) {
            Instance = new ProductManager();
        }
        return Instance;

    }

    /**
     * Read all product List from file Set each product Category
     *
     *
     */
    private ProductManager() {
        categoryManager = CategoryManager.getInstance();
        productList = new ArrayList<>();
        productList = DataAdapter.loadProducts();
        setProductCategory();

    }

    /**
     * Set Category of each Products
     *
     *
     */
    private void setProductCategory() {

        Category category;
        Iterator<Product> i = productList.iterator();
        while (i.hasNext()) {
            Product product = i.next();
            if (product.getCategory() == null) {
                category = categoryManager.getCategory(product.getCategoryCode());
                product.setCategory(category);
            }
        }
    }

    /**
     * Add new Product to ProductList
     *
     * @param product
     * @throws Exception 
     *
     */
	public void addNewProduct(String productNmae, String briefDesp, int qty, double price, String barCode,
			int reorderQty, int orderQty, String categoryCode) throws Exception {
		// new Product(productId, productName, briefDesp, 0, 0, barcode, 0, 0);
		Product product;
		Category category;
		category = categoryManager.getCategory(categoryCode);

		if (category == null) {
			throw new BadProductException("Error to get Product Category during operation!");
		}

		String productId = categoryCode + "/" + Integer.toString(getProductCountInCategory(category) + 1);

		product = new Product(productId, productNmae, briefDesp, qty, price, barCode, reorderQty, orderQty, category);
		productList.add(product);

		saveData();

	}
    
    
    /**
     * @param prodcutID
     * @param briefDescp
     * @param qty
     * @param price
     * @param barCode
     * @param reorderQty
     * @param orderQty
     * @param categoryCode
     * @return
     * 
     *Assumption: ProdcutName and BarCode cannot be modified
     * @throws Exception 
     */
    public void editProduct(String barCode,String briefDescp, int qty, double price,int reorderQty, int orderQty, String categoryCode) throws Exception{
    	Product product = Store.getInstance().getMgrProduct().getProductByBarcode(barCode);
    	if ( product == null){
    		throw new BadProductException("Can not retrive prodcut information.");
    	}
    	
        Category category;
		category = categoryManager.getCategory(categoryCode);

		if (category == null) {
			throw new BadProductException("Category Eror during operation!");
		}

		product.setQty(qty);
		product.setBriefDesp(briefDescp);
		product.setPrice(price);
		product.setReorderQty(reorderQty);
		product.setReorderQty(reorderQty);
		product.setOrderQty(orderQty);
		product.setCategory(category);
		

		saveData();
    }
    
	public void orderProdcut(Product product, int orderQty) throws BadProductException{
		product.setQty(product.getQty() + orderQty);
		saveData();

	}
    
    /**
     * Get the number of products in a Category
     * @reuturn Product Count 
     * @param category
     */
    public int getProductCountInCategory(Category category){
        int count = 0;
        if ( getProductsByCategory(category).size() > 0) 
               count = getProductsByCategory(category).size();
        return count;
    }

    /**
     * Write Product To File
     * Must call after add, update, delete product item
     *
     */
    public void saveData() {
        DataAdapter.writeProducts(productList);
    }

    /**
     * Get all products in a Category
     *
     * @param category
     * @return Products
     */
    public ArrayList<Product> getProductsByCategory(Category category) {

        ArrayList<Product> products = new ArrayList<>();
        Iterator <Product> i = productList.iterator();
        while (i.hasNext()){
            Product product  = i.next();
            //need to test equals methods
            if (product.getCategory().equals(category)){
                products.add(product);
            }
        }
        return products;
    }

    /**
     * Return boolean check if the bar code already exists
     *
     * @param barcode
     * @return boolean
     */
    public boolean isvalidBarCode(String barcode) {
        Iterator<Product> i = productList.iterator();
        while (i.hasNext()) {
            Product product = i.next();
            if (product.getBarcode().equalsIgnoreCase(barcode)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Return boolean check if the bar code already exists
     *
     * @param barcode
     * @return boolean
     */
//    public Product getProduct(String barcode) {
//
//        Iterator<Product> i = this.productList.iterator();
//        while (i.hasNext()) {
//            Product product = i.next();
//            if (product.getBarcode().equalsIgnoreCase(barcode)) {
//                return product;
//            }
//        }
//
//        return null;
//    }
    
    
    public Product getProductByID(String producID){
        for(Product product:productList){
            if(product.getProductId().equalsIgnoreCase(producID)){
                return product;
            }
        }
        return null;
    }//end get PRoductby ID
    
    public Product getProductByBarcode(String barcode){
        for(Product product:productList){
            if(product.getBarcode().equalsIgnoreCase(barcode)){
                return product;
            }
        }
        return null;
    }
    

    /**
     * Return List of Product that have lower inventory quantity
     *
     * @return Product List
     */
    public ArrayList<Product> getLowerInventoryProducts() {
        ArrayList<Product> lowerInventoroyProducts = new ArrayList<>();
        Iterator<Product> i = this.productList.iterator();
        while (i.hasNext()) {
            Product product = i.next();
            if (product.getQty() <= product.getReorderQty()) {
                lowerInventoroyProducts.add(product);
            }
        }

        return lowerInventoroyProducts;
    }

    /**
     * Return List of Product that have lower inventory quantity
     * Call by Transaction during checkout
     * @param productList
     * @return Product List
     */
    public ArrayList<Product> getLowerInventoryProducts(ArrayList<Product> productList) {
        ArrayList<Product> lowerInventoroyProducts = new ArrayList<>();
        Iterator<Product> i = productList.iterator();
        while (i.hasNext()) {
            Product product = i.next();
            if (product.getQty() <= product.getReorderQty()) {
                lowerInventoroyProducts.add(product);
            }
        }

        return lowerInventoroyProducts;
    }

    
     public String[] getProductTableHeader(){
    	 return columnNames;
     }
     
     
     
     //All Products
     //public Object[][] prepareProductTableModel() {
 	//	ArrayList<Product> list = getProductList();
 	//	return prepareProductTableModel(list);
    // }
     
     
     public Object[][] prepareProductTableModel() {
  		Object[][] tableData = new Object[productList.size()][3];
  		for (int i = 0; i < productList.size(); i++) {
  			Product product = productList.get(i);
  			Object[] rowData = new Object[9];
  			rowData[0] = product.getProductId();
  			rowData[1]  = product.getProductName();
  			rowData[2] = product.getBriefDesp();
  			rowData[3] = product.getCategory().getCategoryName();
  			rowData[4] = product.getQty();
  			rowData[5] = product.getPrice();
  			rowData[6] = product.getBarcode();
  			rowData[7] = product.getReorderQty();
  			rowData[8] = product.getOrderQty();
  			tableData[i] = rowData;
  		}
  		return tableData;
  	}
     
     public Object[][] getLowInventoryProdcutTableModel() {
    	 ArrayList<Product> prodcuts = getLowerInventoryProducts();
   		Object[][] tableData = new Object[prodcuts.size()][3];
   		for (int i = 0; i < prodcuts.size(); i++) {
   			Product product = prodcuts.get(i);
   			Object[] rowData = new Object[10];
   			rowData[0] = product.getProductId();
   			rowData[1] = product.getProductName();
   			rowData[2] = product.getBriefDesp();
   			rowData[3] = product.getCategory().getCategoryName();
   			rowData[4] = product.getPrice();
   			rowData[5] = product.getQty();
   			rowData[6] = product.getReorderQty();
   			rowData[7] = product.getOrderQty();
   			if ( product.getCategory().getVendorList().size() >=1 ){
   				rowData[8] = product.getCategory().getVendorList().get(0);
   				rowData[9] = "";
   			}
   			else {
   				rowData[8] = "NA";
   				rowData[9] = "Add Vendor for Prodcut Category First";
   			}
   			
   			tableData[i] = rowData;
   		}
   		return tableData;
   	}
     

	public String[] getInventoryCheckTableHeader() {
		return inventoryCheckColumnNames;
	}

	public void orderAllLowInventoryProdcut() throws BadProductException{
		if(  getLowerInventoryProducts().size() >=1) {
			for (Product product : getLowerInventoryProducts()) {
				int orderno= product.getOrderQty() + product.getQty();
				product.setQty(orderno);
				saveData();
			}
		}
		
			
	}
}
