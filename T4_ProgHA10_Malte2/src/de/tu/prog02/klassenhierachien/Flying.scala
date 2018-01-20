package de.tu.prog02.klassenhierachien

trait Flying extends Animal{
  val flyMessage:String;
  def fly();
  override def makeNoise()= super.makeNoise()+" Flying";
}