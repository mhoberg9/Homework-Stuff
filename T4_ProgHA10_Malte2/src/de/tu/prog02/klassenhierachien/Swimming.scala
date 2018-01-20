package de.tu.prog02.klassenhierachien

trait Swimming extends Animal{
  val swimmMessage:String;
  def swimm();
  override def makeNoise()= super.makeNoise()+" Swimming";
}