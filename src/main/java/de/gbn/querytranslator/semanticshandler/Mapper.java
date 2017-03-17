package de.gbn.querytranslator.semanticshandler;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByModifier;

import de.gbn.querytranslator.omniquery.ConstraintNode;

public class Mapper {

	MappingEntry matchedMapping = new MappingEntry();

	// Direction 0: Samply => i2b2
	// 1: i2b2 => Samply

	public Mapper(int direction, ConstraintNode constraintNode, ItemType i2b2item) {

		// Prepare a new MappingFileEntry based the incoming OmniQuery ContraintNode :

		String sType = "";
		String sKey = "";
		String sValue = "";
		String sLowerBound = "";
		String sUpperBound = "";
		String Direction = "";
		String iType = "";
		String iItemName = "";
		String iItemIcon = "";
		String iKey = "";
		String iModifierName = "";
		String iModifierKey = "";
		String iAppliedPath = "";

		if (direction == 0) { // Samply => i2b2

			// Get the Samply values, unless they are null:

			if (constraintNode.getType() != null)
				sType = constraintNode.getType().toString().trim();
			if (constraintNode.getKey() != null)
				sKey = constraintNode.getKey().toString().trim();
			if (constraintNode.getValue() != null)
				sValue = constraintNode.getValue().toString().trim();
			if (constraintNode.getLowerBound() != null)
				sLowerBound = constraintNode.getLowerBound().toString().trim();
			if (constraintNode.getUpperBound() != null)
				sUpperBound = constraintNode.getUpperBound().toString().trim();

			Direction = ">";
			
			// Set the i2b2 values to "any":
			iType = "*";
			iItemName = "*";
			iItemIcon = "*";
			iKey = "*";
			iModifierName = "*";
			iModifierKey = "*";
			iAppliedPath = "*";
			

		} else { // i2b2 => Samply

			iKey = i2b2item.getItemKey().toString().trim(); // .replace("\\\\i2b2\\", "\\");
			iItemIcon = i2b2item.getItemIcon().trim();
			iItemName = i2b2item.getItemName().trim();

			Direction = "<";
			
			// Set the Samply values to "any":
			sType = "*";
			sKey = "*";
			sValue = "*";
			sLowerBound = "*";
			sUpperBound = "*";
			
		}

		// Replace null with empty string:

		if (sType == null)
			sType = "";
		if (sKey == null)
			sKey = "";
		if (sValue == null)
			sValue = "";
		if (sLowerBound == null)
			sLowerBound = "";
		if (sUpperBound == null)
			sUpperBound = "";
		if (Direction == null)
			Direction = "";
		if (iType == null)
			iType = "";
		if (iItemName == null)
			iItemName = "";
		if (iItemIcon == null)
			iItemIcon = "";
		if (iKey == null)
			iKey = "";
		if (iModifierName == null)
			iModifierName = "";
		if (iModifierKey == null)
			iModifierKey = "";
		if (iAppliedPath == null)
			iAppliedPath = "";

		// Now build the MappingEntry:

		MappingEntry mappingEntry = new MappingEntry();

		mappingEntry.setsType(sType);
		mappingEntry.setsKey(sKey);
		mappingEntry.setsValue(sValue);
		mappingEntry.setsLowerBound(sLowerBound);
		mappingEntry.setsUpperBound(sUpperBound);
		mappingEntry.setDirection(Direction);
		mappingEntry.setiType(iType);
		mappingEntry.setiItemName(iItemName);
		mappingEntry.setiItemIcon(iItemIcon);
		mappingEntry.setiKey(iKey);
		mappingEntry.setiModifierName(iModifierName);
		mappingEntry.setiModifierKey(iModifierName);
		mappingEntry.setiAppliedPath(iAppliedPath);

		// And try to insert it into the mapping file (if it is unique):

		MappingFileProcessor mappingFileProcessor = new MappingFileProcessor();
		mappingFileProcessor.init();

		matchedMapping = mappingFileProcessor.addUniqueMappingEntry(mappingEntry);

		// System.out.println("Looking for: " + mappingEntry.getCsvLine());
		// System.out.println("Found mapping: " + matchedMapping.getCsvLine());
		// System.out.println("");

		mappingFileProcessor.writeCsvFile();

	}

	// Return values for i2b2:

	public String getiItemName() {
		return matchedMapping.getiItemName();
	}

	public String getiModifierName() {
		return matchedMapping.getiModifierName();
	}

	public String getiType() {
		return matchedMapping.getiType();
	}

	public String getiItemIcon() {
		return matchedMapping.getiItemIcon();
	}

	public String getiKey() {
		return matchedMapping.getiKey();
	}

	public String getiModifierKey() {
		return matchedMapping.getiModifierKey();
	}

	public String getiAppliedPath() {
		return matchedMapping.getiAppliedPath();
	}

	// Return values for Samply:

	public String getsType() {
		return matchedMapping.getsType();
	}

	public String getsKey() {
		return matchedMapping.getsKey();
	}

	public String getsValue() {
		return matchedMapping.getsValue();
	}

	public String getsLowerBound() {
		return matchedMapping.getsLowerBound();
	}

	public String getsUpperBound() {
		return matchedMapping.getsUpperBound();
	}

	// Return valuesf for mapping direction:

	public String getDirection() {
		return matchedMapping.getDirection();
	}

}
