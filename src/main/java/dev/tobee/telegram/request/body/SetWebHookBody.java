package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.UpdateTypes;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public record SetWebHookBody(
        @JsonProperty("url") String url,
        @JsonProperty("certificate") Optional<Path> path,
        @JsonProperty("ip_address") Optional<String> ipAddress,
        @JsonProperty("max_connections") OptionalInt maxConnections,
        @JsonProperty("allowed_updates") List<UpdateTypes> allowedUpdates,
        @JsonProperty("drop_pending_updates") Optional<Boolean> dropPendingUpdates
) {
}
