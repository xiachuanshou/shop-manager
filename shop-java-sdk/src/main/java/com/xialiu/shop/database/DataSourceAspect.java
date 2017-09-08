package com.xialiu.shop.database;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.transaction.annotation.Transactional;

import com.xialiu.shop.model.annotation.SpecifyDS;

/**
 * 数据源自动选择的切面类
 * @author XiaChuanshou
 * @since 2017年9月8日
 */
public class DataSourceAspect implements org.springframework.core.Ordered {
    
    private static final String READ_ONLY_METHOD_PREFFIX = "select";
    private static final String DEFAULT_MASTER_SUFFIX = "MasterDataSource";
    private static final String DEFAULT_SLAVE_SUFFIX = "SlaveDataSource";
    private static final int DEFAULT_ORDER = -1;
    
    /**
     * CUD【创建（Create）、更新（Update）和删除（Delete）】所使用的数据源
     * <br>默认使用 {主库}
     */
    private String cudDBSuffix = DEFAULT_MASTER_SUFFIX;
    
    /**
     * R【读取（Read）】所使用的数据源
     * <br>默认使用 {从库}
     */
    private String readDBSuffix = DEFAULT_SLAVE_SUFFIX;
    
    /**
     * Spring Aspect的顺序，如果一个方法上有多个切面，则值越小的先执行。
     */
    private int order = DEFAULT_ORDER;
    
    /**
     * 执行事物切面时默认使用的数据源（通常配置为项目的主数据库的主库）
     */
    private String defaultTransDb;
    
    public void before(JoinPoint point) {
        if (DataSourceHolder.getDataSouce() == null) {
            // 根据包路径名 获取dataSource的key前缀，这样效率太低，改成根据Mapper前缀来获取
            Class<?>[] classz = point.getTarget().getClass().getInterfaces();
            String interfacePath = classz[0].getName();
            // 获取dao和mapper之间的包名，这儿包名与xml的dataSource的key前缀相同
            int daoIndex = interfacePath.indexOf("dao");
            int mapperIndex = interfacePath.indexOf("mapper");
            String packet = interfacePath.substring(daoIndex + 4, mapperIndex - 1);

            if (point.getSignature().getName().indexOf(READ_ONLY_METHOD_PREFFIX) != -1) {
                DataSourceHolder.setDataSource(packet + readDBSuffix);
            } else {
                DataSourceHolder.setDataSource(packet + cudDBSuffix);
            }
        }
    }
    
    public void beforeTrans(JoinPoint point) {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        // 获取目标类
        Class<?> target = point.getTarget().getClass();
        Method targetMethod = null;
        try {
            targetMethod = target.getMethod(method.getName(), method.getParameterTypes());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // 根据目标类方法中的注解，选择数据源
        if (targetMethod != null) {
            Transactional transactional = targetMethod.getAnnotation(Transactional.class);
            if (transactional != null) {
                SpecifyDS specifyDSCls = target.getAnnotation(SpecifyDS.class);
                SpecifyDS specifyDS = targetMethod.getAnnotation(SpecifyDS.class);
                if (specifyDS != null) {
                    DataSourceHolder.setDataSource(specifyDS.value());
                } else if (specifyDSCls != null) {
                    DataSourceHolder.setDataSource(specifyDSCls.value());
                } else {
                    DataSourceHolder.setDataSource(defaultTransDb);
                }
            }
        }
    }

    public void after() {
        DataSourceHolder.setDataSource(null);
    }
    
    
    @Override
    public int getOrder() {
        return order;
    }
    
    public void setOrder(int order){
        this.order = order;
    }


    /**
     * @return the cudDBSuffix
     */
    public String getCudDBSuffix() {
        return cudDBSuffix;
    }

    /**
     * @param cudDBSuffix the cudDBSuffix to set
     */
    public void setCudDBSuffix(String cudDBSuffix) {
        this.cudDBSuffix = cudDBSuffix;
    }

    /**
     * @return the readDBSuffix
     */
    public String getReadDBSuffix() {
        return readDBSuffix;
    }

    /**
     * @param readDBSuffix the readDBSuffix to set
     */
    public void setReadDBSuffix(String readDBSuffix) {
        this.readDBSuffix = readDBSuffix;
    }

    /**
     * @return the defaultTransDb
     */
    public String getDefaultTransDb() {
        return defaultTransDb;
    }

    /**
     * @param defaultTransDb the defaultTransDb to set
     */
    public void setDefaultTransDb(String defaultTransDb) {
        this.defaultTransDb = defaultTransDb;
    }

}

