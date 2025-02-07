package api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessReg {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("token")
    private String token;

    public SuccessReg() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
