package edu.awieclawski.controller;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.dao.EntitiesDao;
import edu.awieclawski.model.Address;
import edu.awieclawski.util.EntityUtils;

/**
 * simple save entity controller
 * 
 * @author AWieclawski
 *
 */
@WebServlet("/upaddress")
public class AddressController extends HttpServlet {
	private final static Logger LOGGER = Logger.getLogger(AddressController.class.getName());
	private static final long serialVersionUID = 873432123456789983L;
	private EntitiesDao entityDao;
	private BaseEntity entity = getEntity();
	private Map<String, Object> entityMap;
	private Map<String, String> labelsMap;

	public void init() {
		entityDao = new EntitiesDao();
		entityMap = EntityUtils.getMapOfFieldsAndValuesFromClass(entity);
		labelsMap = EntityUtils.getMapOfFieldsAndLabelsFromClass(entity);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		registerObject(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("entityMap", labelsMap);
		request.setAttribute("head", entity.getEntityHeaderName());
		request.setAttribute("link", entity.getEntityLink());

		request.getRequestDispatcher("upform.jsp").forward(request, response);
	}

	private void registerObject(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// iterate parameters get from request
		for (Map.Entry<String, Object> entry : entityMap.entrySet()) {
			String key = entry.getKey();
			entityMap.put(key, request.getParameter(key));
		}
		entity = EntityUtils.getEntityFromMap(entityMap, entity);
		entityDao.saveAddress(entity);

		// TODO error check logic and
		// req.getRequestDispatcher("/upaddress")
		// .forward(request,response);

		request.setAttribute("labelsMap", labelsMap);
		request.setAttribute("valuesMap", entityMap);
		request.setAttribute("head", entity.getEntityHeaderName());

		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmview.jsp");
		dispatcher.forward(request, response);
	}

	private Address getEntity() {
		if (entity == null)
			return new Address();
		try {
			return (Address) entity;
		} catch (ClassCastException e) {
			LOGGER.log(Level.SEVERE, entity + " ClassCastException : " + e.getMessage());
		}
		return null;
	}

}
