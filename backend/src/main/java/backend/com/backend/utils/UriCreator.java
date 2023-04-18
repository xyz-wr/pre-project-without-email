package backend.com.backend.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriCreator {
    public static URI createUri(String defualtUrl, long resourceId) {
        return UriComponentsBuilder
                .newInstance()
                .path(defualtUrl + "/{resource-id}")
                .buildAndExpand(resourceId)
                .toUri();
    }
}
