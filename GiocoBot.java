public class GiocoBot{
    public static void main(String[]args) {
        do{
            Metodi.svuota();
            boolean tr = true;
            do {
                tr= true;
                System.out.println("con cosa vuoi giocare?  X oppure O");
                String b = Metodi.chiedistringa() ;
                String assoc = b.toLowerCase();
                if  (assoc.equals("x")){
                    Metodi.conCosaGioca=1;
                } else if (assoc.equals("o")){
                    Metodi.conCosaGioca=-1;
                }
                else{
                    System.out.println("errore");
                    tr = false;
                } }while(!tr);
            Metodi.tris();
            int turnoBot = 0;
            int inizio =  Metodi.inizio ();
            System.out.println("turno di :"+inizio);
            if (inizio == Metodi.conCosaGioca ) {
                do {
                    System.out.println("TURNO UMANO");
                    turnoBot++;
                    gioco();
                    Metodi.tris();
                    Metodi.fine(2);
                    if (Metodi.ctrl == true || Metodi.part == true) {
                        break;
                    }
                    System.out.println("TURNO ROBOT");
                    turnoBot++;
                    bot(turnoBot);
                    Metodi.tris();
                    Metodi.fine(2);
                }
                while( Metodi.ctrl == false &&  Metodi.part == false);
            } else {
                do {
                    System.out.println("TURNO ROBOT");
                    turnoBot++;
                    bot(turnoBot);
                    Metodi.tris();
                    Metodi.fine(2);
                    if (Metodi.ctrl == true || Metodi.part == true) {
                        break;
                    }
                    System.out.println("TURNO UMANO");
                    turnoBot++;
                    gioco();
                    Metodi.tris();
                    Metodi.fine(2);
                }while(Metodi.ctrl == false && Metodi.part == false);
            }
            Metodi.rifare = Metodi.rifare();
        } while(Metodi.rifare);
    }
    public static void bot(int turnoBot) {
        int colonna1 =-1;
        int riga1 =-1;
        switch (turnoBot) {
            case 1:
                riga1 = 1;
                colonna1 = 1;
                break;
            case 2:
                if(Main.tris[1][1]==0) {
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
                if ((Main.tris[0][0] == 0)&&(Main.tris[2][2] == 0)) {
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
                    if ((Math.abs(Main.tris[0][0]) == 1)&& (Main.tris[2][2] == 0) ) {
                        riga1 = 2;
                        colonna1 = 2;
                    } else if ((Math.abs(Main.tris[2][2]) == 1)&& (Main.tris[0][0] == 0) ) {
                        riga1 = 0;
                        colonna1 = 0;
                    } else if (((Math.abs(Main.tris[2][0]) == 1)&& (Main.tris[0][2] == 0) )) {
                        riga1 = 0;
                        colonna1 = 2;
                    } else if (((Math.abs(Main.tris[0][2]) == 1)&& (Main.tris[2][0] == 0) )) {
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
                    if (Math.abs(Main.tris[0][0]) == 1) {
                        riga1 = 2;
                        colonna1 = 2;
                    } else if (Math.abs(Main.tris[2][2]) == 1) {
                        riga1 = 0;
                        colonna1 = 0;
                    } else if (Math.abs(Main.tris[2][0]) == 1) {
                        riga1 = 0;
                        colonna1 = 2;
                    } else if (Math.abs(Main.tris[0][2]) == 1) {
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
                    if ((Math.abs(Main.tris[0][0]) == 1)&&(Main.tris[2][2]==0)){
                        riga1 = 2;
                        colonna1 = 2;
                    } else if ((Math.abs(Main.tris[2][2]) == 1)&&(Main.tris[0][0]==0)) {
                        riga1 = 0;
                        colonna1 = 0;
                    } else if ((Math.abs(Main.tris[2][0]) == 1)&&(Main.tris[0][2]==0)) {
                        riga1 = 0;
                        colonna1 = 2;
                    } else if ((Math.abs(Main.tris[0][2]) == 1)&&(Main.tris[2][0]==0)) {
                        riga1 = 2;
                        colonna1 = 0;
                    } else {
                        if (((Math.abs(Main.tris[0][0]) == 1)&&(Math.abs(Main.tris[2][2])==1))&&(Main.tris[0][2])==0){
                            riga1 = 0;
                            colonna1 = 2;
                        } else if (((Math.abs(Main.tris[2][2]) == 1)&&(Math.abs(Main.tris[0][0])==1))&&(Main.tris[2][0])==0) {
                            riga1 = 2;
                            colonna1 = 0;
                        } else if (((Math.abs(Main.tris[0][2]) == 1)&&(Math.abs(Main.tris[2][0])==1))&&(Main.tris[2][2])==0) {
                            riga1 = 2;
                            colonna1 = 2;
                        } else if (((Math.abs(Main.tris[0][2]) == 1)&&(Math.abs(Main.tris[2][0])==1))&&(Main.tris[0][0])==0) {
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
                    if ((Math.abs(Main.tris[0][0]) == 1)&&(Main.tris[2][2]==0)){
                        riga1 = 2;
                        colonna1 = 2;
                    } else if ((Math.abs(Main.tris[2][2]) == 1)&&(Main.tris[0][0]==0)) {
                        riga1 = 0;
                        colonna1 = 0;
                    } else if ((Math.abs(Main.tris[2][0]) == 1)&&(Main.tris[0][2]==0)) {
                        riga1 = 0;
                        colonna1 = 2;
                    } else if ((Math.abs(Main.tris[0][2]) == 1)&&(Main.tris[2][0]==0)) {
                        riga1 = 2;
                        colonna1 = 0;
                    } else {
                        if (((Math.abs(Main.tris[0][0]) == 1)&&(Math.abs(Main.tris[2][2])==1))&&(Main.tris[0][2])==0){
                            riga1 = 0;
                            colonna1 = 2;
                        } else if (((Math.abs(Main.tris[2][2]) == 1)&&(Math.abs(Main.tris[0][0])==1))&&(Main.tris[2][0])==0) {
                            riga1 = 2;
                            colonna1 = 0;
                        } else if (((Math.abs(Main.tris[0][2]) == 1)&&(Math.abs(Main.tris[2][0])==1))&&(Main.tris[2][2])==0) {
                            riga1 = 2;
                            colonna1 = 2;
                        } else if (((Math.abs(Main.tris[0][2]) == 1)&&(Math.abs(Main.tris[2][0])==1))&&(Main.tris[0][0])==0) {
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
                    if ((Math.abs(Main.tris[0][0]) == 1)&&(Main.tris[2][2]==0)){
                        riga1 = 2;
                        colonna1 = 2;
                    } else if ((Math.abs(Main.tris[2][2]) == 1)&&(Main.tris[0][0]==0)) {
                        riga1 = 0;
                        colonna1 = 0;
                    } else if ((Math.abs(Main.tris[2][0]) == 1)&&(Main.tris[0][2]==0)) {
                        riga1 = 0;
                        colonna1 = 2;
                    } else if ((Math.abs(Main.tris[0][2]) == 1)&&(Main.tris[2][0]==0)) {
                        riga1 = 2;
                        colonna1 = 0;
                    } else {
                        if (((Math.abs(Main.tris[0][0]) == 1)&&(Math.abs(Main.tris[2][2])==1))&&(Main.tris[0][2])==0){
                            riga1 = 0;
                            colonna1 = 2;
                        } else if (((Math.abs(Main.tris[2][2]) == 1)&&(Math.abs(Main.tris[0][0])==1))&&(Main.tris[2][0])==0) {
                            riga1 = 2;
                            colonna1 = 0;
                        } else if (((Math.abs(Main.tris[0][2]) == 1)&&(Math.abs(Main.tris[2][0])==1))&&(Main.tris[2][2])==0) {
                            riga1 = 2;
                            colonna1 = 2;
                        } else if (((Math.abs(Main.tris[0][2]) == 1)&&(Math.abs(Main.tris[2][0])==1))&&(Main.tris[0][0])==0) {
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
                    riga1 = (int) (Math.random() * 3);
                    colonna1 = (int) (Math.random() * 3);
                    break;




                } else {
                    break;
                }
            default:
                riga1 = (int) (Math.random() * 3);
                colonna1 = (int) (Math.random() * 3);
                break;








        }



        //IMPORTANTISSIMO NON TOCCARE


        if(Main.tris[riga1][colonna1]==0) {
            Main.tris[riga1][colonna1]= -1*Metodi.conCosaGioca;
            System.out.println("riga: " + riga1);
            System.out.println("colonna: "+colonna1);




        } else {
            bot(turnoBot);
        }
    }
    public static void gioco(){
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
                        gioco();
                        break;
                }
                System.out.println("riga" + riga);
                System.out.println("colonna = " + colonna);
                break;
        }
        if (Main.tris[riga][colonna]==0){
            Main.tris[riga][colonna] = Metodi.conCosaGioca;
        } else {
            System.out.println("cella già occupata");
            gioco();
        }
        }
    public static int[] controlloStrategia() {
        for (int i = 0 ; i < 3 ;i++) {
            if(Main.tris[i][0] + Main.tris[i][1] + Main.tris[i][2]==Metodi.conCosaGioca*-2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(Main.tris[i][j]==0){
                        int coordinate[]={i,j};
                        return  coordinate;
                    }
                }
            }
        }
        for (int i = 0 ; i < 3 ;i++) {
            if(Main.tris[0][i] + Main.tris[1][i] + Main.tris[2][i]==Metodi.conCosaGioca*-2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(Main.tris[j][i]==0){
                        int coordinate[]= {j, i};
                        return  coordinate;
                    }
                }
            }
        }
        if(Main.tris[0][0] + Main.tris[1][1] + Main.tris[2][2]==Metodi.conCosaGioca*-2) {
            for (int j = 0 ; j < 3 ;j++){
                if(Main.tris[j][j]==0){
                    int coordinate[]={j,j};
                    return  coordinate;
                }
            }
        }
        else if (Main.tris[0][2] + Main.tris[1][1] + Main.tris[2][0]==Metodi.conCosaGioca*-2) {
            for (int i = 2 ; i > -1 ;i--){
                for (int j = 0 ; j < 3 ;j++){
                    if(Main.tris[j][i]==0){
                        int coordinate[]={j,i};
                        return  coordinate;
                    }
                }
            }
        }
        for (int i = 0 ; i < 3 ;i++) {
            if(Math.abs(Main.tris[i][0] + Main.tris[i][1] + Main.tris[i][2])==2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(Main.tris[i][j]==0){
                        int coordinate[]={i,j};
                        return  coordinate;
                    }
                }
            }
        }
        for (int i = 0 ; i < 3 ;i++) {
            if(Math.abs(Main.tris[0][i] + Main.tris[1][i] + Main.tris[2][i])==2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(Main.tris[j][i]==0){
                        int coordinate[]= {j, i};
                        return  coordinate;
                    }
                }
            }
        }
        if(Math.abs(Main.tris[0][0] + Main.tris[1][1] + Main.tris[2][2])==2) {
            for (int j = 0 ; j < 3 ;j++){
                if(Main.tris[j][j]==0){
                    int coordinate[]={j,j};
                    return  coordinate;
                }
            }
        }
        else if(Math.abs(Main.tris[0][2] + Main.tris[1][1] + Main.tris[2][0])==2) {
            for (int i = 2 ; i > -1 ;i--){
                for (int j = 0 ; j < 3 ;j++){
                    if(Main.tris[j][i]==0){
                        int coordinate[]={j,i};
                        return  coordinate;
                    }
                }
            }
        }
        int coordinate[]={1,1};
        return  coordinate;
    }
}
