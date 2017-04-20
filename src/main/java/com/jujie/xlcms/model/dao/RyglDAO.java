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
import com.jujie.xlcms.struts.bean.Rygl;

public class RyglDAO extends SpringJDBCTemplate{
	
	@SuppressWarnings("unchecked")
	public List<Rygl> queryRyglList(Object[] objs , Page page) throws Exception{
		String sql =" SELECT * FROM RYGL WHERE 1=1 and  RYID!=15 ";
		List<Object> list = new ArrayList<Object>();
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and name =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and dept =? ";
				list.add(objs[1]);
			}
		}
		sql += "  ORDER BY RYID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Rygl());
	}
	
	
	@SuppressWarnings("unchecked")
	public Rygl queryRyglByID(String ryid){
		String sql = " select * from rygl where ryid =" +ryid;
		List<Rygl> ryglList = this.getJdbcTemplate().query(sql, new Rygl());
		if(ryglList!=null&&ryglList.size()>0){
			return ryglList.get(0);
		}
		return null;
	}
	
	
	
	
	
	public int modifyRyglForSave(Rygl rygl) throws Exception {
		final String sql = "insert into rygl (name , sex , birthday , idcard , address , education , dept , duty , level , "
				+ "  work_type , entry_date , leave_date , status , remark )  values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?,  ? , ? , ? , ? )";
		final Object[] objs = { rygl.getName(),	rygl.getSex(), 	rygl.getBirthday(), rygl.getIdcard(), rygl.getAddress(), 
				rygl.getEducation(), rygl.getDept(), rygl.getDuty(), rygl.getLevel(),rygl.getWorkType(), rygl.getEntryDate(), 
				rygl.getLeaveDate(), rygl.getStatus(), rygl.getRemark() };
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
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
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
	
	
	public void modifyRyglForUpdate(Rygl rygl) throws Exception {
		String sql = " update rygl set  name=? , sex=? , birthday=? , idcard=? , address=? , education=? , dept=? , duty=? , level=? , "
				+ "  work_type=? , entry_date=? , leave_date=? , status=? , remark=?  where ryid=? " ;
		Object[] objs =  { rygl.getName(),	rygl.getSex(), 	rygl.getBirthday(), rygl.getIdcard(), rygl.getAddress(), 
				rygl.getEducation(), rygl.getDept(), rygl.getDuty(), rygl.getLevel(),rygl.getWorkType(), rygl.getEntryDate(), 
				rygl.getLeaveDate(), rygl.getStatus(), rygl.getRemark(), rygl.getRyid()};
		this.getJdbcTemplate().update(sql,objs);   
	}

}
