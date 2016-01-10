package com.excel;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main();
	}
	
	public Main()
	{
		String path="C://Users//Keeplingshi//Desktop//excelFile//jobcount.xlsx";
		
		List<ArrayList<String>> excelList=ExcelDo.getData(path);
		ExcelDo.saveData(excelList); 
//		for(ExcelRate excelRate:excelRates)
//		{
//			System.out.println(excelRate.getCollege_dm()+"\t"+excelRate.getMajor_dm());
//		}
		
//		HashMap<String, String> collegeMap=BaseInfo.getCollegeMap();
//		HashMap<String, String> majorMap=BaseInfo.getMajorMap();
//		Iterator<Entry<String, String>> iter=majorMap.entrySet().iterator();
//		while(iter.hasNext()){
//			Map.Entry<String, String> entry= (Map.Entry<String, String>)iter.next();
//			Object key=entry.getKey();
//			Object value=entry.getValue();
//			System.out.println(key.toString()+"     "+value.toString());
//		}
		
		//System.out.println(majorMap.size());
		
//		List<String[]> collegeMajorList=BaseInfo.getCollegeAndMajorList();
//		for(int i=0;i<collegeMajorList.size();i++)
//		{
//			for(String s:collegeMajorList.get(i)){
//				System.out.print(s+"\t");
//			}
//			System.out.println();
//		}
//		
//		List<ArrayList<String>> excelList=ExcelDo.getData(path);
//		for(int i=0;i<excelList.size();i++)
//		{
//			//majorMap.put("采矿工程10", "1");
//			//System.out.println("majorMap.put(\""+excelList.get(i).get(1)+"\", \"\");");
//			System.out.println(excelList.get(i).get(0)+"\t"+excelList.get(i).get(1));
////			for(String s:excelList.get(i)){
////				System.out.print(s+"\t");
////			}
//			//System.out.println();
//		}
//		List<ExcelRate> excelRates=ExcelDo.changeData(excelList); 
	}
	


}
