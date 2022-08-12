public class DistrictContestant extends Contestant{
    public DistrictContestant(String name, int attack, int defence, int health) {
        super(name, attack, defence + 3, health);
    }
}
