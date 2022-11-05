package com.gk.APITesting.Utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.gk.APITesting.SetUp.BaseTest;

public class DataUtil extends BaseTest{
	
	@DataProvider(name="data")
	public Object[][] getData() {
		String sheetname="validateCreateCustomer";
		
		int rows=excel.getRowCount(sheetname);
		int cols=excel.getColumnCount(sheetname);
		
		System.out.println("rows-->"+rows);
		System.out.println("columns-->"+cols);
		
		Object[][] data=new Object[rows-1][1];
		
		
		
		int i=0;
		for(int rownum=2;rownum<=rows;rownum++)
		{
			Hashtable<String,String> table =new Hashtable<String,String>();
			for(int colnum=0;colnum<cols;colnum++)
			{
				
				String testdata=excel.getCellData(sheetname, colnum,rownum );
				String colname=excel.getCellData(sheetname, colnum,1 );
			
				table.put(colname, testdata);
			}
			data[i][0]=table;
			i++;
		}
		
		return data;
	}

}
