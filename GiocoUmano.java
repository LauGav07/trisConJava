public class GiocoUmano {
    public static void main(String[] args) {
        do {
            //Finestre.main(args);
            Metodi.svuota();
            boolean tr = true;
            do {
                tr= true;
            System.out.println("con cosa vuoi giocare?  X oppure O");
            String b = Metodi.chiedistringa() ;
            String assoc = b.toLowerCase();
            if  (assoc.equals("x")){
                Metodi.conCosaGioca1=1;
            } else if (assoc.equals("o")){
                Metodi.conCosaGioca1=-1;
            }
            else{
                System.out.println("errore");
                tr = false;
            } }while(!tr);

            Metodi.rifare = true;
            Metodi.tris();
            //Finestre.main(args);
            int inizio = Metodi.inizio();
            System.out.println("turno di :" + inizio);
            if (inizio == Metodi.conCosaGioca1) {
                do {
                    System.out.println("TURNO GIOCATORE1");
                    gioco(1);
                    Metodi.tris();
                    //Finestre.main(args);
                    Metodi.fine(1);

                    if (Metodi.ctrl == true || Metodi.part == true) {
                        break;
                    }
                    System.out.println("TURNO GIOCATORE2");
                    gioco(2);
                    Metodi.tris();
                    //Finestre.main(args);
                    Metodi.fine(1);

                }
                while (!Metodi.ctrl && !Metodi.part);
            } else {
                do {
                    System.out.println("TURNO GIOCATORE2");
                    gioco(2);
                    Metodi.tris();
                    //Finestre.main(args);
                    Metodi.fine(1);

                    if (Metodi.ctrl == true || Metodi.part == true) {
                        break;
                    }
                    System.out.println("TURNO GIOCATORE1");
                    gioco(1);
                    Metodi.tris();
                    //Finestre.main(args);
                    Metodi.fine(1);

                } while (Metodi.ctrl == false && Metodi.part == false);
            }
            Metodi.rifare = Metodi.rifare();
        } while (Metodi.rifare == true);
    }
    public static void gioco(int chiGioca) {
        int colonna = -5;
        int riga = -5;
        switch (Main.tastiera) {
            case -1:
                boolean cont;
                do {
                    System.out.println("in che riga?");
                    riga = Metodi.chiediInt();
                    cont = true;
                    System.out.println("in che colonna? (se vuoi cambiare la riga, scrivere cambio)");
                    colonna = Metodi.chiediInt();
                    if (colonna == 10) {
                        cont = false;
                    }
                } while (!cont);
                break;
            case -2, -3:
                String numero = Metodi.chiedistringa();
                switch (numero) {
                    case "1", "z":
                        riga = 2;
                        colonna = 0;
                        break;
                    case "2", "x":
                        riga = 2;
                        colonna = 1;
                        break;
                    case "3", "c":
                        riga = 2;
                        colonna = 2;
                        break;
                    case "4", "a":
                        riga = 1;
                        colonna = 0;
                        break;
                    case "5", "s":
                        riga = 1;
                        colonna = 2;
                        break;
                    case "6", "d":
                        riga = 1;
                        colonna = 2;
                        break;
                    case "7", "q":
                        riga = 0;
                        colonna = 0;
                        break;
                    case "8", "w":
                        riga = 0;
                        colonna = 1;
                        break;
                    case "9", "e":
                        riga = 0;
                        colonna = 2;
                        break;
                    default:
                        System.out.println("inesistente, riprova");
                        gioco(chiGioca);
                        break;
                }
                System.out.println("riga" + riga);
                System.out.println("colonna = " + colonna);
                break;
        }
        if (Main.tris[riga][colonna] == 0) {
            if (chiGioca == 1) {
                Main.tris[riga][colonna] = Metodi.conCosaGioca1;
            } else {
                Main.tris[riga][colonna] = Metodi.conCosaGioca1 * -1;
            }
        } else {
            System.out.println("cella già occupata");
            gioco(chiGioca);
        }
    }
}
