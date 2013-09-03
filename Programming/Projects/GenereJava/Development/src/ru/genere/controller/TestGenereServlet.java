package ru.genere.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import ru.genere.model.*;
import ru.genere.action.*;


public class TestGenereServlet extends HttpServlet {
	
	protected ActionFactory factory = new ActionFactory();
	
	protected String getActionName(HttpServletRequest request) {
	//	String path = request.getServletPath();
	//	return path.substring(1, path.lastIndexOf("."));
	return "door";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = factory.create(getActionName(request));
		String url = action.perform(request, response);
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}

}
