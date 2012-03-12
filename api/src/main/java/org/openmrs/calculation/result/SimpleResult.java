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
package org.openmrs.calculation.result;

import org.openmrs.calculation.PatientCalculation;
import org.openmrs.calculation.api.CalculationContext;

/**
 * Provides a simple concrete implementation of a {@link Result} that can be used out of the box.
 */
public class SimpleResult implements Result {
	
	private CalculationContext calculationContext;
	
	private PatientCalculation calculation;
	
	private Object value;
	
	/**
	 * Convenience constructor that takes in a value and a {@link PatientCalculation}
	 * 
	 * @param value the value to set
	 * @param calculation the calculation to set
	 */
	public SimpleResult(Object value, PatientCalculation calculation) {
		this(value, calculation, null);
	}
	
	/**
	 * Convenience constructor that takes in a value, a {@link PatientCalculation} and
	 * {@link CalculationContext} in which it was evaluated
	 * 
	 * @param value the value to set
	 * @param calculation the calculation to set
	 * @param calculationContext the CalculationContext to set
	 */
	public SimpleResult(Object value, PatientCalculation calculation, CalculationContext calculationContext) {
		setValue(value);
		setCalculation(calculation);
		setCalculationContext(calculationContext);
	}
	
	/**
	 * @see org.openmrs.calculation.result.Result#getCalculation()
	 */
	@Override
	public PatientCalculation getCalculation() {
		return calculation;
	}
	
	/**
	 * @param calculation the calculation to set
	 */
	public void setCalculation(PatientCalculation calculation) {
		this.calculation = calculation;
	}
	
	/**
	 * @see org.openmrs.calculation.result.Result#getCalculationContext()
	 */
	@Override
	public CalculationContext getCalculationContext() {
		return calculationContext;
	}
	
	/**
	 * @param calculationContext the calculationContext to set
	 */
	public void setCalculationContext(CalculationContext calculationContext) {
		this.calculationContext = calculationContext;
	}
	
	/**
	 * @see org.openmrs.calculation.result.Result#getValue()
	 */
	@Override
	public Object getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	/**
	 * @see org.openmrs.calculation.result.Result#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return getValue() == null;
	}
	
	/**
	 * @see org.openmrs.calculation.result.Result#asType(java.lang.Class)
	 */
	@Override
	public <T> T asType(Class<T> clazz) {
		return ResultUtil.convert(this, clazz);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (value == null)
			return "";
		
		return value.toString();
	}
}
