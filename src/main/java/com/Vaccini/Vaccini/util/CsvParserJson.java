package com.Vaccini.Vaccini.util;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CsvParserJson {


    @PostMapping("/json")
    public List<Map<?, ?>> jsonParser(@RequestParam(value = "url") String url) throws IOException {
        String CSV = IOUtils.toString(new URL(url).openStream(), StandardCharsets.UTF_8);

        return readObjectsFromCsv(CSV);
    }

    public static List<Map<?, ?>> readObjectsFromCsv(String CSV) throws IOException {
        CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(CSV);

        return mappingIterator.readAll();
    }

}