package com.jujie.xlcms.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.model.utils.PageUtil;
import com.jujie.xlcms.model.utils.SpringJDBCTemplate;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class KhxxglDAO extends SpringJDBCTemplate{
	
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryKhxxList(Object[] objs , Page page) throws Exception{
		String sql = " SELECT  a.gdid , a.cphm , a.clpp , a.clxh , a.khmc , a.khdh , a.gddjrq   , a.wxlx , a.tbgs , a.bxdqrq  FROM (SELECT * FROM sgdgl  ORDER BY gdid   DESC) a  WHERE 1=1 " ; 
			List<Object> list = new ArrayList<Object>();
			if(null!=objs&&objs.length>0){
				if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
					sql+=" and a.khlx=? ";
					list.add(objs[0]); 
				}
				if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
					sql+=" and a.cphm=? ";
					list.add(objs[1]); 
				}
				if(objs.length>=3&&null!=objs[2]&&!"".equals(objs[2])){
					sql+=" and a.khmc=? ";
					list.add(objs[2]); 
				}
				if(objs.length>=4&&null!=objs[3]&&!"".equals(objs[3])){
					sql+=" and a.tbgs=? ";
					list.add(objs[3]); 
				}
				if(objs.length>=5&&null!=objs[4]&&!"".equals(objs[4])){
					sql+=" and a.clpp=? ";
					list.add(objs[4]); 
				}
				if(objs.length>=6&&null!=objs[5]&&!"".equals(objs[5])){
					sql+=" and a.khdh=? ";
					list.add(objs[5]); 
				}
				if(objs.length>=7&&null!=objs[6]&&!"".equals(objs[6])){
					sql+=" and a.wxgw=? ";
					list.add(objs[6]); 
				}
				if(objs.length>=8&&null!=objs[7]&&!"".equals(objs[7])){
					sql+=" and a.clxh=? ";
					list.add(objs[7]); 
				}
				if(objs.length>=9&&null!=objs[8]&&!"".equals(objs[8])){
					sql+=" and a.dwmc=? ";
					list.add(objs[8]); 
				}
				if(objs.length>=10&&null!=objs[9]&&!"".equals(objs[9])){
					if(objs.length>=11&&null!=objs[10]&&!"".equals(objs[10])){
						sql +="  and a.gddjrq BETWEEN '"+objs[9]+"' AND '"+objs[10]+"' ";
					}
				}
				if(objs.length>=12&&null!=objs[11]&&!"".equals(objs[11])){
					if(objs.length>=13&&null!=objs[12]&&!"".equals(objs[12])){
						sql +="  and a.bxdqrq BETWEEN '"+objs[11]+"' AND '"+objs[12]+"' ";
					}
				}
				
			}
		sql+=" GROUP BY a.cphm  ORDER BY a.gdid   DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL), list.toArray() , new ShiGongDan(){
			public ShiGongDan mapRow(ResultSet rst, int rowNum) throws SQLException {
				ShiGongDan shiGongDan = new ShiGongDan();
				shiGongDan.setGdid(rst.getInt("gdid"));
				shiGongDan.setCphm(rst.getString("cphm"));
				shiGongDan.setClpp(rst.getString("clpp"));
				shiGongDan.setClxh(rst.getString("clxh"));
				shiGongDan.setKhmc(rst.getString("khmc"));
				shiGongDan.setKhdh(rst.getString("khdh"));
				shiGongDan.setGddjrq(rst.getString("gddjrq"));
				shiGongDan.setWxlx(rst.getString("wxlx"));
				shiGongDan.setTbgs(rst.getString("tbgs"));
				shiGongDan.setBxdqrq(rst.getString("bxdqrq"));
				return shiGongDan;
			}
		});
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryWxjlList(String cphm) throws Exception{
		String sql = " SELECT * FROM sgdgl WHERE 1=1 " ;
		List<Object> list = new ArrayList<Object>();
		
		if(null!=cphm&&!"".equals(cphm)){
			sql+=" and  cphm =? ";
			list.add(cphm);
		}
		return this.getJdbcTemplate().query(sql, list.toArray(), new ShiGongDan());
	}
	
	
	//查询人员(所有接待)
		@SuppressWarnings("unchecked")
		public List<Rygl> queryAllJDList() throws Exception{
			String sql ="  SELECT * FROM rygl WHERE dept=1 ";
			return this.getJdbcTemplate().query( sql , new Rygl());
		}

}
