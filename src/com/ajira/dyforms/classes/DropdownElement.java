package com.ajira.dyforms.classes;

import java.util.ArrayList;
import java.util.List;

public class DropdownElement implements FormElementInterface {
	
	private String fieldName;
	
	private String value;
	
	private String type;
	
	private boolean visibility;
	
	private List<String> options = new ArrayList<String>();
	
	public DropdownElement(String fieldName, String value, String type, boolean visibility, List<String> options) {
		this.fieldName = fieldName;
		this.value = value;
		this.type = type;
		this.visibility = visibility;
		this.options = options;
	}

	@Override
	public String getFieldName() {
		return this.fieldName;
	}

	@Override
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
		
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean getVisibility() {
		return this.visibility;
	}

	@Override
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public List<String> getOptions() {
		return options;
	}

	@Override
	public void setOptions(String option) {
		this.options.add(option);
	}
	

}
