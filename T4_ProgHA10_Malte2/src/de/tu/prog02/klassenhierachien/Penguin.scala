package de.tu.prog02.klassenhierachien

class Penguin(override val name:String) extends Bird(name) with Swimming {
  def swimm()="Performing swimming";
 val swimmMessage=s"It's me $name, I am swimming";
  
}