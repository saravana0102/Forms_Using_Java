package com.ajira.dyforms.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ajira.dyforms.util.classes.Utility;

public class DyForm {

	private List<FormElementInterface> formElements = new ArrayList<>();

	public void addElements(FormElementInterface formElement) {
		formElements.add(formElement);
	}

	public static DyForm creatingForm() {
		DyForm myForm = new DyForm();

		FormElementInterface createdTime = new TextElement("", "text", true, "CreatedBy");
		myForm.addElements(createdTime);

		FormElementInterface description = new TextElement("", "text", true, "Description");
		myForm.addElements(description);

		FormElementInterface seviority = new TextElement("", "number", true, "Severity");
		myForm.addElements(seviority);

		List<String> seviorityOptionList = new ArrayList<String>();
		seviorityOptionList.add("Cancelled");
		seviorityOptionList.add("Completed");

		FormElementInterface Status = new DropdownElement("Status", "", "select", true, seviorityOptionList);
		myForm.addElements(Status);

		List<String> cancelledReasonOptions = new ArrayList<String>();
		cancelledReasonOptions.add("EndUser");
		cancelledReasonOptions.add("Others");

		FormElementInterface CancelledReason = new DropdownElement("CancelledReason", "", "select", false,
				cancelledReasonOptions);
		myForm.addElements(CancelledReason);

		FormElementInterface CancelledOtherDescription = new TextElement("", "text", false,
				"CancelledOtherDescription");
		myForm.addElements(CancelledOtherDescription);

		FormElementInterface Comments = new TextElement("", "text", false, "Comments");
		myForm.addElements(Comments);

		return myForm;
	}

	public void renderForm() {
		System.out.println("************************ Ticket System **********************");

		for (int i = 0; i < formElements.size(); i++) {
			if (formElements.get(i).getVisibility()) {
				System.out.println(i + 1 + "." + formElements.get(i).getFieldName() + " ("
						+ formElements.get(i).getType() + ") :" + formElements.get(i).getValue());
			}
		}

	}

	public void resetForm() {
		for (FormElementInterface formElementInterface : formElements) {
			formElementInterface.setValue("");
			if (formElementInterface.getFieldName().toLowerCase().equals("comments")) {
				formElementInterface.setVisibility(false);
			}
			if (formElementInterface.getFieldName().toLowerCase().equals("cancelledreason")) {
				formElementInterface.setVisibility(false);
			}
			if (formElementInterface.getFieldName().toLowerCase().equals("cancelledotherdescription")) {
				formElementInterface.setVisibility(false);
			}
		}
	}
	
	public boolean getUserInput(DyForm myForm) {

		boolean doContinue = true;

		System.out.println();
		System.out.println("Select option to set field value [or] Press 'R' to Reset form");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if(input.equals("R")) {
			myForm.resetForm();
		}
		else {
			int num = Utility.isNum(input) - 1;
			if (num >= 0 && num < formElements.size() && formElements.get(num).getVisibility()) {
				if (formElements.get(num).getType().equals("select")) {
					myForm.getUserSelectOption(num, sc);
				} else {
					System.out.println("Please enter the value to field :");
					String inputVal = sc.nextLine();
					if (formElements.get(num).getType().equals("number")) {
						int numValueCheck = Utility.isNum(inputVal);
						if (numValueCheck > 0) {
							formElements.get(num).setValue(inputVal);
						} else {
							System.out.println("Invalid input... Please try again");
						}
					} else {
						
						formElements.get(num).setValue(inputVal);
					}
				}
				
			} else {
				System.out.println("Invalid input... Please try again");
				System.out.println("Do you want to continue? Y/n ");
				String continueInput = sc.next();
				if (!continueInput.toLowerCase().equals("y")) {
					doContinue = false;
				}
			}
		}
		return doContinue;

	}

	public void getUserSelectOption(int num, Scanner sc) {
		for (int i = 0; i < formElements.get(num).getOptions().size(); i++) {
			System.out.println(i + 1 + "." + formElements.get(num).getOptions().get(i));
		}
		System.out.println("Please select the option :");
		String selectedOption = sc.next();
		int optionNum = Utility.isNum(selectedOption) - 1;
		if (optionNum >= 0 && optionNum < formElements.get(num).getOptions().size()) {
			formElements.get(num).setValue(formElements.get(num).getOptions().get(optionNum));
			if (formElements.get(num).getOptions().get(optionNum).equals("Cancelled")) {
				for (FormElementInterface formElementInterface : formElements) {
					if (formElementInterface.getFieldName().toLowerCase().equals("comments")) {
						formElementInterface.setVisibility(false);
					}
					if (formElementInterface.getFieldName().toLowerCase().equals("cancelledreason")) {
						formElementInterface.setVisibility(true);
					}
					if (formElementInterface.getFieldName().toLowerCase().equals("cancelledotherdescription")) {
						formElementInterface.setVisibility(false);
					}
				}
			}
			if (formElements.get(num).getOptions().get(optionNum).equals("Completed")) {
				for (FormElementInterface formElementInterface : formElements) {
					if (formElementInterface.getFieldName().toLowerCase().equals("comments")) {
						formElementInterface.setVisibility(true);
					}
					if (formElementInterface.getFieldName().toLowerCase().equals("cancelledreason")) {
						formElementInterface.setVisibility(false);
					}
					if (formElementInterface.getFieldName().toLowerCase().equals("cancelledotherdescription")) {
						formElementInterface.setVisibility(false);
					}
				}
			}
			if (formElements.get(num).getOptions().get(optionNum).equals("EndUser")) {
				for (FormElementInterface formElementInterface : formElements) {
					if (formElementInterface.getFieldName().toLowerCase().equals("comments")) {
						formElementInterface.setVisibility(false);
					}
					if (formElementInterface.getFieldName().toLowerCase().equals("cancelledreason")) {
						formElementInterface.setVisibility(true);
					}
					if (formElementInterface.getFieldName().toLowerCase().equals("cancelledotherdescription")) {
						formElementInterface.setVisibility(false);
					}
				}
			}
			if (formElements.get(num).getOptions().get(optionNum).equals("Others")) {
				for (FormElementInterface formElementInterface : formElements) {
					if (formElementInterface.getFieldName().toLowerCase().equals("comments")) {
						formElementInterface.setVisibility(false);
					}
					if (formElementInterface.getFieldName().toLowerCase().equals("cancelledreason")) {
						formElementInterface.setVisibility(true);
					}
					if (formElementInterface.getFieldName().toLowerCase().equals("cancelledotherdescription")) {
						formElementInterface.setVisibility(true);
					}
				}
			}
		} else {
			System.out.println("Invalid input... Please try again");
		}
	}

	public static void main(String[] args) {

		DyForm myForm = creatingForm();

		boolean doContinue = true;
		while (doContinue) {
			myForm.renderForm();
			doContinue = myForm.getUserInput(myForm);

		}

	}

}
