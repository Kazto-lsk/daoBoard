package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class InsertService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try{
			request.setCharacterEncoding("utf-8");

			BoardDTO board = new BoardDTO();
			
			board.setWriter(request.getParameter("writer"));
			board.setSubject(request.getParameter("subject"));
			board.setContents(request.getParameter("contents"));
			board.setPassword(request.getParameter("password"));
			
			BoardDAO dao = new BoardDAO();
			dao.insert(board);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
