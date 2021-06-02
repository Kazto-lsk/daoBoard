package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class DeleteService  implements BoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String number = request.getParameter("number");
		BoardDAO dao = new BoardDAO();
		dao.delete(number);
	}
}
