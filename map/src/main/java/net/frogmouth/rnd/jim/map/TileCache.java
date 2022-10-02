
package net.frogmouth.rnd.jim.map;


import javafx.scene.image.Image;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class TileCache {

    private final AsyncLoadingCache<TileNumber, Image> cache;

    public TileCache() {
        cache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .refreshAfterWrite(6, TimeUnit.HOURS)
                .buildAsync((key, executor) -> downloadImage(key, executor));
    }

    CompletableFuture<Image> downloadImage(TileNumber tileNumber, Executor executor) {
        // String tilePath = String.format("https://tile.openstreetmap.org/%d/%d/%d.png", tileNumber.getZoomLevel(), tileNumber.x(), tileNumber.y());
        String tilePath = String.format("http://tileserver/hot/%d/%d/%d.png", tileNumber.getZoomLevel(), tileNumber.x(), tileNumber.y());
        System.out.println("Fetching " + tilePath);
        URI uri = URI.create(tilePath);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .setHeader("User-Agent", "Java Image Mogrifier (JIM)")
                .uri(uri)
                .build();
        return client.sendAsync(request, BodyHandlers.ofByteArray())
                .thenApply(HttpResponse::body)
                .thenApply(ByteArrayInputStream::new)
                .thenApply(Image::new);

    }

    public CompletableFuture<Image> getImage(TileNumber tileNumber) {
        return cache.get(tileNumber);
    }

}
