package metier;
import java.util.List;
public interface IMetierCatalogue {
    public List<Produit> getProduitsParMC(String mc);
    public void addProduit(Produit p);
}
