package Game;

public enum GameStates {
    WORLD,
    BATTLE,
    MENU;
    public static GameStates gameState = MENU;

    public static void SetGameState(GameStates state){
        gameState = state;
    }

}
