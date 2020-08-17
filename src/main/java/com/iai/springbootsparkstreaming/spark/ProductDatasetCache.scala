package com.iai.springbootsparkstreaming.spark

import org.apache.spark.sql.{Dataset, Encoders, SparkSession}
import org.springframework.stereotype.Service

import scala.collection.JavaConverters.iterableAsScalaIterableConverter

/**
  * @author Evgeny Borisov
  */
@Service
class ProductDatasetCache(sparkSession: SparkSession) {
  private implicit val encoder = Encoders.bean(classOf[com.iai.springbootsparkstreaming.model.Product])

  var
  productsDataset: Dataset[com.iai.springbootsparkstreaming.model.Product] = _

  def refreshCache(list: java.util.List[com.iai.springbootsparkstreaming.model.Product]): Unit = {
    import sparkSession.implicits._

    productsDataset = sparkSession.createDataset(list)
    productsDataset = sparkSession.sparkContext.parallelize(list.asScala.toList).toDS()
  }

}
