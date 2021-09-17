package edu.awieclawski.base;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.awieclawski.dao.EntitiesDao;
import edu.awieclawski.util.EntityUtils;

@SuppressWarnings("serial")
public abstract class BaseController extends HttpServlet {

	private static Logger LOGGER; // = Logger.getLogger(BaseController.class.getName());

	// operate fields
	protected EntitiesDao entityDao;
	protected Map<String, Object> entityMap;
	protected Map<String, BaseEntity> recordsMap;
	protected Map<String, String> labelsMap;

	// controller individual entity initiator
	protected BaseEntity initEntity = getinitEntity();
	protected String initEntityName = initEntity.getClass().getName();
	protected BaseEntity entity;

	public abstract BaseEntity getinitEntity();

	public void getInit() throws Exception {
		entityDao = new EntitiesDao();
		entity = AllowedEntities.getAllowedEntityByName(initEntityName);
		if (entity != null) {
			entityMap = EntityUtils.getMapOfFieldsAndValuesFromClass(entity);
			labelsMap = EntityUtils.getMapOfFieldsAndLabelsFromClass(entity);
			recordsMap = EntityUtils.getMapOfRecordFieldsFromClass(entity);
		}
	}

	protected void setAttributes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("entityMap", labelsMap);
		request.setAttribute("head", entity.getEntityHeaderName());
		request.setAttribute("action", entity.getEntityUploadPath().replaceAll("/", ""));

		request.getRequestDispatcher("upform.jsp").forward(request, response);
	}

	protected void registerEntity(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// iterate parameters get from request
		for (Map.Entry<String, Object> entry : entityMap.entrySet()) {
			String key = entry.getKey();
			entityMap.put(key, request.getParameter(key));
		}
		entity = EntityUtils.getEntityFromMap(entityMap, entity);
		if (entityDao.saveAddress(entity, recordsMap).getERROR_LOG() != null)
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
