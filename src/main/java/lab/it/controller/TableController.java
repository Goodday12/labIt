package lab.it.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab.it.service.TableMultiplier;
import lab.it.util.db.Table;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@RestController
//@RequestMapping("/labIt_war_exploded")
public class TableController {

    @RequestMapping(method = RequestMethod.POST, value = "/load")
    @ResponseBody
    public String test(@RequestParam("file") MultipartFile[] data) throws IOException {
        ArrayList<String> jsons = new ArrayList<>();
        for (MultipartFile datum : data) {
            jsons.add(new String(datum.getBytes(), StandardCharsets.UTF_8));
        }
        Table table = new ObjectMapper().readValue(jsons.get(0), Table.class);
        Table table1 = new ObjectMapper().readValue(jsons.get(1), Table.class);
        Table multiplyTables = TableMultiplier.multiplyTables(table, table1);
        return new ObjectMapper().writeValueAsString(multiplyTables);
    }

}
