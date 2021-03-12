package com.Vaccini.Vaccini.Controller;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import com.Vaccini.Vaccini.MarshalCSV.Marshal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Controller
@CrossOrigin
public class DataController {

    @Autowired
    Marshal marshal;

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
    public List<RegioneContagi> getDati(@RequestParam(value = "data", required = false, defaultValue = "") String data) throws IOException, SQLException {

        return marshal.getDati(data);

    }

}
