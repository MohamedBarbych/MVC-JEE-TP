package web;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import metier.IMetierCatalogue;
import metier.MetierImpl;
import metier.Produit;

public class ControleurServlet extends HttpServlet {
    private IMetierCatalogue metier;

    @Override
    public void init() throws ServletException {
        metier = new MetierImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws
            ServletException, IOException {
        String mc = request.getParameter("motCle");
        ProduitModele mod = new ProduitModele();
        mod.setMotCle(mc);
        List<Produit> prods = metier.getProduitsParMC(mc);
        mod.setProduits(prods);
        request.setAttribute("modele", mod);
        request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws
            ServletException, IOException {
        // Vous pouvez soit rediriger GET vers POST, soit afficher une page différente
        doPost(request, response); // Redirige vers la logique POST pour les GET
        // OU
        // response.getWriter().write("La méthode GET n'est pas supportée.");
    }
}
