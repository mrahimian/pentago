package pentago;


public class Main {
    /**
     * to color console
     */
    // multi dimension map
    static String[][] map = new String[7][27];
    static int a = 79;
    static char uni = (char) a;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static String blueChar = ANSI_BLUE + "\u25CF" + ANSI_RESET;
    static String redChar = ANSI_RED + "\u25CF" + ANSI_RESET;
    static String s = ANSI_WHITE + uni;
    static String s2 = " " ;
    static String s3 = ANSI_GREEN + "|" + ANSI_RESET;
    static String s4 = ANSI_GREEN + "-" + ANSI_RESET;
    public static void main(String[] args) {
        createMap();
        print();
        Player1 p1 = new Player1();
        Player2 p2 = new Player2();
        while (true){
            p1.call();
            print();
            System.out.println(Player1.counter1);
            if(p1.winner()){
                System.out.println("Player1 wins.");
                break;
            }
            p1.turn();
            print();
            if(p1.winner()){
                if (p2.winner()){
                    System.out.println("No Winner.");
                    break;
                }
                else {
                    System.out.println("Player1 wins.");
                    break;
                }
            }
            if (p2.winner()){
                System.out.println("Player2 wins.");
                break;
            }
            p2.call();
            print();
            System.out.println(Player2.counter2);
            if(p2.winner()){
                System.out.println("Player2 wins.");
                break;
            }
            p2.turn();
            if(p2.winner()){
                if (p1.winner()){
                    System.out.println("No Winner.");
                    break;
                }
                else {
                    System.out.println("Player2 wins.");
                    break;
                }
            }
            if(p1.winner()){
                System.out.println("Player1 wins.");
                break;
            }
            print();
            int j;
            int t=0;
            for (int i = 0; i < 7 ; i++) {
                for (j = 0; j < 27 ; j++) {
                    if (map[i][j] == s){
                        t=1;
                        break;
                    }
                }
                if (map[i][j] == s){
                    break;
                }
            }
            if (t==0){
                System.out.println("No winner");
                break;
            }
        }
        print();
    }

    /**
     * create first map
     */
    public static void createMap() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                if (j % 5 == 0) {
                    map[i][j] = s;
                } else {
                    map[i][j] = s2;
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 14; j < 27; j++) {
                if (j % 5 == 1) {
                    map[i][j] = s;
                } else {
                    map[i][j] = s2;
                }
            }
        }
        for (int j = 0; j < 27 ; j++) {
            map[3][j] = s4;
        }
        for (int i = 0; i < 7 ; i++) {
            map[i][13] = s3;
        }
    }

    /**
     * print map
     */
    public static void print(){
        for (int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 27 ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
