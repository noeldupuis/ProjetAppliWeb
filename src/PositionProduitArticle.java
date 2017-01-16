/**
 * Created by lsapin on 11/01/17.
 */
public class PositionProduitArticle {
    private Produit produit;
    private int numRayon;
    private int positionRayon;


    public PositionProduitArticle() {}

    public void init(Produit produit, int numRayon, int positionRayon) {
        this.produit = produit;
        this.numRayon = numRayon;
        this.positionRayon = positionRayon;
    }


    public Produit getCategorie() {
        return produit;
    }

    public void setCategorie(Produit produit) {
        this.produit = produit;
    }


    public int getNumRayon() {
        return numRayon;
    }

    public void setNumRayon(int numRayon) {
        this.numRayon = numRayon;
    }


    public int getPositionRayon() {
        return positionRayon;
    }

    public void setPositionRayon(int positionRayon) {
        this.positionRayon = positionRayon;
    }
}
