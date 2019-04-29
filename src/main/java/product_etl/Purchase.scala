package product_etl

import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.read

/**
  * @author Evgeny Borisov
  */
case class Purchase(product_id:Int,client_id:Int,cashbox_id:Int,price:Int=0) {

}
object Purchase{
  def fromLine(line:String):Purchase={
    implicit val formats = DefaultFormats
    read[Purchase](line)
  }
}