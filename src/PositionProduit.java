

/**
 * Created by lsapin on 11/01/17.
 */
public class PositionProduit {
    private Produit article;
    private Point positionsArticle;


    public PositionProduit() {}

    public void init(Produit article, Point positionsArticle) {
        this.article = article;
        this.positionsArticle = positionsArticle;
    }

    public Produit getArticle() {
        return article;
    }

    public void setArticle(Produit article) {
        this.article = article;
    }

    public Point getPositionsArticle() {
        return positionsArticle;
    }

    public void setPositionsArticle(Point positionsArticle) {
        this.positionsArticle = positionsArticle;
    }
}
