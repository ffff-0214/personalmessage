package edu.qingtai.personalmessage.service;

import edu.qingtai.personalmessage.domain.Impression;

import java.util.List;

public interface ImpressionService {
    List<Impression> queryImpressions(int PageIndex);
}
