package pentago;

import java.util.Scanner;

public class Player {
    public static String abs = "";

    /**
     * get the location
     * @return a string ( row + column )
     */
    public String enterLoc(){
        System.out.println("Please enter row and column (1,1) to (6,6) :");
        Scanner scanner = new Scanner(System.in);
        String row = scanner.next();
        String column = scanner.next();
        if (Integer.parseInt(row)>=1 && Integer.parseInt(row)<=6 && Integer.parseInt(column)>=1 && Integer.parseInt(column)<=6 ){
            return row + column;
        }
        else {
            boolean flag = Integer.parseInt(row)>=1 && Integer.parseInt(row)<=6 && Integer.parseInt(column)>=1 && Integer.parseInt(column)<=6;
            while (!flag){
                System.out.println("Wrong input. choose again.");
                row = scanner.next();
                column = scanner.next();
                flag = Integer.parseInt(row)>=1 && Integer.parseInt(row)<=6 && Integer.parseInt(column)>=1 && Integer.parseInt(column)<=6;
            }
        }
        return row + column;
    }

    /**
     * call enterloc and put
     */
    public void call(){
        put(enterLoc());
    }

    /**
     * to check and put in the right location
     * @param loc
     */
    public void put(String loc){
        int locToInt = Integer.parseInt(loc);
        int row =  locToInt / 10;
        int column = locToInt % 10;
        if (row < 4 && column < 4){
            row--;
            column = column * 5 - 5;
            if (Main.map[row][column] == Main.s) {
                Main.map[row][column] = abs;
            }
            else {
                System.out.println("This space is full. Choose another");
                call();
            }
        }
        else if (row < 4 && column >= 4){
            row--;
            column = column * 5 - 4;
            if (Main.map[row][column] == Main.s) {
                Main.map[row][column] = abs;
            }
            else {
                System.out.println("This space is full. Choose another");
                call();
            }
        }
        else if (row >= 4 && column < 4){
            column = column * 5 - 5;
            if (Main.map[row][column] == Main.s) {
                Main.map[row][column] = abs;
            }
            else {
                System.out.println("This space is full. Choose another");
                call();
            }
        }
        else if (row >= 4 && column >= 4){
            column = column * 5 - 4;
            if (Main.map[row][column] == Main.s) {
                Main.map[row][column] = abs;
            }
            else {
                System.out.println("This space is full. Choose another");
                call();
            }
        }
    }

    /**
     * choose a quarter to spin
     */
    public void turn(){
        System.out.println("Please choose a quarter to spin (1 to 4) : ");
        Scanner scanner = new Scanner(System.in);
        int quarter = Integer.parseInt(scanner.nextLine());
        if(!(quarter>=1 && quarter<=4)){
            System.out.println("wrong input. it must be between 1 to 4. enter again.");
            turn();
        }
        System.out.println("if clockwise enter 1 otherwise enter 2 :");
        int round = Integer.parseInt(scanner.nextLine());
        while (round!=1 && round!=2){
            System.out.println("wrong input. it must be 1 or 2. enter again.");
            round = Integer.parseInt(scanner.nextLine());
        }
        spin(quarter,round);
    }

