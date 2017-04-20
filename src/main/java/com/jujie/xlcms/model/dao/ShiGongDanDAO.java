package com.jujie.xlcms.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.jujie.xlcms.struts.bean.BaoJia;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.ShiGongDan;
import com.jujie.xlcms.struts.bean.Xydwgl;

public class ShiGongDanDAO extends SpringJDBCTemplate{
	
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryShiGongDanList(Object[] objs , Page page) throws Exception{
		String sql =" SELECT * FROM SGDGL WHERE 1=1  ";
		List<Object> list = new ArrayList<Object>();
		
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and danhao =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and cphm =? ";
				list.add(objs[1]);
			}
			if(objs.length>=3&&null!=objs[2]&&!"0".equals(objs[2])){
				sql +=" and dwmc =? ";
				list.add(objs[2]);
			}
			if(objs.length>=4&&null!=objs[3]&&!"0".equals(objs[3])){
				sql +=" and wxgw =? ";
				list.add(objs[3]);
			}
			if(objs.length>=5&&null!=objs[4]&&!"".equals(objs[4])){
				sql +=" and khmc =? ";
				list.add(objs[4]);
			}
			if(objs.length>=6&&null!=objs[5]&&!"".equals(objs[5])){
				sql +=" and khdh =? ";
				list.add(objs[5]);
			}
			if(objs.length>=7&&null!=objs[6]&&!"".equals(objs[6])){
				sql +=" and clpp =? ";
				list.add(objs[6]);
			}
			if(objs.length>=8&&null!=objs[7]&&!"".equals(objs[7])){
				sql +=" and clxh =? ";
				list.add(objs[7]);
			}
			if(objs.length>=9&&null!=objs[8]&&!"0".equals(objs[8])){
				sql +=" and khlx =? ";
				list.add(objs[8]);
			}
			if(objs.length>=10&&null!=objs[9]&&!"0".equals(objs[9])){
				sql +=" and sflx =? ";
				list.add(objs[9]);
			}
			if(objs.length>=11&&null!=objs[10]&&!"0".equals(objs[10])){
				sql +=" and wxlx =? ";
				list.add(objs[10]);
			}
			if(objs.length>=12&&null!=objs[11]&&!"0".equals(objs[11])){
				sql +=" and wxzt =? ";
				list.add(objs[11]);
			}
			if(objs.length>=13&&null!=objs[12]&&!"".equals(objs[12])){
				if(objs.length>=14&&null!=objs[13]&&!"".equals(objs[13])){
					sql +="  and gddjrq BETWEEN '"+objs[12]+"' AND '"+objs[13]+"' ";
				}
			}
			if(objs.length>=15&&null!=objs[14]&&!"".equals(objs[14])){
				if(objs.length>=16&&null!=objs[15]&&!"".equals(objs[15])){
					sql +="  and yjwgrq BETWEEN '"+objs[14]+"' AND '"+objs[15]+"' ";
				}
			}
			if(objs.length>=17&&null!=objs[16]&&!"".equals(objs[16])){
				if(objs.length>=18&&null!=objs[17]&&!"".equals(objs[17])){
					sql +="  and sjwgrq BETWEEN '"+objs[16]+"' AND '"+objs[17]+"' ";
				}
			}
			if(objs.length>=19&&null!=objs[18]&&!"".equals(objs[18])){
				if(objs.length>=20&&null!=objs[19]&&!"".equals(objs[19])){
					sql +="  and bxdqrq BETWEEN '"+objs[18]+"' AND '"+objs[19]+"' ";
				}
			}
		}
		sql += " AND wxzt IN (1,2)  ORDER BY GDID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryShiGongDanTempList(Object[] objs , Page page) throws Exception{
		String sql =" SELECT * FROM SGDGL WHERE 1=1 ";
		List<Object> list = new ArrayList<Object>();
		
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and danhao =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and cphm =? ";
				list.add(objs[1]);
			}
			if(objs.length>=3&&null!=objs[2]&&!"0".equals(objs[2])){
				sql +=" and dwmc =? ";
				list.add(objs[2]);
			}
			if(objs.length>=4&&null!=objs[3]&&!"0".equals(objs[3])){
				sql +=" and wxgw =? ";
				list.add(objs[3]);
			}
			if(objs.length>=5&&null!=objs[4]&&!"".equals(objs[4])){
				sql +=" and khmc =? ";
				list.add(objs[4]);
			}
			if(objs.length>=6&&null!=objs[5]&&!"".equals(objs[5])){
				sql +=" and khdh =? ";
				list.add(objs[5]);
			}
			if(objs.length>=7&&null!=objs[6]&&!"".equals(objs[6])){
				sql +=" and clpp =? ";
				list.add(objs[6]);
			}
			if(objs.length>=8&&null!=objs[7]&&!"".equals(objs[7])){
				sql +=" and clxh =? ";
				list.add(objs[7]);
			}
			if(objs.length>=9&&null!=objs[8]&&!"0".equals(objs[8])){
				sql +=" and khlx =? ";
				list.add(objs[8]);
			}
			if(objs.length>=10&&null!=objs[9]&&!"0".equals(objs[9])){
				sql +=" and sflx =? ";
				list.add(objs[9]);
			}
			if(objs.length>=11&&null!=objs[10]&&!"0".equals(objs[10])){
				sql +=" and wxlx =? ";
				list.add(objs[10]);
			}
			if(objs.length>=12&&null!=objs[11]&&!"0".equals(objs[11])){
				sql +=" and wxzt =? ";
				list.add(objs[11]);
			}
			if(objs.length>=13&&null!=objs[12]&&!"".equals(objs[12])){
				if(objs.length>=14&&null!=objs[13]&&!"".equals(objs[13])){
					sql +="  and gddjrq BETWEEN '"+objs[12]+"' AND '"+objs[13]+"' ";
				}
			}
			if(objs.length>=15&&null!=objs[14]&&!"".equals(objs[14])){
				if(objs.length>=16&&null!=objs[15]&&!"".equals(objs[15])){
					sql +="  and yjwgrq BETWEEN '"+objs[14]+"' AND '"+objs[15]+"' ";
				}
			}
			if(objs.length>=17&&null!=objs[16]&&!"".equals(objs[16])){
				if(objs.length>=18&&null!=objs[17]&&!"".equals(objs[17])){
					sql +="  and sjwgrq BETWEEN '"+objs[16]+"' AND '"+objs[17]+"' ";
				}
			}
			if(objs.length>=19&&null!=objs[18]&&!"".equals(objs[18])){
				if(objs.length>=20&&null!=objs[19]&&!"".equals(objs[19])){
					sql +="  and bxdqrq BETWEEN '"+objs[18]+"' AND '"+objs[19]+"' ";
				}
			}
		}
		sql += "  and wxzt=7  ORDER BY GDID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryShiGongDanJiesuanList(Object[] objs , Page page) throws Exception{
		String sql =" SELECT * FROM SGDGL WHERE 1=1 ";
		List<Object> list = new ArrayList<Object>();
		
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and danhao =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and cphm =? ";
				list.add(objs[1]);
			}
			if(objs.length>=3&&null!=objs[2]&&!"0".equals(objs[2])){
				sql +=" and dwmc =? ";
				list.add(objs[2]);
			}
			if(objs.length>=4&&null!=objs[3]&&!"0".equals(objs[3])){
				sql +=" and wxgw =? ";
				list.add(objs[3]);
			}
			if(objs.length>=5&&null!=objs[4]&&!"".equals(objs[4])){
				sql +=" and khmc =? ";
				list.add(objs[4]);
			}
			if(objs.length>=6&&null!=objs[5]&&!"".equals(objs[5])){
				sql +=" and khdh =? ";
				list.add(objs[5]);
			}
			if(objs.length>=7&&null!=objs[6]&&!"".equals(objs[6])){
				sql +=" and clpp =? ";
				list.add(objs[6]);
			}
			if(objs.length>=8&&null!=objs[7]&&!"".equals(objs[7])){
				sql +=" and clxh =? ";
				list.add(objs[7]);
			}
			if(objs.length>=9&&null!=objs[8]&&!"0".equals(objs[8])){
				sql +=" and khlx =? ";
				list.add(objs[8]);
			}
			if(objs.length>=10&&null!=objs[9]&&!"0".equals(objs[9])){
				sql +=" and sflx =? ";
				list.add(objs[9]);
			}
			if(objs.length>=11&&null!=objs[10]&&!"0".equals(objs[10])){
				sql +=" and wxlx =? ";
				list.add(objs[10]);
			}
			if(objs.length>=12&&null!=objs[11]&&!"0".equals(objs[11])){
				sql +=" and wxzt =? ";
				list.add(objs[11]);
			}
			if(objs.length>=13&&null!=objs[12]&&!"".equals(objs[12])){
				if(objs.length>=14&&null!=objs[13]&&!"".equals(objs[13])){
					sql +="  and gddjrq BETWEEN '"+objs[12]+"' AND '"+objs[13]+"' ";
				}
			}
			if(objs.length>=15&&null!=objs[14]&&!"".equals(objs[14])){
				if(objs.length>=16&&null!=objs[15]&&!"".equals(objs[15])){
					sql +="  and yjwgrq BETWEEN '"+objs[14]+"' AND '"+objs[15]+"' ";
				}
			}
			if(objs.length>=17&&null!=objs[16]&&!"".equals(objs[16])){
				if(objs.length>=18&&null!=objs[17]&&!"".equals(objs[17])){
					sql +="  and sjwgrq BETWEEN '"+objs[16]+"' AND '"+objs[17]+"' ";
				}
			}
			if(objs.length>=19&&null!=objs[18]&&!"".equals(objs[18])){
				if(objs.length>=20&&null!=objs[19]&&!"".equals(objs[19])){
					sql +="  and bxdqrq BETWEEN '"+objs[18]+"' AND '"+objs[19]+"' ";
				}
			}
		}
		sql += "  AND wxzt!=1 AND wxzt!=7  ORDER BY GDID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryBeiliaoShiGongDanList(Object[] objs , Page page ) throws Exception{
		String sql =" SELECT * FROM SGDGL WHERE 1=1  ";
		 
		List<Object> list = new ArrayList<Object>();
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and danhao =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and cphm =? ";
				list.add(objs[1]);
			}
			if(objs.length>=3&&null!=objs[2]&&!"0".equals(objs[2])){
				sql +=" and dwmc =? ";
				list.add(objs[2]);
			}
			if(objs.length>=4&&null!=objs[3]&&!"0".equals(objs[3])){
				sql +=" and wxgw =? ";
				list.add(objs[3]);
			}
			if(objs.length>=5&&null!=objs[4]&&!"".equals(objs[4])){
				sql +=" and khmc =? ";
				list.add(objs[4]);
			}
			if(objs.length>=6&&null!=objs[5]&&!"".equals(objs[5])){
				sql +=" and khdh =? ";
				list.add(objs[5]);
			}
			if(objs.length>=7&&null!=objs[6]&&!"".equals(objs[6])){
				sql +=" and clpp =? ";
				list.add(objs[6]);
			}
			if(objs.length>=8&&null!=objs[7]&&!"".equals(objs[7])){
				sql +=" and clxh =? ";
				list.add(objs[7]);
			}
			if(objs.length>=9&&null!=objs[8]&&!"0".equals(objs[8])){
				sql +=" and khlx =? ";
				list.add(objs[8]);
			}
			if(objs.length>=10&&null!=objs[9]&&!"0".equals(objs[9])){
				sql +=" and sflx =? ";
				list.add(objs[9]);
			}
			if(objs.length>=11&&null!=objs[10]&&!"0".equals(objs[10])){
				sql +=" and wxlx =? ";
				list.add(objs[10]);
			}
			if(objs.length>=12&&null!=objs[11]&&!"0".equals(objs[11])){
				sql +=" and wxzt =? ";
				list.add(objs[11]);
			}
			if(objs.length>=13&&null!=objs[12]&&!"".equals(objs[12])){
				if(objs.length>=14&&null!=objs[13]&&!"".equals(objs[13])){
					sql +="  and gddjrq BETWEEN '"+objs[12]+"' AND '"+objs[13]+"' ";
				}
			}
			if(objs.length>=15&&null!=objs[14]&&!"".equals(objs[14])){
				if(objs.length>=16&&null!=objs[15]&&!"".equals(objs[15])){
					sql +="  and yjwgrq BETWEEN '"+objs[14]+"' AND '"+objs[15]+"' ";
				}
			}
			if(objs.length>=17&&null!=objs[16]&&!"".equals(objs[16])){
				if(objs.length>=18&&null!=objs[17]&&!"".equals(objs[17])){
					sql +="  and sjwgrq BETWEEN '"+objs[16]+"' AND '"+objs[17]+"' ";
				}
			}
			if(objs.length>=19&&null!=objs[18]&&!"".equals(objs[18])){
				if(objs.length>=20&&null!=objs[19]&&!"".equals(objs[19])){
					sql +="  and bxdqrq BETWEEN '"+objs[18]+"' AND '"+objs[19]+"' ";
				}
			}
		}
		sql += " AND wlzt=2  ORDER BY GDID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
	}
	
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public ShiGongDan queryShiGongDanByID(String gdid) throws Exception{
		String sql = " select * from sgdgl where gdid =" +gdid;
		List<ShiGongDan> shiGongDanList = this.getJdbcTemplate().query(sql, new ShiGongDan());
		if(shiGongDanList!=null&&shiGongDanList.size()>0){
			return shiGongDanList.get(0);
		}
		return null;
	}
	
	
	/**
	 *按id查询对应的报价单
	 */
	@SuppressWarnings("unchecked")
	public List<BaoJia> queryBaoJiaList(String gdid) throws Exception{
		String sql =" SELECT r.danjia jinjia , a.* , b.danhao danhao , b.clpp clpp , b.clxh clxh, b.cjh cjh, b.khlx  khlx  FROM BJGL a , SGDGL b  , rkjl r "
				+ " WHERE  a.rkid = r.rkid AND  a.gdid = b.gdid AND a.gdid ="+gdid;
		sql += "  ORDER BY  a.BJID DESC ";
		return this.getJdbcTemplate().query( sql , new BaoJia(){
			public BaoJia mapRow(ResultSet rst, int rowNum) throws SQLException {
				BaoJia baoJia = new BaoJia();
				baoJia.setBjid(rst.getInt("bjid"));
				baoJia.getSgd().setGdid(rst.getInt("gdid"));
				baoJia.getRkjl().setRkid(rst.getInt("rkid"));
				baoJia.getCkgl().setCkid(rst.getInt("ckid"));
				baoJia.setWlmc(rst.getString("wlmc"));
				
				baoJia.setWlzl(rst.getString("wlzl"));
				baoJia.setBjrq(rst.getString("bjrq"));
				baoJia.setFhrq(rst.getString("fhrq"));
				baoJia.setRkrq(rst.getString("rkrq"));
				
				baoJia.setLlrq(rst.getString("llrq"));
				baoJia.setDanjia(rst.getString("danjia"));
				baoJia.setShuliang(rst.getString("shuliang"));
				baoJia.setGsf(rst.getString("gsf"));
				baoJia.setBjzt(rst.getString("bjzt"));
				baoJia.setSfyh(rst.getString("sfyh"));
				baoJia.setRemark(rst.getString("remark"));
				
				baoJia.getSgd().setDanhao(rst.getString("danhao"));
				baoJia.getSgd().setClpp(rst.getString("clpp"));
				baoJia.getSgd().setClxh(rst.getString("clxh"));
				baoJia.getSgd().setCjh(rst.getString("cjh"));
				baoJia.getSgd().setKhlx(rst.getString("khlx"));
				
				baoJia.getRkjl().setDanjia(rst.getString("jinjia"));
				
				return baoJia;
			}
		});
	}
	
	
	/**
	 *新增
	 */
	public int modifyShiGongDanForSave(ShiGongDan shiGongDan) throws Exception {
		final String sql = "insert into sgdgl ( "
				+ " danhao,cphm,cjh,clpp,clxh ,"
				+ " fdjh,fdjpx,cllc,scrq,khmc, "
				+ " khdh,wxgw,jxzxr,jxzjr,bpzxr,"
				+ " bpzjr,gddjrq,yjwgrq,sjwgrq,khlx,"
				+ " sflx,wxlx,wxzt,dwmc,zfy, "
				+ " yjpf,sjpf,wlzt,tbgs,bxdqrq,remark ) "
				+ " values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
		final Object[] objs = {shiGongDan.getDanhao() , shiGongDan.getCphm() , shiGongDan.getCjh() , shiGongDan.getClpp() , shiGongDan.getClxh() , 
				shiGongDan.getFdjh() , shiGongDan.getFdjpx() , shiGongDan.getCllc() , shiGongDan.getScrq() , shiGongDan.getKhmc() , 
				shiGongDan.getKhdh() , shiGongDan.getWxgw() , shiGongDan.getJxzxr(),shiGongDan.getJxzjr() , shiGongDan.getBpzxr() , 
				shiGongDan.getBpzjr() , shiGongDan.getGddjrq() , shiGongDan.getYjwgrq() ,  shiGongDan.getSjwgrq() , shiGongDan.getKhlx() ,  
				shiGongDan.getSflx() , shiGongDan.getWxlx() ,  shiGongDan.getWxzt() , shiGongDan.getDwmc() ,  shiGongDan.getZfy() , 
				shiGongDan.getYjpf() , shiGongDan.getSjpf() , shiGongDan.getWlzt() ,shiGongDan.getTbgs() , shiGongDan.getBxdqrq() ,shiGongDan.getRemark()};
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
	
	
	/**
	 *修改(结算) 
	 */
	public void modifyShiGongDanForUpdate(ShiGongDan shiGongDan) throws Exception {
		String sql = " update sgdgl set  wxzt=?  , wlzt=? , sjzfy=? , sjpf=? , sjwgrq=? where gdid=? " ;
		Object[] objs =  {shiGongDan.getWxzt(),shiGongDan.getWlzt() ,shiGongDan.getSjzfy(),shiGongDan.getSjpf(),shiGongDan.getSjwgrq(),shiGongDan.getGdid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *修改(临时补录) modifyShiGongDanTempForUpdate
	 */
	public void modifyShiGongDanTempForUpdate(ShiGongDan shiGongDan) throws Exception {
		String sql = " update sgdgl set  cphm=?, cjh=?, clpp=?, clxh=?,  fdjh=?, fdjpx=?, cllc=?, scrq=?, khmc=? , "
		+ " khdh=?, wxgw=?, jxzxr=?, jxzjr=? ,bpzxr=?, bpzjr=?, gddjrq=?, yjwgrq=?, sjwgrq=?, khlx=?, sflx=?, "
		+ " wxlx=?, wxzt=?, dwmc=?, zfy=?, yjpf=?, sjpf=?, wlzt=?, tbgs=?, bxdqrq=?, remark=?  "
		+ " where gdid=? " ;
		 Object[] objs = {shiGongDan.getCphm() , shiGongDan.getCjh() , shiGongDan.getClpp() , shiGongDan.getClxh() , 
				shiGongDan.getFdjh() , shiGongDan.getFdjpx() , shiGongDan.getCllc() , shiGongDan.getScrq() , shiGongDan.getKhmc() , 
				shiGongDan.getKhdh() , shiGongDan.getWxgw() , shiGongDan.getJxzxr(),shiGongDan.getJxzjr() , shiGongDan.getBpzxr() , 
				shiGongDan.getBpzjr() , shiGongDan.getGddjrq() , shiGongDan.getYjwgrq() ,  shiGongDan.getSjwgrq() , shiGongDan.getKhlx() ,  
				shiGongDan.getSflx() , shiGongDan.getWxlx() ,  shiGongDan.getWxzt() , shiGongDan.getDwmc() ,  shiGongDan.getZfy() , 
				shiGongDan.getYjpf() , shiGongDan.getSjpf() , shiGongDan.getWlzt() ,shiGongDan.getTbgs(), shiGongDan.getBxdqrq(),shiGongDan.getRemark(),shiGongDan.getGdid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryShiGongDanInfoList(Object[] objs , Page page) throws Exception{
		String sql =" SELECT * FROM SGDGL WHERE 1=1  ";
		List<Object> list = new ArrayList<Object>();
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and danhao =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and cphm =? ";
				list.add(objs[1]);
			}
			if(objs.length>=3&&null!=objs[2]&&!"0".equals(objs[2])){
				sql +=" and dwmc =? ";
				list.add(objs[2]);
			}
			if(objs.length>=4&&null!=objs[3]&&!"0".equals(objs[3])){
				sql +=" and wxgw =? ";
				list.add(objs[3]);
			}
			if(objs.length>=5&&null!=objs[4]&&!"".equals(objs[4])){
				sql +=" and khmc =? ";
				list.add(objs[4]);
			}
			if(objs.length>=6&&null!=objs[5]&&!"".equals(objs[5])){
				sql +=" and khdh =? ";
				list.add(objs[5]);
			}
			if(objs.length>=7&&null!=objs[6]&&!"".equals(objs[6])){
				sql +=" and clpp =? ";
				list.add(objs[6]);
			}
			if(objs.length>=8&&null!=objs[7]&&!"".equals(objs[7])){
				sql +=" and clxh =? ";
				list.add(objs[7]);
			}
			if(objs.length>=9&&null!=objs[8]&&!"0".equals(objs[8])){
				sql +=" and khlx =? ";
				list.add(objs[8]);
			}
			if(objs.length>=10&&null!=objs[9]&&!"0".equals(objs[9])){
				sql +=" and sflx =? ";
				list.add(objs[9]);
			}
			if(objs.length>=11&&null!=objs[10]&&!"0".equals(objs[10])){
				sql +=" and wxlx =? ";
				list.add(objs[10]);
			}
			if(objs.length>=12&&null!=objs[11]&&!"0".equals(objs[11])){
				sql +=" and wxzt =? ";
				list.add(objs[11]);
			}
			if(objs.length>=13&&null!=objs[12]&&!"".equals(objs[12])){
				if(objs.length>=14&&null!=objs[13]&&!"".equals(objs[13])){
					sql +="  and gddjrq BETWEEN '"+objs[12]+"' AND '"+objs[13]+"' ";
				}
			}
			if(objs.length>=15&&null!=objs[14]&&!"".equals(objs[14])){
				if(objs.length>=16&&null!=objs[15]&&!"".equals(objs[15])){
					sql +="  and yjwgrq BETWEEN '"+objs[14]+"' AND '"+objs[15]+"' ";
				}
			}
			if(objs.length>=17&&null!=objs[16]&&!"".equals(objs[16])){
				if(objs.length>=18&&null!=objs[17]&&!"".equals(objs[17])){
					sql +="  and sjwgrq BETWEEN '"+objs[16]+"' AND '"+objs[17]+"' ";
				}
			}
			if(objs.length>=19&&null!=objs[18]&&!"".equals(objs[18])){
				if(objs.length>=20&&null!=objs[19]&&!"".equals(objs[19])){
					sql +="  and bxdqrq BETWEEN '"+objs[18]+"' AND '"+objs[19]+"' ";
				}
			}
		}
		sql +=  " and gddjrq !=''  ORDER BY GDID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
	}
	
	
	//修改施工单
	public void modifyShiGongDanInfoForUpdate(ShiGongDan shiGongDan) throws Exception {
		String sql = " update sgdgl set  cphm=?, cjh=?, clpp=?, clxh=?,  fdjh=?, fdjpx=?, cllc=?, scrq=?, khmc=? ,  khdh=?, "
		+ " wxgw=?, jxzxr=?, jxzjr=? ,bpzxr=?, bpzjr=?, gddjrq=?, yjwgrq=?, sjwgrq=?, khlx=?, sflx=?, "
		+ " wxlx=?, wxzt=?, dwmc=?, sjzfy=? , yjpf=?, sjpf=?, remark=?  "
		+ " where gdid=? " ;
		 Object[] objs = {shiGongDan.getCphm() , shiGongDan.getCjh() , shiGongDan.getClpp() , shiGongDan.getClxh() , 
				shiGongDan.getFdjh() , shiGongDan.getFdjpx() , shiGongDan.getCllc() , shiGongDan.getScrq() , shiGongDan.getKhmc() , 
				shiGongDan.getKhdh() , shiGongDan.getWxgw() , shiGongDan.getJxzxr(),shiGongDan.getJxzjr() , shiGongDan.getBpzxr() , 
				shiGongDan.getBpzjr() , shiGongDan.getGddjrq() , shiGongDan.getYjwgrq() ,  shiGongDan.getSjwgrq() , shiGongDan.getKhlx() ,  
				shiGongDan.getSflx() , shiGongDan.getWxlx() ,  shiGongDan.getWxzt() , shiGongDan.getDwmc() ,  
				shiGongDan.getSjzfy(), shiGongDan.getYjpf() , shiGongDan.getSjpf() , shiGongDan.getRemark(),shiGongDan.getGdid()};
		this.getJdbcTemplate().update(sql,objs);   
	}	
	
	
	
	
	
	//自动补全
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryCheLiangListAuto(String q) throws Exception {
		final String sql = "SELECT  * FROM sgdgl WHERE cphm LIKE  '%"+q+"%'  ORDER BY  gdid DESC" ;
		List<ShiGongDan> shiGongDanList = new ArrayList<ShiGongDan>();
		shiGongDanList = this.getJdbcTemplate().query(sql,new ShiGongDan());
		return shiGongDanList;
	}
	
	
	
	//查询协议单位名称
	@SuppressWarnings("unchecked")
	public List<Xydwgl> queryXydwglList() throws Exception{
		String sql ="  SELECT xyid , dwname FROM xydwgl ";
		return this.getJdbcTemplate().query( sql , new Xydwgl());
	}
	
	//查询人员(在职接待)
	@SuppressWarnings("unchecked")
	public List<Rygl> queryJDList() throws Exception{
		String sql ="  SELECT * FROM rygl WHERE dept=1 and status=1";
		return this.getJdbcTemplate().query( sql , new Rygl());
	}
	
	//查询人员(所有接待)
	@SuppressWarnings("unchecked")
	public List<Rygl> queryAllJDList() throws Exception{
		String sql ="  SELECT * FROM rygl WHERE dept=1 ";
		return this.getJdbcTemplate().query( sql , new Rygl());
	}
	
	//查询人员(所有)
		@SuppressWarnings("unchecked")
		public List<Rygl> queryRYList() throws Exception{
			String sql ="  SELECT * FROM rygl ";
			return this.getJdbcTemplate().query( sql , new Rygl());
		}
		
	
}
