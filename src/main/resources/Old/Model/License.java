package Old.Controller.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class License {
    @JsonProperty("key")
    String key;
    @JsonProperty("name")
    String name;
    @JsonProperty("spdx_id")
    String spdx_id;
    @JsonProperty("url")
    String url;
    @JsonProperty("node_id")
    String node_id;

    public String getSpdx_id() {
        return spdx_id;
    }
}
