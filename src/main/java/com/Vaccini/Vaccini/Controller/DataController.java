package com.Vaccini.Vaccini.Controller;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import com.Vaccini.Vaccini.MarshalCSV.Marshal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@CrossOrigin
public class DataController {

    private final Map<String, List<RegioneContagi>> cache = new HashMap<>();
    private final Marshal marshal;

    @Autowired
    private DataController(Marshal marshal) {
        this.marshal = marshal;
    }


    @GetMapping("/index")
    public String homePage() {
        return "graph";
    }

    @GetMapping("/waitingPage")
    public String waitingPage() {
        return "waitingPage";
    }

    @GetMapping("/regioniContagi")
    @ResponseBody
    public List<RegioneContagi> getDati(@RequestParam(value = "data", required = false) String data) throws IOException {
        if (data == null) {
            data = LocalDate.now().toString();
        }
        if (cache.get(data) == null) {
            cache.put(data, marshal.getDati(data));
        }
        return cache.get(data);
    }

}
