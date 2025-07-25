package org.gtreeviewer.controller;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.*;

import org.gtreeviewer.model.*;
import org.gtreeviewer.view.*;

/**
 * Mediator between Model and View.
 */
public class Controller {
	private final Model model;
	private final View view;

	public Controller(final Model model, final View view) {
		System.out.println("Contoller constuctor");
		this.model = model;

		this.view = view;
		this.view.addOpenFileListener(new menuOpenListener());
		this.view.addDisplayAboutDialogListener(new DisplayAboutDialogListener());
		this.view.addDisplayDocumentationDialogListener(new DisplayDocumentationDialogListener());
	}

	private class menuOpenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			System.out.println("Open");
		}
	}

	private class DisplayAboutDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			System.out.println("About listener");
			view.displayAboutDialogWindow();
		}
	}

	private class DisplayDocumentationDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			System.out.println("Doc listener");
			view.displayDocumentationDialog();
		}
	}
} // End Controller class
