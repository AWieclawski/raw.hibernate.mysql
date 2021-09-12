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
import edu.awieclawski.base.EntitiesList;
import edu.awieclawski.dao.EntitiesDao;
import edu.awieclawski.label.AddressLabels;
import edu.awieclawski.model.Address;
import edu.awieclawski.util.EntityUtils;

/**
 * simple upload / save entity controller
 * 
 * @author AWieclawski
 *
 */
@WebServlet(AddressLabels.entityUploadPath) // individual entity path
public class AddressController extends HttpServlet {
	private final static Logger LOGGER = Logger.getLogger(AddressController.class.getName());
	private static final long serialVersionUID = 873432123456789983L;
	private EntitiesDao entityDao;
	private Map<String, Object> entityMap;
	private Map<String, String> labelsMap;

	// controller individual entity initiator
	private BaseEntity init = new Address();
	private BaseEntity entity;

	public void init() {
		entityDao = new EntitiesDao();
		entity = EntitiesList.getAllowedEntityByName(init.getClass().getName());
		if (entity != null) {
			entityMap = EntityUtils.getMapOfFieldsAndValuesFromClass(entity);
			labelsMap = EntityUtils.getMapOfFieldsAndLabelsFromClass(entity);
		} else
			try {
				throw new Exception();
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Allowed entity initialisation failed: " + entity);
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		registerEntity(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("entityMap", labelsMap);
		request.setAttribute("head", entity.getEntityHeaderName());
		request.setAttribute("action", entity.getEntityUploadPath().replaceAll("/", ""));

		request.getRequestDispatcher("upform.jsp").forward(request, response);
	}

	private void registerEntity(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// iterate parameters get from request
		for (Map.Entry<String, Object> entry : entityMap.entrySet()) {
			String key = entry.getKey();
			entityMap.put(key, request.getParameter(key));
		}
		entity = EntityUtils.getEntityFromMap(entityMap, entity);
		if (entityDao.saveAddress(entity).getCALLOUT_INV_LOG() != null)
			LOGGER.log(Level.SEVERE, "Entity not saved: " + entity.toString());

		// TODO error check logic and
		// req.getRequestDispatcher("/upaddress")
		// .forward(request,response);

		request.setAttribute("labelsMap", labelsMap);
		request.setAttribute("valuesMap", entityMap);
		request.setAttribute("head", entity.getEntityHeaderName());

		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmview.jsp");
		dispatcher.forward(request, response);
	}

}
