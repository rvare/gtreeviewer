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

import org.gtreeviewer.view.View;

/**
 * Contains program logic.
 */
public class Model {
	private JSONObject jsonObject;
	private Hashtable<String, Object> jsonHashTable;
	private File filePath;
	private View view;

	public Model() {
		System.out.println("Init model");
	}

	// Getters
	public String getJsonObject() { return this.jsonObject.toString(); }

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
	public void setView(View view) {
		this.view = view;
	}

	public void setJTreeModel() {
		this.view.setJtree(this.createHashTable());
	}

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
	public void newField(String newKey, String value) {
		this.jsonObject.put(newKey, value);
	}

	public void newField(String newKey, int value) {
		this.jsonObject.put(newKey, value);
	}

	public void newField(String newKey, float value) {
		this.jsonObject.put(newKey, value);
	}

	public void newField(String newKey, boolean value) {
		this.jsonObject.put(newKey, value);
	}

	// Operations
	public void openAndLoadJsonFile(String filePath) {
		System.out.println("In openAndLoadJsonFile");
		this.filePath = new File(filePath);
		String jsonContents = "{}";
		try {
			jsonContents = Files.readString(Paths.get("./test.json"));
			System.out.println(jsonContents);
			this.jsonObject = new JSONObject(jsonContents);
			System.out.println("jsonObject");
			System.out.println(this.jsonObject);
			HashMap<String, Object> hashMap = new HashMap<String, Object>(this.jsonObject.toMap());
			System.out.println(hashMap);
			this.jsonHashTable = new Hashtable(hashMap);
			System.out.println("jsonHashTable");
			System.out.println(this.jsonHashTable);
		}
		catch(IOException ioEx) {
			System.out.println(ioEx.getMessage());
		}
		catch(JSONException jsonEx) {
			System.out.println(jsonEx.getMessage());
		}
		catch(Exception ex) {
			System.out.println("here");
			System.out.println(ex.getMessage());
		}
	}

	public Hashtable<String, Object> getHashTable() {
		return this.jsonHashTable;
	}

	public Hashtable<String, Object> createHashTable() {
		return new Hashtable<String, Object>(this.jsonObject.toMap());
	}
} // End Model class

