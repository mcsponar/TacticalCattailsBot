package Repository;

import base.CraftingMaterial;

import java.util.Collection;
import java.util.List;

public interface IRepository<T, K> {

    void Add(T tItem);
    void AddItems(List<T> tItem);
    void Update(T tItem);
    void Remove(T tItem);
    void Clear();
    T GetItem(K key);
    Collection<CraftingMaterial> GetItems();

}
