import java.util.Scanner;
    public class GiocoBotBot  {
        static boolean ctrl = false;
        static boolean part = true;
        //static int x = 1;
//static int o = -1;
        static int decisione = 0;
        static int trr = 0;
        static int [][] tris = new int[3][3];
        public static void main(String[]args) {
           // Metodi.svuota();

            boolean rifare =true;
            do {

                tris();
                svuota();
                System.out.println("funziona");
                rifare =rifare();
                svuota();
            } while (rifare==true);
        }
        public static void tris(){
            for(int riga=0; riga<tris.length; riga++) {
                for(int colonna=0; colonna<tris[0].length; colonna++) {
                    if (tris[riga][colonna]==1) {
                        System.out.print("X"+" ");
                    }else if (tris[riga][colonna]==-1){
                        System.out.print("O"+" ");
                    }else {
                        System.out.print(tris[riga][colonna]+" ");
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
            for(int riga=0; riga<tris.length; riga++) {
                for(int colonna=0; colonna<tris[0].length; colonna++) {
                    tris[riga][colonna]=0;
                }
            }
        }
        /*  public static void fine(){
             part = true;
             for(int i=0; i<tris.length; i++) {
                 for(int j=0; j<tris[0].length; j++) {
                     if (tris[i][j] == 0) {
                         part = false;
      //partita in corso
                     }
                 }
             }
             if(Math.abs(tris[0][0] + tris[0][1] + tris[0][2])==3) {
                 ctrl = true;
                 trr=tris[0][0] + tris[0][1] + tris[0][2];
             }
             else if(Math.abs(tris[1][0] + tris[1][1] + tris[1][2])==3) {
                 ctrl = true;
                 trr=tris[1][0] + tris[1][1] + tris[1][2];
             }
             else if(Math.abs(tris[2][0] + tris[2][1] + tris[2][2])==3) {
                 ctrl = true;
                 trr=tris[2][0] + tris[2][1] + tris[2][2];
             }
             else if(Math.abs(tris[0][0] + tris[1][1] + tris[2][2])==3) {
                 ctrl = true;
                 trr=tris[0][0] + tris[1][1] + tris[2][2];
             }
             else if(Math.abs(tris[0][2] + tris[1][1] + tris[2][0])==3) {
                 ctrl = true;
                 trr=tris[0][2] + tris[1][1] + tris[2][0];
             }
             else if(Math.abs(tris[0][0] + tris[1][0] + tris[2][0])==3) {
                 ctrl = true;
                 trr=tris[0][0] + tris[1][0] + tris[2][0];
             }
             else if(Math.abs(tris[0][1] + tris[1][1] + tris[2][1])==3) {
                 ctrl = true;
                 trr=tris[0][1] + tris[1][1] + tris[2][1];
             }
             else if(Math.abs(tris[0][2] + tris[1][2] + tris[2][2])==3) {
                 ctrl = true;
                 trr=tris[0][2] + tris[1][2] + tris[2][2];
             } else {ctrl = false;
             }
             if(ctrl == true){
                 if ((trr<0 && decisione<0)||(trr>0 && decisione>0)) {
                     System.out.println("vinto");
                 } else if((trr<0 && decisione>0)||(trr>0 && decisione<0)) {
                     System.out.println("perso");}
             }
             else if(part == true) {
                 System.out.println("pareggio");
             }
         }*/
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
    }

