package cn.front.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.fp.Fclass.Back_data;
import cn.fp.dao.impl.FinancingDAOImpl;
 

/**
 * Servlet implementation class financing_mix_show
 */
public class financing_mix_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public financing_mix_show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		List<Back_data> list = new ArrayList<Back_data>();
		FinancingDAOImpl dao = new FinancingDAOImpl();
		list = dao.getmix();
		
		ObjectMapper mapper = new ObjectMapper(); //提供java-json相互转换功能的类
		String json = mapper.writeValueAsString(list); //将list中的对象转换为Json格式的数组
		//System.out.println(json);
		//将json数据返回给客户端
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
