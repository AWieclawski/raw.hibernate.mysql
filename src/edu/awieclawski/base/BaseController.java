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
//import edu.awieclawski.base.LabelAttributes;

/**
 * abstract Base upload / save entity controller
 * 
 * @author AWieclawski
 *
 */
@SuppressWarnings("serial")
public abstract class BaseController extends HttpServlet {

	// to be overwritten in extender
	protected static Logger LOGGER = Logger.getLogger(BaseController.class.getName());

	// to be overwritten in extender
	public abstract BaseEntity getinitEntity();

	// operate fields - to be overwritten in extender
	protected EntitiesDao entityDao;
	protected Map<String, Object> entityMap;
	protected Map<String, BaseEntity> recordsMap;
	protected Map<String, String> labelsMap;

	// controller individual entity initiator - to be overwritten in extender
	protected BaseEntity initEntity = getinitEntity();
	protected String initEntityName = initEntity.getClass().getName();
	protected BaseEntity entity;

	/**
	 * do not override!
	 * 
	 * @throws Exception
	 */
	protected void getInit() throws Exception {
		entityDao = new EntitiesDao();
		entity = AllowedEntities.getAllowedEntityByName(initEntityName);
		if (entity != null) {
			entityMap = EntityUtils.getMapOfFieldsAndValuesFromClass(entity);
			labelsMap = entity.getLabelsOrder();
			recordsMap = EntityUtils.getMapOfRecordFieldsFromClass(entity);
		}
	}

	/**
	 * do not override!
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void setAttributes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(LabelAttributes.ENT_MAP.getParName(), labelsMap);
		request.setAttribute(LabelAttributes.HEAD.getParName(), entity.getEntityHeaderName());
		request.setAttribute(LabelAttributes.ACT.getParName(), entity.getEntityUploadPath().replaceAll("/", ""));

		request.getRequestDispatcher("upform.jsp").forward(request, response);
	}

	/**
	 * do not override!
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
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

		request.setAttribute(LabelAttributes.LAB_MAP.getParName(), labelsMap);
		request.setAttribute(LabelAttributes.VAL_MAP.getParName(), entityMap);
		request.setAttribute(LabelAttributes.HEAD.getParName(), entity.getEntityHeaderName());

		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmview.jsp");
		dispatcher.forward(request, response);
	}

	protected void getEntitiesStack(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//TODO build & operate entities stack
	}

}
