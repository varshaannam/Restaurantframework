package com.test;
import org.testng.annotations.DataProvider;
import com.utilities.ExcelUtil;




public class DataSupplier {
	ExcelUtil	excelutil = new ExcelUtil();

	@DataProvider(name="waiter")
	public Object[][] datasupplierwaiter() {
		Object [][]data=new Object[2][4];
		data[0][0]= excelutil.readStringData("waiter_dataprovider", 2, 1);
		data[0][1]=excelutil.readStringData("waiter_dataprovider", 2, 2);
		data[0][2]=excelutil.readStringData("waiter_dataprovider", 2, 3);
		data[0][3]=excelutil.readStringData("waiter_dataprovider", 2, 4);
		data[1][0]=excelutil.readStringData("waiter_dataprovider", 3, 1);
		data[1][1]=excelutil.readStringData("waiter_dataprovider", 3, 2);
		data[1][2]=excelutil.readStringData("waiter_dataprovider", 3, 3);
		data[0][2]=excelutil.readStringData("waiter_dataprovider", 3, 4);
		return data;
		

}}



