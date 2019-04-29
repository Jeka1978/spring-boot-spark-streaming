package com.iai.springbootsparkstreaming.spark.services

import java.beans.Transient

import com.iai.springbootsparkstreaming.Purchase
import com.iai.springbootsparkstreaming.services.ProductService
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.springframework.stereotype.Service

/**
  * @author Evgeny Borisov
  */
@Service
class EtlService(sparkSession: SparkSession, products:Map[Long,com.iai.springbootsparkstreaming.model.Product]) extends Serializable {
 /* def start(): Unit = {
    val ssc = new StreamingContext(sparkSession.sparkContext, Seconds(1))
    val lines = ssc.socketTextStream("localhost", 9999)

    lines.map(Purchase.fromLine)
      .transform(rdd => rdd.mapPartitions(iterator => {
        iterator.map(purchase => {
          val product = products(purchase.product_id)
          purchase.copy(price = product.getPrice,product_name = product.getName)
        })
      }))
      .print()

    // Print the first ten elements of each RDD generated in this DStream to the console
    ssc.start() // Start the computation
    ssc.awaitTermination()
  }*/
}
