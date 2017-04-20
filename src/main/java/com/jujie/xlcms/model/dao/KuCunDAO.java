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
import com.jujie.xlcms.struts.bean.Ckgl;
import com.jujie.xlcms.struts.bean.Ghsgl;
import com.jujie.xlcms.struts.bean.KuCun;
import com.jujie.xlcms.struts.bean.Rkjl;
import com.jujie.xlcms.struts.bean.Thgl;

public class KuCunDAO extends SpringJDBCTemplate{
	
	@SuppressWarnings("unchecked")
	public List<KuCun> queryKuCunList(Object[] objs, Page page  , String kclx) throws Exception{
		String sql =" SELECT *  FROM KCGL    WHERE  1=1 AND kclx ="+kclx;
		List<Object> list = new ArrayList<Object>();
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and wlmc like ? ";
				list.add("%" +objs[0] + "%" );
			}
			if(objs.length>=2&&null!=objs[1]&&!"0".equals(objs[1])){
				sql +=" and wllx =? ";
				list.add(objs[1]);
			}
		}
		sql += "  ORDER BY KCID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new KuCun(){
			public KuCun mapRow(ResultSet rst, int rowNum) throws SQLException {
				KuCun kuCun = new KuCun();
				kuCun.setKcid(rst.getInt("kcid"));
				kuCun.setClpp(rst.getString("clpp"));
				kuCun.setClxh(rst.getString("clxh"));
				kuCun.setWlmc(rst.getString("wlmc"));
				kuCun.setWllx(rst.getString("wllx"));
				kuCun.setDqsl(rst.getString("dqsl"));
				kuCun.setHuowei(rst.getString("huowei"));
				kuCun.setRemark(rst.getString("remark"));
				return kuCun;
			}
		});
	}
	
	
	/**
	 *新增
	 */
	public int modifyKuCunForSave(Rkjl rkjl) throws Exception {
		final String sql = "insert into kcgl ( "
				+ " clpp,clxh,wlmc,wllx,"
				+ " dqsl,huowei,kclx,remark ) "
				+ " values (? , ? , ? , ? , ? , ? , ? , ? )";
		final Object[] objs = { rkjl.getKuCun().getClpp(), rkjl.getKuCun().getClxh(),rkjl.getKuCun().getWlmc(),rkjl.getKuCun().getWllx(),
				rkjl.getKuCun().getDqsl(),rkjl.getKuCun().getHuowei(),rkjl.getKuCun().getKclx(),rkjl.getKuCun().getRemark()};
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
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	/**
	 *出入库时修改当前数量修改
	 */
	public void modifyKuCunDqslForUpdate(Rkjl rkjl) throws Exception {
		String sql = " update kcgl set  dqsl=?  where kcid=? " ;
		Object[] objs =  { rkjl.getKuCun().getDqsl() , rkjl.getKuCun().getKcid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	//修改库存信息
	public void modifyRkjlForUpdate(Rkjl rkjl) throws Exception {
		String sql = " update rkjl set bcsl=?, danjia=? , ghsid=? , wlzl = ? , remark=?  where rkid=? " ;
		Object[] objs =  { rkjl.getBcsl() , rkjl.getDanjia() , rkjl.getGhs().getGhsid() , rkjl.getWlzl() , rkjl.getRemark() , rkjl.getRkid() };
		this.getJdbcTemplate().update(sql,objs);   
	}
	

	// 退货修改库存数量  
	public void modifyThglForUpdate(Rkjl rkjl , String thsl) throws Exception{
		 String[] sqls = new String[2];
	 
		  sqls[0] = " update kcgl set dqsl=dqsl-"+thsl+" where kcid="+rkjl.getKuCun().getKcid();
		 //不修改入库数量
		  // sqls[1] = " update rkjl set  bcsl=bcsl-"+thsl+"  where rkid="+rkjl.getRkid() ;
		this.getJdbcTemplate().batchUpdate(sqls);
	}
	
 
	//出库后修改库存表  油漆辅料出库记录专用
	public void modifyShuliangForUpdate(Ckgl ckgl) throws Exception {
		String sql = " update kcgl set dqsl=dqsl-? where kcid=? " ;	 
		Object[] objs =  { ckgl.getCksl() , ckgl.getRkjl().getKuCun().getKcid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	//修改记录的时候用来修改库存数量
	public void modifyJiLuShuliangForUpdate(Rkjl rkjl , String scsl) throws Exception {
		String[] sqls = new String[2];
		  sqls[0] = " update kcgl set dqsl=dqsl-"+scsl.trim()+" where kcid="+rkjl.getKuCun().getKcid();	 
		  sqls[1] = " update kcgl set dqsl=dqsl+"+rkjl.getBcsl().trim()+" where kcid="+rkjl.getKuCun().getKcid() ;	 
		this.getJdbcTemplate().batchUpdate(sqls);   
	}
	
	
	//插入入库记录
	public int modifyRkjlForSave(Rkjl rkjl) throws Exception {
		final String sql = "insert into rkjl ( kcid , ghsid , rkrq , bcsl , danjia  , wlzl , sfzf) values ( ? , ? , ? , ? , ? , ? , ? )";
		final Object[] objs = { rkjl.getKuCun().getKcid() , rkjl.getGhs().getGhsid() , rkjl.getRkrq() , rkjl.getBcsl() ,rkjl.getDanjia() , rkjl.getWlzl() , 1 };
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public KuCun queryKuCunByID(String kcid) throws Exception{
		String sql = " select * from kcgl where kcid =" +kcid;
		List<KuCun> kuCunList = this.getJdbcTemplate().query(sql, new KuCun(){
			public KuCun mapRow(ResultSet rst, int rowNum) throws SQLException {
				KuCun kuCun = new KuCun();
				kuCun.setKcid(rst.getInt("kcid"));
				kuCun.setClpp(rst.getString("clpp"));
				kuCun.setClxh(rst.getString("clxh"));
				kuCun.setWlmc(rst.getString("wlmc"));
				kuCun.setWllx(rst.getString("wllx"));
				kuCun.setDqsl(rst.getString("dqsl"));
				kuCun.setHuowei(rst.getString("huowei"));
				kuCun.setKclx(rst.getString("kclx"));
				kuCun.setRemark(rst.getString("remark"));
				return kuCun;
			}
		});
		if(kuCunList!=null&&kuCunList.size()>0){
			return kuCunList.get(0);
		}
		return null;
	}
 
		
	
	 //查询入库记录
	@SuppressWarnings("unchecked")
	public List<Rkjl> queryRkjlList(String kcid) throws Exception{
		String sql ="SELECT a.* , b.name ghsname  FROM rkjl a , ghsgl b WHERE a.ghsid = b.ghsid AND kcid ="+kcid;
		
		sql += "  ORDER BY RKID DESC ";
		return this.getJdbcTemplate().query( sql,new Rkjl());
	}
	
	
	//查询入库记录
	@SuppressWarnings("unchecked")
	public Rkjl queryRkjlByID(String rkid) throws Exception{
		String sql = " SELECT a.* , b.name ghsname FROM rkjl a , ghsgl b WHERE a.ghsid = b.ghsid AND rkid =" +rkid;
		List<Rkjl> rkjlList = this.getJdbcTemplate().query(sql, new Rkjl());
		if(rkjlList!=null&&rkjlList.size()>0){
			return rkjlList.get(0);
		}
		return null;
	}

	
	//查询油漆辅料出库列表
	@SuppressWarnings("unchecked")
	public List<Ckgl> queryCkglList(Object[] objs, Page page , String tag ,String kcid) throws Exception{
		String sql =" SELECT  c.*  FROM  CKGL c  , RKJL  r    WHERE  1=1  AND c.rkid=r.rkid ";
		
		if(null!=tag&&"yfck".equals(tag)){
			sql +=" and c.kclx=2 ";
		}else{
			sql +=" and c.kclx!=2 ";
		}
		
		List<Object> list = new ArrayList<Object>();
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and c.cphm =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and c.wlmc =? ";
				list.add(objs[1]);
			}
			if(objs.length>=3&&null!=objs[2]&&!"".equals(objs[2])){
				sql +=" and c.remark =? ";
				list.add(objs[2]);
			}
		}
		
		if(null!=kcid&&!"".equals(kcid)){
			sql +=" and r.kcid ="+kcid;
		}
		
		sql += "  ORDER BY ckid DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Ckgl());
	}
	
	
	
	//查询退货记录
	@SuppressWarnings("unchecked")
	public List<Thgl> queryThglList(String kcid) throws Exception{
			String sql ="SELECT  b.*  FROM rkjl a , thgl b WHERE a.rkid  = b.rkid  AND a.kcid ="+kcid;
		
		sql += "  ORDER BY b.thid DESC ";
		return this.getJdbcTemplate().query(sql , new Thgl());
	}
	
	 
 
	//插入退货记录
	public int modifyThglForSave(Thgl thgl) throws Exception {
		final String sql = "insert into thgl ( rkid , thrq , bcsl , danjia , ghs , wlzl , remark ) values ( ? , ? , ? , ? , ? , ? , ? )";
		final Object[] objs = { thgl.getRkid(), thgl.getThrq(), thgl.getBcsl(), thgl.getDanjia(), thgl.getGhs(), thgl.getWlzl(), thgl.getRemark() };
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
					pst.setInt(++i, DataUtil.toInt(objs[n++]));  
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	
	
	//插入油漆辅料出库记录
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

	
	//获取供货商List
	@SuppressWarnings("unchecked")
	public List<Ghsgl> queryGhsglList() throws Exception{
		String sql =" select * from ghsgl ";
		return this.getJdbcTemplate().query(sql, new Ghsgl());
	}
	
	
	
	
	
	
	
	
	
	//自动补全
	@SuppressWarnings("unchecked")
	public List<Rkjl> queryKuCunListAuto(String q) throws Exception {
		final String sql = " SELECT DISTINCT  a.* , b.rkid rkid , b.ghsid ghsid , b.wlzl wlzl ,  b.rkrq rkrq , c.name ghsname   FROM rkjl b , kcgl a , ghsgl c "
				+ " WHERE a.dqsl>0  AND  a.kclx!=2  AND a.kcid= b.kcid AND b.ghsid=c.ghsid AND a.wlmc LIKE  '%"+q+"%' "
				+ " GROUP  BY a.kcid ORDER BY a.kcid DESC ";
		List<Rkjl> rkjlList = new ArrayList<Rkjl>();
		rkjlList = this.getJdbcTemplate().query(sql,new Rkjl(){
			public Rkjl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Rkjl rkjl = new Rkjl();
				rkjl.getKuCun().setKcid(rst.getInt("kcid"));
				rkjl.getKuCun().setClpp(rst.getString("clpp"));
				rkjl.getKuCun().setClxh(rst.getString("clxh"));
				rkjl.getKuCun().setWlmc(rst.getString("wlmc"));
				rkjl.getKuCun().setWllx(rst.getString("wllx"));
				rkjl.getKuCun().setDqsl(rst.getString("dqsl"));
				rkjl.getKuCun().setHuowei(rst.getString("huowei"));
				rkjl.getKuCun().setRemark(rst.getString("remark"));
				rkjl.getGhs().setGhsid(rst.getInt("ghsid"));
				rkjl.getGhs().setName(rst.getString("ghsname"));
				rkjl.setWlzl(rst.getString("wlzl"));
				rkjl.setRkrq(rst.getString("rkrq"));
				rkjl.setRkid(rst.getInt("rkid"));
				return rkjl;
			}
		});
		return rkjlList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Rkjl> queryKuCunWlmcListAuto(String q) throws Exception {
		final String sql = " SELECT DISTINCT  a.* , b.ghsid ghsid , c.name ghsname , b.wlzl wlzl  FROM rkjl b , kcgl a , ghsgl c "
				+ " WHERE   a.kclx!=2  AND a.kcid= b.kcid AND b.ghsid = c.ghsid AND a.wlmc LIKE '%"+q+"%'  ORDER BY a.kcid DESC";
		List<Rkjl> rkjlList = new ArrayList<Rkjl>();
		rkjlList = this.getJdbcTemplate().query(sql,new Rkjl(){
			public Rkjl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Rkjl rkjl = new Rkjl();
				rkjl.getKuCun().setKcid(rst.getInt("kcid"));
				rkjl.getKuCun().setClpp(rst.getString("clpp"));
				rkjl.getKuCun().setClxh(rst.getString("clxh"));
				rkjl.getKuCun().setWlmc(rst.getString("wlmc"));
				rkjl.getKuCun().setWllx(rst.getString("wllx"));
				rkjl.getKuCun().setDqsl(rst.getString("dqsl"));
				rkjl.getKuCun().setHuowei(rst.getString("huowei"));
				rkjl.getKuCun().setRemark(rst.getString("remark"));
				rkjl.getGhs().setGhsid(rst.getInt("ghsid"));
				rkjl.getGhs().setName(rst.getString("ghsname"));
				rkjl.setWlzl(rst.getString("wlzl"));
				
				return rkjl;
			}
		});
		return rkjlList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Rkjl> queryKuCunTYListAuto(String q) throws Exception {
		final String sql = "SELECT DISTINCT  a.* , b.ghsid ghsid , c.name ghsname , b.wlzl wlzl   FROM rkjl b , kcgl a , ghsgl c "
				+ " WHERE a.kclx=1 AND a.kcid= b.kcid AND b.ghsid=c.ghsid AND a.wlmc LIKE '%"+q+"%'  ORDER BY a.kcid DESC";
		List<Rkjl> rkjlList = new ArrayList<Rkjl>();
		rkjlList = this.getJdbcTemplate().query(sql,new Rkjl(){
			public Rkjl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Rkjl rkjl = new Rkjl();
				rkjl.getKuCun().setKcid(rst.getInt("kcid"));
				rkjl.getKuCun().setClpp(rst.getString("clpp"));
				rkjl.getKuCun().setClxh(rst.getString("clxh"));
				rkjl.getKuCun().setWlmc(rst.getString("wlmc"));
				rkjl.getKuCun().setWllx(rst.getString("wllx"));
				rkjl.getKuCun().setDqsl(rst.getString("dqsl"));
				rkjl.getKuCun().setHuowei(rst.getString("huowei"));
				rkjl.getKuCun().setRemark(rst.getString("remark"));
				rkjl.getGhs().setGhsid(rst.getInt("ghsid"));
				rkjl.getGhs().setName(rst.getString("ghsname"));
				rkjl.setWlzl(rst.getString("wlzl"));
				
				return rkjl;
			}
		});
		return rkjlList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Rkjl> queryKuCunYFListAuto(String q) throws Exception {
		final String sql = "SELECT DISTINCT  a.* , b.ghsid ghsid , c.name ghsname , b.wlzl wlzl   FROM rkjl b , kcgl a , ghsgl c "
				+ " WHERE a.kclx=2 AND a.kcid= b.kcid AND b.ghsid= c.ghsid AND a.wlmc LIKE '%"+q+"%'  ORDER BY a.kcid DESC";
		List<Rkjl> rkjlList = new ArrayList<Rkjl>();
		rkjlList = this.getJdbcTemplate().query(sql,new Rkjl(){
			public Rkjl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Rkjl rkjl = new Rkjl();
				rkjl.getKuCun().setKcid(rst.getInt("kcid"));
				rkjl.getKuCun().setClpp(rst.getString("clpp"));
				rkjl.getKuCun().setClxh(rst.getString("clxh"));
				rkjl.getKuCun().setWlmc(rst.getString("wlmc"));
				rkjl.getKuCun().setWllx(rst.getString("wllx"));
				rkjl.getKuCun().setDqsl(rst.getString("dqsl"));
				rkjl.getKuCun().setHuowei(rst.getString("huowei"));
				rkjl.getKuCun().setRemark(rst.getString("remark"));
				rkjl.getGhs().setGhsid(rst.getInt("ghsid"));
				rkjl.getGhs().setName(rst.getString("ghsname"));
				rkjl.setWlzl(rst.getString("wlzl"));
				
				return rkjl;
			}
		});
		return rkjlList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Rkjl> queryKuCunZYListAuto(String q) throws Exception {
		final String sql = "SELECT DISTINCT  a.* , b.ghsid ghsid , c.name ghsname , b.wlzl wlzl  FROM rkjl b , kcgl a , ghsgl c  "
				+ " WHERE a.kclx=3 AND a.kcid= b.kcid AND b.ghsid=c.ghsid AND a.clxh LIKE '%"+q+"%'  ORDER BY a.kcid DESC";
		List<Rkjl> rkjlList = new ArrayList<Rkjl>();
		rkjlList = this.getJdbcTemplate().query(sql,new Rkjl(){
			public Rkjl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Rkjl rkjl = new Rkjl();
				rkjl.getKuCun().setKcid(rst.getInt("kcid"));
				rkjl.getKuCun().setClpp(rst.getString("clpp"));
				rkjl.getKuCun().setClxh(rst.getString("clxh"));
				rkjl.getKuCun().setWlmc(rst.getString("wlmc"));
				rkjl.getKuCun().setWllx(rst.getString("wllx"));
				rkjl.getKuCun().setDqsl(rst.getString("dqsl"));
				rkjl.getKuCun().setHuowei(rst.getString("huowei"));
				rkjl.getKuCun().setRemark(rst.getString("remark"));
				rkjl.getGhs().setGhsid(rst.getInt("ghsid"));
				rkjl.getGhs().setName(rst.getString("ghsname"));
				rkjl.setWlzl(rst.getString("wlzl"));
				
				return rkjl;
			}
		});
		return rkjlList;
	}
	
	
	 
	
	@SuppressWarnings("unchecked")
	public List<Rkjl> queryCkglListAuto(String q) throws Exception {
		final String sql = "SELECT DISTINCT  a.* ,  b.rkid rkid  ,  b.ghsid ghsid , c.name ghsname , b.wlzl wlzl   FROM rkjl b , kcgl a , ghsgl c "
				+ " WHERE a.dqsl>0 AND a.kclx=2 AND a.kcid= b.kcid AND b.ghsid=c.ghsid AND a.wlmc LIKE  '%"+q+"%' "
				+ " GROUP  BY a.kcid  ORDER BY a.kcid DESC";
		List<Rkjl> rkjlList = new ArrayList<Rkjl>();
		rkjlList = this.getJdbcTemplate().query(sql,new Rkjl(){
			public Rkjl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Rkjl rkjl = new Rkjl();
				rkjl.getKuCun().setKcid(rst.getInt("kcid"));
				rkjl.getKuCun().setClpp(rst.getString("clpp"));
				rkjl.getKuCun().setClxh(rst.getString("clxh"));
				rkjl.getKuCun().setWlmc(rst.getString("wlmc"));
				rkjl.getKuCun().setWllx(rst.getString("wllx"));
				rkjl.getKuCun().setDqsl(rst.getString("dqsl"));
				rkjl.getKuCun().setHuowei(rst.getString("huowei"));
				rkjl.getKuCun().setRemark(rst.getString("remark"));
				rkjl.getGhs().setGhsid(rst.getInt("ghsid"));
				rkjl.getGhs().setName(rst.getString("ghsname"));
				rkjl.setWlzl(rst.getString("wlzl"));
				rkjl.setRkid(rst.getInt("rkid"));
				return rkjl;
			}
		});
		return rkjlList;
	}
	
	

}
