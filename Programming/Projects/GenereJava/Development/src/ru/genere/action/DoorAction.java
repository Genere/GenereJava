package ru.genere.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.genere.model.*;


public class DoorAction implements Action {

	public String perform(HttpServletRequest request, HttpServletResponse response) {
		
		Product product = new Door();
		product.setName();
		request.setAttribute("product", product);
		return "/test.jsp";
	}
}
