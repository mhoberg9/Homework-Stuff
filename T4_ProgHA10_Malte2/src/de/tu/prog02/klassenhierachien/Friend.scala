package de.tu.prog02.klassenhierachien

trait Friend {
  val name:String;
  def isFriend()=println(s"Your Friend is $name");
}