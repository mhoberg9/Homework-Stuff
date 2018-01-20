package de.tuberlin.snet.prog2.ue10.consoles

class Console(var hersteller: String, var modell: String, var date: java.util.Date , wifi: Option[String] , format : List[Format]  , val pixel : Resolution) {
  
   override def toString = s"Hersteller: ($hersteller) , Modell: ($modell) , Date: ($date) , Wifi: ($wifi), Format: ($format) , ($pixel)";
   
  

}