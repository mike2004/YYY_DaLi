package auxp.ch17.splitter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class FileSplitPane extends BorderPane {
    private File file;

    private Button browseButton;
    private TextField fileDir;
    private FileChooser fileChooser;

    private TextField newName;
    private TextField newExt;
    private TextField totalSize;
    private TextField numOfPieces;
    private TextField sizeOfPieces;

    private RadioButton pickNumOfPiecesRadio;
    private RadioButton pickSizeOfSplitsRadio;
    private Text finalSizeOfPieces;
    private Text finalNumOfSplits;

    private ArrayList<File> files;

    private Button execButton;

    public FileSplitPane() {
        this(false); // default is join pane
    }

    public FileSplitPane(boolean split) {
        setPadding(new Insets(5));

        HBox browsePane = getBrowseBox();

        GridPane grid = getFieldsGrid();

        HBox bot = getExecButtonBox();

        if (split) {
            pickNumOfPiecesRadio = new RadioButton();
            pickSizeOfSplitsRadio = new RadioButton();

            ToggleGroup pickSplitType = new ToggleGroup();
            pickNumOfPiecesRadio.setToggleGroup(pickSplitType);
            pickSizeOfSplitsRadio.setToggleGroup(pickSplitType);

            finalSizeOfPieces = new Text();
            finalSizeOfPieces.setVisible(false);

            finalNumOfSplits = new Text();
            finalNumOfSplits.setVisible(false);

            grid.addRow(2, pickNumOfPiecesRadio, finalSizeOfPieces);
            grid.addRow(3, pickSizeOfSplitsRadio, finalNumOfSplits);

            execButton.setText("Split");
            setSplitActions();
        } else {
            execButton.setText("Join");
            setJoinActions();
        }

        setTop(browsePane);
        setLeft(grid);
        setBottom(bot);
    }

    private void setSplitActions() {
        browseButton.setOnAction(event -> {
            file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                fileDir.setText(file.getAbsolutePath());

                newName.setText(file.getName());
                newName.setEditable(true);
                newExt.setText("000");

                totalSize.setText(FileSplitter.byteSizeFormatter(file.length()));
                numOfPieces.setText("1");
                sizeOfPieces.setText(file.length() + "");

                numOfPieces.setEditable(true);
                pickNumOfPiecesRadio.setSelected(true);
                finalSizeOfPieces.setVisible(true);
            }
        });

        numOfPieces.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                numOfPieces.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (numOfPieces.getText().length() > 0  ) {
                long n = Long.parseLong(numOfPieces.getText());
                if(n>0)
                    finalSizeOfPieces.setText(FileSplitter.byteSizeFormatter((file.length() / n) + (file.length() % n == 0 ? 0 : 1)) + " bytes per file"); // if length % n != 0 1 more byte per file.
                else
                    finalSizeOfPieces.setText("0 bytes per file");
            }else   finalSizeOfPieces.setText("0 bytes per file");
        });

        sizeOfPieces.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                sizeOfPieces.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (sizeOfPieces.getText().length() > 0 ) {
                long n = Long.parseLong(sizeOfPieces.getText());
                if(n>0)
                    finalNumOfSplits.setText((file.length() % n == 0 ? file.length() / n : (file.length() / n) + 1)+" piece(s)");
                else
                    finalNumOfSplits.setText("0 piece(s)");
            }else   finalNumOfSplits.setText("0 piece(s)");
        });
        pickNumOfPiecesRadio.setOnAction(event -> {
            if(file != null && file.exists()) {
                finalSizeOfPieces.setVisible(true);
                finalNumOfSplits.setVisible(false);

                numOfPieces.setEditable(true);
                sizeOfPieces.setEditable(false);
            }
        });
        pickSizeOfSplitsRadio.setOnAction(event -> {
            if(file != null && file.exists()) {
                finalSizeOfPieces.setVisible(false);
                finalNumOfSplits.setVisible(true);

                numOfPieces.setEditable(false);
                sizeOfPieces.setEditable(true);
            }
        });
        execButton.setOnAction(event -> {
            FileSplitter.splitBySize(file, Integer.parseInt(sizeOfPieces.getText()));
        });
    }

    private void setJoinActions() {
        browseButton.setOnAction(event -> {
            file = fileChooser.showOpenDialog(new Stage());
            if (file == null || !file.exists() || !FileSplitter.getFileExtension(file).matches("[0-9]*")) {
                JOptionPane.showMessageDialog(null,"Invalid file");
            }else{
                files = FileSplitter.getSplitFiles(file);

                fileDir.setText(file.getAbsolutePath());
                newName.setText(FileSplitter.getCleanName(FileSplitter.getCleanName(file.getName()))+"-[joint]");
                newName.setEditable(true);
                newExt.setText(FileSplitter.getFileExtension(FileSplitter.getCleanName(file)));

                sizeOfPieces.setText(FileSplitter.byteSizeFormatter(file.length()));


                numOfPieces.setText(files.size()+"");
                totalSize.setText(FileSplitter.byteSizeFormatter(FileSplitter.getSizeOfFilesList(files)));
            }
        });

        execButton.setOnAction(event -> {
            if(files == null)
                JOptionPane.showMessageDialog(null, "You must pick a file.");
            else if(files.size() < 1 || !file.exists() || !FileSplitter.getFileExtension(file).matches("[0-9]*"))
                JOptionPane.showMessageDialog(null,"Invalid file");
            else if(newName.getText().length() == 0)
                JOptionPane.showMessageDialog(null,"Invalid filename");
            else
                FileSplitter.join(files,newName.getText()+"."+newExt.getText());
        });
    }

    private HBox getExecButtonBox() {
        execButton = new Button("GO");
        HBox bot = new HBox(execButton);
        bot.setAlignment(Pos.CENTER);
        return bot;
    }

    private GridPane getFieldsGrid() {
        newName = new TextField();
        newName.setEditable(false);
        newExt = new TextField();
        newExt.setPrefColumnCount(4);
        newExt.setEditable(false);
        totalSize = new TextField();
        totalSize.setEditable(false);
        numOfPieces = new TextField();
        numOfPieces.setEditable(false);
        sizeOfPieces = new TextField();
        sizeOfPieces.setEditable(false);

        HBox nameWithExt = new HBox(newName, new Text("."), newExt);
        nameWithExt.setAlignment(Pos.BASELINE_LEFT);

        GridPane fieldsGrid = new GridPane();
        BorderPane.setMargin(fieldsGrid, new Insets(5));
        fieldsGrid.setHgap(3);
        fieldsGrid.setVgap(5);
        fieldsGrid.addRow(0, new Label("Output Name"), nameWithExt);
        fieldsGrid.addRow(1, new Label("Total Size (bytes)"), totalSize);
        fieldsGrid.addRow(2, new Label("Num of Pieces"), numOfPieces);
        fieldsGrid.addRow(3, new Label("Size of Pieces (bytes)"), sizeOfPieces);
        return fieldsGrid;
    }

    private HBox getBrowseBox() {
        fileChooser = new FileChooser();
        fileDir = new TextField();
        fileDir.setPrefColumnCount(40);
        fileDir.setEditable(false);
        browseButton = new Button("Browse");
        HBox browsePane = new HBox(new Label("Pick a File"), fileDir, browseButton);
        browsePane.setSpacing(5);
        browsePane.setAlignment(Pos.BASELINE_LEFT);
        browsePane.setPadding(new Insets(10));
        browsePane.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        return browsePane;
    }

}
