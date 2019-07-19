package capitanamerica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.awt.Desktop;
import java.net.URI;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;

public class VistaFXMLController implements Initializable {

    private boolean animado = false;
    private int anime = 1;
    
    double xMouse, yMouse;

    @FXML
    private Circle cCircle;

    @FXML
    private Pane ivIsquierda, ivDerecha, pBoton, pImagen;

    @FXML
    private VBox pSteve, pBucky;

    @FXML
    private ImageView ivBucky, ivSteve, mensaje, buscar;

    @FXML
    private Line lhorisontal;
    @FXML
    private Hyperlink instagram, linkedin, github;
    @FXML
    private AnchorPane root;
    private Image img;
  

    private void Direccion(String n) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(n));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        root.setOnMousePressed((t) -> {
            xMouse= t.getSceneX();
            yMouse= t.getSceneY();
        });
        
       root.setOnMouseDragged((t) -> {
           Main.stage.setX(t.getScreenX()-xMouse);
           Main.stage.setY(t.getScreenY()-yMouse);
           Main.stage.setOpacity(0.8f);
       });
       
       root.setOnDragDone((t) -> {
           Main.stage.setOpacity(1.0f);
       });
       
       root.setOnMouseReleased((t) -> {
           Main.stage.setOpacity(1.0f);
       });

        mensaje.setOnMouseEntered((t) -> {
            img = new Image(getClass().getResourceAsStream("/img/messageh.png"));
            mensaje.setImage(img);
        });
        mensaje.setOnMouseExited((t) -> {
            img = new Image(getClass().getResourceAsStream("/img/icons8_message_60px.png"));
            mensaje.setImage(img);
        });

        buscar.setOnMouseEntered((t) -> {
            img = new Image(getClass().getResourceAsStream("/img/buscarh.png"));
            buscar.setImage(img);
        });

        buscar.setOnMouseExited((t) -> {
            img = new Image(getClass().getResourceAsStream("/img/icons8_search_52px.png"));
            buscar.setImage(img);
        });

        instagram.setOnMouseClicked((t) -> {

            Direccion("https://www.instagram.com/joshua_atencia");
        });

        linkedin.setOnMouseClicked((t) -> {
            Direccion("https://www.linkedin.com/in/joshuaruiz95");
        });

        github.setOnMouseClicked((t) -> {
            Direccion("https://github.com/joshuaatencia");
        });

        Image avatar = new Image("/img/avatar.jpg", false);
        cCircle.setFill(new ImagePattern(avatar));

        TranslateTransition tposition = new TranslateTransition(Duration.seconds(2), lhorisontal);
        tposition.setToX(100);
        tposition.setCycleCount(Timeline.INDEFINITE);
        tposition.setAutoReverse(true);
        tposition.play();

        ///////////////////////////////////////////////////////
        ivDerecha.setOnMouseClicked((t) -> {
            if (anime == 1) {
                pBucky.setVisible(true);
                ivBucky.setVisible(true);
                FadeTransition ftb = new FadeTransition(Duration.seconds(1), ivBucky);
                ftb.setFromValue(0.0f);
                ftb.setToValue(1.0f);
                ftb.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                FadeTransition ftbb = new FadeTransition(Duration.seconds(1), pBucky);
                ftbb.setFromValue(0.0f);
                ftbb.setToValue(1.0f);
                ftbb.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                FadeTransition ftbi = new FadeTransition(Duration.seconds(1), ivBucky);
                ftbi.setFromValue(0.0f);
                ftbi.setToValue(1.0f);
                ftbi.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                FadeTransition fte = new FadeTransition(Duration.seconds(1), pSteve);
                fte.setFromValue(1.0f);
                fte.setToValue(0.0f);
                fte.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                TranslateTransition tte = new TranslateTransition(Duration.seconds(1), pSteve);
                tte.setToX(300);
                tte.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                FadeTransition ft = new FadeTransition(Duration.seconds(1), ivSteve);
                ft.setFromValue(1.0f);
                ft.setToValue(0.0f);
                ft.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                TranslateTransition tt = new TranslateTransition(Duration.seconds(1), ivSteve);
                tt.setToX(370);
                tt.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                ParallelTransition pt = new ParallelTransition();
                pt.getChildren().addAll(ft, tt, fte, tte, ftb, ftbi, ftbb);
                pt.play();

                pSteve.setVisible(false);
                anime = 2;
            }

        });

        pBoton.setOnMouseEntered((e) -> {
            RotateTransition rt = new RotateTransition(Duration.seconds(5), pBoton);
            rt.setByAngle(360);
            rt.setAutoReverse(true);
            rt.setInterpolator(new Interpolator() {
                @Override
                protected double curve(double t) {
                    //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                    return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                }
            });
            rt.play();
        });

        //////////////////////////////////////////////////////////////////////////////
        ivIsquierda.setOnMouseClicked((t) -> {

            if (anime == 2) {
                pSteve.setVisible(true);
                FadeTransition ft = new FadeTransition(Duration.seconds(1), pBucky);
                ft.setFromValue(1.0f);
                ft.setToValue(0.0f);
                ft.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                FadeTransition fti = new FadeTransition(Duration.seconds(1), ivBucky);
                fti.setFromValue(1.0f);
                fti.setToValue(0.0f);
                fti.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                TranslateTransition tt = new TranslateTransition(Duration.seconds(1), ivSteve);
                tt.setToX(0);
                tt.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                FadeTransition ftif = new FadeTransition(Duration.seconds(1), ivSteve);
                ftif.setFromValue(0.0f);
                ftif.setToValue(1.0f);
                ftif.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                TranslateTransition ttd = new TranslateTransition(Duration.seconds(1), pSteve);
                ttd.setToX(0);
                ttd.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                FadeTransition ftiff = new FadeTransition(Duration.seconds(1), pSteve);
                ftiff.setFromValue(0.0f);
                ftiff.setToValue(1.0f);
                ftiff.setInterpolator(new Interpolator() {
                    @Override
                    protected double curve(double t) {
                        //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                        return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
                    }
                });

                ParallelTransition pt = new ParallelTransition();
                pt.getChildren().addAll(ft, fti, tt, ftif, ttd, ftiff);
                pt.play();

                anime = 1;

            }

        });

    }

    @FXML
    void Clicked(MouseEvent event) {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(2), pImagen);
        if (animado) {
            tt.setToX(0);
            animado = false;
        } else {
            tt.setToX(200);
            tt.setOnFinished(e -> animado = true);

        }

        tt.setInterpolator(new Interpolator() {
            @Override
            protected double curve(double t) {
                //return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
                return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
            }
        });

        tt.play();

    }

    @FXML
    void label(MouseEvent event) {
        System.exit(0);
    }

}
