package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class UpdateService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try{
			request.setCharacterEncoding("utf-8");
			
			String number = request.getParameter("number");
			int num = Integer.parseInt(number);
			
			BoardDTO board = new BoardDTO();
			board.setNumber(num);
			board.setWriter(request.getParameter("writer"));
			board.setSubject(request.getParameter("subject"));
			board.setContents(request.getParameter("contents"));
			
			
			BoardDAO dao = new BoardDAO();
			dao.update(board);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
