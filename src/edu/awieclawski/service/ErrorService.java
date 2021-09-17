package edu.awieclawski.service;

/**
 * 
 * not used yet
 * 
 * @author AWieclawski
 *
 */
public class ErrorService {

	private String ERROR_LOG;

	public String getERROR_LOG() {
		return ERROR_LOG;
	}

	public void setCALLOUT_INV_LOG(String ERROR_LOG) {
		if (getERROR_LOG() != null)
			stackERROR_LOG(ERROR_LOG);
		else
			this.ERROR_LOG = ERROR_LOG;
	}

	private void stackERROR_LOG(String cALLOUT_INV_LOG) {
		ERROR_LOG += "\n" + cALLOUT_INV_LOG;
	}

}
