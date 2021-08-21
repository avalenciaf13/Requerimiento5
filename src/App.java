import views.index;

public class App {
    public static void main(String[] args) throws Exception {
        index i = new index("jdbc:sqlite:ProyectosConstruccion.db");
        i.setVisible(true);

    }
}