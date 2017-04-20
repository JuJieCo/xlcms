package com.jujie.xlcms.model.dao;

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
import com.jujie.xlcms.struts.bean.Ghsgl;

public class GhsglDAO extends SpringJDBCTemplate{

	@SuppressWarnings("unchecked")
	public List<Ghsgl> queryGhsglList(Object[] objs , Page page) throws Exception{
		String sql = "select * from ghsgl where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and name like ? ";
				list.add("%" +objs[0] + "%" );
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and status = ? ";
				list.add(objs[1]);
			}
		}
		sql +=" order by ghsid desc ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL), list.toArray(), new Ghsgl());
	}
	
	@SuppressWarnings("unchecked")
	public Ghsgl queryGhsglByID(String ghsid) throws Exception{
		String sql= "select * from ghsgl where ghsid="+ghsid;
		List<Ghsgl> ghsgllist = this.getJdbcTemplate().query(sql, new Ghsgl());
		if(null!=ghsgllist&&ghsgllist.size()>0){
			return ghsgllist.get(0);
		}
		return null;
	}
	
	public int modifyGhsglForSave(Ghsgl ghsgl)throws Exception {
		final String sql = "insert into ghsgl ( name , lxdh1 , lxdh2 , address , status , remark ) values( ? , ? , ? , ? , ? , ? ) ";
		final Object[] objs = { ghsgl.getName() , ghsgl.getLxdh1() , ghsgl.getLxdh2() , ghsgl.getAddress() , ghsgl.getStatus() , ghsgl.getRemark()};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	public void modifyGhsglForUpdate(Ghsgl ghsgl)throws Exception {
		String sql = " update  ghsgl set name=? , lxdh1=? , lxdh2=? , address=? , status=? , remark=? where ghsid=?";
		Object[] objs={ ghsgl.getName() , ghsgl.getLxdh1() , ghsgl.getLxdh2() , ghsgl.getAddress() , ghsgl.getStatus() , ghsgl.getRemark() , ghsgl.getGhsid()};
		this.getJdbcTemplate().update(sql, objs);
	}
 
}
