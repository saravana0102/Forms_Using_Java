package com.ajira.dyforms.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DyForm {
	
	private List<FormElementInterface> formElements = new ArrayList<>();
	
	public void addElements(FormElementInterface formElement) {
		formElements.add(formElement);
	}
	
	public static DyForm creatingForm() {
		DyForm myForm= new DyForm();
		
		FormElementInterface createdTime = new TextElement("", "text", true, "CreatedBy");
		myForm.addElements(createdTime);
		
		FormElementInterface description = new TextElement("", "text", true, "Description");
		myForm.addElements(description);
		
		FormElementInterface seviority = new TextElement("", "number", true, "Severity");
		myForm.addElements(seviority);
		
		List<String> seviorityOptionList = new ArrayList<String>();
		seviorityOptionList.add("Cancelled");
		seviorityOptionList.add("Completed");
		
		FormElementInterface Status = new DropdownElement("Status","","select", true, seviorityOptionList);
		myForm.addElements(Status);
		
		List<String> cancelledReasonOptions = new ArrayList<String>();
		cancelledReasonOptions.add("EndUser");
		cancelledReasonOptions.add("Others");
		
		FormElementInterface CancelledReason = new DropdownElement("CancelledReason","","select", false, cancelledReasonOptions);
		myForm.addElements(CancelledReason);
		
		FormElementInterface CancelledOtherDescription = new TextElement("", "text", false, "CancelledOtherDescription");
		myForm.addElements(CancelledOtherDescription);
		
		FormElementInterface Comments = new TextElement("", "text", false, "Comments");
		myForm.addElements(Comments);
		
		return myForm;
	}
	
	public void renderForm() {
		System.out.println("************************ Ticket System **********************");
		
		for(int i = 0;i<formElements.size();i++) {
			if(formElements.get(i).getVisibility()) {
				System.out.println(i+1 +"." + formElements.get(i).getFieldName() + " (" +formElements.get(i).getType() + ") :" + formElements.get(i).getValue());
			}
		}
	
	}

	public void getUserInput() {
		System.out.println();
		System.out.println("Please select a column to enter the value");
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		boolean isNum = Utility.isNum(input);
		if(!isNum) {
			System.out.println("Invalid input... Please try again");
		}
		else {
			int val = Integer.parseInt(input)-1;
			if(formElements.get(val).getType().equals("select")) {
				for(int i = 0;i<formElements.get(val).getOptions().size();i++) {
					System.out.println(i+1 + "." + formElements.get(val).getOptions().get(i));
				}
			}
			else {
				String inputVal = sc.nextLine();
				formElements.get(val).setValue(inputVal);
			}
		}
	}
	public static void main(String[] args) {
		
		DyForm myForm = creatingForm();

		myForm.renderForm();
		
		myForm.getUserInput();

		myForm.renderForm();
		
		
	}

}
