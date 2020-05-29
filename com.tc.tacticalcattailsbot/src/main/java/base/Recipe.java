package base;

import Repository.IRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe implements IRepository<CraftingMaterial, String> {

    private Map<String, CraftingMaterial> craftingMaterialMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Material getOutputMaterial() {
        return outputMaterial;
    }

    public void setOutputMaterial(Material outputMaterial) {
        this.outputMaterial = outputMaterial;
    }

    private Material outputMaterial;

    public Recipe(String name, Material outputMaterial) {
        this.name = name;
        this.outputMaterial = outputMaterial;
        craftingMaterialMap = new HashMap<>();
    }

    @Override
    public void Add(CraftingMaterial tItem) {
        if (tItem != null){
            craftingMaterialMap.putIfAbsent(tItem.getName(), tItem);
        }
    }

    @Override
    public void AddItems(List<CraftingMaterial> tItem) {
        if (tItem != null) {
            for (CraftingMaterial item : tItem
                 ) {
                Add(item);
            }
        }
        
    }

    @Override
    public void Update(CraftingMaterial tItem) {

    }

    @Override
    public void Remove(CraftingMaterial tItem) {

    }

    @Override
    public void Clear() {
        craftingMaterialMap.clear();
    }

    @Override
    public CraftingMaterial GetItem(String key) {
        if (key != null) {
            return craftingMaterialMap.get(key);
        }
        else {
            return null;
        }
    }

    @Override
    public Collection<CraftingMaterial> GetItems() {
        return craftingMaterialMap.values();
    }

    @Override
    public String toString() {
        StringBuilder recipeList = new StringBuilder();
        for (CraftingMaterial item : GetItems()){
            recipeList.append(String.format("%s ", item.toString() + ' '));
        }
        return recipeList.toString();
    }
}
