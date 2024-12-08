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

    public TeamMember(CharacterMember characterMember, Strategy strategy) {
        this.characterMember = characterMember;
        this.strategy = strategy;
    }

    public CharacterMember getCharacterMember() {
        return characterMember;
    }

    public void setCharacterMember(CharacterMember characterMember) {
        this.characterMember = characterMember;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Item getArmour() {
        return armour;
    }

    public void setArmour(Item armour) {
        this.armour = armour;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public void attackRival(TeamMember rival) {
    }

    public void requestNewWeapon() {
    }

    public void defendAttack() {
    }
}
