package com.iai.springbootsparkstreaming.spark.services

import com.iai.springbootsparkstreaming.spark.{Distributor, ProductDatasetCache}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.OutputMode
import org.apache.spark.sql.{SparkSession, functions}
import org.springframework.stereotype.Service

/**
  * @author Evgeny Borisov
  */
@Service
class EtlService(@transient sparkSession: SparkSession, @transient webSocketService: WebSocketService,@transient productDatasetCache: ProductDatasetCache) extends Serializable {
  var name:String="Vasya"
  def changeName(newName:String):Unit={
    name=newName
  }
  def clientId2Name(id:String):String=name
  val myUdf: UserDefinedFunction =functions.udf[String,String](clientId2Name)

  def start(): Unit = {
    val purchases = webSocketService.getDs(sparkSession).as("purchase")
    val products = productDatasetCache.productsDataset.as("products")
    var df = purchases.join(products,col("purchase.product_id")===col("products.id"))
    df=df.withColumn("a",myUdf(col("purchase.client_id")))
    Distributor.write(df, mode = OutputMode.Append()).awaitTermination
  }
}
