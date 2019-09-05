package com.csu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

    private static Properties props;

    synchronized static private void loadProps(String fileName) {
        props = new Properties();
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(PropertyUtil.class.getClassLoader().getResourceAsStream(fileName + ".properties"), "GBK");
            props.load(in);
        } catch (IOException e) {
            logger.error("出现IOException", e);
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("文件流关闭出现异常", e);
            }
        }
    }


    public static String getProperty(String fileName, String key) {
        if (null == props) {
            loadProps(fileName);
        }
        return props.getProperty(key);
    }
}
