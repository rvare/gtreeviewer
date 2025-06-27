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

/**
 * Contains program logic.
 */

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

	// Getters
	public String getAll() { return this.jsonObject.toString(); }

	public Object getFieldValue(String key) {
		return this.jsonObject.get(key);
	}

	public String getStringFieldValue(String key) {
		return this.jsonObject.getString(key);
	}

	public int getIntegerFieldValue(String key) {
		return this.jsonObject.getInt(key);
	}

	public float getFloatFieldValue(String key) {
		return this.jsonObject.getFloat(key);
	}

	public boolean getBooleanFieldValue(String key) {
		return this.jsonObject.getBoolean(key);
	}

	// Setters
	public void setField(String key, String value) {
		this.jsonObject.put(key, value);
	}

	public void setField(String key, int value) {
		this.jsonObject.put(key, value);
	}

	public void setField(String key, float value) {
		this.jsonObject.put(key, value);
	}

	public void setField(String key, boolean value) {
		this.jsonObject.put(key, value);
	}


	// New operations
	public void newField(String newKey, String value) { }

	public void newField(String newKey, int value) { }

	public void newField(String newKey, float value) { }

	public void newField(String newKey, boolean value) { }

	// Operations
	public void openAndLoadJsonFile() { }

	public Map<String, Object> createHashMap() {
		return this.jsonObject.toMap();
	}

} // End Model class
