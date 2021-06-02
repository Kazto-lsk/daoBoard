package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class ReadService  implements BoardService{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			response.setContentType("text/html; charset=utf-8");
			request.setCharacterEncoding("utf-8");
			String number = request.getParameter("number");

			BoardDAO dao = new BoardDAO();
			BoardDTO board = dao.read(number);
			
			request.setAttribute("board",board);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
