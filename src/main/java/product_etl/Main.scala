package product_etl

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark._
import org.apache.spark.streaming._

/**
  * @author Evgeny Borisov
  */
object Main {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("products").setMaster("local[*]")
    val ssc = new StreamingContext(conf, Seconds(5))


    ssc.socketTextStream("localhost", 9999)
      .map(Purchase.fromLine)
      .map(purchase=>purchase.copy(price = productId2Price(purchase.product_id)))
      .print()

    ssc.start()
    ssc.awaitTermination()
  }

  def productId2Price(id:Long):Int={
    val map=Map(1L->100,2->200,4->500)
    map.getOrElse(id,50)

  }


}
