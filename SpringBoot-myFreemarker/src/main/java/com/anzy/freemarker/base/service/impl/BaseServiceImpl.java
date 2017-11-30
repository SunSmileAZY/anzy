//package com.anzy.freemarker.base.service.impl;
//
//import java.io.Serializable;
//import java.lang.reflect.Method;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.ibatis.logging.Log;
//import org.apache.ibatis.logging.LogFactory;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import com.anzy.bussiness.comm.Constants;
//import com.anzy.freemarker.base.service.BaseService;
//import com.anzy.freemarker.utils.ClassUtils;
//import com.baomidou.mybatisplus.entity.TableInfo;
//import com.baomidou.mybatisplus.enums.IdType;
//import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.mapper.BaseMapper;
//import com.baomidou.mybatisplus.mapper.SqlHelper;
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
//import com.baomidou.mybatisplus.toolkit.CollectionUtils;
//import com.baomidou.mybatisplus.toolkit.MapUtils;
//import com.baomidou.mybatisplus.toolkit.ReflectionKit;
//import com.baomidou.mybatisplus.toolkit.StringUtils;
//import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
//
//public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T> {
//
//    private static final Log LOGGER = LogFactory.getLog(ServiceImpl.class);
//
//    @Autowired
//    @Qualifier("sqlSessionFactory") 
//    protected M baseMapper;
//
//    @SuppressWarnings("unchecked")
//    protected Class<T> currentModleClass() {
//        return ReflectionKit.getSuperClassGenricType(getClass(), 1);
//    }
//
//    /**
//     * <p>
//     * 批量操作 SqlSession
//     * </p>
//     */
//    protected SqlSession sqlSessionBatch() {
//        return SqlHelper.sqlSessionBatch(currentModleClass());
//    }
//
//    /**
//     * <p>
//     * 判断数据库操作是否成功
//     * </p>
//     *
//     * @param result
//     *            数据库操作返回影响条数
//     * @return boolean
//     */
//    public boolean retBool(int result) {
//        return result >= 1;
//    }
//
//    /**
//     * <p>
//     * TableId 注解存在更新记录，否插入一条记录
//     * </p>
//     *
//     * @param entity
//     *            实体对象
//     * @return boolean
//     */
//    public boolean insertOrUpdate(T entity, HttpServletRequest request) {
//        if (null != entity) {
//            Class<?> cls = entity.getClass();
//            entity = setCreateParam(entity, request);
//            entity = setUpdateParam(entity, request);
//            TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
//            if (null != tableInfo) {
//                Object idVal = ReflectionKit
//                    .getMethodValue(cls, entity, tableInfo.getKeyProperty());
//                if (StringUtils.checkValNull(idVal)) {
//                    return insert(entity, request);
//                }
//                else {
//                    /* 特殊处理 INPUT 主键策略逻辑 */
//                    if (IdType.INPUT == tableInfo.getIdType()) {
//                        T entityValue = selectById((Serializable) idVal);
//                        if (null != entityValue) {
//                            return updateById(entity, request);
//                        }
//                        else {
//                            return insert(entity, request);
//                        }
//                    }
//                    return updateById(entity, request);
//                }
//            }
//            else {
//                throw new MybatisPlusException("Error:  Can not execute. Could not find @TableId.");
//            }
//        }
//        return false;
//    }
//
//    public boolean insert(T entity, HttpServletRequest request) {
//        entity = setCreateParam(entity, request);
//        entity = setUpdateParam(entity, request);
//        return retBool(baseMapper.insert(entity));
//    }
//
//    public boolean insertOrUpdateBatch(List<T> entityList, HttpServletRequest request) {
//        return insertOrUpdateBatch(entityList, 30, request);
//    }
//
//    public boolean insertOrUpdateBatch(List<T> entityList, int batchSize, HttpServletRequest request) {
//        if (CollectionUtils.isEmpty(entityList)) {
//            throw new IllegalArgumentException("Error: entityList must not be empty");
//        }
//        try {
//            SqlSession batchSqlSession = sqlSessionBatch();
//            int size = entityList.size();
//            for (int i = 0; i < size; i++) {
//                insertOrUpdate(entityList.get(i), request);
//                if (i % batchSize == 0) {
//                    batchSqlSession.flushStatements();
//                }
//            }
//            batchSqlSession.flushStatements();
//        }
//        catch (Exception e) {
//            LOGGER.warn("Error: Cannot execute insertOrUpdateBatch Method. Cause:" + e);
//            return false;
//        }
//        return true;
//    }
//
//    public boolean insertBatch(List<T> entityList, HttpServletRequest request) {
//        for (T entity : entityList) {
//            entity = setCreateParam(entity, request);
//            entity = setUpdateParam(entity, request);
//        }
//        return insertBatch(entityList, 30);
//    }
//
//    /**
//     * 批量插入
//     *
//     * @param entityList
//     * @param batchSize
//     * @return
//     */
//    public boolean insertBatch(List<T> entityList, int batchSize) {
//        if (CollectionUtils.isEmpty(entityList)) {
//            throw new IllegalArgumentException("Error: entityList must not be empty");
//        }
//        SqlSession batchSqlSession = sqlSessionBatch();
//        try {
//            int size = entityList.size();
//            for (int i = 0; i < size; i++) {
//                baseMapper.insert(entityList.get(i));
//                if (i % batchSize == 0) {
//                    batchSqlSession.flushStatements();
//                }
//            }
//            batchSqlSession.flushStatements();
//        }
//        catch (Exception e) {
//            LOGGER.warn("Error: Cannot execute insertBatch Method. Cause:" + e);
//            return false;
//        }
//        return true;
//
//    }
//
//    public boolean deleteById(Serializable id) {
//        return retBool(baseMapper.deleteById(id));
//    }
//
//    public boolean deleteByMap(Map<String, Object> columnMap) {
//        if (MapUtils.isEmpty(columnMap)) {
//            throw new MybatisPlusException("deleteByMap columnMap is empty.");
//        }
//        return retBool(baseMapper.deleteByMap(columnMap));
//    }
//
//    public boolean delete(Wrapper<T> wrapper) {
//        return retBool(baseMapper.delete(wrapper));
//    }
//
//    public boolean deleteBatchIds(List<? extends Serializable> idList) {
//        return retBool(baseMapper.deleteBatchIds(idList));
//    }
//
//    public boolean updateById(T entity, HttpServletRequest request) {
//        return updateById(entity, false, request);
//    }
//
//    public boolean update(T entity, Wrapper<T> wrapper, HttpServletRequest request) {
//        return update(entity, wrapper, false, request);
//    }
//
//    public boolean updateById(T entity, boolean isDelete, HttpServletRequest request) {
//        entity = setUpdateParam(entity, request);
//        if (isDelete) {
//            entity = setDeleteParam(entity, request);
//        }
//        return retBool(baseMapper.updateById(entity));
//    }
//
//    public boolean update(T entity, Wrapper<T> wrapper, boolean isDelete, HttpServletRequest request) {
//        entity = setUpdateParam(entity, request);
//        if (isDelete) {
//            entity = setDeleteParam(entity, request);
//        }
//        return retBool(baseMapper.update(entity, wrapper));
//    }
//
//    public boolean updateBatchById(List<T> entityList, HttpServletRequest request) {
//        if (CollectionUtils.isEmpty(entityList)) {
//            throw new IllegalArgumentException("Error: entityList must not be empty");
//        }
//        SqlSession batchSqlSession = sqlSessionBatch();
//        try {
//            int size = entityList.size();
//            for (int i = 0; i < size; i++) {
//                //baseMapper.updateById(entityList.get(i));
//                baseMapper.updateById(setUpdateParam(entityList.get(i), request));
//                if (i % 30 == 0) {
//                    batchSqlSession.flushStatements();
//                }
//            }
//            batchSqlSession.flushStatements();
//        }
//        catch (Exception e) {
//            LOGGER.warn("Error: Cannot execute insertBatch Method. Cause:" + e);
//            return false;
//        }
//        return true;
//    }
//
//    public T selectById(Serializable id) {
//        return baseMapper.selectById(id);
//    }
//
//    public List<T> selectBatchIds(List<? extends Serializable> idList) {
//        return baseMapper.selectBatchIds(idList);
//    }
//
//    public List<T> selectByMap(Map<String, Object> columnMap) {
//        return baseMapper.selectByMap(columnMap);
//    }
//
//    public T selectOne(Wrapper<T> wrapper) {
//        List<T> list = baseMapper.selectList(wrapper);
//        if (CollectionUtils.isNotEmpty(list)) {
//            int size = list.size();
//            if (size > 1) {
//                LOGGER.warn(String.format("Warn: selectOne Method There are  %s results.", size));
//            }
//            return list.get(0);
//        }
//        return null;
//    }
//
//    public int selectCount(Wrapper<T> wrapper) {
//        return baseMapper.selectCount(wrapper);
//    }
//
//    public List<T> selectList(Wrapper<T> wrapper) {
//        return baseMapper.selectList(wrapper);
//    }
//
//    public Page<T> selectPage(Page<T> page) {
//        page.setRecords(baseMapper.selectPage(page, null));
//        return page;
//    }
//
//    public Page<T> selectPage(Page<T> page, Wrapper<T> wrapper) {
//        if (null != wrapper) {
//            wrapper.orderBy(page.getOrderByField(), page.isAsc());
//        }
//        page.setRecords(baseMapper.selectPage(page, wrapper));
//        return page;
//    }
//
//    private T setCreateParam(T entity, HttpServletRequest request) {
//        try {
//            String userId = request.getSession().getAttribute(Constants.SESN_USR_UID).toString();
//            Method method = ClassUtils.getSetMethodByMethodName(entity.getClass(), "setCreateBy");
//            if (null != method) {
//                method.invoke(entity, userId);
//            }
//            method = ClassUtils.getSetMethodByMethodName(entity.getClass(), "setCreateDt");
//            if (null != method) {
//                method.invoke(entity, new Date());
//            }
//            return entity;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return entity;
//        }
//    }
//
//    private T setUpdateParam(T entity, HttpServletRequest request) {
//        try {
//            String userId = request.getSession().getAttribute(Constants.SESN_USR_UID).toString();
//            Method method = ClassUtils.getSetMethodByMethodName(entity.getClass(), "setUpdateBy");
//            if (null != method) {
//                method.invoke(entity, userId);
//            }
//            method = ClassUtils.getSetMethodByMethodName(entity.getClass(), "setUpdateDt");
//            if (null != method) {
//                method.invoke(entity, new Date());
//            }
//            return entity;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return entity;
//        }
//    }
//
//    private T setDeleteParam(T entity, HttpServletRequest request) {
//        try {
//            String userId = request.getSession().getAttribute(Constants.SESN_USR_UID).toString();
//            Method method = ClassUtils.getSetMethodByMethodName(entity.getClass(), "setDeleteBy");
//            if (null != method) {
//                method.invoke(entity, userId);
//            }
//            method = ClassUtils.getSetMethodByMethodName(entity.getClass(), "setUpdateDt");
//            if (null != method) {
//                method.invoke(entity, new Date());
//            }
//            return entity;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return entity;
//        }
//    }
//}
