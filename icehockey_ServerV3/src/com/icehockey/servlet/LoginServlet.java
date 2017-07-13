package com.icehockey.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// 构造方法
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 初始化方法
	@Override
	public void init() throws ServletException {
		super.init();
	}

	// 销毁方法
	public void destory() {
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		/**
		 * response.getWriter();
		 * 获取了一个输出流 输出的对象是页面 
		 * 这就像System.out.print（）一样 
		 * 只不过这个输出对象的是命令提示符窗口  他们都是包装好的 实际用输出流时 之前应该指向一个文件的
		 * 
		 * */
        PrintWriter out = response.getWriter();

        //拿到$("#editform").serialize();
        String jsonString =getStringFromReq(request) ;
        System.out.println("jsonString..."+jsonString);

        //通过拿到的querystring转换为map
        HashMap<String, Object> map = getMapFromQueryString(jsonString);

        //将转换得到的map转换为json并返回
        ObjectMapper objectMapper = new ObjectMapper();
        String resultJson = objectMapper.writeValueAsString(map);
        //此处直接返回JSON object对象，JSP可直接使用data.key
        System.out.println("resultJson ..."+resultJson);

//      resultJson = resultJson.replace("\"", "\\\"");
//      resultJson = "\""+resultJson+"\"";
        //此处返回JSON 字符串 string对象;JSP需要解析才能使用data.key
//      System.out.println("resultJson ..."+resultJson);

        out.print(resultJson);
        out.flush();
        out.close();
    }


    public String getStringFromReq(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();  
        try {
            BufferedReader reader = request.getReader();
            char[]buff = new char[1024];  
            int len;  
            while((len = reader.read(buff)) != -1) {
                sb.append(buff,0, len);  
            }  
        }catch (IOException e) {  
                 e.printStackTrace();  
        }  
        String resultString = sb.toString();

        return resultString;

    }

    public HashMap<String, Object> getMapFromQueryString(String queryString) {

        HashMap map = new HashMap<String, String>();
        String[] qStrings = queryString.split("&");
        for (String string : qStrings) {
            String[] qStrings2 = string.split("=");
            map.put(qStrings2[0], qStrings2[1]);
        }

        return map;

    }

}
