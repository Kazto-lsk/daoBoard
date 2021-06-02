package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class UpdateFormService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO board = dao.read(number);

		request.setAttribute("board",board);
	}
}
