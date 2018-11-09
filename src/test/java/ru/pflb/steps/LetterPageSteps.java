package ru.pflb.steps;

import ru.pflb.pages.LetterPage;
import ru.pflb.tech.BaseStep;
import ru.pflb.tech.Context;

public class LetterPageSteps extends BaseStep {

    LetterPage letterPage;

    public LetterPageSteps(Context context){
        super(context);
        letterPage = context.getPageObjectManager().getLetterPage();
    }
}
