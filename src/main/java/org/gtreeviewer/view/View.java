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

	private static int DEFAULT_WIDTH = 500;
	private static int DEFAULT_HEIGHT = 500;
	private final static String WINDOW_TITLE = "GTreeViewer";
	private final static String WINDOW_TITLE_DIRTY = "GTreeViewer *";

	public View() {
		System.out.println("Init");
		// Set default close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create menu bar
		this.menuBar = new JMenuBar();

		// Create file menu and its items
		JMenu fileMenu = new JMenu("File");

		this.openFileOption = new JMenuItem("Open");
		fileMenu.add(this.openFileOption);

		this.saveOption = new JMenuItem("Save");
		fileMenu.add(this.saveOption);

		this.saveAsOption = new JMenuItem("Save As");
		fileMenu.add(this.saveAsOption);

		this.exportMenuOption = new JMenuItem("Export");
		fileMenu.add(this.exportMenuOption);

		// Create Help menu and its items
		JMenu helpMenu = new JMenu("Help");

		this.docOption = new JMenuItem("Documentation");;
		helpMenu.add(this.docOption);

		this.aboutOption = new JMenuItem("About");
		helpMenu.add(this.aboutOption);

		// Add all menu items to the menu bar
		this.menuBar.add(fileMenu);
		this.menuBar.add(helpMenu);

		// Create panels
		Dimension minimumSize = new Dimension(100, 50);

		// Left panel for JTree
		JPanel leftPanel = new JPanel();
		leftPanel.add(new JLabel("Left"));
		leftPanel.setMinimumSize(minimumSize);
		// this.getContentPane().add(BorderLayout.WEST, leftPanel);

		// Right panel for data display
		JPanel rightPanel = new JPanel();
		rightPanel.add(new JLabel("Right"));
		rightPanel.setMinimumSize(minimumSize);
		// this.getContentPane().add(BorderLayout.EAST, rightPanel);

		// Create split pane
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(250);
		this.getContentPane().add(splitPane);

		// Create the frame
		this.setTitle(this.WINDOW_TITLE);
		this.setSize(this.DEFAULT_WIDTH, this.DEFAULT_HEIGHT);
	} // End default constructor
} // End View class
