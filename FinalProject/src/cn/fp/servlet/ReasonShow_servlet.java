package cn.fp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.fp.Fclass.Back_data;
import cn.fp.dao.impl.ReasonDAOImpl;


/**
 * Servlet implementation class ReasonShow_servlet
 */
public class ReasonShow_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReasonShow_servlet() {
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
		String cat =  request.getParameter("cat");
		String Cat = "��������";
		if(cat != "") {
			Cat = cat;
		}
		List<Back_data> list = new ArrayList<Back_data>();
		ReasonDAOImpl dao = new ReasonDAOImpl();
		list = dao.getOne(Cat);
		
		ObjectMapper mapper = new ObjectMapper(); //�ṩjava-json�໥ת�����ܵ���
		String json = mapper.writeValueAsString(list); //��list�еĶ���ת��ΪJson��ʽ������
		//System.out.println(json);
		//��json���ݷ��ظ��ͻ���
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