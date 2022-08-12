import java.awt.*;
import java.util.ArrayList;

public class Game {
    ArrayList<Contestant> contestants;

    private int day = 0;


    public Game() {
        this.contestants = GameLogic.createContestants();
    }

    public void startOfDayMessage() {
        System.out.println("Welcome to day " + this.day + "\nThere are " +
                contestants.size() + " contestants still alive!");
    }

    public void fight(Contestant contestantOne, Contestant contestantTwo) {
        if (contestantOne == contestantTwo) {
            return;
        }
        while (contestantOne.getHealth() > 0 && contestantTwo.getHealth() > 0) {
            contestantTwo.setHealth(contestantTwo.getHealth()- (contestantOne.getAttack() - (int) (0.5*contestantTwo.getDefence())));
            contestantOne.setHealth(contestantOne.getHealth() - (contestantTwo.getAttack() - (int) (0.5*contestantOne.getDefence())));
        }
        Contestant winner = contestantOne;
        Contestant loser = contestantTwo;

        if (contestantOne.getHealth() < 0 ) {
            winner = contestantTwo;
            loser = contestantOne;
        }
        contestants.remove(loser);
        System.out.println(contestantOne.getName() + " and " + contestantTwo.getName() + " fought, with " +
                winner.getName() + " as the winner");
    }

    public void itemFound() {
        int randomItem = GameLogic.getRandomInt(0, 21);
        int randomStrength = GameLogic.getRandomInt(1,5);
        Contestant randomContestant = contestants.get(GameLogic.getRandomInt(0, contestants.size()-1));

        if (randomItem <= 10) {
            randomContestant.setAttack(randomContestant.getAttack() + randomStrength);
            System.out.println(randomContestant.getName() + " found an item to aid their attack. " +
                    "Attack increased by " + randomStrength);
        } else {
            randomContestant.setDefence(randomContestant.getDefence() + randomStrength);
            System.out.println(randomContestant.getName() + " found an item to aid their defence. " +
                    "Defence increased by " + randomStrength);
        }
    }

    public void startGame() {
        while (contestants.size() > 1) {
            day++;
            startOfDayMessage();
            if (GameLogic.getRandomInt(0, 11) < 7) {
                fight(getRandomContestant(), getRandomContestant());
            }
            if (GameLogic.getRandomInt(0, 11) <= 5) {
                itemFound();
            }
        }
        System.out.println(contestants.get(0) + " has been declared the victor");
    }


    public Contestant getRandomContestant() {
        return contestants.get(GameLogic.getRandomInt(0, contestants.size()));
    }




}
