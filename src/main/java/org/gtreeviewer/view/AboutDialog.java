package org.gtreeviewer.view;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AboutDialog extends JDialog {
	private static short DEFAULT_WIDTH = 350;
	private static short DEFAULT_HEIGHT = 150;
	public AboutDialog() {
		this.setTitle("About");

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel applicationTitle = new JLabel("GTreeViewer (sometimes spelled as gtreeviewer)");
		applicationTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(applicationTitle);

		JLabel authorAndCopyrightLabel = new JLabel("Copyright 2025 Richard Varela", SwingConstants.CENTER);
		authorAndCopyrightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(authorAndCopyrightLabel);

		JLabel versionNumber = new JLabel("Version: 0.1", SwingConstants.CENTER);
		versionNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(versionNumber);

		this.getContentPane().add(BorderLayout.CENTER, panel);

		this.pack();
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
	}
}
