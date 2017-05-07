package com.home.chegg1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProjectManagement implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Project> list;

	public ProjectManagement() {
		this.list = new ArrayList<Project>();
	}

	int projNumberExists(int projNumber) {
		if (this.list != null) {
			for (int i = 0; i < list.size(); i++) {
				Project project = list.get(i);
				if (project.getNumber() == projNumber) {
					return i;
				}
			}
		}
		return -1;
	}

	int nameLocationExists(String name, String location) {
		if (this.list != null) {
			for (int i = 0; i < list.size(); i++) {
				Project project = list.get(i);
				if (project.getName().endsWith(name) && project.getLocation().equalsIgnoreCase(location)) {
					return i;
				}
			}
		}
		return -1;
	}

	boolean addProject(String name, String location, int projNumber, double initialFund) {
		int result = nameLocationExists(name, location);
		if (result == -1) {
			result = projNumberExists(projNumber);
			if (result == -1) {
				Project project = new Project(initialFund);
				project.setLocation(location);
				project.setName(name);
				project.setNumber(projNumber);
				this.list.add(project);
				return true;
			}
		}
		return false;
	}

	boolean removeProjNumber(int projNumber) {
		if (this.list != null) {
			Iterator<Project> iterator = this.list.iterator();
			while (iterator.hasNext()) {
				Project project = iterator.next();
				if (project.getNumber() == projNumber) {
					iterator.remove();
					return true;
				}
			}
		}
		return false;
	}

	boolean removeNameLocation(String name, String location) {
		if (this.list != null) {
			Iterator<Project> iterator = this.list.iterator();
			while (iterator.hasNext()) {
				Project project = iterator.next();
				if (project.getName().endsWith(name) && project.getLocation().equalsIgnoreCase(location)) {
					iterator.remove();
					return true;
				}
			}
		}
		return false;
	}

	void sortByProjNumber() {
		Collections.sort(this.list, new ProjNumberComparator());
	}

	void sortByNameLocation() {
		Collections.sort(this.list, new ProjNameLocationComparator());
	}

	String listProjects() {
		return this.list.toString();
	}

	void closeProjectManagement() {
		this.list.clear();
	}

	public List<Project> getList() {
		return list;
	}

	public void setList(List<Project> list) {
		this.list = list;
	}

}
