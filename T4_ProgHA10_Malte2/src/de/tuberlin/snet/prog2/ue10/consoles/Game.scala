package de.tuberlin.snet.prog2.ue10.consoles

class Game ( name :String, hersteller : String, supconsole : List[Console]) {
  
  
   def isSupported(c : Console) : Boolean = {for(x <- supconsole) if (x.equals(c)) return true;
   return false;
   }
   
 
   
   override def toString = s"Name: ($name), Hersteller: ($hersteller), SupportedConsole: ($supconsole)";

   
   
   
}

object Game {
    
//????
  
  
  
}