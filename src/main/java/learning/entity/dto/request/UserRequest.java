package learning.entity.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserRequest {
    @JsonProperty("email")
    @NonNull
    private String email;
    @JsonProperty("password")
    @NonNull
    private String password;
    @JsonProperty("username")
    @NonNull
    private String username;
}
