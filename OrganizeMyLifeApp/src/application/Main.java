package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Popup;
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
					text = "Reminder " + (reminderList.getItems().size());
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
					text = "Event " + (eventList.getItems().size());
				}
				eventList.getItems().add(eventList.getItems().size(), text);
				eventName.clear();
	
			}
			);
			
			
			Popup eventPopup = new Popup(); 
			eventPopup.setHeight(height/2);
			eventPopup.setWidth(width/2);

			BorderPane eventPopBox = new BorderPane();
			Button eventYes = new Button("Yes");
			Button eventNo = new Button("No");
			Label eventConfirm = new Label("Are you sure you want to delete this event?");
			
			eventPopBox.setTop(eventConfirm);
			eventPopBox.setLeft(eventYes);
			eventPopBox.setRight(eventNo);
			
			eventPopBox.setPadding(new Insets(height/40, width/40, height/40, width/40));

			eventPopBox.setStyle(" -fx-background-color: white;" + "-fx-border-color: black");
			eventPopup.getContent().add(eventPopBox);
			
			eventDelete.setOnAction(event -> {
				String selectedItem = eventList.getSelectionModel().getSelectedItem();
				if(selectedItem != null && eventList.getSelectionModel().getSelectedIndex() != 0) {
					eventPopup.show(primaryStage);
				}
				
			}
			);
			
			eventYes.setOnAction(event -> {
				eventList.getItems().remove(eventList.getSelectionModel().getSelectedIndex());
				eventList.getSelectionModel().clearSelection();
				eventPopup.hide();
			}
			);
			
			eventNo.setOnAction(event -> {
				eventList.getSelectionModel().clearSelection();
				eventPopup.hide();
			}
			);
			
			Popup reminderPopup = new Popup(); 
			reminderPopup.setHeight(height/2);
			reminderPopup.setWidth(width/2);

			BorderPane reminderPopBox = new BorderPane();
			Button reminderYes = new Button("Yes");
			Button reminderNo = new Button("No");
			Label reminderConfirm = new Label("Are you sure you want to delete this reminder?");
			
			reminderPopBox.setTop(reminderConfirm);
			reminderPopBox.setLeft(reminderYes);
			reminderPopBox.setRight(reminderNo);
			
			reminderPopBox.setPadding(new Insets(height/40, width/40, height/40, width/40));

			reminderPopBox.setStyle(" -fx-background-color: white;" + "-fx-border-color: black");
			reminderPopup.getContent().add(reminderPopBox);
			
			reminderDelete.setOnAction(event -> {
				String selectedItem = reminderList.getSelectionModel().getSelectedItem();
				if(selectedItem != null && reminderList.getSelectionModel().getSelectedIndex() != 0) {
					reminderPopup.show(primaryStage);
				}
				
			}
			);
			
			reminderYes.setOnAction(event -> {
				reminderList.getItems().remove(reminderList.getSelectionModel().getSelectedIndex());
				reminderList.getSelectionModel().clearSelection();
				reminderPopup.hide();
			}
			);
			
			reminderNo.setOnAction(event -> {
				reminderList.getSelectionModel().clearSelection();
				reminderPopup.hide();
			}
			);
			
			//edit event functionality
			
			Popup eventEditPop = new Popup(); 
			eventEditPop.setHeight(height/2);
			eventEditPop.setWidth(width/2);

			BorderPane eventEditBox = new BorderPane();
			Button eventChange = new Button("Confirm");
			Button eventCancel = new Button("Cancel");
			Label eventEditConfirm = new Label("What would you like to change this event to?");
			TextField eventEditText = new TextField();
			
			eventEditBox.setTop(eventEditConfirm);
			eventEditBox.setCenter(eventEditText);
			eventEditBox.setLeft(eventCancel);
			eventEditBox.setRight(eventChange);
			
			eventEditBox.setPadding(new Insets(height/40, width/40, height/40, width/40));

			eventEditBox.setStyle(" -fx-background-color: white;" + "-fx-border-color: black");
			eventEditPop.getContent().add(eventEditBox);
			
			
			eventEdit.setOnAction(event -> {
				String selectedItem = eventList.getSelectionModel().getSelectedItem();
				if(selectedItem != null && eventList.getSelectionModel().getSelectedIndex() != 0) {
					eventEditPop.show(primaryStage);
				}
			}
			);
			
			eventChange.setOnAction(event -> {
				eventList.getSelectionModel().getSelectedItem();
				
				String text;
				if(!eventEditText.getText().isEmpty()) {
					text = eventEditText.getText();
				}
				else {
					text = "Event " + (eventList.getSelectionModel().getSelectedIndex());
				}
				eventList.getItems().set(eventList.getSelectionModel().getSelectedIndex(), text);
				eventList.getSelectionModel().clearSelection();
				eventEditText.clear();
				eventEditPop.hide();
			}
			);
			
			eventCancel.setOnAction(event -> {
				eventList.getSelectionModel().clearSelection();
				eventEditPop.hide();
				eventEditText.clear();
			}
			);
			
			//edit reminder functionality
			
			Popup reminderEditPop = new Popup(); 
			reminderEditPop.setHeight(height/2);
			reminderEditPop.setWidth(width/2);

			BorderPane reminderEditBox = new BorderPane();
			Button reminderChange = new Button("Confirm");
			Button reminderCancel = new Button("Cancel");
			Label reminderEditConfirm = new Label("What would you like to change this reminder to?");
			TextField reminderEditText = new TextField();
			
			reminderEditBox.setTop(reminderEditConfirm);
			reminderEditBox.setCenter(reminderEditText);
			reminderEditBox.setLeft(reminderCancel);
			reminderEditBox.setRight(reminderChange);
			
			reminderEditBox.setPadding(new Insets(height/40, width/40, height/40, width/40));

			reminderEditBox.setStyle(" -fx-background-color: white;" + "-fx-border-color: black");
			reminderEditPop.getContent().add(reminderEditBox);
			
			
			reminderEdit.setOnAction(event -> {
				String selectedItem = reminderList.getSelectionModel().getSelectedItem();
				if(selectedItem != null && reminderList.getSelectionModel().getSelectedIndex() != 0) {
					reminderEditPop.show(primaryStage);
				}
			}
			);
			
			reminderChange.setOnAction(event -> {
				reminderList.getSelectionModel().getSelectedItem();
				
				String text;
				if(!reminderEditText.getText().isEmpty()) {
					text = reminderEditText.getText();
				}
				else {
					text = "Reminder " + (reminderList.getSelectionModel().getSelectedIndex());
				}
				reminderList.getItems().set(reminderList.getSelectionModel().getSelectedIndex(), text);
				reminderList.getSelectionModel().clearSelection();
				reminderEditText.clear();
				reminderEditPop.hide();
			}
			);
			
			reminderCancel.setOnAction(event -> {
				reminderList.getSelectionModel().clearSelection();
				reminderEditPop.hide();
				reminderEditText.clear();
			}
			);

			
			pane.setStyle(" -fx-background-color: #e8d8e3" );

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
