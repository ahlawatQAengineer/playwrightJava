package com.rahulshettyacademy.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class JsonReader {
    private ObjectMapper mapper;
    private JsonNode rootNode;

    public JsonReader() {
        this.mapper = new ObjectMapper();
    }

    public void loadJson(String filePath) throws IOException {
        rootNode = mapper.readTree(new File(filePath));
    }

    public JsonNode getRootNode() {
        return rootNode;
    }

    public String getValue(String path) {
        String[] parts = path.split("\\.");
        JsonNode current = rootNode;
        
        for (String part : parts) {
            if (current == null) return null;
            current = current.get(part);
        }
        
        return current != null ? current.asText() : null;
    }

    public List<String> getArrayValues(String path) {
        JsonNode arrayNode = getNode(path);
        List<String> values = new ArrayList<>();
        
        if (arrayNode != null && arrayNode.isArray()) {
            for (JsonNode node : arrayNode) {
                values.add(node.asText());
            }
        }
        
        return values;
    }

    public Map<String, String> getObjectAsMap(String path) {
        JsonNode objectNode = getNode(path);
        Map<String, String> map = new HashMap<>();
        
        if (objectNode != null && objectNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                map.put(entry.getKey(), entry.getValue().asText());
            }
        }
        
        return map;
    }

    private JsonNode getNode(String path) {
        String[] parts = path.split("\\.");
        JsonNode current = rootNode;
        
        for (String part : parts) {
            if (current == null) return null;
            current = current.get(part);
        }
        
        return current;
    }

    public <T> T parseJson(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    public <T> T parseJsonFile(String filePath, Class<T> clazz) throws IOException {
        return mapper.readValue(new File(filePath), clazz);
    }

    public String toJson(Object object) throws IOException {
        return mapper.writeValueAsString(object);
    }
} 