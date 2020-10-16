package com.itwill2.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionMapInjectionBean {
	
	private List<String> addressList;
	private Set<String> addressSet;
	private Map<String,String> addressMap;
	private Properties addressProperties;
	
	private List<Controller> controllerList;
	private Set<Controller> controllerSet;
	private Map<String,Controller> controllerMap;
	private Properties controllerProperties;
	public List<String> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	public Set<String> getAddressSet() {
		return addressSet;
	}
	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}
	public Map<String, String> getAddressMap() {
		return addressMap;
	}
	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}
	public Properties getAddressProperties() {
		return addressProperties;
	}
	public void setAddressProperties(Properties addressProperties) {
		this.addressProperties = addressProperties;
	}
	public List<Controller> getControllerList() {
		return controllerList;
	}
	public void setControllerList(List<Controller> controllerList) {
		this.controllerList = controllerList;
	}
	public Set<Controller> getControllerSet() {
		return controllerSet;
	}
	public void setControllerSet(Set<Controller> controllerSet) {
		this.controllerSet = controllerSet;
	}
	public Map<String, Controller> getControllerMap() {
		return controllerMap;
	}
	public void setControllerMap(Map<String, Controller> controllerMap) {
		this.controllerMap = controllerMap;
	}
	public Properties getControllerProperties() {
		return controllerProperties;
	}
	public void setControllerProperties(Properties controllerProperties) {
		this.controllerProperties = controllerProperties;
	}
	public void print(){
		System.out.println("### List<String>: " + addressList);
		System.out.println("### Set<String>: " + addressSet);
		System.out.println("### Map<String, String>: " + addressMap);
		System.out.println("### Properties: " + addressProperties);
		System.out.println("### List<Controller>: " + controllerList);
		System.out.println("### Set<Controller>: " + controllerSet);
		System.out.println("### Map<String, Controller>: " + controllerMap);
		System.out.println("### Properties --> (String, String): " + controllerProperties);
	}
	
	
	
}
