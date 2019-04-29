package com.iai.springbootsparkstreaming.spark.conf

import java.util

import com.iai.springbootsparkstreaming.model.Product
import com.iai.springbootsparkstreaming.services.ProductService
import org.apache.spark.sql.SparkSession
import org.springframework.context.annotation.{Bean, Configuration, DependsOn}

/**
  * @author Evgeny Borisov
  */
@Configuration
class SparkConfiguration {

 /* @Bean
  def productMap(productService: ProductService): Map[Long, Product] = {
    var map: Map[Long, Product] = Map.empty
    val products: util.List[Product] = productService.findAll()
    import scala.collection.JavaConversions._
    products.foreach(p => {
      map += (p.getId -> p)
    })
    println(products.size())
    println("******************************* "+map.size)
    map

  }*/

  @Bean
  def sparkSession(): SparkSession = {
    SparkSession.builder()
      .appName("Cashbox")
      .master("local[*]")
      .getOrCreate()
  }

}
