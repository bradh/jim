package com.sigmabravo.rnd.jim.ui;

import com.sigmabravo.rnd.jim.nitf.Reader;
import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeItem;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

public class PrimaryController {

    @FXML
    private MenuBar menuBar;
    @FXML
    private TreeItem<String> treRoot;

    /**
     * Handle action related to "File->Open" menu item.
     *
     * @param event Event on "Open" menu item.
     */
    @FXML
    private void openFile(final ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
    chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(menuBar.getScene().getWindow());
        if (file != null) {
            Reader reader = new Reader(file.getAbsolutePath());
            List<TRE> tres = reader.getFileTREs();
            for (TRE tre: tres) {
                treRoot.getChildren().add(tre.toTreeItem());
            }
        }
    }

    /**
     * Handle action related to "About" menu item.
     *
     * @param event Event on "About" menu item.
     */
    @FXML
    private void handleAboutAction(final ActionEvent event) {
        provideAboutFunctionality();
    }

    /**
     * Handle action related to input (in this case specifically only responds
     * to keyboard event CTRL-A).
     *
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event) {
        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A) {
                provideAboutFunctionality();
            }
        }
    }

    /**
     * Perform functionality associated with "About" menu selection or CTRL-A.
     */
    private void provideAboutFunctionality() {
        System.out.println("You clicked on About!");
    }

    @FXML
    public void initialize() {
        menuBar.setFocusTraversable(true);
    }
}
