/*******************************************************************************
 * jSSTL:  jSSTL : java Signal Spatio Temporal Logic
 * Copyright (C) 2018 
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package eu.quanticol.jsstl.core.formula;

/**
 * @author loreti
 *
 */
public class Dictionary {
	
	private String[] variables;
	private String[] order;
	private int[] dictionary;
	
	public Dictionary(String[] variables) {
		this(variables,variables);
	}
	
	public Dictionary(String[] variables , String[] order) {
		this.variables = variables;
		this.order = order;
		computeDictionary();
	}

	private void computeDictionary() {
		this.dictionary = new int[variables.length];
		for( int i=0 ; i<this.dictionary.length ; i++) {
			this.dictionary[i] = find( this.variables[i] );
		}
	}
	
	private int find( String v ) {
		for( int i=0 ; i<order.length ; i++ ) {
			if (v.equals(order[i])) {
				return i;
			}
		}
		throw new IllegalArgumentException("Unknown variable "+v);
	}	
	
	public int get(int idx) {
		return dictionary[idx];
	}

	public String[] getVariables() {
		return variables;
	}

	public void setOrder(String[] order) {
		this.order = order;
		computeDictionary();
	}
	
}
