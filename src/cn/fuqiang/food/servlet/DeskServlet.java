package cn.fuqiang.food.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fuqiang.food.service.imp.DeskManager;
import cn.fuqiang.food.utilities.PageTools;

/**
 * Servlet implementation class DeskServlet
 */
public class DeskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//�������÷�������
	private DeskManager manager = new DeskManager();
	private String lineNumber = "6";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ���ַ���
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//�鿴����ķ�����
		String service = request.getParameter("method");
		//����ǲ鿴
		if(service.equals("select")){
			//�鿴�Ƿ���ģ������
			String name = request.getParameter("name");
			//�鿴��ǰҳ
			String curPage = request.getParameter("curPage");
			//�鿴�Ƿ�ָ����ÿҳ������
			if(request.getParameter("lineNumber")!=null){
				//������򸲸Ǹ�ֵ û����ʹ��Ĭ��
				lineNumber = request.getParameter("lineNumber");
			}
			
			PageTools pageTools = manager.getPageTools(name, curPage, lineNumber );
			request.setAttribute("pageTools", pageTools);
			request.getRequestDispatcher("/detail/boardList.jsp").forward(request, response);
			return;
		}else if(service.equals("update")){
			
		}else if(service.equals("delete")){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
