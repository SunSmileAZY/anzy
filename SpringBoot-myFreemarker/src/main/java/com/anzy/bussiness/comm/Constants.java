package com.anzy.bussiness.comm;

/**
 * 常量表
 *
 * @author 当归
 * @version 2014-4-4
 */
public class Constants {

    /** SessionKey: 用户uuid */
    public static final String SESN_USR_UID = "sesnUsrId";

    /** SessionKey: 用户Name */
    public static final String SESN_USR_NAME = "sesnUsrName";

    /** SessionKey: 用户帐号 */
    public static final String SESN_USR_ACOUNT = "sesnUsrACOUNT";
    /** SessionKey: 用户权限菜单*/
    public static final String SESN_USR_MENUS = "sesnUsrMenus";
    /**EhCache 的公共cache名字**/
    public static final String EHCACHE_SYLOGIC = "sylogicCache";
    /** cache Key: 用户角色列表 */
    public static final String CACHE_USR_ROLES = "cacheUsrRoles:";

    /** cache Key: 非拦截URL的Key */
    public static final String ANTI_INTERCEPT_URL = "antiUrl";

    /** cache Key: 需要拦截URL的Key的前缀 */
    public static final String INTERCEPT_URL_PREX = "interceptUrlPrex:";

    /** 角色数据权限Key的前缀 */
    public static final String DATA_AUTH_PREX = "DataAuth_";

    /** 码表Key的前缀 */
    public static final String CODETYPE_PREX = "CodeType_";

    /** vsac码表Key的前缀 */
    public static final String SYSCODE_PREX = "SysCode_";

    /** 系统参数Key的前缀 */
    public static final String SYSPARAM_PREX = "SysParam_";

    /** 相机sdp内容Key的前缀 */
    public static final String CAMERA_SDP_PREX = "CameraSDP_";

    /**部门权限控制标示符*/
    public static final String DATAAUTH_D = "hbDataAuth_D";

    /**人员权限控制标示符*/
    public static final String DATAAUTH_U = "hbDataAuth_U";

    /**当前系统标示符*/
    public static final String DOMAIN_LOCAL = "domainName";

    /**公共模块系统标示符*/
    public static final String DOMAIN_SYS = "sys.domainName";

    /**公共库用户名标示符*/
    public static final String SYS_DB_USER = "sys.db.user";
    /**日志入库实现类 */
    public static final String BIZ_LOG_IMPL = "biz.log.impl";
    /**日志URL不拦截过滤*/
    public static final String LOG_URL_FILTER = "log.url.filter";

    /**资讯允许上传图片的栏目类型ID**/
    public static final String[] ZX_PICTRUEID = { "1001" };

    /**系统参数key：综合要闻图片路径前缀*/
    public static final String ZHYW_IMG_PATH_KEY = "ZHYW_IMG_PATH_PREX";

    /**系统参数key：N天内发布的公告或通知通告添加new标识*/
    public static final String INFO_NEW_LIMIT_KEY = "INFO_NEW_LIMIT";

    /** 当前展示的默认tiles模板 */
    public static final String DEFLT_TILESVIEW = "deflt_tiles_view";

    /***公告、图片新闻管理上传图片附件，的文件夹目录*/
    public static final String UPLOAD_FILE_DIR = "/upload";
}
