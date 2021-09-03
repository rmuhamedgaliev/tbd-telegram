package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public record SetWebHookBody(
        @JsonProperty("url") String url,
        @JsonProperty("certificate") Optional<Path> path,
        @JsonProperty("ip_address") Optional<String> ipAddress,
        @JsonProperty("max_connections") Optional<Integer> maxConnections,
        @JsonProperty("allowed_updates") List<UpdateTypes> allowedUpdates,
        @JsonProperty("drop_pending_updates") Optional<Boolean> dropPendingUpdates
) {
}
