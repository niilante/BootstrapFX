package bootstrapfx;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author BENJAH
 */
public class Controller implements Initializable {
    @FXML
    private AnchorPane main_pane;
    @FXML
    private Button sign_out, min_window, clz_window;

    @FXML
    private JFXButton comp_btn_labels, comp_btn_buttons, comp_btn_toggles,
            comp_btn_radios;
    @FXML
    private AnchorPane comp_pane_labels, comp_pane_buttons, comp_pane_toggles,
            comp_pane_radios;
    
    public static Stage primaryStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    /***** Formatted Code *****/
    @FXML
    private void navigationControl(ActionEvent e) {
        controlSelected(((Group)((Button)e.getSource()).getParent()), e);
        if (e.getSource()== comp_btn_labels) comp_pane_labels.toFront();
        else if (e.getSource()== comp_btn_buttons) comp_pane_buttons.toFront();
        else if (e.getSource()== comp_btn_toggles) comp_pane_toggles.toFront();
        else if (e.getSource()== comp_btn_radios) comp_pane_radios.toFront();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent e) {
        if (e.getSource()==min_window) primaryStage.setIconified(true);
        else if (e.getSource()==clz_window) {
            primaryStage.hide();
            //shutdown hook here;
            System.exit(0);
        }
    }
    
    /***** Reusable Code *****/
    private void controlSelected(Group group, ActionEvent e) {
        group.getChildren().forEach(node-> {
            ((Button)node).getStyleClass().removeAll("ctrl-selected");
        });
        ((Button)e.getTarget()).getStyleClass().add("ctrl-selected");
    }
}