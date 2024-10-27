package metier;
import java.sql.Connection;
import java.sql.DriverManager;
public class SingletonConnection {
    private static Connection connection;
    // Un blocs static s’exécute une seule fois lors du chargement de la classe
    // et ne s’exécute pas lors des instanciation de la classe ,ils sont lancés avant l'appel des constructeurs.
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/base","root","");
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}