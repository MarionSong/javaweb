package com.jt.sys.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.jt.sys.entity.SysLog;

public interface SysLogDao {
	int insertObject(SysLog entity);
	
    List<SysLog> findPageObjects(
    		       @Param("username")String username,
    		       @Param("startIndex")Integer startIndex,
    		       @Param("pageSize")Integer pageSize);
    
	int getRowCount(@Param("username")String username);
	

}
