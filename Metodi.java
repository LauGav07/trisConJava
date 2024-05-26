import java.util.Scanner;
public class Metodi {
    public static boolean ctrl = false;
    public static boolean part = true;
    //static int x = 1;
//static int o = -1;
    public static int conCosaGioca1 = 0;
    public static int conCosaGioca = 0;
    public static int trr = 0;

    public static void tris(){

        for(int riga=0; riga<Main.tris.length; riga++) {
            for(int colonna=0; colonna<Main.tris[0].length; colonna++) {
                if (Main.tris[riga][colonna]==1) {
                    System.out.print("X"+" ");
                }else if (Main.tris[riga][colonna]==-1){
                    System.out.print("O"+" ");
                }else {
                    System.out.print(Main.tris[riga][colonna]+" ");
                } }
            System.out.println(" ");
        }
    }
    public static boolean rifare(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("vuoi giocare ancora a questa modalità : [si] o [no]");
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
    public static void svuota(){
        for(int riga=0; riga<Main.tris.length; riga++) {
            for(int colonna=0; colonna<Main.tris[0].length; colonna++) {
                Main.tris[riga][colonna]=0;
            }
        }
    }
    public static void fine(){
        part = true;
        for(int i=0; i<Main.tris.length; i++) {
            for(int j=0; j<Main.tris[0].length; j++) {
                if (Main.tris[i][j] == 0) {
                    part = false;
                    //partita in corso
                }
            }
        }
        if(Math.abs(Main.tris[0][0] + Main.tris[0][1] + Main.tris[0][2])==3) {
            ctrl = true;
            trr=Main.tris[0][0] + Main.tris[0][1] + Main.tris[0][2];
        }
        else if(Math.abs(Main.tris[1][0] + Main.tris[1][1] + Main.tris[1][2])==3) {
            ctrl = true;
            trr=Main.tris[1][0] + Main.tris[1][1] + Main.tris[1][2];
        }
        else if(Math.abs(Main.tris[2][0] + Main.tris[2][1] + Main.tris[2][2])==3) {
            ctrl = true;
            trr=Main.tris[2][0] + Main.tris[2][1] + Main.tris[2][2];
        }
        else if(Math.abs(Main.tris[0][0] + Main.tris[1][1] + Main.tris[2][2])==3) {
            ctrl = true;
            trr=Main.tris[0][0] + Main.tris[1][1] + Main.tris[2][2];
        }
        else if(Math.abs(Main.tris[0][2] + Main.tris[1][1] + Main.tris[2][0])==3) {
            ctrl = true;
            trr=Main.tris[0][2] + Main.tris[1][1] + Main.tris[2][0];
        }
        else if(Math.abs(Main.tris[0][0] + Main.tris[1][0] + Main.tris[2][0])==3) {
            ctrl = true;
            trr=Main.tris[0][0] + Main.tris[1][0] + Main.tris[2][0];
        }
        else if(Math.abs(Main.tris[0][1] + Main.tris[1][1] + Main.tris[2][1])==3) {
            ctrl = true;
            trr=Main.tris[0][1] + Main.tris[1][1] + Main.tris[2][1];
        }
        else if(Math.abs(Main.tris[0][2] + Main.tris[1][2] + Main.tris[2][2])==3) {
            ctrl = true;
            trr=Main.tris[0][2] + Main.tris[1][2] + Main.tris[2][2];
        } else {ctrl = false;
        }
        if(ctrl == true){
            if ((trr<0 && conCosaGioca1<0)||(trr>0 && conCosaGioca1>0)) {
                System.out.println("Ha vinto Giocatore1");
            } else if((trr<0 && conCosaGioca1>0)||(trr>0 && conCosaGioca1<0)) {
                System.out.println("Ha vinto Giocatore2");}
        }
        else if(part == true) {
            System.out.println("pareggio");
        }
    }
    public static int chiediInt(int n) {
        Scanner scanner = new Scanner(System.in);
        boolean f = false;
        int valore= 0;
        do {
            try {
                valore = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("valore impossibile");
                f=true;
                System.out.println("inserisci valore : ");
                return chiediInt(n);
            }
        } while (f);
        switch (valore) {
            case -1:
                if (n!=3) {
                    return valore;
                }
                else{
                    System.out.println("Scelta non corretta, riprova");
                    return chiediInt(n);
                }
            case 0:
                if (n==3) {
                    return valore;
                }
                else{
                    System.out.println("Scelta non corretta, riprova");
                    return chiediInt(n);
                }
            case 1 :
                return valore;
            case 2:
                if (n==3) {
                    return valore;
                }
                else{
                    System.out.println("Scelta non corretta, riprova");
                    return chiediInt(n);
                }
            default :
                System.out.println("Scelta non corretta, riprova");
                return chiediInt(n);
        }
    }
    public static int inizio(){
        int inizio = (int)(Math.random()*2);
        if (inizio==0) {
            inizio = -1;
        }
        return inizio;
    }
}
