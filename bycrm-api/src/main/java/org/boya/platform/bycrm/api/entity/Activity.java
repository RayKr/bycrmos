package org.boya.platform.bycrm.api.entity;
import org.hswebframework.web.commons.entity.SimpleGenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
* 
* @author hsweb-generator3.0
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "")
public class Activity extends SimpleGenericEntity<String> {
    
    @ApiModelProperty(value = "展会活动ID")
    private Long activityId;
    
    @ApiModelProperty(value = "&#39;展会主题名称&#39;")
    private String activityTitle;
    
    @ApiModelProperty(value = "&#39;活动年份&#39;")
    private String activityYear;
    
    @ApiModelProperty(value = "&#39;活动简介&#39;")
    private String activityIntroduction;
    
}