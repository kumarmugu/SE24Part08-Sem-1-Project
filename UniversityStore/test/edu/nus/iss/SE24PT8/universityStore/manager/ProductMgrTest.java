package edu.nus.iss.SE24PT8.universityStore.manager;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.nus.iss.SE24PT8.universityStore.domain.Category;
import edu.nus.iss.SE24PT8.universityStore.domain.Product;
import edu.nus.iss.SE24PT8.universityStore.exception.BadProductException;
import edu.nus.iss.SE24PT8.universityStore.util.Constants;
import junit.framework.TestCase;

public class ProductMgrTest extends TestCase{
	ProductManager pordMgr  = null;
	CategoryManager catMgr = null;
	
	Category cat1  = null;
	public ProductMgrTest(){
		
	}
	@Before
	public void setUp()  {
		pordMgr = ProductManager.getInstance();
		catMgr = CategoryManager.getInstance();
		
		try{
			cat1 = catMgr.getCategories().get(1);
		}catch (NullPointerException e){
		}
	}

	@After
	public void tearDown() throws IOException {
		pordMgr = null;
		catMgr = null;
	}

	@Test
	public void testProdcutMgrInstance() {
		ProductManager mgr1 = ProductManager.getInstance();
		ProductManager mgr2 = ProductManager.getInstance();
		assertFalse(mgr1 == null);
		assertFalse(mgr2 == null);
		assertTrue(mgr1.equals(mgr2)); // Singleton test
	}
	 @Test
	    public void testaddProdcutTest(){
	        
	        Product prod1  = new Product();
	        int oriProdSize = pordMgr.getProductList().size();
	        int catProdcutCnt = pordMgr.getProductCountInCategory(cat1);
	        
	        try {
				pordMgr.addNewProduct("Air Tight Coffee", "Air Tight Coffee Cup", 20, 25, "BAR1", 50, 20, cat1.getCategoryCode());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        prod1 = pordMgr.getProductList().get(pordMgr.getProductList().size()-1);
	        assertTrue( prod1.getProductId().equalsIgnoreCase(cat1.getCategoryCode()+"/"+ String.valueOf(catProdcutCnt +1) ));
	        
	       try{
	    	   pordMgr.addNewProduct("Air Tight Coffee", "Air Tight Coffee Cup", 20, 25, "BAR2", 50, 20, cat1.getCategoryCode());
	    	   catProdcutCnt ++;
	       }catch(BadProductException e){
	    	    fail();
	       }catch (Exception e){
	    	   e.printStackTrace();
	       }
	       
			try {

				pordMgr.addNewProduct("Air Tight Coffee", "Air Tight Coffee Cup", 20, 25, "BAR3", 50, 20,
						cat1.getCategoryCode());
				prod1 = pordMgr.getProductList().get(oriProdSize + 1);
				System.out.println(prod1.getProductId());
				assertTrue(prod1.getProductId()
						.equalsIgnoreCase(cat1.getCategoryCode() + "/" + String.valueOf(catProdcutCnt+1)));
			} catch (Exception e) {
				e.printStackTrace();
			}
	    
	    }
	 }
