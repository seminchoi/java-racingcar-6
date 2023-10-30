package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameMachineValidatorTest {
    private final String RACING_CAR_NAME_1 = "semin";
    private final String RACING_CAR_NAME_2 = "woowa";
    private final String RACING_CAR_NAME_3 = "tech";
    private final String RACING_CAR_NAME_4 = "pre";
    private final String RACING_CAR_NAME_5 = "java";
    private final String RACING_CAR_NAME_6 = "back";
    private final int TOO_SMALL_ROUND_COUNT = 0;
    private final int TOO_LARGE_ROUND_COUNT = 31;

    private RacingCarGameMachineValidator racingCarGameMachineValidator;

    @BeforeEach
    void init() {
        racingCarGameMachineValidator = new RacingCarGameMachineValidator();
    }

    @Test
    void 레이싱카_허용_개수_초과() {
        List<String> tooManyRacingCarNameList = new ArrayList<>();
        tooManyRacingCarNameList.add(RACING_CAR_NAME_1);
        tooManyRacingCarNameList.add(RACING_CAR_NAME_2);
        tooManyRacingCarNameList.add(RACING_CAR_NAME_3);
        tooManyRacingCarNameList.add(RACING_CAR_NAME_4);
        tooManyRacingCarNameList.add(RACING_CAR_NAME_5);
        tooManyRacingCarNameList.add(RACING_CAR_NAME_6);


        assertThatThrownBy(() -> callValidateNameInputMethod(tooManyRacingCarNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱카_허용_개수_미만() {
        List<String> tooFewRacingCarNameList = new ArrayList<>();
        tooFewRacingCarNameList.add(RACING_CAR_NAME_1);

        assertThatThrownBy(() -> callValidateNameInputMethod(tooFewRacingCarNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름_포함() {
        List<String> containingDuplicateRacingCarNameList = new ArrayList<>();
        containingDuplicateRacingCarNameList.add(RACING_CAR_NAME_1);
        containingDuplicateRacingCarNameList.add(RACING_CAR_NAME_1);

        assertThatThrownBy(() -> callValidateNameInputMethod(containingDuplicateRacingCarNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void callValidateNameInputMethod(List<String> names) {
        racingCarGameMachineValidator.validateNameList(names);
    }

    @Test
    void 최소_라운드_미만() {
        assertThatThrownBy(() -> callValidateRoundCountMethod(TOO_SMALL_ROUND_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최대_라운드_초과() {
        assertThatThrownBy(() -> callValidateRoundCountMethod(TOO_LARGE_ROUND_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void callValidateRoundCountMethod(int tooLargeRoundCount) {
        racingCarGameMachineValidator.validateRoundCount(tooLargeRoundCount);
    }
}
