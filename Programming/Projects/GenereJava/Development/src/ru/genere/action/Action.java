package ru.genere.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.genere.model.*;

public interface Action {

	public String perform(HttpServletRequest request, HttpServletResponse response, Catalog catalog);
}
