package com.demo;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.get_json_object;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;

public class ApplianceStructuredStreaming {

	public static void main(String[] args) throws InterruptedException, StreamingQueryException {
		SparkConf conf = new SparkConf().setAppName("SmartAppliance-Spark-Structured-Streaming").setMaster("local[*]");

		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

		Dataset<Row> applianceinfoDf = spark.readStream()
				.format("kafka")
				.option("kafka.bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094")
				.option("subscribe", "appliance-info-kafka")
				.load()
				.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
				.select(get_json_object(col("value"), "$.homeId").alias("homeId"),
						get_json_object(col("value"), "$.homeType").alias("homeType"),
						get_json_object(col("value"), "$.washingmachine").alias("washingmachine"),
						get_json_object(col("value"), "$.ac").alias("ac"),
						get_json_object(col("value"), "$.fridge").alias("fridge"),
						get_json_object(col("value"), "$.waterlevel").alias("waterlevel"),
						get_json_object(col("value"), "$.emergency").alias("emergency"));

		Dataset<Row> busInfo = applianceinfoDf.filter(col("homeType").equalTo("Apartment"));
		busInfo.writeStream().format("json")
				.option("checkpointLocation",
						"/home/dhayanidhi/workspace/GenerateSmartHomeData/simulated-data/check-point")
				.option("path","/home/dhayanidhi/workspace/GenerateSmartHomeData/simulated-data/out/apartment").start()
				.awaitTermination();

	}
}