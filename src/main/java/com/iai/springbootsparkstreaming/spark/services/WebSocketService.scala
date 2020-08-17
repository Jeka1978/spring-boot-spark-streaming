package com.iai.springbootsparkstreaming.spark.services

import com.iai.springbootsparkstreaming.Purchase
import org.apache.spark.sql.functions.from_json
import org.apache.spark.sql.{Dataset, Encoders, SparkSession}
import org.springframework.stereotype.Service

/**
  * @author Evgeny Borisov
  */
@Service
class WebSocketService(spark: SparkSession) {
  def getDs(spark: SparkSession): Dataset[Purchase] = {
    import spark.implicits._
    spark.readStream
      .format("socket")
      .option("host", "localhost")
      .option("port", 9988)
      .load()
      .withColumn("purchase_json", from_json($"value", Encoders.product[Purchase].schema))
      .select($"purchase_json.*")
      .as[Purchase]
  }

}
