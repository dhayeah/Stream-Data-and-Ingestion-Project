package com.demo.appliance.data;

import com.google.gson.Gson;

public class ApplianceInfo {

	private String homeId;
	private String homeType;
	private double washingmachine;
	private double ac;
	private double fridge;
	private int waterlevel;
	private boolean emergency;

	
	public String gethomeId() {
		return homeId;
	}

	public void sethomeId(String homeId) {
		this.homeId= homeId;
	}

	public String gethomeType() {
		return homeType;
	}

	public void sethomeType(String homeType) {
		this.homeType = homeType;
	}

	public double getwashingmachine() {
		return washingmachine;
	}

	public void setwashingmachine(double washingmachine) {
		this.washingmachine = washingmachine;
	}
	public double getac() {
		return ac;
	}

	public void setac(double ac) {
		this.ac = ac;
	}
	public int getwaterlevel() {
		return waterlevel;
	}
	
	public void setwaterlevel(int waterlevel) {
		this.waterlevel = waterlevel;
	}
	public double getfridge() {
		return fridge;
	}

	public void setfridge(double fridge) {
		this.fridge = fridge;
	}
	
	public boolean isemergency() {
		return emergency;
	}

	public void setemergency(boolean emergency) {
		this.emergency = emergency;
	}


	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
