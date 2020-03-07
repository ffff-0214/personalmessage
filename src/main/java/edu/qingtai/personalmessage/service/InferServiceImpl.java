package edu.qingtai.personalmessage.service;

import edu.qingtai.personalmessage.domain.Infer;
import edu.qingtai.personalmessage.mapper.InferMapper;
import edu.qingtai.personalmessage.utils.ConstData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InferServiceImpl implements InferService{

    private InferMapper inferMapper;

    @Autowired
    public InferServiceImpl(final InferMapper inferMapper){
        this.inferMapper = inferMapper;
    }

    @Override
    public List<Infer> queryInfers(int pageIndex){
        int startIndex = (pageIndex - 1) * ConstData.pageSize;
        List<String> uuidList = inferMapper.selectUuidByPageIndex(startIndex, ConstData.pageSize);
        if(uuidList.isEmpty()){
            return null;
        }
        return inferMapper.selectInferByUuidlist(uuidList);
    }

}
