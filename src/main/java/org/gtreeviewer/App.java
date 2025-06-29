package org.gtreeviewer;

import org.gtreeviewer.view.*;
import org.gtreeviewer.model.*;
import org.gtreeviewer.controller.*;

/**
 * This file will init all classes.
 *
 */
public class App 
{
	public static void main(String[] args)
	{
		System.out.println("Test");
		Model model = new Model();
		model.openAndLoadJsonFile("../test.json");
		View view = new View(model.getHashTable());
		Controller controller = new Controller(model, view);
		view.setVisible(true);
	}
}
