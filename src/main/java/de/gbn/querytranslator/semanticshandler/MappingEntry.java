package de.gbn.querytranslator.semanticshandler;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import de.gbn.querytranslator.omniquery.ConstraintNode;

public class MappingEntry {

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

	public String getHeadline() {
		return "sType; sKey; sValue; sLowerBound; sUpperBound; Direction; iType; iItemName; iItemIcon; iKey; iModifierName; iModifierKey; iAppliedPath";
	}

	public String getCsvLine() {
		removeNulls();
		return sType + "; " + sKey + "; " + sValue + "; " + sLowerBound + "; " + sUpperBound + "; " + Direction + "; " + iType + "; " + iItemName + "; " + iItemIcon + "; " + iKey + "; "
				+ iModifierName + "; " + iModifierKey + "; " + iAppliedPath;
	}

	
	public void removeWildcards() {
		if (this.sType == "*")
			this.sType = "";
		if (this.sKey == "*")
			this.sKey = "";
		if (this.sValue == "*")
			this.sValue = "";
		if (this.sLowerBound == "*")
			this.sLowerBound = "";
		if (this.sUpperBound == "*")
			this.sUpperBound = "";
		if (this.Direction == "*")
			this.Direction = "";
		if (this.iType == "*")
			this.iType = "";
		if (this.iItemName == "*")
			this.iItemName = "";
		if (this.iItemIcon == "*")
			this.iItemIcon = "";
		if (this.iKey == "*")
			this.iKey = "";
		if (this.iModifierName == "*")
			this.iModifierName = "";
		if (this.iModifierKey == "*")
			this.iModifierKey = "";
		if (this.iAppliedPath == "*")
			this.iAppliedPath = "";
	}
	
	
	public void initFromLine(String line) {

		String[] attributes = line.split(";");
		this.sType = attributes[0].trim();
		this.sKey = attributes[1].trim();
		this.sValue = attributes[2].trim();
		this.sLowerBound = attributes[3].trim();
		this.sUpperBound = attributes[4].trim();
		this.Direction = attributes[5].trim();
		this.iType = attributes[6].trim();
		this.iItemName = attributes[7].trim();
		this.iItemIcon = attributes[8].trim();
		this.iKey = attributes[9].trim();
		this.iModifierName = attributes[10].trim();
		this.iModifierKey = attributes[11].trim();
		this.iAppliedPath = attributes[12].trim();
		removeNulls();
	}

	private void removeNulls() {

		if (this.sType == null)
			this.sType = "";
		if (this.sKey == null)
			this.sKey = "";
		if (this.sValue == null)
			this.sValue = "";
		if (this.sLowerBound == null)
			this.sLowerBound = "";
		if (this.sUpperBound == null)
			this.sUpperBound = "";
		if (this.Direction == null)
			this.Direction = "";
		if (this.iType == null)
			this.iType = "";
		if (this.iItemName == null)
			this.iItemName = "";
		if (this.iItemIcon == null)
			this.iItemIcon = "";
		if (this.iKey == null)
			this.iKey = "";
		if (this.iModifierName == null)
			this.iModifierName = "";
		if (this.iModifierKey == null)
			this.iModifierKey = "";
		if (this.iAppliedPath == null)
			this.iAppliedPath = "";
	}

	public boolean isMappable(MappingEntry comp) {

		/*
		 * if ((this.sType.matches(comp.getsType()) && this.sKey.matches(comp.getsKey()) && this.sValue.matches(comp.getsValue()) &&
		 * this.sLowerBound.matches(comp.getsLowerBound()) && this.sUpperBound.matches(comp.getsUpperBound()) && this.Direction.matches(comp.getDirection()) &&
		 * this.iType.matches(comp.getiType()) && this.iItemIcon.matches(comp.getiItemIcon()) && this.iKey.matches(comp.getiKey()) &&
		 * this.iModifierKey.matches(comp.getiModifierKey()) && this.iAppliedPath.matches(comp.getiAppliedPath()) &&
		 * this.iModifierName.matches(comp.getiModifierName()) && this.iItemName.matches(comp.getiItemName()))) {
		 */

		if (compare(this.sType, comp.getsType()) &&
				compare(this.sKey, comp.getsKey()) &&
				compare(this.sValue, comp.getsValue()) &&
				compare(this.sLowerBound, comp.getsLowerBound())&&
				compare(this.sUpperBound, comp.getsUpperBound()) &&
				compare(this.Direction, comp.getDirection()) &&
				compare(this.iType, comp.getiType())&&
				compare(this.iItemName, comp.getiItemName()) &&
				compare(this.iItemIcon, comp.getiItemIcon()) &&
				compare(this.iKey, comp.getiKey())&&
				compare(this.iModifierName, comp.getiModifierName()) &&
				compare(this.iModifierKey, comp.getiModifierKey()) &&
				compare(this.iAppliedPath, comp.getiAppliedPath())) {

			System.out.println("Match: " + getCsvLine());
			System.out.println(" with: " + comp.getCsvLine());
			System.out.println("");

			return true;
		}

		// System.out.println("No Match: " + getCsvLine()); System.out.println(" with: " + comp.getCsvLine()); System.out.println("");

		return false;
	}

	// ------------------ Getters and Setters: ------------------

	private boolean compare(String a, String b) {

		if (a.equals(b))
			return true;
		if (a.equals("*") && !b.equals("*"))
			return true;
		if (!a.equals("*") && b.equals("*"))
			return true;

		return false;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getsKey() {
		return sKey;
	}

	public void setsKey(String sKey) {
		this.sKey = sKey;
	}

	public String getsValue() {
		return sValue;
	}

	public void setsValue(String sValue) {
		this.sValue = sValue;
	}

	public String getsLowerBound() {
		return sLowerBound;
	}

	public void setsLowerBound(String sLowerBound) {
		this.sLowerBound = sLowerBound;
	}

	public String getsUpperBound() {
		return sUpperBound;
	}

	public void setsUpperBound(String sUpperBound) {
		this.sUpperBound = sUpperBound;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}

	public String getiType() {
		return iType;
	}

	public void setiType(String iType) {
		this.iType = iType;
	}

	public String getiItemIcon() {
		return iItemIcon;
	}

	public void setiItemIcon(String iItemIcon) {
		this.iItemIcon = iItemIcon;
	}

	public String getiKey() {
		return iKey;
	}

	public void setiKey(String iKey) {
		this.iKey = iKey;
	}

	public String getiModifierKey() {
		return iModifierKey;
	}

	public void setiModifierKey(String iModifierKey) {
		this.iModifierKey = iModifierKey;
	}

	public String getiAppliedPath() {
		return iAppliedPath;
	}

	public void setiAppliedPath(String iAppliedPath) {
		this.iAppliedPath = iAppliedPath;
	}

	public String getiItemName() {
		return iItemName;
	}

	public void setiItemName(String iItemName) {
		this.iItemName = iItemName;
	}

	public String getiModifierName() {
		return iModifierName;
	}

	public void setiModifierName(String iModifierName) {
		this.iModifierName = iModifierName;
	}

	
}
