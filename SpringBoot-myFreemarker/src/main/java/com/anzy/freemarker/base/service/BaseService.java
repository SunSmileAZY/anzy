//package com.anzy.freemarker.base.service;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//
///**
// * 顶级 Service
// * @author anzy
// *
// * @param <T>
// */
//public interface BaseService<T> {
//
//    /**
//     * <p>
//     * 插入一条记录
//     * </p>
//     *
//     * @param entity
//     *            实体对象
//     * @return boolean
//     */
//    boolean insert(T entity, HttpServletRequest r);
//
//    /**
//     * <p>
//     * 插入（批量），该方法不适合 Oracle
//     * </p>
//     *
//     * @param entityList
//     *            实体对象列表
//     * @return boolean
//     */
//    boolean insertBatch(List<T> entityList, HttpServletRequest request);
//
//    /**
//     * <p>
//     * 插入（批量）
//     * </p>
//     *
//     * @param entityList
//     *            实体对象列表
//     * @param batchSize
//     *
//     * @return boolean
//     */
//    boolean insertBatch(List<T> entityList, int batchSize);
//
//    /**
//     * <p>
//     * 批量修改插入
//     * </p>
//     *
//     * @param entityList
//     *            实体对象列表
//     * @return boolean
//     */
//    boolean insertOrUpdateBatch(List<T> entityList, HttpServletRequest request);
//
//    /**
//     * <p>
//     * 批量修改插入
//     * </p>
//     *
//     * @param entityList
//     *            实体对象列表
//     * @param batchSize
//     *
//     * @return boolean
//     */
//    boolean insertOrUpdateBatch(List<T> entityList, int batchSize, HttpServletRequest request);
//
//    /**
//     * <p>
//     * 根据 ID 删除
//     * </p>
//     *
//     * @param id
//     *            主键ID
//     * @return boolean
//     */
//    boolean deleteById(Serializable id);
//
//    /**
//     * <p>
//     * 根据 columnMap 条件，删除记录
//     * </p>
//     *
//     * @param columnMap
//     *            表字段 map 对象
//     * @return boolean
//     */
//    boolean deleteByMap(Map<String, Object> columnMap);
//
//    /**
//     * <p>
//     * 根据 entity 条件，删除记录
//     * </p>
//     *
//     * @param wrapper
//     *            实体包装类 {@link Wrapper}
//     * @return boolean
//     */
//    boolean delete(Wrapper<T> wrapper);
//
//    /**
//     * <p>
//     * 删除（根据ID 批量删除）
//     * </p>
//     *
//     * @param idList
//     *            主键ID列表
//     * @return boolean
//     */
//    boolean deleteBatchIds(List<? extends Serializable> idList);
//
//    /**
//     * <p>
//     * 根据 ID 修改
//     * </p>
//     *
//     * @param entity
//     *            实体对象
//     * @return boolean
//     */
//    boolean updateById(T entity, HttpServletRequest request);
//
//    /**
//     * <p>
//     * 根据 whereEntity 条件，更新记录
//     * </p>
//     *
//     * @param entity
//     *            实体对象
//     * @param wrapper
//     *            实体包装类 {@link Wrapper}
//     * @return boolean
//     */
//    boolean update(T entity, Wrapper<T> wrapper, HttpServletRequest request);
//
//    /**
//     * 逻辑删除
//     * @param entity
//     * @param isDelete
//     * @return
//     */
//    public boolean updateById(T entity, boolean isDelete, HttpServletRequest request);
//
//    /**
//     * 逻辑删除
//     * @param entity
//     * @param wrapper
//     * @param isDelete
//     * @return
//     */
//    public boolean update(T entity, Wrapper<T> wrapper, boolean isDelete, HttpServletRequest request);
//
//    /**
//     * <p>
//     * 根据ID 批量更新
//     * </p>
//     *
//     * @param entityList
//     *            实体对象列表
//     * @return boolean
//     */
//    boolean updateBatchById(List<T> entityList, HttpServletRequest request);
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
//    boolean insertOrUpdate(T entity, HttpServletRequest request);
//
//    /**
//     * <p>
//     * 根据 ID 查询
//     * </p>
//     *
//     * @param id
//     *            主键ID
//     * @return T
//     */
//    T selectById(Serializable id);
//
//    /**
//     * <p>
//     * 查询（根据ID 批量查询）
//     * </p>
//     *
//     * @param idList
//     *            主键ID列表
//     * @return List<T>
//     */
//    List<T> selectBatchIds(List<? extends Serializable> idList);
//
//    /**
//     * <p>
//     * 查询（根据 columnMap 条件）
//     * </p>
//     *
//     * @param columnMap
//     *            表字段 map 对象
//     * @return List<T>
//     */
//    List<T> selectByMap(Map<String, Object> columnMap);
//
//    /**
//     * <p>
//     * 根据 Wrapper，查询一条记录
//     * </p>
//     *
//     * @param wrapper
//     *            实体对象
//     * @return T
//     */
//    T selectOne(Wrapper<T> wrapper);
//
//    /**
//     * <p>
//     * 根据 Wrapper 条件，查询总记录数
//     * </p>
//     *
//     * @param wrapper
//     *            实体对象
//     * @return int
//     */
//    int selectCount(Wrapper<T> wrapper);
//
//    /**
//     * <p>
//     * 查询列表
//     * </p>
//     *
//     * @param wrapper
//     *            实体包装类 {@link Wrapper}
//     * @return
//     */
//    List<T> selectList(Wrapper<T> wrapper);
//
//    /**
//     * <p>
//     * 翻页查询
//     * </p>
//     *
//     * @param page
//     *            翻页对象
//     * @return
//     */
//    Page<T> selectPage(Page<T> page);
//
//    /**
//     * <p>
//     * 翻页查询
//     * </p>
//     *
//     * @param page
//     *            翻页对象
//     * @param wrapper
//     *            实体包装类 {@link Wrapper}
//     * @return
//     */
//    Page<T> selectPage(Page<T> page, Wrapper<T> wrapper);
//}
