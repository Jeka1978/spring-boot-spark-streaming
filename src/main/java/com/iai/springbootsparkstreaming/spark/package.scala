package com.iai.springbootsparkstreaming

import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.read

/**
  * @author Evgeny Borisov
  */

case class Purchase(
                     product_id: Long,
                     client_id: Long,
                     cashbox_id: Long,
                     timestamp: Long,
                     price:Int=0,
                     product_name:String=""
                   )
object
Purchase{
  def fromLine(line:String):Purchase={
    implicit val formats = DefaultFormats
    read[Purchase](line)
  }
}