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
import com.jujie.xlcms.struts.bean.Ckgl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class BaoJiaDAO  extends SpringJDBCTemplate{
	
	//初始化施工单内容
	@SuppressWarnings("unchecked")
	public ShiGongDan queryBaojiaDanByID(String gdid) throws Exception{
		String sql = " select * from sgdgl where gdid =" +gdid;
		List<ShiGongDan> shiGongDanList = this.getJdbcTemplate().query(sql, new ShiGongDan());
		if(shiGongDanList!=null&&shiGongDanList.size()>0){
			return shiGongDanList.get(0);
		}
		return null;
	}
		
	
	//查看一个物料的报价内容
	@SuppressWarnings("unchecked")
	public BaoJia queryBaojiaByID(String bjid) throws Exception{
		String sql = " select * from bjgl where bjid =" +bjid;
		List<BaoJia> baoJiaList = this.getJdbcTemplate().query(sql, new BaoJia(){
			public BaoJia mapRow(ResultSet rst, int rowNum) throws SQLException {
				BaoJia baoJia = new BaoJia();
				baoJia.setBjid(rst.getInt("bjid"));
				baoJia.getSgd().setGdid(rst.getInt("gdid"));
				baoJia.getRkjl().setRkid(rst.getInt("rkid"));
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
				
				return baoJia;
			}
		});
		if(baoJiaList!=null&&baoJiaList.size()>0){
			return baoJiaList.get(0);
		}
		return null;
	}
	
	
			
	//查询请求报价物料单 查询施工单对应的报料,报价,补料单
	@SuppressWarnings("unchecked")
	public List<BaoJia> queryBaoJiaList(String gdid) throws Exception{
		String sql =" SELECT a.* , b.danhao danhao , b.clpp clpp , b.clxh clxh, b.cjh cjh, b.khlx  khlx  FROM BJGL a , SGDGL b WHERE  a.gdid = b.gdid   and a.gdid ="+gdid;
		
		sql += "  ORDER BY BJZT DESC ";
		return this.getJdbcTemplate().query( sql,new BaoJia());
	}
	
	//查询备料物料单
	@SuppressWarnings("unchecked")
	public List<BaoJia> queryBeiliaoList(String gdid) throws Exception{
		String sql =" SELECT a.* , b.danhao danhao , b.clpp clpp , b.clxh clxh, b.cjh cjh, b.khlx  khlx   FROM BJGL a , SGDGL b WHERE a.bjzt=3 and a.gdid = b.gdid  and a.gdid ="+gdid;
		
		sql += "  ORDER BY BJZT DESC ";
		return this.getJdbcTemplate().query( sql,new BaoJia());
	}
	
	//查询领料物料单
	@SuppressWarnings("unchecked")
	public List<BaoJia> queryLingliaoList(String gdid) throws Exception{
		String sql =" SELECT b.* , a.danhao danhao , a.clpp clpp , a.clxh clxh, a.cjh cjh, a.cphm  cphm , a.khlx  khlx , d.kclx kclx , d.wllx wllx , c.kcid kcid FROM  SGDGL a  , BJGL b  ,  rkjl c  , kcgl d "
				+ " WHERE b.bjzt=4 AND a.gdid = b.gdid  AND b.rkid = c.rkid AND c.kcid = d.kcid AND a.gdid ="+gdid;
		sql += "  ORDER BY BJZT DESC ";
		return this.getJdbcTemplate().query( sql,new BaoJia(){
			public BaoJia mapRow(ResultSet rst, int rowNum) throws SQLException {
				BaoJia baoJia = new BaoJia();
				baoJia.setBjid(rst.getInt("bjid"));
				baoJia.getSgd().setGdid(rst.getInt("gdid"));
				baoJia.getRkjl().setRkid(rst.getInt("rkid"));
				baoJia.getRkjl().getKuCun().setKcid(rst.getInt("kcid"));
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
				
				baoJia.getRkjl().getKuCun().setKclx(rst.getString("kclx"));
				baoJia.getRkjl().getKuCun().setWllx(rst.getString("wllx"));  
				baoJia.getSgd().setCphm(rst.getString("cphm"));
				return baoJia;
			}
		});
	}
	
	
	//查询退料物料单  
	@SuppressWarnings("unchecked")
	public List<BaoJia> queryTuiliaoList(String gdid) throws Exception{
		String sql =" SELECT a.* , b.danhao danhao , b.clpp clpp , b.clxh clxh, b.cjh cjh, b.khlx  khlx , c.kcid kcid FROM BJGL a , SGDGL b , rkjl c  "
				+ " WHERE a.bjzt=5 AND a.gdid = b.gdid AND a.rkid = c.rkid AND a.gdid ="+gdid;
		
		sql += "  ORDER BY BJZT DESC ";
		return this.getJdbcTemplate().query( sql,new BaoJia(){
			public BaoJia mapRow(ResultSet rst, int rowNum) throws SQLException {
				BaoJia baoJia = new BaoJia();
				baoJia.setBjid(rst.getInt("bjid"));
				baoJia.getSgd().setGdid(rst.getInt("gdid"));
				baoJia.getRkjl().setRkid(rst.getInt("rkid"));
				baoJia.getCkgl().setCkid(rst.getInt("ckid"));
				baoJia.getRkjl().getKuCun().setKcid(rst.getInt("kcid"));
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
				
				return baoJia;
			}
		});
	}
	
	
	
	
	//查询请求报料工单
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryBaoliaoSGDList(Object[] objs , Page page) throws Exception{
		String sql =" SELECT * FROM SGDGL WHERE 1=1 AND WLZT=0  ";
		List<Object> list = new ArrayList<Object>();
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and danhao =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and cphm like ? ";
				list.add("%" +objs[1] + "%" );
			}
		}
		sql += "  ORDER BY GDID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
	}
	
	
	//查询请求报价工单
		@SuppressWarnings("unchecked")
		public List<ShiGongDan> queryBaoJiaSGDList(Object[] objs , Page page) throws Exception{
			String sql =" SELECT * FROM SGDGL WHERE 1=1 AND WLZT=1  ";
			List<Object> list = new ArrayList<Object>();
			if(null!=objs&&objs.length>0){
				if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
					sql +=" and danhao =? ";
					list.add(objs[0]);
				}
				if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
					sql +=" and cphm like ? ";
					list.add("%" +objs[1] + "%" );
				}
			}
			sql += "  ORDER BY GDID DESC ";
			return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
		}
		
		
	//查询请求备料工单
			@SuppressWarnings("unchecked")
			public List<ShiGongDan> queryBeiLiaoSGDList(Object[] objs , Page page) throws Exception{
				String sql =" SELECT * FROM SGDGL WHERE 1=1 AND WLZT=3";
				List<Object> list = new ArrayList<Object>();
				if(null!=objs&&objs.length>0){
					if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
						sql +=" and danhao =? ";
						list.add(objs[0]);
					}
					if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
						sql +=" and cphm like ? ";
						list.add("%" +objs[1] + "%" );
					}
				}
				sql += "  ORDER BY GDID DESC ";
				return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
			}
	
			
	//查询领料工单
			@SuppressWarnings("unchecked")
			public List<ShiGongDan> queryLingLiaoSGDList(Object[] objs , Page page) throws Exception{
				String sql =" SELECT * FROM SGDGL WHERE 1=1 AND  WLZT=4";
			//	String sql =" SELECT * FROM SGDGL WHERE 1=1 AND WLZT=3 or  WLZT=4";
				List<Object> list = new ArrayList<Object>();
				if(null!=objs&&objs.length>0){
					if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
						sql +=" and danhao =? ";
						list.add(objs[0]);
					}
					if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
						sql +=" and cphm like ? ";
						list.add("%" +objs[1] + "%" );
					}
				}
				sql += "  ORDER BY GDID DESC ";
				return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
			}
			
			
			
			//查询工单补料
			@SuppressWarnings("unchecked")
			public List<ShiGongDan> queryBuliaoSGDList(Object[] objs , Page page) throws Exception{
				String sql =" SELECT * FROM SGDGL WHERE 1=1 AND  WLZT!=0  AND WXZT=1 OR  WXZT=2 ";
				List<Object> list = new ArrayList<Object>();
				if(null!=objs&&objs.length>0){
					if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
						sql +=" and danhao =? ";
						list.add(objs[0]);
					}
					if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
						sql +=" and cphm like ? ";
						list.add("%" +objs[1] + "%" );
					}
				}
				sql += "  ORDER BY GDID DESC ";
				return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
			}
	
	
	
	

		
	/**
	 *新增报料(请求报价)
	 */
	public int modifyBaoliaoForSave(BaoJia baoJia) throws Exception {
		final String sql = "insert into bjgl (gdid , wlmc , shuliang , wlzl , bjrq , bjzt )  values ( ? , ? , ? , ? , ? , ? )";
		final Object[] objs = {baoJia.getSgd().getGdid() , baoJia.getWlmc() , baoJia.getShuliang() , baoJia.getWlzl() ,baoJia.getBjrq() , baoJia.getBjzt() };
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
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
	 *修改物料费,工时费(进行报价)
	 */
	public void modifyBaojiaForUpdate(BaoJia baoJia) throws Exception {
		String sql = " update bjgl set  danjia=? , gsf=? , bjzt=? where bjid=? " ;
		Object[] objs =  { baoJia.getDanjia() , baoJia.getGsf() , baoJia.getBjzt() , baoJia.getBjid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	/**
	 *修改是否要货(请求备货)
	 */
	public void modifyBeiLiaoForUpdate(BaoJia baoJia) throws Exception {
		String sql = " update bjgl set bjzt =? ,  fhrq=? , sfyh=? where bjid=? " ;
		Object[] objs =  { baoJia.getBjzt(), baoJia.getFhrq() , baoJia.getSfyh() , baoJia.getBjid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *修改备料状态(备料到货)
	 */
	public void modifyBeiLiaoDoneForUpdate(BaoJia baoJia) throws Exception {
		String sql = " update bjgl set rkid=? , bjzt=? , rkrq=? where bjid=? " ;
		Object[] objs =  { baoJia.getRkjl().getRkid(), baoJia.getBjzt(),  baoJia.getRkrq() , baoJia.getBjid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	/**
	 *修改领料状态(领料出库)
	 */
	public void modifyLingliaoForUpdate(BaoJia baoJia) throws Exception {
		String sql = " update bjgl set  ckid=? ,  bjzt=? , llrq=? where bjid=? " ;
		Object[] objs =  {baoJia.getCkgl().getCkid() , baoJia.getBjzt() , baoJia.getLlrq() , baoJia.getBjid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	
	/**
	 *修改当前库存数量(减少库存)
	 */
	public void modifyShuliangForUpdateSubtract (BaoJia baoJia) throws Exception {
		String sql = " update kcgl set dqsl=dqsl-? where kcid=? " ;	 
		Object[] objs =  { baoJia.getShuliang() , baoJia.getRkjl().getKuCun().getKcid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	/**
	 *修改当前库存数量(增加库存)
	 */
	public void modifyShuliangForUpdateAdd (String shuliang , String kcid) throws Exception {
		String sql = " update kcgl set dqsl=dqsl+? where kcid=? " ;	 
		Object[] objs =  { shuliang , kcid};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	

	/**
	 *添加出库信息
	 */
	public int modifyCkglForSave(Ckgl ckgl) throws Exception {
		final String sql = "insert into ckgl ( rkid , cphm , ckrq , cksl , wlmc , wllx , kclx , remark ) values ( ? , ? , ? , ? , ? , ? , ? , ? )";
		final Object[] objs = { ckgl.getRkjl().getRkid() , ckgl.getCphm(), ckgl.getCkrq() , ckgl.getCksl() , ckgl.getWlmc() , ckgl.getWllx() , ckgl.getKclx() , ckgl.getRemark() };
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
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
	 *删除出库信息
	 */
	public void modifyCkglForDelete(String ckid)throws Exception{
		String sql= "delete from ckgl where ckid="+ckid ;
		this.getJdbcTemplate().update(sql);
	}
	
	
	/**
	 *修改施工单物料状态 
	 */
	public void modifySGDWlztForUpdate(String wlzt , String gdid) throws Exception {
		String sql = " update SGDGL set  wlzt=?  where gdid=? " ;
		Object[] objs =  { wlzt , gdid};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	/**
	 *修改施工单总费用
	 */
	public void modifySGDZfyForUpdate(String zfy , String gdid) throws Exception {
		String sql = " update SGDGL set  zfy=?  where gdid=? " ;
		Object[] objs =  { zfy , gdid};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *修改施工单维修状态
	 */
	public void editSGDWxzt(String wxzt , String gdid) throws Exception {
		String sql = " update SGDGL set  wxzt=?  where gdid=? " ;
		Object[] objs =  { wxzt , gdid};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
 
	@SuppressWarnings("unchecked")
	public BaoJia queryWlmcByID(String bjid) throws Exception {
		String sql = " select * from bjgl where bjid =" +bjid;
		List<BaoJia> baojiaList = this.getJdbcTemplate().query(sql, new BaoJia(){
			public BaoJia mapRow(ResultSet rst, int rowNum) throws SQLException {
				BaoJia baoJia = new BaoJia();
				baoJia.setBjid(rst.getInt("bjid"));
				baoJia.getSgd().setGdid(rst.getInt("gdid"));
				baoJia.getRkjl().setRkid(rst.getInt("rkid"));
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
				return baoJia;
			}
		});
		if(baojiaList!=null&&baojiaList.size()>0){
			return baojiaList.get(0);
		}
		return null;
	}
	
	
	/**
	 *修改物料名称
	 */
	public void modifyWlmcForUpdate(BaoJia baoJia) throws Exception {
		String sql = " update bjgl set  wlmc=?  where bjid=? " ;
		Object[] objs =  { baoJia.getWlmc() , baoJia.getBjid() };
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	/**
	 *删除报价信息
	 */
	public void modifyBaoJiaForDelete(String bjid)throws Exception{
		String sql= "delete from bjgl where bjid="+bjid ;
		this.getJdbcTemplate().update(sql);
	}
	
	

}
