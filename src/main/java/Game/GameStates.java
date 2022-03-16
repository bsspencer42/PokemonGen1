package Game;

public enum GameStates {
    PLAY,
    WORLDEDITOR,
    BATTLE,
    MENU;
    public static GameStates gameState = MENU;

    public static void SetGameState(GameStates state){
        gameState = state;
    }

}
