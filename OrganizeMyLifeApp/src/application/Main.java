package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//title of the app
			primaryStage.setTitle("Organize My Life");
			
			//create new buttons, lists, and labels
			Button btn = new Button("Add an Event");
			TextField eventName = new TextField();
			Button btn2 = new Button("Delete an Event");
			ListView<String> list = new ListView<String>();
			Label lbl = new Label("Click the button to add some events :)");
			
			//create vbox with all components
			VBox pane = new VBox();
			pane.getChildren().add(lbl);
			pane.getChildren().add(btn);
			pane.getChildren().add(eventName);
			pane.getChildren().add(btn2);
			pane.getChildren().add(list);
			
			//add event when button 1 is clicked
			btn.setOnAction(event -> {
				String text;
				if(!eventName.getText().isEmpty()) {
					text = eventName.getText();
				}
				else {
					text = "Event " + (list.getItems().size() + 1);
				}
				list.getItems().add(list.getItems().size(), text);
				lbl.setText("You have a total of " + list.getItems().size() + " event(s)!");
			}
			);
			
			
			
			
			//remove event when button 2 is clicked
			btn2.setOnAction(event -> {
				if(list.getItems().size() > 0) {
					list.getItems().remove(list.getItems().size() - 1);
				}
				lbl.setText("You have a total of " + list.getItems().size() + " event(s)!");
			}
			);
			
			//create scene
			Scene scene = new Scene(pane,500,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//show the scene
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
