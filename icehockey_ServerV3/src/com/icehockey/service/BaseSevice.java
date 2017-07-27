package com.icehockey.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BaseSevice {

	public String getStringFromReq(HttpServletRequest request) {

		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = request.getReader();
			System.out.println("reader: " + reader);
			char[] buff = new char[1024];
			int len;
			while ((len = reader.read(buff)) != -1) {
				sb.append(buff, 0, len);
				System.out.println("buff: " + buff.toString());
			}
		} catch (IOException e) {
			System.out.println("报错啦");
			e.printStackTrace();
		}
		String resultString = sb.toString();
		System.out.println("resultString: " + resultString.length());
		return resultString;

	}

	public Map<String, Object> getMapFromQueryString(String queryString) {

		Map<String, Object> map = new HashMap<String, Object>();
		String[] qStrings = queryString.split("&");
		//System.out.println("qStrings" + qStrings[0]);

		for (String string : qStrings) {
			String[] qStrings2 = string.split("=");
			//System.out.println("qStrings2:  " + qStrings2[0] + ":" + qStrings2[1]);
			map.put(qStrings2[0], qStrings2[1]);
		}

		return map;

	}

}
