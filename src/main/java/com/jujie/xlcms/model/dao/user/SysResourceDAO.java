package com.jujie.xlcms.model.dao.user;

import java.util.List;

import com.jujie.xlcms.model.utils.SpringJDBCTemplate;
import com.jujie.xlcms.struts.bean.user.SysResource;

public class SysResourceDAO  extends SpringJDBCTemplate{

	@SuppressWarnings("unchecked")
	public List<SysResource> querySysResourceList() throws Exception {
		String sql = "SELECT *,resource_id FROM sys_resource ORDER BY resource_pid ASC";
		return this.getJdbcTemplate().query(sql, new SysResource());
	}
	
	

	
	//查询用户的角色的资源
	@SuppressWarnings("unchecked")
	public List<SysResource> getResourceByRole(int roleID) throws Exception {
		String sql = "SELECT re.*,re.resource_id FROM sys_resource re INNER JOIN sys_role_resource ro ON re.resource_id=ro.resource_id WHERE ro.role_id="+roleID+" ORDER BY re.resource_pid DESC";
		return this.getJdbcTemplate().query(sql, new SysResource());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SysResource> getAllResourceByUser(int userID) throws Exception{
		String sql = " SELECT DISTINCT re.*,re.resource_id  FROM sys_resource re INNER JOIN sys_role_resource rr ON re.resource_id=rr.resource_id "
					+" INNER JOIN sys_role r ON rr.role_id=r.role_id INNER JOIN sys_user_role ur ON r.role_id=ur.role_id "
					+" INNER JOIN sys_user u ON ur.user_id=u.user_id "
					+" WHERE u.user_id="+userID+" ORDER BY re.resource_pid ASC ";
		return this.getJdbcTemplate().query(sql, new SysResource());
	}
	
	
	
	
//	@SuppressWarnings("unchecked")
//	public SysResource getOneResource(int resourceID) throws Exception {
//		String sql = "select *,resource_id from sys_resource where resource_id="+resourceID;
//		List<SysResource> list = this.getJdbcTemplate().query(sql, new SysResource());
//		if(list!=null&&list.size()>0){
//			return list.get(0);
//		}
//		return null;
//	}
	
//	public int saveResource(SysResource resource) throws Exception {
//		final String sql = "insert into sys_resource(resource_name,resource_url,resource_pid,resource_sign) values(?,?,?,?)";
//		final Object[] objs = { resource.getResourceName() , resource.getResourceUrl() , resource.getResourcePID() , resource.getResourceSign() };
//	    KeyHolder keyHolder = new GeneratedKeyHolder();     
//		try{
//			this.getJdbcTemplate().update(new PreparedStatementCreator(){         
//				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
//					int i = 0;
//					int n = 0;
//					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);                                                 
//					ps.setString(++i,  DataUtil.toString(objs[n++]));    
//					ps.setString(++i,  DataUtil.toString(objs[n++]));  
//					if(DataUtil.toInt(objs[n])==0){
//						ps.setNull(++i, Type.INT);
//					}else{
//						ps.setInt(++i, DataUtil.toInt(objs[n++]));  
//					}
//					ps.setString(++i,  DataUtil.toString(objs[n++]));
//					return ps;    
//				}             
//			}, keyHolder);    
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return keyHolder.getKey().intValue();
//	}
	
//	public void editResource(SysResource resource) throws Exception {
//		String sql = "update sys_resource set resource_name=?,resource_url=?,resource_pid=?,resource_sign=? where resource_id=?";
//		Object[] objs = {resource.getResourceName() , resource.getResourceUrl() , resource.getResourcePID() , resource.getResourceSign() , resource.getResourceID()};
//		this.getJdbcTemplate().update(sql, objs);
//	}
	
//	public void deleteResource(int resourceID){
//		String[] sqls = new String[2];
//		sqls[0] = "delete from sys_role_resource where resource_id="+resourceID;
//		sqls[1] = "delete from sys_resource where resource_id="+resourceID;
//		this.getJdbcTemplate().batchUpdate(sqls);
//	}
	
	
	

	

	

	
}
