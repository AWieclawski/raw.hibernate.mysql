package edu.awieclawski.service;

/**
 * 
 * not used yet
 * 
 * @author AWieclawski
 *
 */
public class ErrorService {

	public String ERROR_LOG;

	public String getCALLOUT_INV_LOG() {
		return ERROR_LOG;
	}

	public void setCALLOUT_INV_LOG(String cALLOUT_INV_LOG) {
		ERROR_LOG = cALLOUT_INV_LOG;
	}

	public void stackCALLOUT_INV_LOG(String cALLOUT_INV_LOG) {
		ERROR_LOG += "\n" + cALLOUT_INV_LOG;
	}

}
