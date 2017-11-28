/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import webservice.DatingSiteWebServiceException_Exception;

/**
 *
 * @author MS-Laptop
 */
public class DataLoader {
    
    IDatingSite ds30;
    IDatingSite ds50;
    public static boolean dataSetInit;
    
    public DataLoader() {
        ds30 = new HttpManager();
        ds50 = new HttpManager();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws DatingSiteWebServiceException_Exception {
        //Load up testDataset
        if (!dataSetInit)
        {
            //load datingsite 30+ dataset
            DataSet30 d30 = new DataSet30(ds30);
            d30.registerUsers();

            //load datingsite 50+ dataset
            DataSet50 d50 = new DataSet50(ds50);
            d50.registerUsers();     
                        
            dataSetInit = true;
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testForInit(){
        System.out.println("Test to init db");
    }
}
