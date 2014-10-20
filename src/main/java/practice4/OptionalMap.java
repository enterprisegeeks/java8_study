package practice4;

import java.util.Map;
import java.util.Optional;

/**
 * Mapのgetに、Optioanalで取得する機能を追加する。
 */
public interface OptionalMap<K,V> extends Map<K, V>{
    
    default Optional<V> getByOpt(K key) {
        return null;// 解答
       
    }
    
}
