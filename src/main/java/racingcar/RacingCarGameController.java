package racingcar;

public class RacingCarGameController {
    private final RacingCarGameMachine racingCarGameMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(RacingCarGameMachine racingCarGameMachine, InputView inputView, OutputView outputView) {
        this.racingCarGameMachine = racingCarGameMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private void init() {
        outputView.outputMessage(OutputMessage.RACING_CAR_NAME_INPUT_REQUEST);
        String nameInput = inputView.readLine();
        outputView.outputMessage(OutputMessage.ROUND_COUNT_INPUT_REQUEST);
        int roundCount = inputView.readInt();
        racingCarGameMachine.init(nameInput, roundCount);
    }

    private void executeGame() {
        while (racingCarGameMachine.isGameInProgress()) {
            String roundResult = racingCarGameMachine.playRound();
            outputView.outputMessage(roundResult);
        }
    }
}
