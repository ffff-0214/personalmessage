package edu.qingtai.personalmessage.controller;


import edu.qingtai.personalmessage.domain.Impression;
import edu.qingtai.personalmessage.service.ImpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/impression")
public class ImpressionController {
    private ImpressionService impressionService;

    @Autowired
    public ImpressionController(final ImpressionService impressionService){
        this.impressionService=impressionService;
    }

    @GetMapping
    public List<Impression> getImpressionsByPageIndex(@RequestParam("pageIndex") int pageIndex){
        return impressionService.queryImpressions(pageIndex);
    }
}
