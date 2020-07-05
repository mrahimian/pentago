package pentago;

public class Player2 extends Player {
    static int counter2 = 0;
    @Override
    public String enterLoc() {
        System.out.println("Player 2 (blue) :");
        return super.enterLoc();
    }

    @Override
    public void put(String loc) {
        Player.abs = Main.blueChar;
        super.put(loc);
        counter2++;
    }


    @Override
    public boolean winner() {
        Player.abs = Main.blueChar;
        return super.winner();
    }
}
