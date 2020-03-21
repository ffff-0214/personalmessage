package edu.qingtai.personalmessage.service;

import edu.qingtai.personalmessage.domain.Infer;

import java.util.List;

public interface InferService {
    List<Infer> queryInfers(int pageIndex);
    void handleInfer(Infer infer);
}
