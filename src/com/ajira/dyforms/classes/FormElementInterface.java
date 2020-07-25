package com.ajira.dyforms.classes;

import java.util.List;

public interface FormElementInterface {
	
	public String getFieldName();
	
	public void setFieldName(String fieldName);
	
	public String getValue();
	
	public void setValue(String value);
	
	public boolean getVisibility();
	
	public void setVisibility(boolean visibility);
	
	public String getType();
	
	public void setType(String type);
	
	public List<String> getOptions();
	
	public void setOptions(String option);
	
}
