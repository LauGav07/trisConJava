// sistemare pareggio
import java.util.Scanner;
public class Main{
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
        titolo();
        do {
            System.out.println("giocatore 1");
            menu();
            String giocatore = chiedistringa();
            String giocatore1= giocatore.toLowerCase();
            System.out.println("giocatore 2");
            menu();
            giocatore = chiedistringa();
            String giocatore2= giocatore.toLowerCase();
            giocatore2.toLowerCase();
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
                System.out.println("scelta inesistente, riprova");
                rifare = true;
            }
            //argomento menu
            // ricordati di portare tutto a low chase se lasci il menu cosi


        }while (rifare);
    }
    public static void menu() {}
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
    public static String chiedistringa() {
        Scanner scanner = new Scanner(System.in);
        String frase = scanner.nextLine();
        return frase;
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