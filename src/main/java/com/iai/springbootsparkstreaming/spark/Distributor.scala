package com.iai.springbootsparkstreaming.spark

import org.apache.spark.sql.Dataset
import org.apache.spark.sql.streaming.{OutputMode, StreamingQuery, Trigger}

/**
  * @author Evgeny Borisov
  */
object Distributor {
  def write(ds: Dataset[_], mode: OutputMode = OutputMode.Append()): StreamingQuery = {
    ds
      .writeStream
      .format("console")
      .outputMode(mode)
      .trigger(Trigger.ProcessingTime("5 seconds"))
      .start()
  }
}
