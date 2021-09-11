package edu.awieclawski.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.awieclawski.model.Address;

/**
 * builds list of classes used by servlets
 * 
 * @author AWieclawski
 *
 */
public class EntitiesList {

	public static List<?> get() {
		return new ArrayList<>(Arrays.asList(Address.class));
	}

}
