package Business;

public class TeamMember {
    private CharacterMember characterMember;
    private Strategy strategy;
    private Item armour;
    private Item weapon;

    public TeamMember(CharacterMember characterMember, Strategy strategy, Item armour, Item weapon) {
        this.characterMember = characterMember;
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
