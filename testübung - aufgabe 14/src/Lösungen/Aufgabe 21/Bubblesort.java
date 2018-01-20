import Prog1Tools.*;
public class Bubblesort {
  public static void main(String [] args) {
    int count=IOTools.readInteger("Wieviele Zahlen willst Du sortieren? ");
    int [] zahl=new int[count];
    for (int i=0;i<count;i++)
      zahl[i]=IOTools.readInteger((i+1)+". Zahl: ");
    
    for (int i=0;i<count-1;i++) {
      for (int j=0;j<count-1;j++) {
        if (zahl[j]>zahl[j+1]) {
          int k=zahl[j];
          zahl[j]=zahl[j+1];
          zahl[j+1]=k;
        }
      }
    }

    for (int i=0;i<count;i++)
      System.out.print(zahl[i]+" ");
    System.out.println();
  }
}// Bubblesort



