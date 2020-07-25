package com.ajira.dyforms.classes;

import java.util.List;

public class TextElement implements FormElementInterface {
	
	private String value;
	
	private String type;
	
	private boolean visibility;

	private String fieldName;
	
	public TextElement(String value, String type, boolean visibility, String fieldName) {
		this.value = value;
		this.type = type;
		this.visibility = visibility;
		this.fieldName = fieldName;
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
		return value;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOptions(String option) {
		// TODO Auto-generated method stub
		
	}

	

}
