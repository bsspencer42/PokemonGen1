package Pokemon;

public class LevelUp {

    public static int levelUpHP(int level,int numLevels, int baseHP, int IV){
        if (numLevels < 1){
            return baseHP;
        }
        int newHP = baseHP;
        int currentLevel = level;
        for (int i = 0; i < numLevels; i++) {
            currentLevel++;
            newHP = ((2*baseHP+IV)*currentLevel)/100+currentLevel+10;
        }
        return  newHP;
    }

    public static int levelUpStat(int level,int numLevels, int baseStat, int IV){
        if (numLevels < 1){
            return baseStat;
        }
        int newStat = baseStat;
        int currentLevel = level;
        for (int i = 0; i < numLevels; i++) {
            currentLevel++;
            newStat = ((2*baseStat+IV)*currentLevel)/100+5;
        }
        return  newStat;
    }

    public static int checkLevelUp(int level, int expPoints, long growthRate){
        int levelUp = 0;
        boolean calcComplete = false;
        while (!calcComplete) {
            int requiredExp = getExpPoints(level+1, growthRate);

            if (requiredExp > expPoints) {
                calcComplete = true;
            }
            else {
                levelUp++;
                level++;
            }
        }
        return levelUp;
    }

    public static int getExpPoints(int level, long growthRate){
        double requiredExp;
        switch ((int) growthRate) {
            case 800000:
                requiredExp = ((int) 4.0 / 5.0 * Math.pow(level, 3));
                break;
            case 1000000:
                requiredExp = Math.pow(level, 3);
                break;
            case 1059860:
                requiredExp = (6.0 / 5.0) * Math.pow(level, 3.0) - (15.0 * Math.pow(level, 2.0)) + (100.0 * level) - 140.0;
                break;
            case 1250000:
                requiredExp = (5.0 / 4.0 * Math.pow(level, 3.0));
                break;
            default:
                throw new IllegalArgumentException("Growth rate does not exist");
        }
        return (int) requiredExp;
    }



}
