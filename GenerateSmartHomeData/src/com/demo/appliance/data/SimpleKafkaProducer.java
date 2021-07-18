package com.demo.appliance.data;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleKafkaProducer {
	 
	 public static void sendDataToKafka(String msg, String topicName){
	    
	    // create instance for properties to access producer configs   
	    Properties props = new Properties();
	    
	    //Assign localhost id
	    props.put("bootstrap.servers","localhost:9092");
	    
	    props.put("key.serializer", 
	       "org.apache.kafka.common.serialization.StringSerializer");
	       
	    props.put("value.serializer", 
	       "org.apache.kafka.common.serialization.StringSerializer");
	    
	    Producer<String, String> producer = new KafkaProducer<String, String>(props);
	          

	       producer.send(new ProducerRecord<String, String>(topicName,"appliance",msg));
	          
	        producer.close();
	           
	    }
	 public static void sendDataToKafkaMultipleBroker(String msg, String topicName, String key) {
			Properties props = new Properties();
			props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
			props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			Producer<String, String> producer = new KafkaProducer<String, String>(props);
			producer.send(new ProducerRecord<String, String>(topicName, key, msg));
			producer.close();
		}
}
