import java.util.Scanner;
public class GiocoBot{
    static boolean rifare =true;
    static boolean ctrl = false;
    static boolean part = false;
    //static int x = 1;
//static int o = -1;
    static int conCosaGioca = 0;
    static int trr = 0;
    static int [][] tris = new int[3][3];
    public static void main(String[]args) {
        System.out.println("con cosa vuoi giocare? 1 = x; -1 = o");
        conCosaGioca = chiediInt(2);
        do{
            tris();

            int turnoBot = 0;
            int inizio = inizio ();

            System.out.println("turno di :"+inizio);
            if (inizio == decisione ) {
                do {
                    System.out.println("TURNO UMANO");
                    turnoBot++;

                    gioco();
                    tris();
                    fine();

                    if (ctrl == true || part == true) {
                        break;
                    }
                    System.out.println("TURNO ROBOT");
                    turnoBot++;
                    bot(turnoBot);
                    tris();
                    fine();

                }
                while(ctrl == false && part == false);
            } else {
                do {
                    System.out.println("TURNO ROBOT");
                    turnoBot++;
                    bot(turnoBot);
                    tris();
                    fine();
                    if (ctrl == true || part == true) {
                        break;
                    }
                    System.out.println("TURNO UMANO");
                    turnoBot++;
                    gioco();
                    tris();
                    fine();

                }while(ctrl == false && part == false);
            }
            rifare =rifare();
            svuota();
        } while(rifare);
    }
    public static int inizio(){
        int inizio = (int)(Math.random()*2);
        if (inizio==0) {
            inizio = -1;
        }
        return inizio;
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
    public static void gioco(){
        System.out.println("in che riga?");
        int riga = chiediInt(3);
        System.out.println("in che colonna?");
        int colonna = chiediInt(3);
        if (tris[riga][colonna]==0){
            tris[riga][colonna] = decisione;
        } else {
            System.out.println("cella già occupata");
            gioco();
        }
    }
    public static int[] controlloStrategia() {
       for (int i = 0 ; i < 3 ;i++) {
            if(tris[i][0] + tris[i][1] + tris[i][2]==conCosaGioca*-2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(tris[i][j]==0){
                        int coordinate[]={i,j};
                        return  coordinate;
                    }
                }
            }
        }
        for (int i = 0 ; i < 3 ;i++) {
            if(tris[0][i] + tris[1][i] + tris[2][i]==conCosaGioca*-2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(tris[j][i]==0){
                        int coordinate[]= {j, i};
                        return  coordinate;
                    }
                }
            }
        }

