public abstract class Contestant {
    private String name;
    private int attack, defence, health;

    public Contestant(String name, int attack, int defence, int health) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
    }

    @Override
    public String toString() {
        return "Contestant{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void heal(int amountOfHealing) {
        this.health += amountOfHealing;
    }
}
