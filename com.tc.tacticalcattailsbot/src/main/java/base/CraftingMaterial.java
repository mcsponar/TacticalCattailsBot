package base;


public class CraftingMaterial extends Material {

    private int quantity;

    public CraftingMaterial(String name, String wikiUrl, int quantity) {
        super(name, wikiUrl);
        this.quantity = quantity;
    }

    public CraftingMaterial(Material material, int quantity){
        super(material.getName(), material.getWikiUrl());
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%dx: %s", quantity, super.toString());
    }
}
