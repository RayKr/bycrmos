package org.boya.platform.bycrm.impl.service;

import org.boya.platform.bycrm.api.entity.Activity;
import org.boya.platform.bycrm.api.service.ActivityService;
import org.boya.platform.bycrm.impl.dao.ActivityDao;
import org.hswebframework.web.service.GenericEntityService;
import org.hswebframework.web.id.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 默认的服务实现
 *
 * @author hsweb-generator3.0
 */
@Service("activityService")
public class LocalActivityServiceImpl extends GenericEntityService<Activity, String> implements ActivityService {
            
    @Autowired
    private ActivityDao activityDao;
    
    @Override
    protected IDGenerator<String> getIDGenerator() {
        return IDGenerator.MD5;
    }
    
    @Override
    public ActivityDao getDao() {
        return activityDao;
    }

}
