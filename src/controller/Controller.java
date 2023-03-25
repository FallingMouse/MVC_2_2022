package controller;

import view.View;
import model.Model;

public class Controller {
    // region fields ***
    View view;
    Model model;
    // endregion fields ***
    
    // region constructors ***
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        iniController();
    }
    // endregion constructors ***

    // region private method ***
    private void iniController() {
        view.getBtnSend().addActionListener(e -> onSend());
    }

    private void onSend() {
        model.setFullInput(view.getTxtYourTextHere().getText());
        model.execute();
        view.getTextRespond().setText(model.getRespondText());
    }
    // endregion private method ***
}
