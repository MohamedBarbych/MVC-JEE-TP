package metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MetierImpl implements IMetierCatalogue {
    @Override
    public List<Produit> getProduitsParMC(String mc) {
// TODO Auto-generated method stub
        List<Produit> prods=new ArrayList<Produit>();
        Connection conn=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from PRODUIT where NOM_PRODUIT Like ?");
                    ps.setString(1, "%"+mc+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Produit p =new Produit();
                p.setIdProduit(rs.getLong("ID_PRODUIT"));
                p.setNomProduit(rs.getString("NOM_PRODUIT"));
                p.setPrix(rs.getDouble("PRIX"));
                prods.add(p);
            }

        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prods;
    }
    @Override
    public void addProduit(Produit p) {
// TODO Auto-generated method stub
    }
}