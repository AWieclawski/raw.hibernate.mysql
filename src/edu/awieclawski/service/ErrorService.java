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

	public String getCALLOUT_INV_LOG() {
		return ERROR_LOG;
	}

	public void setCALLOUT_INV_LOG(String cALLOUT_INV_LOG) {
		if (getCALLOUT_INV_LOG() != null)
			stackCALLOUT_INV_LOG(cALLOUT_INV_LOG);
		else
			ERROR_LOG = cALLOUT_INV_LOG;
	}

	private void stackCALLOUT_INV_LOG(String cALLOUT_INV_LOG) {
		ERROR_LOG += "\n" + cALLOUT_INV_LOG;
	}

}
