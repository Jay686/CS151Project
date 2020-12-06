package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
			
			int height = 600;
			int width = 1000;
			//title of the app
			primaryStage.setTitle("Organize My Life");
			
			//create new buttons, lists, and labels for name
			
			VBox pane = new VBox();
			
			
			HBox reminderBox = new HBox();
			Button reminderAdd = new Button("Add");
			TextField reminderName = new TextField();
			reminderName.setPrefWidth(width / 3);
			Label reminderLbl = new Label("Reminder Name =");
			ListView<String> reminderList = new ListView<String>();
			Label lbl = new Label("Click the button to add some events :)");
			
			HBox eventBox = new HBox();
			Button eventAdd = new Button("Add");
			TextField eventName = new TextField();
			eventName.setPrefWidth(width / 3);
			Label eventLbl = new Label("	Event Name =");
			ListView<String> eventList = new ListView<String>();
			
			HBox listBox = new HBox();
			
			VBox.setMargin(reminderBox, new Insets(width/45,width/5,width/45,width/5));
			VBox.setMargin(eventBox, new Insets(width/45,width/5,width/45,width/5));
			HBox.setMargin(reminderName, new Insets(0,width/50,0,width/50));
			HBox.setMargin(eventName, new Insets(0,width/50,0,width/50));
			
			
			
			reminderBox.getChildren().add(reminderLbl);
			reminderBox.getChildren().add(reminderName);
			reminderBox.getChildren().add(reminderAdd);
			
			eventBox.getChildren().add(eventLbl);
			eventBox.getChildren().add(eventName);
			eventBox.getChildren().add(eventAdd);
			
			pane.getChildren().add(reminderBox);
			pane.getChildren().add(eventBox);
			
			HBox lists = new HBox();
			
			VBox reminderControl = new VBox();
			VBox eventControl = new VBox();
			
			Button reminderEdit = new Button("Edit");
			Button reminderDelete = new Button("Delete");
			
			Button eventEdit = new Button("Edit");
			Button eventDelete = new Button("Delete");
			
			
			reminderControl.getChildren().add(reminderEdit);
			reminderControl.getChildren().add(reminderDelete);
			lists.getChildren().add(reminderControl);
			
			
			lists.getChildren().add(reminderList);
			lists.getChildren().add(eventList);
			
			eventList.getItems().add(0, "EVENTS");
			reminderList.getItems().add(0, "REMINDERS");

			
			eventControl.getChildren().add(eventEdit);
			eventControl.getChildren().add(eventDelete);
			lists.getChildren().add(eventControl);
			
			HBox.setMargin(reminderList, new Insets(0,width/25,0,width/20));
			HBox.setMargin(eventList, new Insets(0,width/20,0,width/25));
			HBox.setMargin(reminderControl, new Insets(width/10,width/25,0,width/15));
			HBox.setMargin(eventControl, new Insets(width/10,width/15,0,width/25));
			
	
			
			pane.getChildren().add(lists);
			
			//create vbox with all components
			
	
			
			
			//add event when button 1 is clicked
			reminderAdd.setOnAction(event -> {
				String text;
				if(!reminderName.getText().isEmpty()) {
					text = reminderName.getText();
				}
				else {
					text = "Event " + (reminderList.getItems().size() + 1);
				}
				reminderList.getItems().add(reminderList.getItems().size(), text);
				reminderName.clear();
			
			}
			);
			
			eventAdd.setOnAction(event -> {
				String text;
				if(!eventName.getText().isEmpty()) {
					text = eventName.getText();
				}
				else {
					text = "Event " + (eventList.getItems().size() + 1);
				}
				eventList.getItems().add(eventList.getItems().size(), text);
				eventName.clear();
	
			}
			);
			
			eventDelete.setOnAction(event -> {
				String selectedItem = eventList.getSelectionModel().getSelectedItem();
				if(selectedItem != null && eventList.getSelectionModel().getSelectedIndex() != 0) {
					eventList.getItems().remove(eventList.getSelectionModel().getSelectedIndex());
				}
			}
			);
			
			
			reminderDelete.setOnAction(event -> {
				String selectedItem = reminderList.getSelectionModel().getSelectedItem();
				if(selectedItem != null && reminderList.getSelectionModel().getSelectedIndex() != 0) {
					reminderList.getItems().remove(reminderList.getSelectionModel().getSelectedIndex());
				}
			}
			);
			
			
			
			/*
			//remove event when button 2 is clicked
			btn2.setOnAction(event -> {
				if(list.getItems().size() > 0) {
					list.getItems().remove(list.getItems().size() - 1);
				}
				lbl.setText("You have a total of " + list.getItems().size() + " event(s)!");
			}
			);
			*/
			//create scene
			Scene scene = new Scene(pane,width,height);
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
