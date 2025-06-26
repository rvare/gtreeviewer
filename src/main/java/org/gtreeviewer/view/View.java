package org.gtreeviewer.view;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JTree;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.gtreeviewer.view.AboutDialog;
import org.gtreeviewer.view.DocumentationDialog;

// TODO: Add in the file explorer when working on the Model class.

public class View extends JFrame {
	private JTree tree;

	// Menu bar
	private JMenuBar menuBar;
	private JMenu menu;

	// Menu bar items
	private JMenuItem openFileOption;
	private JMenuItem saveOption;
	private JMenuItem saveAsOption;
	private JMenuItem exportMenuOption;
	private JMenuItem docOption;
	private JMenuItem aboutOption;

	private static int DEFAULT_WIDTH = 700;
	private static int DEFAULT_HEIGHT = 500;
	private final static String WINDOW_TITLE = "GTreeViewer";
	private final static String WINDOW_TITLE_DIRTY = "GTreeViewer *";

	public View() {
		System.out.println("Init view");
		// Set default close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create menu bar
		this.menuBar = new JMenuBar();

		// Create file menu and its items
		JMenu fileMenu = new JMenu("File");

		this.openFileOption = new JMenuItem("Open");
		fileMenu.add(this.openFileOption);

		// this.saveOption = new JMenuItem("Save");
		// fileMenu.add(this.saveOption);

		// this.saveAsOption = new JMenuItem("Save As");
		// fileMenu.add(this.saveAsOption);

		// this.exportMenuOption = new JMenuItem("Export");
		// fileMenu.add(this.exportMenuOption);

		// Create Help menu and its items
		JMenu helpMenu = new JMenu("Help");

		this.docOption = new JMenuItem("Documentation");;
		this.docOption.addActionListener(new displayDocumentationDialogListener());
		helpMenu.add(this.docOption);

		this.aboutOption = new JMenuItem("About");
		this.aboutOption.addActionListener(new displayAboutDialogListener());
		helpMenu.add(this.aboutOption);

		// Add all menu items to the menu bar and add the menu bar to frame
		this.menuBar.add(fileMenu);
		this.menuBar.add(helpMenu);
		this.setJMenuBar(this.menuBar);

		// Create JTree
		// TODO: Make it empty and figure out how to pass its model to the Model class
		// TODO: How to change the symbols?
		JTree treeGUI = new JTree();
		JScrollPane leftScrollPane = new JScrollPane(treeGUI);

		// Right panel for data display
		JPanel rightPanel = new JPanel();
		rightPanel.add(new JLabel("Right"));
		rightPanel.setMinimumSize(new Dimension(400, 500));
		JScrollPane rightScrollPane = new JScrollPane(rightPanel);

		// Create split pane and add to frame
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(300);
		this.getContentPane().add(splitPane);

		// Finish the frame
		this.setTitle(this.WINDOW_TITLE);
		this.setSize(this.DEFAULT_WIDTH, this.DEFAULT_HEIGHT);
	} // End default constructor

	public void displayAboutDialogWindow() {
		new AboutDialog().setVisible(true);
	}

	public void displayDocumentationDialog() {
		new DocumentationDialog().setVisible(true);
	}

	private class displayAboutDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			displayAboutDialogWindow();
		}
	}

	private class displayDocumentationDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			displayDocumentationDialog();
		}
	}
} // End View class
