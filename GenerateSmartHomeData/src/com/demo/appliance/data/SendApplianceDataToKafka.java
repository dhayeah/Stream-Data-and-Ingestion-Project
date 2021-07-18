package com.demo.appliance.data;

import static com.demo.appliance.data.GenerateApplianceInfo.generateBooleanData;
import static com.demo.appliance.data.GenerateApplianceInfo.generateRandomhomeId;
import static com.demo.appliance.data.GenerateApplianceInfo.generatewaterlevel;
import static com.demo.appliance.data.GenerateApplianceInfo.generatewashingmachineData;
import static com.demo.appliance.data.GenerateApplianceInfo.generatefridgeData;
import static com.demo.appliance.data.GenerateApplianceInfo.generateacData;
import static com.demo.appliance.data.GenerateApplianceInfo.generateRandomhomeType;

import java.util.Random;

import com.demo.appliance.data.SimpleKafkaProducer;

public class SendApplianceDataToKafka {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		while (true) {

			int records = new Random().nextInt(15);
			for (int i = 1; i <= records; i++) {
				ApplianceInfo applianceInfo = new ApplianceInfo();
				applianceInfo.sethomeId(generateRandomhomeId());
				applianceInfo.sethomeType(generateRandomhomeType());
				
				applianceInfo.setac(generateacData(18.5, 24.5));
				applianceInfo.setfridge(generatefridgeData(0, 15));
				applianceInfo.setwashingmachine(generatewashingmachineData(12.99, 98.99));
				
				applianceInfo.setwaterlevel(generatewaterlevel(0, 100));
				applianceInfo.setemergency(generateBooleanData());
				
				// Write the applianceInfo data into a file
				SimpleKafkaProducer.sendDataToKafkaMultipleBroker(applianceInfo.toString(), "appliance-info-kafka",applianceInfo.gethomeType());
			  
			}
			System.out.println("Written "+records+" to kafka..");
			Thread.sleep(300);
		}
		
	}
}
