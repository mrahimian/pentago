package pentago;

public class Player1 extends Player {
    static int counter1 = 0;
    @Override
    public String enterLoc() {
        System.out.println("Player 1 (red) :");
        return super.enterLoc();
    }

    @Override
    public void put(String loc) {
        Player.abs = Main.redChar;
        super.put(loc);
        counter1++;

    }


    @Override
    public boolean winner() {
        Player.abs = Main.redChar;
        return super.winner();
    }
}
