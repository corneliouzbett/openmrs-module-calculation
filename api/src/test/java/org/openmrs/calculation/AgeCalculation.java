/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.calculation;

import org.openmrs.calculation.definition.ParameterDefinitionSet;
import org.openmrs.calculation.util.CalculationUtil;

/**
 * A simple implementation of a calculation for calculating patient ages and is purely for testing
 * purposes
 */
public class AgeCalculation implements PatientCalculation {
	
	private ParameterDefinitionSet pds = null;
	
	public AgeCalculation() {
		pds = new ParameterDefinitionSet();
		pds.add(CalculationUtil.createParameterDefinition("units", "java.lang.String", "Units Of Age"));
	}
	
	/**
	 * @see org.openmrs.calculation.BaseCalculation#getParameterDefinitionSet()
	 */
	@Override
	public ParameterDefinitionSet getParameterDefinitionSet() {
		return pds;
	}
}
