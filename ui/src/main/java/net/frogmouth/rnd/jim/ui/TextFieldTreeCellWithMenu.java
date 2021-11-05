package net.frogmouth.rnd.jim.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.TextFieldTreeCell;

public class TextFieldTreeCellWithMenu extends TextFieldTreeCell<String> {

    ContextMenu contextMenu;

    public TextFieldTreeCellWithMenu() {
        MenuItem menuItem = new MenuItem("Right Click");
        menuItem.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent ah) {
                        System.out.println(ah);
                    }
                });
        contextMenu = new ContextMenu(menuItem);
    }

    @Override
    public void updateItem(String t, boolean bln) {
        // Call the super class so everything works as before
        super.updateItem(t, bln);
        // Check to show the context menu for this TreeItem
        if (showMenu(t, bln)) {
            setContextMenu(contextMenu);
        } else {
            // If no menu for this TreeItem is used, deactivate the menu
            setContextMenu(null);
        }
    }

    private boolean showMenu(String t, boolean bln) {
        if (t != null && !t.equals("Root")) {
            return true;
        }
        return false;
    }
}
