import java.util.Scanner;
import java.awt.Frame;

public class GiocoUmano  {

    public static void main(String[]args) {
        Finestre.main(args);
        Metodi.svuota();
        System.out.println("con cosa vuoi giocare? 1 = x; -1 = o");
        Metodi.conCosaGioca1 = Metodi.chiediInt(2);
        boolean rifare =true;
        do {
            Metodi.tris();
            int inizio = Metodi.inizio();
            System.out.println("turno di :"+inizio);
            if (inizio == Metodi.conCosaGioca1 ) {
                do {
                    System.out.println("TURNO GIOCATORE1");
                    gioco(1);
                    Metodi.tris();
                    Metodi.fine();

                    if (Metodi.ctrl == true || Metodi.part == true) {
                        break;
                    }
                    System.out.println("TURNO GIOCATORE2");
                    gioco(2);
                    Metodi.tris();
                    Metodi.fine();

                }
                while(!Metodi.ctrl && !Metodi.part);
            }
            else {
                do {
                    System.out.println("TURNO GIOCATORE2");
                    gioco(2);
                    Metodi.tris();
                    Metodi.fine();

                    if (Metodi.ctrl == true || Metodi.part == true) {
                        break;
                    }
                    System.out.println("TURNO GIOCATORE1");
                    gioco(1);
                    Metodi.tris();
                    Metodi.fine();

                }while(Metodi.ctrl == false && Metodi.part == false);
            }
            rifare =Metodi.rifare();
            Metodi.svuota();
        } while (rifare==true);
    }




    public static void gioco(int chiGioca){

        System.out.println("in che riga?");
        int riga = Metodi.chiediInt(3);
        System.out.println("in che colonna?");
        int colonna = Metodi.chiediInt(3);
        if (Main.tris[riga][colonna]==0){
            if (chiGioca == 1){
                Main.tris[riga][colonna] = Metodi.conCosaGioca1;
            }else{
                Main.tris[riga][colonna] = Metodi.conCosaGioca1 * -1;
            }
        } else {
            System.out.println("cella già occupata");
            gioco(chiGioca);
        }
    }

}