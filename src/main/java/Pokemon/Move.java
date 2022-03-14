package Pokemon;

public class Move {
    private String name;
    private String type;
    private String category;
    private Integer power;
    private Integer accuracy;
    private Integer PP;
    private String effect;
    private Integer critProbability;
    private String TM;
    private int gen;
    private Integer ID;
    private Integer targetID;
    private Integer damageClassID;
    private Integer effectID;
    private Integer effectProb;
    private Integer contestTypeID;
    private Integer contestEffectID;
    private Integer superContestEffectID;

    public Move(String name, String type, String category, Integer power, Integer accuracy, Integer PP,
                String effect, Integer probability, String TM, int gen, Integer ID, Integer targetID,
                Integer damageClassID, Integer effectID, Integer effectProb, Integer contestTypeID, Integer contestEffectID, Integer superContestEffectID){
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.PP = PP;
        this.effect = effect;
        this.critProbability = probability;
        this.TM = TM;
        this.gen = gen;
        this.ID = ID;
        this.targetID = targetID;
        this.damageClassID = damageClassID;
        this.effectID = effectID;
        this.effectProb = effectProb;
        this.contestTypeID = contestTypeID;
        this.contestEffectID = contestEffectID;
        this.superContestEffectID = superContestEffectID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public Integer getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Integer getPP() {
        return PP;
    }

    public String getEffect() {
        return effect;
    }

    public Integer getCritProbability() {
        return critProbability;
    }

    public String getTM() {
        return TM;
    }

    public int getGen() {
        return gen;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getTargetID() {
        return targetID;
    }

    public Integer getDamageClassID() {
        return damageClassID;
    }

    public Integer getEffectID() {
        return effectID;
    }

    public Integer getEffectProb() {
        return effectProb;
    }

    public Integer getContestTypeID() {
        return contestTypeID;
    }

    public Integer getContestEffectID() {
        return contestEffectID;
    }

    public Integer getSuperContestEffectID() {
        return superContestEffectID;
    }

    @Override
    public String toString() {
        return "Move{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", power=" + power +
                ", accuracy=" + accuracy +
                ", PP=" + PP +
                ", effect='" + effect + '\'' +
                ", critProbability=" + critProbability +
                ", TM='" + TM + '\'' +
                ", gen=" + gen +
                ", ID=" + ID +
                ", targetID=" + targetID +
                ", damageClassID=" + damageClassID +
                ", effectID=" + effectID +
                ", effectProb=" + effectProb +
                ", contestTypeID=" + contestTypeID +
                ", contestEffectID=" + contestEffectID +
                ", superContestEffectID=" + superContestEffectID +
                '}';
    }
}
