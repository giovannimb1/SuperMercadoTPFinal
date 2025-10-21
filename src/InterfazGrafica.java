import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InterfazGrafica extends Application {

    @Override
    public void start(Stage stage) {
        System.out.println(getClass().getResource("/img/cap.png"));

        // Instancia del layout con la resolucion de la ventana;
        AnchorPane layout = new AnchorPane();
        layout.setPrefSize(800, 600);


        //fondo
        Rectangle fondo = new Rectangle();
        fondo.setX(-9.0);
        fondo.setY(-4.0);
        fondo.setWidth(381.0);
        fondo.setHeight(606.0);
        fondo.setArcWidth(5.0);
        fondo.setArcHeight(5.0);
        fondo.setFill(Color.web("#0e1625"));
        fondo.setStroke(Color.BLACK);


        //Campos de texto donde el usuario va a ingresar la cuenta con sus datos
        TextField txtUsuario = new TextField();
        txtUsuario.setLayoutX(82.0);
        txtUsuario.setLayoutY(306.0);
        txtUsuario.setPrefWidth(200);

        PasswordField txtPass = new PasswordField();
        txtPass.setLayoutX(82.0);
        txtPass.setLayoutY(382.0);
        txtPass.setPrefWidth(200);

        //Textos para ubicar donde poner el usuario y la contraseña
        Text lblUsuario = new Text("Usuario");
        lblUsuario.setFill(Color.WHITE);
        lblUsuario.setLayoutX(82.0);
        lblUsuario.setLayoutY(294.0);

        Text lblPass = new Text("Contraseña");
        lblPass.setFill(Color.WHITE);
        lblPass.setLayoutX(82.0);
        lblPass.setLayoutY(370.0);

        // Boton de inicio de sesion
        Button btnIniciar = new Button("Iniciar");
        btnIniciar.setLayoutX(82.0);
        btnIniciar.setLayoutY(446.0);
        btnIniciar.setPrefSize(200.0, 40.0);


        // Importacion de imagenes
        ImageView imgFondo = new ImageView();
        imgFondo.setFitWidth(589.0);
        imgFondo.setFitHeight(602.0);
        imgFondo.setLayoutX(327.0);
        imgFondo.setLayoutY(0.0);
        imgFondo.setImage(new Image(getClass().getResource("/img/cap.png").toExternalForm()));

        ImageView logo = new ImageView();
        logo.setFitWidth(160.0);
        logo.setFitHeight(155.0);
        logo.setLayoutX(20.0);
        logo.setLayoutY(97.0);
        logo.setImage(new Image(getClass().getResource("/img/fall.png").toExternalForm()));

        ImageView textoLogo = new ImageView();
        textoLogo.setFitWidth(320.0);
        textoLogo.setFitHeight(260.0);
        textoLogo.setLayoutX(65.0);
        textoLogo.setLayoutY(50);
        textoLogo.setImage(new Image(getClass().getResource("/img/nombre.png").toExternalForm()));

        //muestro TOD0
        layout.getChildren().addAll(imgFondo, fondo, textoLogo, logo, lblUsuario, txtUsuario, lblPass, txtPass, btnIniciar);

        /*Escena con el layout antes creado donde se le pone
        un titulo a la ventana, y hace que no se pueda ni achicar ni ampliar
        la pantalla obligando a que el programa tenga una sola resolucion, ademas de
        que se muestre
         */
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("SuperMercado");
        stage.setResizable(false);//<-
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
