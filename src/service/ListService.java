package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class ListService implements BoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			response.setContentType("text/html; charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			
			BoardDAO dao = new BoardDAO();
			ArrayList<BoardDTO> list = dao.getList();
			
			request.setAttribute("list",list);
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