        if(tris[0][0] + tris[1][1] + tris[2][2]==conCosaGioca*-2) {
            for (int j = 0 ; j < 3 ;j++){
                if(tris[j][j]==0){
                    int coordinate[]={j,j};
                    return  coordinate;

                }
            }
        }
        else if (tris[0][2] + tris[1][1] + tris[2][0]==decisione*-2) {
            for (int i = 2 ; i > -1 ;i--){
                for (int j = 0 ; j < 3 ;j++){
                    if(tris[j][i]==0){
                        int coordinate[]={j,i};
                        return  coordinate;

                    }
                }
            }
        }
        for (int i = 0 ; i < 3 ;i++) {
            if(Math.abs(tris[i][0] + tris[i][1] + tris[i][2])==2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(tris[i][j]==0){
                        int coordinate[]={i,j};
                        return  coordinate;
                    }
                }
            }
        }
        for (int i = 0 ; i < 3 ;i++) {
            if(Math.abs(tris[0][i] + tris[1][i] + tris[2][i])==2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(tris[j][i]==0){
                        int coordinate[]= {j, i};
                        return  coordinate;
                    }
                }
            }
        }

        if(Math.abs(tris[0][0] + tris[1][1] + tris[2][2])==2) {
            for (int j = 0 ; j < 3 ;j++){
                if(tris[j][j]==0){
                    int coordinate[]={j,j};
                    return  coordinate;

                }
            }
        }
        else if(Math.abs(tris[0][2] + tris[1][1] + tris[2][0])==2) {
            for (int i = 2 ; i > -1 ;i--){
                for (int j = 0 ; j < 3 ;j++){
                    if(tris[j][i]==0){
                        int coordinate[]={j,i};
                        return  coordinate;

                    }
                }
            }
        }
        int coordinate[]={1,1};
        return  coordinate;
    }
    public static void bot(int turnoBot) {
        int colonna1 =-1;
        int riga1 =-1;
        System.out.println(turnoBot);
        switch (turnoBot) {
            case 1:
                riga1 = 1;
                colonna1 = 1;
                break;
            case 2:
                if(tris[1][1]==0) {
                    riga1 = 1;
                    colonna1 = 1;
                } else{
                    riga1 = (int) (Math.random() * 2);
                    colonna1 = (int) (Math.random() * 2);
                    if (riga1 == 1) { riga1 = 2; }
                    if (colonna1 == 1) { colonna1 = 2;}
                }
                break;
            case 3:
                if ((tris[0][0] == 0)&&(tris[2][2] == 0)) {
                    riga1 = (int) (Math.random() * 2);
                    if (riga1 == 1) { riga1 = 2; }
                    colonna1 =  riga1 ;
                } else {
                    riga1 = (int) (Math.random() * 2);
                    if (riga1 == 1) { riga1 = 2; }
                    if (riga1 == 2){colonna1 =  0;}
                    else{colonna1 =  2;}
                }
                break;
            case 4:
                int g[] = controlloStrategia();
                riga1 = g[0];
                colonna1 = g[1];

                if ((g[0] == 1) && (g[1] == 1)) {
                    if ((Math.abs(tris[0][0]) == 1)&& (tris[2][2] == 0) ) {
                        riga1 = 2;
                        colonna1 = 2;
                    } else if ((Math.abs(tris[2][2]) == 1)&& (tris[0][0] == 0) ) {
                        riga1 = 0;
                        colonna1 = 0;
                    } else if (((Math.abs(tris[2][0]) == 1)&& (tris[0][2] == 0) )) {
                        riga1 = 0;
                        colonna1 = 2;
                    } else if (((Math.abs(tris[0][2]) == 1)&& (tris[2][0] == 0) )) {
                        riga1 = 2;
                        colonna1 = 0;
                    } else {
                        riga1 = (int) (Math.random() * 3);
                        colonna1 = (int) (Math.random() * 3);
                    }
                }
                break;
            case 5:
               int v[] = controlloStrategia();
                riga1 = v[0];
                colonna1 = v[1];
                if ((v[0] == 1) && (v[1] == 1)) {
                    if (Math.abs(tris[0][0]) == 1) {
                        riga1 = 2;
                        colonna1 = 2;
                    } else if (Math.abs(tris[2][2]) == 1) {
                        riga1 = 0;
                        colonna1 = 0;
                    } else if (Math.abs(tris[2][0]) == 1) {
                        riga1 = 0;
                        colonna1 = 2;
                    } else if (Math.abs(tris[0][2]) == 1) {
                        riga1 = 2;
                        colonna1 = 0;
                    } else {
                        riga1 = (int) (Math.random() * 3);
                        colonna1 = (int) (Math.random() * 3);
                    }
                }
                break;
            case 6:
                int p[] = controlloStrategia();
                riga1 = p[0];
                colonna1 = p[1];
                if ((p[0] == 1) && (p[1] == 1)) {
                            if ((Math.abs(tris[0][0]) == 1)&&(tris[2][2]==0)){
                                riga1 = 2;
                                colonna1 = 2;
                            } else if ((Math.abs(tris[2][2]) == 1)&&(tris[0][0]==0)) {
                                riga1 = 0;
                                colonna1 = 0;
                            } else if ((Math.abs(tris[2][0]) == 1)&&(tris[0][2]==0)) {
                                riga1 = 0;
                                colonna1 = 2;
                            } else if ((Math.abs(tris[0][2]) == 1)&&(tris[2][0]==0)) {
                                riga1 = 2;
                                colonna1 = 0;
                            } else {
                                if (((Math.abs(tris[0][0]) == 1)&&(Math.abs(tris[2][2])==1))&&(tris[0][2])==0){
                                    riga1 = 0;
                                    colonna1 = 2;
                                } else if (((Math.abs(tris[2][2]) == 1)&&(Math.abs(tris[0][0])==1))&&(tris[2][0])==0) {
                                    riga1 = 2;
                                    colonna1 = 0;
                                } else if (((Math.abs(tris[0][2]) == 1)&&(Math.abs(tris[2][0])==1))&&(tris[2][2])==0) {
                                    riga1 = 2;
                                    colonna1 = 2;
                                } else if (((Math.abs(tris[0][2]) == 1)&&(Math.abs(tris[2][0])==1))&&(tris[0][0])==0) {
                                    riga1 = 0;
                                    colonna1 = 0;
                                } else {
                                    riga1 = (int) (Math.random() * 3);
                                    colonna1 = (int) (Math.random() * 3);
                                }
                            }

                        } break;
                    case 7:
                        int c[] = controlloStrategia();
                        riga1 = c[0];
                        colonna1 = c[1];
                        if ((c[0] == 1) && (c[1] == 1)) {
                            if ((Math.abs(tris[0][0]) == 1)&&(tris[2][2]==0)){
                                riga1 = 2;
                                colonna1 = 2;
                            } else if ((Math.abs(tris[2][2]) == 1)&&(tris[0][0]==0)) {
                                riga1 = 0;
                                colonna1 = 0;
                            } else if ((Math.abs(tris[2][0]) == 1)&&(tris[0][2]==0)) {
                                riga1 = 0;
                                colonna1 = 2;
                            } else if ((Math.abs(tris[0][2]) == 1)&&(tris[2][0]==0)) {
                                riga1 = 2;
                                colonna1 = 0;
                            } else {
                                if (((Math.abs(tris[0][0]) == 1)&&(Math.abs(tris[2][2])==1))&&(tris[0][2])==0){
                                    riga1 = 0;
                                    colonna1 = 2;
                                } else if (((Math.abs(tris[2][2]) == 1)&&(Math.abs(tris[0][0])==1))&&(tris[2][0])==0) {
                                    riga1 = 2;
                                    colonna1 = 0;
                                } else if (((Math.abs(tris[0][2]) == 1)&&(Math.abs(tris[2][0])==1))&&(tris[2][2])==0) {
                                    riga1 = 2;
                                    colonna1 = 2;
                                } else if (((Math.abs(tris[0][2]) == 1)&&(Math.abs(tris[2][0])==1))&&(tris[0][0])==0) {
                                    riga1 = 0;
                                    colonna1 = 0;
                                } else {
                                    riga1 = (int) (Math.random() * 3);
                                    colonna1 = (int) (Math.random() * 3);
                                }
                            }
                        }
                        break;
                    case 8:
                        int d[] = controlloStrategia();
                        riga1 = d[0];
                        colonna1 = d[1];
                        if ((d[0] == 1) && (d[1] == 1)) {
                            if ((Math.abs(tris[0][0]) == 1)&&(tris[2][2]==0)){
                                riga1 = 2;
                                colonna1 = 2;
                            } else if ((Math.abs(tris[2][2]) == 1)&&(tris[0][0]==0)) {
                                riga1 = 0;
                                colonna1 = 0;
                            } else if ((Math.abs(tris[2][0]) == 1)&&(tris[0][2]==0)) {
                                riga1 = 0;
                                colonna1 = 2;
                            } else if ((Math.abs(tris[0][2]) == 1)&&(tris[2][0]==0)) {
                                riga1 = 2;
                                colonna1 = 0;
                            } else {
                                if (((Math.abs(tris[0][0]) == 1)&&(Math.abs(tris[2][2])==1))&&(tris[0][2])==0){
                                    riga1 = 0;
                                    colonna1 = 2;
                                } else if (((Math.abs(tris[2][2]) == 1)&&(Math.abs(tris[0][0])==1))&&(tris[2][0])==0) {
                                    riga1 = 2;
                                    colonna1 = 0;
                                } else if (((Math.abs(tris[0][2]) == 1)&&(Math.abs(tris[2][0])==1))&&(tris[2][2])==0) {
                                    riga1 = 2;
                                    colonna1 = 2;
                                } else if (((Math.abs(tris[0][2]) == 1)&&(Math.abs(tris[2][0])==1))&&(tris[0][0])==0) {
                                    riga1 = 0;
                                    colonna1 = 0;
                                } else {
                                    riga1 = (int) (Math.random() * 3);
                                    colonna1 = (int) (Math.random() * 3);
                                }
                            }
                        }
                        break;
                    case 9:
                        int[] z = controlloStrategia();
                        riga1 = z[0];
                        colonna1 = z[1];
                        if ((z[0] == 1) && (z[1] == 1)) {
                            bot(10);
                        } else {
                            break;
                        }
                    default:
                        riga1 = (int) (Math.random() * 3);
                        colonna1 = (int) (Math.random() * 3);
                        break;

        }



        //IMPORTANTISSIMO NON TOCCARE
        if(tris[riga1][colonna1]==0) {
            tris[riga1][colonna1]= -1*decisione;
            System.out.println("colonna: "+colonna1);
            System.out.println("riga: " + riga1);
        } else {
            bot(turnoBot);
        }
    }
    public static void fine(){
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
}

