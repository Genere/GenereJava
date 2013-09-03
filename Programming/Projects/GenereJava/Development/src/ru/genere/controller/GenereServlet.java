package ru.genere.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

import ru.genere.action.*;
import ru.genere.persistence.GenereDatabase;
import ru.genere.model.*;

public class GenereServlet extends HttpServlet {

	protected ActionFactory factory = new ActionFactory();
	public Catalog catalog;

	public GenereServlet() {
		super();
	}
	
	private String getActionName(HttpServletRequest request) {
		return request.getServletPath().substring(1);
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		GenereDatabase database = GenereDatabase.getSingleton();
		database.setInitParameters(config);
		Connection c = database.initialize();
		catalog = new Catalog(c);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = factory.create(getActionName(request));
		String url = action.perform(request, response, catalog);
		if (url != null)
			getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	public void destroy() {
		super.destroy();
		GenereDatabase.getSingleton().shutDown();
	}
}
