import java.util.Scanner;
public class Main{
    public static int tastiera ;
    public static int [][] tris = new int[3][3];
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";
    static boolean rifare =true;
    public static void main(String[]args) {
        boolean e1 = false;
        boolean err2 = false;
        String giocatore1;
        String giocatore2;
        titolo();
        boolean ff ;
        do{
            ff =true;
            System.out.println("scegli per decidere il tipo di input tra coordinate, lettere, numeri");
          String tr1 = Metodi.chiedistringa();
            String tr= tr1.toLowerCase();
            if(!tr.equals("numeri") && !tr.equals("coordinate") && !tr.equals("lettere")){
                System.out.println("errore, riprova");
               ff  = false;
            } else if (tr.equals("coordinate")) {
                tastiera =-1;
            } else if (tr.equals("numeri")) {
                tastiera =-2;
            } else {
                tastiera =-3;
            }
        }while(!ff);
        do {
            do{
                e1 = false;
                System.out.println("giocatore 1");
                System.out.println("scegli tra bot e umano per decidere ");
                String giocatore = Metodi.chiedistringa();
                giocatore1= giocatore.toLowerCase();
                if(!giocatore1.equals("umano") && !giocatore1.equals("bot")){
                    System.out.println("errore, riprova");
                    e1 = true;
                }
            }while(e1);
            do{
                err2 = false;
                System.out.println("giocatore 2");
                System.out.println("scegli tra bot e umano per decidere, per cambiare giocatore1 scrivere cambio");
                String giocatore = Metodi.chiedistringa();
                giocatore2= giocatore.toLowerCase();
                if(!giocatore2.equals("umano") && !giocatore2.equals("bot")&& !giocatore2.equals("cambio")){
                    System.out.println("errore, riprova");
                    err2 = true;
                }
            }while(err2);
            if ((giocatore1.equals("umano") && giocatore2.equals("bot")) || (giocatore1.equals("bot") && giocatore2.equals("umano"))) {
                botVSumano(args);
                rifare =rifare();
            } else if (giocatore1.equals("umano") && giocatore2.equals("umano")) {
                umanoVSumano(args);
                rifare =rifare();
            } else if (giocatore1.equals("bot") && giocatore2.equals("bot")) {
                botVSbot(args);
                rifare =rifare();
            } else {
                rifare = true;
            }
        }while (rifare);
    }
    public static boolean rifare(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("vuoi rifare: [si] o [no]");
        String decisione = scanner.nextLine();
        decisione.toLowerCase();
        if(decisione.equals("si")){
            return true;
        }
        if (decisione.equals("no") ){
            return false;
        } else {
            System.out.println("cosa vuoi dalla mia vita?");
            return rifare();
        }
    }
    public static void botVSumano(String[]args) {
        GiocoBot prova = new GiocoBot();
        prova.main(args);
    }
    public static void botVSbot(String[]args) {
        GiocoBotBot prova = new GiocoBotBot();
        prova.main(args);
    }
    public static void umanoVSumano(String[]args) {
        GiocoUmano prova = new GiocoUmano();
        prova.main(args);
    }
    public static void titolo() {
        System.out.println(YELLOW + """  
               _______   _    \s
              |__   __| (_)   \s
                 | |_ __ _ ___\s
                 | | '__| / __|
                 | | |  | \\__ \\
                 |_|_|  |_|___/
     """+ WHITE);
    }
}
