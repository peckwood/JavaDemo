package com.example.demo.json.jackson_demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;

import java.io.File;
import java.io.IOException;

public class CSVMapperDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectmapper = new ObjectMapper();
        JsonNode jsonTree = objectmapper.readTree("[ {\n" +
                "  \"item\" : \"No. 9 Sprockets\",\n" +
                "  \"quantity\" : 12,\n" +
                "  \"unitPrice\" : 1.23\n" +
                "}, {\n" +
                "  \"item\" : \"Widget (10mm)\",\n" +
                "  \"quantity\" : 4,\n" +
                "  \"unitPrice\" : 3.45\n" +
                "} ]");

        Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(new File("files/json/CSVMapperDemo/orderLines.csv"), jsonTree);

    }
}
