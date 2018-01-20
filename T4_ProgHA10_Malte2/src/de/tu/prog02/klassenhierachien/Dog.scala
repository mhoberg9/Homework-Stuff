package de.tu.prog02.klassenhierachien

class Dog(val name:String) extends Animal with Friend {
 override def makeNoise()="Wuff";
override def isFriend()= println(s"Dog's name: $name");
}