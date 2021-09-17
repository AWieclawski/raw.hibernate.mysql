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
import edu.awieclawski.label.JobContractLabels;
import edu.awieclawski.model.JobContract;

/**
 * extender of Base upload / save entity controller
 * 
 * @author AWieclawski
 *
 */
@WebServlet(JobContractLabels.entityUploadPath) // individual entity path
public class JobContractController extends BaseController {
	private final static Logger LOGGER = Logger.getLogger(JobContractController.class.getName());
	private static final long serialVersionUID = 842598365456524835L;

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
		return new JobContract();
	}

}
