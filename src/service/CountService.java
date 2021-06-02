package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class CountService  implements BoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.getCount();
		
		request.setAttribute("count",cnt);
	}
}
