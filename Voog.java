import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
import java.io.*;

public class Voog{
  public static void main(String[] args)throws Exception{
    PrintWriter kirjutaja = new PrintWriter(new FileWriter("valjund.txt"));

    Files.readAllLines(Paths.get("sisend.txt")).
      stream().
      filter(s -> Integer.parseInt(s.split(",")[2]) > 160).
      sorted(Comparator.comparing(s -> s.split(",")[2])).
      map(s -> "Õpilane " + s.split(",")[0] + ", pikkusega " + s.split(",")[2] + " cm, on pikem kui 160 cm").
      collect(Collectors.toList()).
      forEach(kirjutaja::println)
      ;
    kirjutaja.close();
  }
}

/*
Sisend:

Juku,M,176
Madis,M,170
Liisa,N,166
Juhan,M,164
Malle,N,158
Kati,N,160
Kalle,M,169
Grete,N,149
Maali,N,155
Meelis,M,171

Väljund:

Õpilane Juhan, pikkusega 164 cm, on pikem kui 160 cm
Õpilane Liisa, pikkusega 166 cm, on pikem kui 160 cm
Õpilane Kalle, pikkusega 169 cm, on pikem kui 160 cm
Õpilane Madis, pikkusega 170 cm, on pikem kui 160 cm
Õpilane Meelis, pikkusega 171 cm, on pikem kui 160 cm
Õpilane Juku, pikkusega 176 cm, on pikem kui 160 cm


*/
