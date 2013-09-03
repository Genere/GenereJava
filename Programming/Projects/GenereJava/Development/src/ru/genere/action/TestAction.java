package ru.genere.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.genere.model.*;


public class TestAction implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response, Catalog catalog) {
/*		
		String categoryUrl = request.getParameter("cat");
		Category category = catalog.getRootCategoryByLink(categoryUrl);
		request.setAttribute("page", category);
		*/
		return "/test2.jsp";
	}
}
