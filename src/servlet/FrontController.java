package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.DeleteService;
import service.InsertService;
import service.ListService;
import service.ReadService;
import service.UpdateFormService;
import service.UpdateService;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");		
		
		BoardService service = null;
		String path = null;
		
		if(command.equals("/list.do")) {
			service = new ListService();
			path = "/view/list.jsp";
		}else if(command.equals("/read.do")) {
			service = new ReadService();
			path = "/view/read.jsp";
		}else if(command.equals("/delete.do")) {
			service = new DeleteService();
			path = "redirect::list.do";
		}else if(command.equals("/insertform.do")) {
			path = "/view/insertform.jsp";
		}else if(command.equals("/insert.do")) {
			service = new InsertService();
			path = "redirect::list.do";
		}else if(command.equals("/updateform.do")) {
			service = new UpdateFormService();
			path = "/view/updateform.jsp";
		}else if(command.equals("/update.do")) {
			service = new UpdateService();
			path = "redirect::list.do";
		}
		if(service!=null) service.execute(request, response);
		
		if(path.equals("redirect::list.do")) {
			response.sendRedirect("list.do");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
