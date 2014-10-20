package practice4;

import java.util.Map;
import java.util.Optional;

/**
 * Mapのgetに、Optioanalで取得する機能を追加する。
 */
public interface OptionalMap<K,V> extends Map<K, V>{
    
    default Optional<V> getByOpt(K key) {
        // Mapを継承しているので、this参照でMapのメソッドが呼べる。
        if (containsKey(key)) {
            return Optional.of(get(key));
        } else {
            return Optional.empty();
        }

    }
}
