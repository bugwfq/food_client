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

	//用来调用方法的类
	private DeskManager manager = new DeskManager();
	private String lineNumber = "6";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应的字符集
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//查看请求的方方法
		String service = request.getParameter("method");
		//如果是查看
		if(service.equals("select")){
			//查看是否是模糊查找
			String name = request.getParameter("name");
			//查看当前页
			String curPage = request.getParameter("curPage");
			//查看是否指定了每页的条数
			if(request.getParameter("lineNumber")!=null){
				//如果有则覆盖该值 没有则使用默认
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
