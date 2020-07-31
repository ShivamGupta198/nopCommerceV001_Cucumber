package api_data_objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PostSampleRequest {
    @JsonProperty("name")
    String name;
    @JsonProperty("job")
    String job;

    public PostSampleRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }
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

}
