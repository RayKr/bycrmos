package org.boya.platform.bycrm.logger;

import com.alibaba.fastjson.JSON;
import org.hswebframework.web.logging.AccessLoggerInfo;
import org.hswebframework.web.logging.AccessLoggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.stream.Stream;

/**
 * 使用sfl4j 打印访问日志
 *
 * @author zhouhao
 */
@Component
public class Slf4jAccessLoggerListener implements AccessLoggerListener {
    private Logger logger = LoggerFactory.getLogger("access-logger");

   private static final Class excludes[] = {
            ServletRequest.class,
            ServletResponse.class,
            InputStream.class,
            OutputStream.class,
            MultipartFile.class
    };

    @Override
    public void onLogger(AccessLoggerInfo accessLoggerInfo) {
        if (logger.isInfoEnabled()) {
            logger.info(JSON.toJSONString(accessLoggerInfo.toSimpleMap(obj -> {
                if (Stream.of(excludes).anyMatch(aClass -> aClass.isInstance(obj))) {
                    return obj.getClass().getName();
                }
                return (Serializable) JSON.toJSON(obj);
            })));
        }
    }
}
