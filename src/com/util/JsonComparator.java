package com.util;

import java.util.Comparator;

import net.sf.json.JSONObject;

/**
 * json 自定义比较类
 * @author Keeplingshi
 *
 */
public class JsonComparator implements Comparator<JSONObject> {

	String dateName = "";

	public JsonComparator(String dateName) {
		this.dateName = dateName;
	}

	@Override
	public int compare(JSONObject json1, JSONObject json2) {
		
		String date1 = json1.optString(dateName);
		String date2 = json2.optString(dateName);
		
		String[] s1=date1.split("%");
		String[] s2=date2.split("%");
		
		double d1=Double.parseDouble(s1[0]);
		double d2=Double.parseDouble(s2[0]);
		
		if (d1<d2) {
			return 1;
		} else if (d1>d2) {
			return -1;
		}
		return 0;
	}
}
