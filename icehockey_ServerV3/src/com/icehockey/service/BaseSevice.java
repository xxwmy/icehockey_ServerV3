package com.icehockey.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

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
		System.out.println("qStrings" + qStrings[0]);

		for (String string : qStrings) {
			String[] qStrings2 = string.split("=");
			System.out.println("qStrings2:  " + qStrings2[0] + ":" + qStrings2[1]);
			map.put(qStrings2[0], qStrings2[1]);
		}

		return map;

	}

	public JSONObject receivePost(HttpServletRequest request) {

		// 读取请求内容
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			}
			System.out.println("sb: "+sb);
			// 将json字符串转换为json对象
			JSONObject json = JSONObject.fromObject(sb.toString());
			System.out.println("json: "+json);
			return json;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
