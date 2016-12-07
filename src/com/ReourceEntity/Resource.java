package com.ReourceEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource {

	@Id
	@Column(name="resourceId")
	private int resourceId;
	
	@Column(name="resourceName")
	private String resourceName;
	
	public Resource(){
		
	}

	public Resource(String resourceName) {
		super();
		this.resourceName = resourceName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	

	public int getResourceId() {
		return resourceId;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceName=" + resourceName + "]";
	}
	
	
	
}
