package de.tu.prog02.klassenhierachien

object ClassApp {
  def main(args: Array[String]): Unit = {
    val p= new Duck("Donald");
    println(p.makeNoise());
  }
}