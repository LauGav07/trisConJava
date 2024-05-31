public class GiocoBotBot  {
    public static void main(String[]args) {
        do {
            Metodi.svuota();
            Metodi.conCosaGiocaBot1 = Metodi.inizio();
            if (Metodi.conCosaGiocaBot1==-1){
                System.out.println("Il bot1 uno giocerà con O" );
                System.out.println("Il bot2 uno giocerà con X" );
            } else {
                System.out.println("Il bot1 uno giocerà con X" );
                System.out.println("Il bot2 uno giocerà con O" );
            }
            int turnoBot = 0;
            Metodi.tris();
            int inizio = Metodi.inizio();
            System.out.println("turno di :"+inizio);
            if (inizio == Metodi.conCosaGiocaBot1 ) {
                do {
                    turnoBot++;
                    System.out.println("TURNO BOT1");
                    bot(turnoBot,1);
                    Metodi.tris();
                    Metodi.fine(3);
                    if (Metodi.ctrl == true || Metodi.part == true) {
                        break;
                    }
                    System.out.println("TURNO BOT2");
                    turnoBot++;
                    bot(turnoBot,2);
                    Metodi.tris();
                    Metodi.fine(3);
                }
                while(!Metodi.ctrl && !Metodi.part);
            }
            else {
                do {
                    System.out.println("TURNO GIOCATORE2");
                    turnoBot++;
                    bot(turnoBot,1);
                    Metodi.tris();
                    Metodi.fine(3);
                    if (Metodi.ctrl == true || Metodi.part == true) {
                        break;
                    }
                    System.out.println("TURNO GIOCATORE1");
                    turnoBot++;
                    bot(turnoBot,2);
                    Metodi.tris();
                    Metodi.fine(3);
                }while(Metodi.ctrl == false && Metodi.part == false);
            }
            Metodi.svuota();
            Metodi.rifare =Metodi.rifare();
        } while (Metodi.rifare==true);
    }
    public static int[] controlloStrategia() {
        for (int i = 0 ; i < 3 ;i++) {
            if(Main.tris[i][0] + Main.tris[i][1] + Main.tris[i][2]==Metodi.conCosaGiocaBot1*-2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(Main.tris[i][j]==0){
                        int coordinate[]={i,j};
                        return  coordinate;
                    }
                }
            }
        }
        for (int i = 0 ; i < 3 ;i++) {
            if(Main.tris[0][i] + Main.tris[1][i] + Main.tris[2][i]==Metodi.conCosaGiocaBot1*-2) {
                for (int j = 0 ; j < 3 ;j++){
                    if(Main.tris[j][i]==0){
                        int coordinate[]= {j, i};
                        return  coordinate;
                    }
                }
            }
        }
        if(Main.tris[0][0] + Main.tris[1][1] + Main.tris[2][2]==Metodi.conCosaGiocaBot1*-2) {
            for (int j = 0 ; j < 3 ;j++){
                if(Main.tris[j][j]==0){
                    int coordinate[]={j,j};
                    return  coordinate;
                }
            }
        }
        else if (Main.tris[0][2] + Main.tris[1][1] + Main.tris[2][0]==Metodi.conCosaGiocaBot1*-2) {
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
    public static void bot(int turnoBot, int cosaGioca) {
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
            System.out.println("riga: " + riga1);
            System.out.println("colonna: "+colonna1);
            if (cosaGioca == 1){
                Main.tris[riga1][colonna1] = Metodi.conCosaGiocaBot1;
            }else{
                Main.tris[riga1][colonna1] = Metodi.conCosaGiocaBot1 * -1;
            }
        } else {
            bot(turnoBot, cosaGioca);
        }
    }
}

