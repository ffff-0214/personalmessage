package edu.qingtai.personalmessage.service;

import edu.qingtai.personalmessage.domain.Impression;
import edu.qingtai.personalmessage.mapper.ImpressionMapper;
import edu.qingtai.personalmessage.utils.ConstData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpressionServiceImpl implements ImpressionService{
    private ImpressionMapper impressionMapper;

    @Autowired
    public ImpressionServiceImpl(final ImpressionMapper impressionMapper){
        this.impressionMapper=impressionMapper;
    }

    @Override
    public List<Impression> queryImpressions(int pageIndex){
        //前端的页面从1开始
        int startIndex = (pageIndex - 1) * ConstData.pageSize;
        List<String> uuidList = impressionMapper.selectUuidByPageIndex(startIndex, ConstData.pageSize);
        if(uuidList.isEmpty()){
            return null;
        }
        return impressionMapper.selectImpressionByUuidlist(uuidList);
    }

    @Override
    public void handleImpression(Impression impression){
        if(impression.getFavorite() == null){
            impressionMapper.deleteByPrimaryKey(impression.getUuid());
        }else if(impression.getCompany() == null){
            impressionMapper.updateByPrimaryKeySelective(impression);
        }else{
            impressionMapper.insert(impression);
        }
    }
}
