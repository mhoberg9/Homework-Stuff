package de.tu.prog02.klassenhierachien

abstract class Bird(val name:String) extends Animal{
  
 override def makeNoise()=super.makeNoise()+s" $name";
}