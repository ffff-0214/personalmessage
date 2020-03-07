package edu.qingtai.personalmessage.controller;

import edu.qingtai.personalmessage.domain.Infer;
import edu.qingtai.personalmessage.service.InferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/infer")
public class InferController {
    private InferService inferService;

    @Autowired
    public InferController(final InferService inferService){
        this.inferService = inferService;
    }

    @GetMapping
    public List<Infer> getInferByPageIndex(@RequestParam("pageIndex") int pageIndex){
        return inferService.queryInfers(pageIndex);
    }
}
