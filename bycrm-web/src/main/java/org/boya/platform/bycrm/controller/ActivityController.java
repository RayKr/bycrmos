package org.boya.platform.bycrm.controller;

import io.swagger.annotations.Api;
import org.hswebframework.web.authorization.annotation.Authorize;
import org.hswebframework.web.commons.entity.param.QueryParamEntity;
import org.hswebframework.web.controller.SimpleGenericEntityController;
import org.boya.platform.bycrm.api.entity.Activity;
import org.boya.platform.bycrm.api.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * @author hsweb-generator3.0
 */
@RestController
@RequestMapping("/activity")
@Authorize(permission = "",description="")
@Api(tags = "null",value="")
public class ActivityController implements SimpleGenericEntityController<Activity, String, QueryParamEntity> {

    private ActivityService activityService;
  
    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
  
    @Override
    public ActivityService getService() {
        return activityService;
    }

    @GetMapping("/test")
    public Object test() {

        List<Activity> select = activityService.select();
        return select;
    }
}
