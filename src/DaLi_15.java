import auxp.ch15.MovableRectanglePane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lib.Misc.Asserts;
import lib.Misc.Randomizer;
import lib.MyFX.ToolFX;

public class DaLi_15 extends Application{

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("C15");
        //stage.setHeight(500);
        //stage.setWidth(500);


        Pane pane = ex04();


        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void ex00() {
    }
    public static Pane ex01() {//Pick four cards
        HBox cards = new HBox();
        final int elements = 4;
        for (int i = 0; i < elements; i++) {
            int rand = Randomizer.randomInt(1, 53);
            Image img = new Image("res/image/card/" + (rand + 1) + ".png");
            ImageView iv = new ImageView(img);
            cards.getChildren().add(iv);
        }

        Button refreshBtn = new Button("Refresh");
        refreshBtn.setOnAction(e -> {
            cards.getChildren().clear();
            for (int i = 0; i < elements; i++) {
                int rand = Randomizer.randomInt(1, 53);
                Image img = new Image("res/image/card/" + (rand + 1) + ".png");
                ImageView iv = new ImageView(img);
                cards.getChildren().add(iv);
            }
        });
        BorderPane bp = new BorderPane();
        bp.setCenter(cards);
        bp.setBottom(refreshBtn);
        BorderPane.setAlignment(refreshBtn, Pos.CENTER);
        return bp;

    }
    public static Pane ex02() {//Rotate an Ellipse
        Ellipse ellipse = new Ellipse(150, 100);
        ToolFX.setFillStroke(null, Color.BLACK, ellipse);

        Button rtBtnL = new Button("Rotate C-CW (Left)");
        rtBtnL.setOnAction(e -> ellipse.setRotate(ellipse.getRotate()-5));
        Button rtBtnR = new Button("Rotate CW (Right)");
        rtBtnR.setOnAction(event -> ellipse.setRotate(ellipse.getRotate()+5));

        BorderPane bp = new BorderPane();
        bp.setCenter(ellipse);
        HBox btns = new HBox(rtBtnL,rtBtnR);
        btns.setAlignment(Pos.CENTER);
        bp.setBottom(btns);
        BorderPane.setAlignment(btns, Pos.CENTER);

        stage.setMinHeight(ellipse.getRadiusY()*3);
        stage.setMinWidth(ellipse.getRadiusX()*2.5);

        ellipse.centerXProperty().bind(bp.widthProperty().divide(2));
        ellipse.centerYProperty().bind(bp.heightProperty().divide(2));
        return bp;
    }
    public static Pane ex03() {//Move the rectangle
        return new MovableRectanglePane();
    }
    public static Pane ex04() {//Create a simple calculator

        Text n1 = new Text("N1:");
        TextField t1 = new TextField();
        t1.setMaxWidth(60);
        Text n2 = new Text("N2:");
        TextField t2 = new TextField();
        t2.setMaxWidth(60);
        Text n3 = new Text("N3:");
        TextField t3 = new TextField();
        t3.setMaxWidth(80);
        t3.setEditable(false);
        HBox values = new HBox(n1,t1,n2,t2,n3,t3);
        values.setAlignment(Pos.CENTER);
        values.setSpacing(5);

        Button add = new Button("Add");
        Button sub = new Button("Subtract");
        Button mult = new Button("Multiply");
        Button divi = new Button("Divide");
        HBox buttons = new HBox(add,sub,mult,divi);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        add.setOnAction(event -> {
            String st1 = t1.getText();
            if(Asserts.isDouble(st1) && Asserts.isDouble(t2.getText())){
                t3.setText( (Double.parseDouble(t1.getText())+Double.parseDouble(t2.getText()) ) + "" );
            }else{
                t3.setText("N/A");
            }
        });

        sub.setOnAction(event -> {
            String st1 = t1.getText();
            if(Asserts.isDouble(st1) && Asserts.isDouble(t2.getText())){
                t3.setText( (Double.parseDouble(t1.getText())-Double.parseDouble(t2.getText()) ) + "" );
            }else{
                t3.setText("N/A");
            }
        });

        mult.setOnAction(event -> {
            String st1 = t1.getText();
            if(Asserts.isDouble(st1) && Asserts.isDouble(t2.getText())){
                t3.setText( (Double.parseDouble(t1.getText())*Double.parseDouble(t2.getText()) ) + "" );
            }else{
                t3.setText("N/A");
            }
        });

        divi.setOnAction(event -> {
            String st1 = t1.getText();
            if(Asserts.isDouble(st1) && Asserts.isDouble(t2.getText())){
                t3.setText( (Double.parseDouble(t1.getText())/Double.parseDouble(t2.getText()) ) + "" );
            }else{
                t3.setText("N/A");
            }
        });
        VBox vb = new VBox(values, buttons);
        vb.setPadding(new Insets(10));
        vb.setSpacing(5);
        return vb;
    }
    public static void ex05() {
    }
    public static void ex06() {
    }
    public static void ex07() {
    }
    public static void ex08() {
    }
    public static void ex09() {
    }
    public static void ex10() {
    }
    public static void ex11() {
    }
    public static void ex12() {
    }
    public static void ex13() {
    }
    public static void ex14() {
    }
    public static void ex15() {
    }
    public static void ex16() {
    }
    public static void ex17() {
    }
    public static void ex18() {
    }
    public static void ex19() {
    }
    public static void ex20() {
    }
    public static void ex21() {
    }
    public static void ex22() {
    }
    public static void ex23() {
    }
    public static void ex24() {
    }
    public static void ex25() {
    }
    public static void ex26() {
    }
    public static void ex27() {
    }
    public static void ex28() {
    }
    public static void ex29() {
    }
    public static void ex30() {
    }
    public static void ex31() {
    }
    public static void ex32() {
    }
    public static void ex33() {
    }
    public static void ex34() {
    }
    public static void ex35() {
    }
    public static void ex36() {
    }
}