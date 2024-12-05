package Business;

public class CharacterMember extends Character {
    private float accumulatedDamage;
    private float knockout;
    private float damageReduction;
    private boolean isEliminated;

    public CharacterMember(int id, String name, double weight, float accumulatedDamage, float knockout, float damageReduction, boolean isEliminated) {
        super(id, name, weight);

        this.accumulatedDamage = accumulatedDamage;
        this.knockout = knockout;
        this.damageReduction = damageReduction;
        this.isEliminated = isEliminated;
    }

    public float getAccumulatedDamage() {
        return accumulatedDamage;
    }

    public void setAccumulatedDamage(float accumulatedDamage) {
        this.accumulatedDamage = accumulatedDamage;
    }

    public float getKnockout() {
        return knockout;
    }

    public void setKnockout(float knockout) {
        this.knockout = knockout;
    }

    public float getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(float damageReduction) {
        this.damageReduction = damageReduction;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public void setEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }
}