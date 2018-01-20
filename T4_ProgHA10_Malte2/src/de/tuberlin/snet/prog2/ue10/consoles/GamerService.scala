package de.tuberlin.snet.prog2.ue10.consoles

import java.util.Date
import javafx.collections.transformation.SortedList

object GamerService {
  def main(args: Array[String]): Unit = {
    val ps = new Console("Sony", "PlayStation 5", new Date(2017, 8, 23), None, List(new CD), new FHD)

    val atari = new Console("Atari", "2600", new Date(1977, 10, 1), None, List(new BD), new QHD)

    val n64 = new Console("Nintendo", "N64", new Date(2017, 5, 14), None, List(new Cartridge), new HD)

    val GameCube = new Console("Nintendo", "GameCube", new Date(2015, 4, 24), None, List(new Cartridge), new UHD4K);

    println(ps.toString());
    println(atari.toString());
    println(GameCube.toString());
    println(n64.toString());
    
    var lc : List[Console] = List(ps, n64 , atari, GameCube);
    
    println("Unsorted: " + lc.toString());
    println("Sorted: " +lc.sortBy    {x => x.pixel.pixel }.toString());//_.pixl.pixl
    
    val peter = new Game ("Peter", "N5", List(ps, n64));
    
    
  }

}