package com.oakscode.spring.model;

import java.util.ArrayList;

public class Sidemenu {private String title, url, icon;
private ArrayList<Sidemenu> subMenu;

public Sidemenu(String title, String url, String icon, ArrayList<Sidemenu> subMenu) {
	super();
	this.title = title;
	this.url = url;
	this.icon = icon;
	this.subMenu = subMenu;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public String getIcon() {
	return icon;
}

public void setIcon(String icon) {
	this.icon = icon;
}

public ArrayList<Sidemenu> getSubMenu() {
	return subMenu;
}

public void setSubMenu(ArrayList<Sidemenu> subMenu) {
	this.subMenu = subMenu;
}





}
