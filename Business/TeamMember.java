package Business;

public class TeamMember {
    private Character character;
    private Strategy strategy;
    private Item armour;
    private Item weapon;

    public TeamMember(Character character, Strategy strategy, Item armour, Item weapon) {
        this.character = character;
        this.strategy = strategy;
        this.armour = armour;
        this.weapon = weapon;
    }

    public void attackRival(TeamMember rival) {
    }

    public void requestNewWeapon() {
    }

    public void defendAttack() {
    }
}
