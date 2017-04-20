package com.jujie.xlcms.model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jujie.xlcms.model.utils.DataUtil;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.model.utils.PageUtil;
import com.jujie.xlcms.model.utils.SpringJDBCTemplate;
import com.jujie.xlcms.struts.bean.user.SysResource;
import com.jujie.xlcms.struts.bean.user.SysRole;

public class SysRoleDAO extends SpringJDBCTemplate{
	
	//查询所有角色
	@SuppressWarnings("unchecked")
	public List<SysRole> querySysRoleList(Page page) throws Exception {
		String sql = "SELECT * FROM sys_role WHERE 1=1 AND role_id!=1 ";
		List<Object> list = new ArrayList<Object>();
		sql += " order by role_id desc ";
		if(page==null){
			return this.getJdbcTemplate().query(sql, list.toArray(), new SysRole());
		}
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new SysRole());
	}
	
	
	//新增角色
	public int saveRole(SysRole role) throws Exception {
		final String sql = "insert into sys_role(role_name, remark) values(?,?)";
		final Object[] objs = {role.getRoleName(), role.getRemark()};
	    KeyHolder keyHolder = new GeneratedKeyHolder();     
		try{
			this.getJdbcTemplate().update(new PreparedStatementCreator(){         
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);                                                 
					ps.setString(++i, DataUtil.toString(objs[n++]));    
					ps.setString(++i, DataUtil.toString(objs[n++]));    
					return ps;    
				}             
			}, keyHolder);    
		}catch(Exception e){
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	
	//修改角色
	public void editRole(SysRole role) throws Exception {
		String sql = "update sys_role set role_name=? ,  remark=? where role_id=?";
		Object[] objs = {role.getRoleName() , role.getRemark() , role.getRoleID()};
		this.getJdbcTemplate().update(sql, objs);
	}
	

	//给角色授资源
	public void modifySysRoleResource(SysRole role){
		String[] sqls = new String[role.getResourceList().size()+1];
		int i = 0;
		sqls[i++] = "delete from sys_role_resource where role_id="+role.getRoleID();
		for (SysResource resource : role.getResourceList()) {
			sqls[i++] = "insert into sys_role_resource(role_id,resource_id) values("+role.getRoleID()+","+resource.getResourceID()+")";
		}
		this.getJdbcTemplate().batchUpdate(sqls);
	}

	
	//根基role_id查询一个角色
	@SuppressWarnings("unchecked")
	public SysRole getOneRole(int roleID) throws Exception {
		String sql = "select *,  role_id  from sys_role  where role_id="+roleID;
		List<SysRole> list = this.getJdbcTemplate().query(sql, new SysRole());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	

	//查询登录用户的角色
	@SuppressWarnings("unchecked")
	public List<SysRole> getRolesByUser(int userID) throws Exception {
		String sql = "SELECT r.*,r.role_id FROM sys_role r INNER JOIN sys_user_role ur ON r.role_id=ur.role_id WHERE ur.user_id="+userID;
		return this.getJdbcTemplate().query(sql, new SysRole());
	}
	
	

	
//	//删除角色
//	public void deleteRole(int roleID){
//		String[] sqls = new String[3];
//		sqls[0] = "delete from sys_role_resource where role_id="+roleID;
//		sqls[1] = "delete from sys_user_role where role_id="+roleID;
//		sqls[2] = "delete from sys_role where role_id="+roleID;
//		this.getJdbcTemplate().batchUpdate(sqls);
//	}

}
