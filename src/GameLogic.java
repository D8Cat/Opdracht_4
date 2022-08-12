import java.util.ArrayList;

public class GameLogic {


    public static ArrayList<Contestant> createContestants() {
        ArrayList<Contestant> contestants= new ArrayList<>();
        for (int i = 0; i < 6;i++) {
            contestants.add(new CareerContestant("Career contestant " + i,getRandomInt(0,5),getRandomInt(0,5),getRandomInt(20,40)));
        }
        for (int i = 0; i < 18;i++) {
            contestants.add(new DistrictContestant("District contestant " + i, getRandomInt(0,5),getRandomInt(0,5),getRandomInt(20,40)));
        }
        return contestants;
    }


    public static int getRandomInt(int min, int max) {
        return min + (int) (Math.random() * max);
    }



}
