package com.excel;

import java.io.File;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;  

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;    
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDo {

	/**
	 * 根据流，存入文件
	 * @param request
	 * @return
	 */
	public static String doSave(HttpServletRequest request)
	{
		String filePath=request.getSession().getServletContext().getRealPath("/")+"cumtjobExcel/";
		File fileDir=new File(filePath);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
        	List<?> items = upload.parseRequest(request);
        	Iterator<?> it = items.iterator();
        	while (it.hasNext()) {
        		FileItem item = (FileItem) it.next();
        		if (!item.isFormField()) { 
        			filePath+=item.getName();
        			if (item.getName() != null && !item.getName().equals("")) {   
        				File file = new File(filePath);
        				item.write(file);
        			}
        		}
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return filePath;
	}
	
	/**
	 * 根据从excel中获取的数据，转换成写入数据库的数据格式
	 * @param path
	 */
	public static boolean saveData(List<ArrayList<String>> excelList)
	{
		HashMap<String, String> collegeMap=ExcelDo.getExcelCollegeMap();
		HashMap<String, String> majorMap=ExcelDo.getExcelMajorMap();
		
		for(ArrayList<String> arrayList:excelList)
		{
			if(arrayList.size()==9)
			{
				ExcelRate excelRate=new ExcelRate();
				excelRate.setCollege_dm(collegeMap.get(arrayList.get(0)));
				excelRate.setMajor_dm(majorMap.get(arrayList.get(1)));
				
				//分别为excel中对应数据
				int excelAllNum=Integer.parseInt(arrayList.get(2));	//毕业人数
				int excelUpSchool=Integer.parseInt(arrayList.get(3));	//升学
				int excelDirect=Integer.parseInt(arrayList.get(4));	//定向
				int excelAboard=Integer.parseInt(arrayList.get(5));	//出国
				int excelNibufen=Integer.parseInt(arrayList.get(6));	//拟不分
				int excelYijiao=Integer.parseInt(arrayList.get(7));	//已交
				int excelWeijiao=Integer.parseInt(arrayList.get(8));	//未交
				
				int promotion_num=excelUpSchool;
				int work_num=excelDirect+excelNibufen+excelWeijiao+excelYijiao;
				int abroad_num=excelAboard;
				int not_employed_num=excelAllNum-promotion_num-work_num-abroad_num;
				
				excelRate.setPromotion_num(promotion_num);
				excelRate.setWork_num(work_num);
				excelRate.setAbroad_num(abroad_num);
				excelRate.setNot_employed_num(not_employed_num);
				
				if(!excelRate.save()){
					return false;
				};
				
			}
		}
		
		return true;
	}
	
	
	/**
	 * 从excel中获取格式化的数据
	 * @param path
	 * @return
	 */
	public static List<ArrayList<String>> getData(String path)
	{
		File file=new File(path);
		if(!file.exists()){
			return null;
		}
		
		Workbook wb=null;
		try {
			InputStream inp = new FileInputStream(path);  
			wb = WorkbookFactory.create(inp);
		} catch (FileNotFoundException e) {  
			e.printStackTrace();  
		} catch (InvalidFormatException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}
		
		//excel取数据范围，第0-8列，第10-97行
		int columnNum = 9;  
		int rowNum=0;
		Sheet sheet = wb.getSheetAt(0); 
		
		//获取矿业学院在第多少行，从这里开始取数据
		for(Row row:sheet)
		{
			Cell cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);  
			cell.setCellType(Cell.CELL_TYPE_STRING);  
			String content=cell.getStringCellValue().trim();
			if("矿业".equals(content)){
				rowNum=row.getRowNum();
				break;
			}
		}
		
		List<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
		
		String zeroCollege="";
		for(int i=rowNum;i<=sheet.getLastRowNum();i++)
		{
			ArrayList<String> rowList=new ArrayList<String>();
			Row row=sheet.getRow(i);
			for(int j=0;j<columnNum;j++)
			{
				Cell cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK); 
				cell.setCellType(Cell.CELL_TYPE_STRING);  
				String content=cell.getStringCellValue().trim();
				if(j==0){
					if(!("".equals(content))){
						zeroCollege=content;
					}else{
						content=zeroCollege;
					}
				}
				if(j==1){
					content=content+""+i;
				}
				if("".equals(content)||content==null)
				{
					content="0";
				}
				rowList.add(content);
			}
			list.add(rowList);
		}
		return list;
	}
	
	public static HashMap<String, String> getExcelCollegeMap()
	{
		HashMap<String, String> collegeMap=new HashMap<String, String>();
		collegeMap.put("矿业", "1");
		collegeMap.put("安全", "2");
		collegeMap.put("力建", "3");
		collegeMap.put("机电", "4");
		collegeMap.put("信电", "5");
		collegeMap.put("资源", "6");
		collegeMap.put("化工", "7");
		collegeMap.put("环测", "8");
		collegeMap.put("电力", "9");
		collegeMap.put("材料", "10");
		collegeMap.put("理学院", "11");
		collegeMap.put("计算机", "12");
		collegeMap.put("管理", "13");
		collegeMap.put("文法", "14");
		collegeMap.put("马克思", "15");
		collegeMap.put("外文", "16");
		collegeMap.put("艺术", "17");
		collegeMap.put("体育", "18");
		collegeMap.put("孙越崎", "19");
		collegeMap.put("国际", "20");
		collegeMap.put("应用", "21");
		
		return collegeMap;
	}
	
	public static HashMap<String, String> getExcelMajorMap()
	{
		HashMap<String, String> majorMap=new HashMap<String, String>();
		majorMap.put("采矿工程10", "1");
		majorMap.put("工业工程11", "2");
		majorMap.put("交通运输12", "3");
		majorMap.put("研究生13", "79");
		majorMap.put("安全工程14", "4");
		majorMap.put("消防工程15", "5");
		majorMap.put("研究生16", "79");
		majorMap.put("建筑学17", "6");
		majorMap.put("土木工程18", "7");
		majorMap.put("建筑环境与设备工程19", "8");
		majorMap.put("工程管理20", "9");
		majorMap.put("工程力学21", "10");
		majorMap.put("研究生22", "79");
		majorMap.put("机械工程及自动化23", "11");
		majorMap.put("测控技术与仪器24", "12");
		majorMap.put("研究生25", "79");
		majorMap.put("电气工程与自动化26", "13");
		majorMap.put("信息工程27", "14");
		majorMap.put("电子科学与技术28", "15");
		majorMap.put("研究生29", "79");
		majorMap.put("地质工程30", "16");
		majorMap.put("水文与水资源工程31", "17");
		majorMap.put("资源环境与城乡规划管理32", "18");
		majorMap.put("地球物理学33", "19");
		majorMap.put("研究生34", "79");
		majorMap.put("化学工程与工艺35", "20");
		majorMap.put("矿物加工工程36", "21");
		majorMap.put("应用化学37", "22");
		majorMap.put("生物工程38", "23");
		majorMap.put("过程装备与控制工程39", "24");
		majorMap.put("能源化学工程40", "25");
		majorMap.put("研究生41", "79");
		majorMap.put("测绘工程42", "26");
		majorMap.put("环境工程43", "27");
		majorMap.put("环境科学44", "28");
		majorMap.put("土地资源管理45", "29");
		majorMap.put("地理信息系统46", "30");
		majorMap.put("研究生47", "79");
		majorMap.put("热能与动力工程48", "31");
		majorMap.put("研究生49", "79");
		majorMap.put("材料科学与工程50", "32");
		majorMap.put("材料成型及控制工程51", "33");
		majorMap.put("研究生52", "79");
		majorMap.put("数学与应用数学53", "34");
		majorMap.put("应用物理学54", "35");
		majorMap.put("信息与计算科学55", "36");
		majorMap.put("光信息科学与技术56", "37");
		majorMap.put("研究生57", "79");
		majorMap.put("计算机科学与技术58", "38");
		majorMap.put("电子信息科学与技术59", "39");
		majorMap.put("信息安全60", "40");
		majorMap.put("网络工程61", "41");
		majorMap.put("研究生62", "79");
		majorMap.put("会计学63", "42");
		majorMap.put("市场营销64", "43");
		majorMap.put("国际经济与贸易65", "44");
		majorMap.put("人力资源管理66", "45");
		majorMap.put("工商管理67", "46");
		majorMap.put("电子商务68", "47");
		majorMap.put("金融学69", "48");
		majorMap.put("研究生70", "79");
		majorMap.put("法学71", "49");
		majorMap.put("汉语言文学72", "50");
		majorMap.put("广播电视新闻学73", "51");
		majorMap.put("行政管理74", "52");
		majorMap.put("研究生75", "79");
		majorMap.put("研究生76", "53");
		majorMap.put("英语77", "54");
		majorMap.put("德语78", "55");
		majorMap.put("研究生79", "79");
		majorMap.put("音乐学80", "56");
		majorMap.put("艺术设计81", "57");
		majorMap.put("工业设计82", "58");
		majorMap.put("研究生83", "79");
		majorMap.put("体育教育84", "59");
		majorMap.put("社会体育85", "60");
		majorMap.put("营销高水平86", "61");
		majorMap.put("研究生87", "79");
		majorMap.put("本科88", "80");
		majorMap.put("本科89", "81");
		majorMap.put("采矿工程90", "72");
		majorMap.put("地质工程91", "73");
		majorMap.put("安全工程92", "74");
		majorMap.put("机械工程及自动化93", "75");
		majorMap.put("电气工程与自动化94", "76");
		majorMap.put("化学工程与工艺95", "77");
		majorMap.put("工商管理96", "78");

		
		return majorMap;
	}
	
}