    /**
     * spin a quarter clockwise or counter clockwise
     * @param quarter to spin
     * @param round 1 = clockwise or 2 = counter clockwise
     */
    public void spin(int quarter , int round){
        String[][] store = new String[3][3];
        int a=0,b=0,c=0,d=0;
        if(quarter == 1){
            a = b = 0;
            c = 3; d = 11;
        }
        if(quarter == 2){
            a = 0 ; b = 16;
            c = 3; d = 27 ;
        }
        if(quarter == 3){
            a = 4 ; b = 0;
            c = 7; d = 11 ;
        }
        if(quarter == 4){
            a = 4 ; b = 16;
            c = 7; d = 27 ;
        }
        int k=0;
        for (int i = a; i < c ; i++) {
            int l=0;
            for (int j = b; j < d ; j++) {
                if (Main.map[i][j] == Main.redChar || Main.map[i][j] == Main.blueChar || Main.map[i][j] == Main.s){
                    store[k][l] = Main.map[i][j];
                    l++;
                }
            }
            k++;
        }
        //clockwise
        if(round == 1) {
            if (quarter == 1){
                Main.map[0][0] = store[2][0];
                Main.map[0][5] = store[1][0];
                Main.map[0][10] = store[0][0];
                Main.map[1][0] = store[2][1];
                Main.map[1][5] = store[1][1];
                Main.map[1][10] = store[0][1];
                Main.map[2][0] = store[2][2];
                Main.map[2][5] = store[1][2];
                Main.map[2][10] = store[0][2];
            }
            if (quarter == 2){
                Main.map[0][16] = store[2][0];
                Main.map[0][21] = store[1][0];
                Main.map[0][26] = store[0][0];
                Main.map[1][16] = store[2][1];
                Main.map[1][21] = store[1][1];
                Main.map[1][26] = store[0][1];
                Main.map[2][16] = store[2][2];
                Main.map[2][21] = store[1][2];
                Main.map[2][26] = store[0][2];
            }
            if (quarter == 3){
                Main.map[4][0] = store[2][0];
                Main.map[4][5] = store[1][0];
                Main.map[4][10] = store[0][0];
                Main.map[5][0] = store[2][1];
                Main.map[5][5] = store[1][1];
                Main.map[5][10] = store[0][1];
                Main.map[6][0] = store[2][2];
                Main.map[6][5] = store[1][2];
                Main.map[6][10] = store[0][2];
            }
            if (quarter == 4){
                Main.map[4][16] = store[2][0];
                Main.map[4][21] = store[1][0];
                Main.map[4][26] = store[0][0];
                Main.map[5][16] = store[2][1];
                Main.map[5][21] = store[1][1];
                Main.map[5][26] = store[0][1];
                Main.map[6][16] = store[2][2];
                Main.map[6][21] = store[1][2];
                Main.map[6][26] = store[0][2];
            }
        }
        //counter clockwise
        if(round == 2) {
            if (quarter == 1) {
                Main.map[0][0] = store[0][2];
                Main.map[0][5] = store[1][2];
                Main.map[0][10] = store[2][2];
                Main.map[1][0] = store[0][1];
                Main.map[1][5] = store[1][1];
                Main.map[1][10] = store[2][1];
                Main.map[2][0] = store[0][0];
                Main.map[2][5] = store[1][0];
                Main.map[2][10] = store[2][0];
            }
            if (quarter == 2) {
                Main.map[0][16] = store[0][2];
                Main.map[0][21] = store[1][2];
                Main.map[0][26] = store[2][2];
                Main.map[1][16] = store[0][1];
                Main.map[1][21] = store[1][1];
                Main.map[1][26] = store[2][1];
                Main.map[2][16] = store[0][0];
                Main.map[2][21] = store[1][0];
                Main.map[2][26] = store[2][0];
            }
            if (quarter == 4) {
                Main.map[4][16] = store[0][2];
                Main.map[4][21] = store[1][2];
                Main.map[4][26] = store[2][2];
                Main.map[5][16] = store[0][1];
                Main.map[5][21] = store[1][1];
                Main.map[5][26] = store[2][1];
                Main.map[6][16] = store[0][0];
                Main.map[6][21] = store[1][0];
                Main.map[6][26] = store[2][0];
            }
            if (quarter == 3) {
                Main.map[4][0] = store[0][2];
                Main.map[4][5] = store[1][2];
                Main.map[4][10] = store[2][2];
                Main.map[5][0] = store[0][1];
                Main.map[5][5] = store[1][1];
                Main.map[5][10] = store[2][1];
                Main.map[6][0] = store[0][0];
                Main.map[6][5] = store[1][0];
                Main.map[6][10] = store[2][0];
            }
        }
    }

    /**
     * check if the game is finished or not and who is the winner
     * @return
     */
    public boolean winner(){
        int a=0,b=0,counter=0;
        for (int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 27 ; j++) {
                if (Main.map[i][j] == abs){
                    if (i+1 < 7 && Main.map[i+1][j] == abs){
                        a=i;b=j;
                        counter=1;
                        while (Main.map[a+1][b] == abs){
                            a++;
                            if (a+1==3){a++;}
                            counter++;
                            if (counter==5){ return true;}
                            if (a+1>=7){break;}
                        }
                    }
                    if (j+1 < 27 && Main.map[i][j+5] == abs){
                        a=i;b=j;
                        counter=1;
                        while (Main.map[a][b+5] == abs){
                            b+=5;
                            if (b+3 == 13){b++;}
                            counter++;
                            if (counter==5){return true;}
                            if (b+1>=27){break;}
                        }
                    }
                    if( i+1 < 7 && j+1 < 27 && Main.map[i+1][j+5] == abs ){
                        a=i;b=j;
                        counter=1;
                        while (Main.map[a+1][b+5] == abs){
                            a++;b+=5;
                            if (a+1 == 3 && b+3 == 13){
                                a++;b++;
                            }
                            counter++;
                            if (counter==5){return true;}
                            if (b+1>=27 || a+1>=7){break;}
                        }
                    }
                    if( i+1 < 7 && j-1 >= 0 && Main.map[i+1][j-5] == abs ){
                        a=i;b=j;
                        counter=1;
                        while (Main.map[a+1][b-5] == abs){
                            a++;b-=5;
                            if (a+1 == 3 && b-3 == 13){
                                a++;b--;
                            }
                            counter++;
                            if (counter==5){return true;}
                            if (b-1<0 || a+1>=7){break;}
                        }
                    }
                }
                if (Main.map[0][5] == abs && Main.map[1][10] == abs && Main.map[2][16] == abs && Main.map[4][21] == abs && Main.map[5][26] == abs ){
                    System.out.println("from (1,2) to (5,6)");
                    return true;
                }
                if (Main.map[1][0] == abs && Main.map[2][5] == abs && Main.map[4][10] == abs && Main.map[5][16] == abs && Main.map[6][21] == abs ){
                    System.out.println("from (2,1) to (6,5)");
                    return true;
                }
                if (Main.map[0][21] == abs && Main.map[1][16] == abs && Main.map[2][10] == abs && Main.map[4][5] == abs && Main.map[5][0] == abs ){
                    System.out.println("from (1,5) to (5,1)");
                    return true;
                }
                if (Main.map[1][26] == abs && Main.map[2][21] == abs && Main.map[4][16] == abs && Main.map[5][10] == abs && Main.map[6][5] == abs ){
                    System.out.println("from (2,6) to (6,2)");
                    return true;
                }
            }
        }
        return false;
    }
}
