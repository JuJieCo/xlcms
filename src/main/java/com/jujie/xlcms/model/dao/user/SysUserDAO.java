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
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.user.SysRole;
import com.jujie.xlcms.struts.bean.user.SysUser;


public class SysUserDAO extends SpringJDBCTemplate{
	
	//查询所有用户
	@SuppressWarnings("unchecked")
	public List<SysUser> querySysUserList(Page page) throws Exception{
		String sql =" SELECT ry.name name , su.* FROM sys_user su , rygl ry WHERE 1=1 AND su.ryid=ry.ryid AND  su.user_id!=1";
		List<Object> list = new ArrayList<Object>();
	 
		sql += "  ORDER BY user_id DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new SysUser());
	}
	
	
	//根据系统用户ID查找一个用户
	@SuppressWarnings("unchecked")
	public SysUser querySysUserByUserID(int userID) throws Exception {
		String sql = "SELECT su.*, su.user_id , ry.name name FROM sys_user su , rygl ry WHERE su.ryid = ry.ryid AND user_id="+userID;
		List<SysUser> list = this.getJdbcTemplate().query(sql,new SysUser());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	
	//根据系统用户ID查找一个用户拥有的角色
	@SuppressWarnings("unchecked")
	public List<SysRole> querySysUserRoleListByUserID(int userID) throws Exception {
		String sql = "SELECT sr.*  FROM sys_role sr ,  sys_user_role sur WHERE sr.role_id =  sur.role_id AND sur.user_id = "+userID;
		
		return this.getJdbcTemplate().query( sql,new SysRole());
	}
	
	
	//新增系统用户
	public int saveUser(SysUser user) throws Exception {
		final String sql = "insert into sys_user(username,password,ryid) values(?,?,?)";
		final Object[] objs = {user.getUsername() , user.getPassword() , user.getRygl().getRyid()};
	    KeyHolder keyHolder = new GeneratedKeyHolder();     
		try{
			this.getJdbcTemplate().update(new PreparedStatementCreator(){         
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);                                                 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
					return pst;    
				}             
			}, keyHolder);    
		}catch(Exception e){
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	

	//修改系统用户
	public void editUser(SysUser user) throws Exception {
		String sql = "update sys_user set username=?,password=? where user_id=?";
		Object[] objs = {user.getUsername() , user.getPassword() , user.getUserID()};
		this.getJdbcTemplate().update(sql, objs);
	}
	

	//给用户授角色
	public void modifySysUserRole(SysUser user){
		String[] sqls = new String[user.getRoleList().size()+1];
		int i = 0;
		sqls[i++] = "delete from sys_user_role where user_id="+user.getUserID();
		for (SysRole role : user.getRoleList()) {
			sqls[i++] = "insert into sys_user_role(user_id,role_id) values("+user.getUserID()+","+role.getRoleID()+")";
		}
		this.getJdbcTemplate().batchUpdate(sqls);
	}


	//查看人员信息自动补全用
	@SuppressWarnings("unchecked")
	public List<Rygl> queryRyglNameListAuto(String q) throws Exception {
		final String sql = "SELECT  * FROM rygl WHERE name LIKE  '%"+q+"%'  ORDER BY  ryid DESC" ;
		List<Rygl> ryglList = new ArrayList<Rygl>();
		ryglList = this.getJdbcTemplate().query(sql,new Rygl());
		return ryglList;
	}
	
	
	//根据用登录的户名名与密码查找一个用户
		@SuppressWarnings("unchecked")
		public SysUser getOneUser(String username,String password) throws Exception {
			String sql = "select su.*,su.user_id ,  ry.name name  from  sys_user su , rygl ry  where su.ryid=ry.ryid and su.username=? and su.password=?";
			Object[] objs = {username,password};
			List<SysUser> list = this.getJdbcTemplate().query(sql,objs,new SysUser());
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
			return null;
		}
		
		
		
//	//根据人员ID查找一个用户
//	@SuppressWarnings("unchecked")
//	public SysUser getOneUserByRyid(int ryid) throws Exception {
//		String sql = "select *,user_id from sys_user where ryid="+ryid;
//		List<SysUser> list = this.getJdbcTemplate().query(sql,new SysUser());
//		if(list!=null&&list.size()>0){
//			return list.get(0);
//		}
//		return null;
//	}
	
//	//删除用户角色表
//	public void deleteUserByRyid(int ryid){
//		String[] sqls = new String[2];
//		sqls[0] = "delete from sys_user_role where user_id in(select user_id from sys_user where ryid="+ryid+")";
//		sqls[1] = "delete from sys_user where ryid="+ryid;
//		this.getJdbcTemplate().batchUpdate(sqls);
//	}
	
//	//删除系统用户
//	public void deleteUser(int userID){
//		String sql = "delete from sys_user where user_id="+userID;
//		this.getJdbcTemplate().update(sql);
//	}
	
//	//修改用户密码
//	public boolean editPwd(int userID,String password) {
//		String sql = "update sys_user set password='"+password+"' where user_id="+userID;
//		try{
//			this.getJdbcTemplate().update(sql);
//			return true;
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return false;
//	}
	
//	//检查用户名
//	public boolean checkUserName(String username) throws Exception {
//		String sql = "select count(*) from sys_user where username='"+username+"'";
//		//int count = getJdbcTemplate().queryForInt(sql, new Object[] { username }); //spring 3.2.2 之后 queryForInt 被取消了
//		//int count = this.getJdbcTemplate().queryForInt(sql);
//		//int count = getJdbcTemplate().queryForObject(sql, new Object[] { username }, Integer.class); 
//		int count = getJdbcTemplate().queryForObject(sql, Integer.class); 
//		if(count<1){
//			return true;
//		}
//		return false;
//	}
}
