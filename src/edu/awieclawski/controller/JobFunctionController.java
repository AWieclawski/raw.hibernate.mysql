package edu.awieclawski.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.awieclawski.base.BaseController;
import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.label.JobFunctionLabel;
import edu.awieclawski.model.JobFunction;

/**
 * simple upload / save entity controller
 * 
 * @author AWieclawski
 *
 */
@WebServlet(JobFunctionLabel.entityUploadPath) // individual entity path
public class JobFunctionController extends BaseController {
	private final static Logger LOGGER = Logger.getLogger(JobFunctionController.class.getName());
	private static final long serialVersionUID = -4941015790072830084L;

	@Override
	public void init() {
		try {
			getInit();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Allowed entity initialisation failed: " + entity);
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		registerEntity(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAttributes(request, response);
	}

	@Override
	public BaseEntity getinitEntity() {
		return new JobFunction();
	}

}
