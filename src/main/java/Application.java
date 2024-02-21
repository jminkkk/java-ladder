import controller.LadderGame;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new InputView(), new OutputView());
        ladderGame.play();
    }
}
