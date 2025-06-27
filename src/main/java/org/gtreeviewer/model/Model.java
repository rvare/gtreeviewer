package org.gtreeviewer.model;

import java.util.*;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.*;

public class Model {
	private JSONObject jsonObject;

	public Model() {
		System.out.println("Init model");
		String jsonContents = null;
		try {
			jsonContents = Files.readString(Paths.get("./test.json"));
			System.out.println(jsonContents);
			this.jsonObject = new JSONObject(jsonContents);
		}
		catch(IOException ioEx) {
			System.out.println(ioEx.getMessage());
		}
		catch(JSONException jsonEx) {
			System.out.println(jsonEx.getMessage());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(new JSONObject(jsonContents));
	}
} // End Model class
