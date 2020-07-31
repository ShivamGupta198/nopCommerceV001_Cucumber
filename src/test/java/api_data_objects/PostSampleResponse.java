package api_data_objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostSampleResponse {
    @JsonProperty("name")
    String name;
    @JsonProperty("job")
    String job;
    @JsonProperty("id")
    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("createdAt")
    String createdAt;
}
