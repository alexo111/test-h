package dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Network {
    public List<String> company;
    public String href;
    public String id;
    public Location location;
    public String name;
    public String source;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String gbfs_href;
}
