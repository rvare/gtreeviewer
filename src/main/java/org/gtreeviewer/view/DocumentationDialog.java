
package org.gtreeviewer.view;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DocumentationDialog extends JDialog {
	public DocumentationDialog() {
		this.setTitle("Documentation");

		String docContent = "Place holder";

		JLabel docContentContainer = new JLabel(docContent);
		JPanel panel = new JPanel();
		panel.add(docContentContainer);
		this.getContentPane().add(BorderLayout.CENTER, panel);

		this.pack();
		this.setSize(500, 400);
		this.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
	}
}
