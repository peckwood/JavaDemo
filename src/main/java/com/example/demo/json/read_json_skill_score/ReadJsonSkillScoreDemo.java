package com.example.demo.json.read_json_skill_score;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 把JSON文件转化成json对象
 * 1. 读取文本文件
 * 2. 忽略属性
 * 3. Jackson的使用
 * 4. 把JsonNode转java list
 */
public class ReadJsonSkillScoreDemo {
    public static void main(String[] args) throws IOException {
        String json = getStringFromJsonFile();
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置忽略未设置的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ObjectNode objectNode = objectMapper.readValue(json, ObjectNode.class);
        JsonNode dataNode = objectNode.get("data");
        JsonNode treesNode = dataNode.get("trees");
        TypeReference<List<MyNode>> typeReferenceList = new TypeReference<List<MyNode>>() {};
        // convert JsonNode to java list
        // 4.2. Using convertValue()
        // https://www.baeldung.com/java-jackson-jsonnode-collection#31-manually-converting-jsonnode-to-list
        List<MyNode> list = objectMapper.convertValue(treesNode, typeReferenceList);
        System.out.println(list);
    }

    private static String getStringFromJsonFile() throws IOException {
        String path = "/json/read_json_skill_score/response.json";
        try (InputStream inputStream = ReadJsonSkillScoreDemo.class.getResourceAsStream(path)) {
            InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line;
            boolean loop = false;
            while ((line = br.readLine()) != null) {
                loop = true;
                sb.append(line).append(System.lineSeparator());
            }
            if(loop) {
                sb.deleteCharAt(sb.length() - 1);
            }
            System.out.println(sb);
            br.close();
            return sb.toString();
        }
    }

}
