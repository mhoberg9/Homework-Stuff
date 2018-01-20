package de.tu.prog02.klassenhierachien

trait Colleague  {
  val name:String;
  def isColleague()= println(s" Colleague's name: $name");
}