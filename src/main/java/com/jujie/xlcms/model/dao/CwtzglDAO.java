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
import com.jujie.xlcms.struts.bean.Cwtzgl;
import com.jujie.xlcms.struts.bean.Ghsgl;
import com.jujie.xlcms.struts.bean.Rkjl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class CwtzglDAO extends SpringJDBCTemplate{
	
	
	/**
	 * 
	 * 营业收入
	 * */
	//查询营业收入
	@SuppressWarnings("unchecked")
	public List<ShiGongDan> queryShiGongDanList(Object[] objs , Page page , String gddjrqb , String gddjrqe) throws Exception{
		String sql =" SELECT * FROM SGDGL WHERE 1=1 AND  DANHAO  IS NOT NULL AND wxzt IN (2,3,4,5,6) ";
		if(null!=gddjrqb&&null!=gddjrqe&&!"".equals(gddjrqb)&&!"".equals(gddjrqe)){
			sql +="  and gddjrq BETWEEN '"+gddjrqb+"' AND '" + gddjrqe +"'";
		}
		
		List<Object> list = new ArrayList<Object>();
		
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and wxzt =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and wxlx =? ";
				list.add(objs[1]);
			}
		}

		sql += "  ORDER BY GDID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new ShiGongDan());
	}
	
	
	
	//统计-- 查询一般客户应收实收
	@SuppressWarnings("unchecked")
	public  Cwtzgl queryYBSR(ShiGongDan sgd , String gddjrqb , String gddjrqe) throws Exception{
		String sql = " SELECT SUM(zfy) ybzfy  ,  SUM(sjzfy) ybsjzfy FROM SGDGL WHERE 1=1 AND  DANHAO  IS NOT NULL AND wxzt IN (2,3,4,5,6)  AND khlx IN (1,3,5,6) ";
		if(null!=gddjrqb&&null!=gddjrqe&&!"".equals(gddjrqb)&&!"".equals(gddjrqe)){
			sql +="  and gddjrq BETWEEN '"+gddjrqb+"' AND '" + gddjrqe +"'";
		}
		if(null!=sgd&&!"0".equals(sgd.getWxzt())){
			sql += " and wxzt="+sgd.getWxzt();
		}
		if(null!=sgd&&!"0".equals(sgd.getWxlx())){
			sql += " and wxlx="+sgd.getWxlx();
		}
		List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl(){
			public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Cwtzgl cwtzgl = new Cwtzgl();
				cwtzgl.setYbzfy(rst.getInt("ybzfy"));
				cwtzgl.setYbsjzfy(rst.getInt("ybsjzfy"));
				return cwtzgl;
			}
		});
		if(cwtzglList!=null&&cwtzglList.size()>0){
			return cwtzglList.get(0);
		}
		return null;
	}
	//统计-- 查询快赔客户应收实收
	@SuppressWarnings("unchecked")
	public  Cwtzgl queryKPSR(ShiGongDan sgd , String gddjrqb , String gddjrqe) throws Exception{
		String sql = " SELECT SUM(zfy) kpzfy  ,  SUM(sjzfy) kpsjzfy FROM SGDGL WHERE 1=1 AND  DANHAO  IS NOT NULL AND wxzt IN (2,3,4,5,6)  AND khlx=2 ";
		if(null!=gddjrqb&&null!=gddjrqe&&!"".equals(gddjrqb)&&!"".equals(gddjrqe)){
			sql +="  and gddjrq BETWEEN '"+gddjrqb+"' AND '" + gddjrqe +"'";
		}
		if(null!=sgd&&!"0".equals(sgd.getWxzt())){
			sql += " and wxzt="+sgd.getWxzt();
		}
		if(null!=sgd&&!"0".equals(sgd.getWxlx())){
			sql += " and wxlx="+sgd.getWxlx();
		}
		List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl(){
			public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Cwtzgl cwtzgl = new Cwtzgl();
				cwtzgl.setKpzfy(rst.getInt("kpzfy"));
				cwtzgl.setKpsjzfy(rst.getInt("kpsjzfy"));
				return cwtzgl;
			}
		});
		if(cwtzglList!=null&&cwtzglList.size()>0){
			return cwtzglList.get(0);
		}
		return null;
	}
	//统计-- 查询协议单位应收实收
	@SuppressWarnings("unchecked")
	public  Cwtzgl queryXYSR(ShiGongDan sgd , String gddjrqb , String gddjrqe) throws Exception{
		String sql = " SELECT SUM(zfy) xyzfy  ,  SUM(sjzfy) xysjzfy FROM SGDGL WHERE 1=1 AND  DANHAO  IS NOT NULL AND wxzt IN (2,3,4,5,6)  AND khlx=4 ";
		if(null!=gddjrqb&&null!=gddjrqe&&!"".equals(gddjrqb)&&!"".equals(gddjrqe)){
			sql +="  and gddjrq BETWEEN '"+gddjrqb+"' AND '" + gddjrqe +"'";
		}
		if(null!=sgd&&!"0".equals(sgd.getWxzt())){
			sql += " and wxzt="+sgd.getWxzt();
		}
		if(null!=sgd&&!"0".equals(sgd.getWxlx())){
			sql += " and wxlx="+sgd.getWxlx();
		}
		List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl(){
			public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Cwtzgl cwtzgl = new Cwtzgl();
				cwtzgl.setXyzfy(rst.getInt("xyzfy"));
				cwtzgl.setXysjzfy(rst.getInt("xysjzfy"));
				return cwtzgl;
			}
		});
		if(cwtzglList!=null&&cwtzglList.size()>0){
			return cwtzglList.get(0);
		}
		return null;
	}
				
	
	
	/**
	 * 
	 * 其他收入
	 * */
	//查询其他收入 明细
	@SuppressWarnings("unchecked")
	public List<Cwtzgl> queryCwtzglListQTSR(Object[] objs , Page page , String bfsdate , String efsdate) throws Exception{
		String sql =" SELECT * FROM CWTZGL WHERE 1=1  and  sztype=0 ";
		List<Object> list = new ArrayList<Object>();
		if(null!=bfsdate&&null!=efsdate&&!"".equals(bfsdate)&&!"".equals(efsdate)){
			sql +="  and fsdate BETWEEN '"+bfsdate+"' AND '" + efsdate +"'";
		}
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and kmname like ? ";
				list.add("%" +objs[0] + "%" );
			}
		}
		sql += "  ORDER BY CWID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Cwtzgl());
	}
	
	//统计 查询其他收入统计金额
	@SuppressWarnings("unchecked")
	public Cwtzgl queryQTSR(Cwtzgl cwtzgl ,  String bfsdate , String efsdate) throws Exception{
		String sql = " SELECT SUM(jine) qtsr FROM cwtzgl WHERE sztype=0 " ;
		if(null!=cwtzgl&&!"".equals(cwtzgl)){
			sql+=" and kmname like '%"+cwtzgl.getKmname()+"%'";
		}
		if(null!=bfsdate&&null!=efsdate&&!"".equals(bfsdate)&&!"".equals(efsdate)){
			sql +="  and fsdate BETWEEN '"+bfsdate+"' AND '" + efsdate +"'";
		}
		List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl(){
			public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Cwtzgl cwtzgl = new Cwtzgl();
				cwtzgl.setQtsr(rst.getInt("qtsr"));
				return cwtzgl;
			}
		});
		if(cwtzglList!=null&&cwtzglList.size()>0){
			return cwtzglList.get(0);
		}
		return null;
	}
	
	
	//查找一个
	@SuppressWarnings("unchecked")
	public Cwtzgl queryCwtzglByID(String cwid) throws Exception{
		String sql ="select * from CWTZGL where 1=1 and cwid="+cwid;
		List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl());
		if(cwtzglList!=null&&cwtzglList.size()>0){
			return cwtzglList.get(0);
		}
		return null;
	}
	
	//新增
	public int modifyCwtzglForSave(Cwtzgl cwtzgl) throws Exception{
		final String sql = "insert into cwtzgl ( jine , zhaiyao , kmname , kmtype , sztype , fsdate , remark )values( ? , ? , ? , ? , ? , ? , ? )";
		final Object[] objs = { cwtzgl.getJine() , cwtzgl.getZhaiyao() , cwtzgl.getKmname() , cwtzgl.getKmtype() , cwtzgl.getSztype() , cwtzgl.getFsdate() , cwtzgl.getRemark() };
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
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	//修改
	public void modifyCwtzglFroUpdate(Cwtzgl cwtzgl) throws Exception{
		String sql = "update cwtzgl set jine=? , zhaiyao=? , kmname=? , kmtype=? ,  fsdate=? , remark=? where cwid=?"; 
		Object[] objs= { cwtzgl.getJine() , cwtzgl.getZhaiyao() , cwtzgl.getKmname() , cwtzgl.getKmtype() ,  cwtzgl.getFsdate() , cwtzgl.getRemark() , cwtzgl.getCwid() };
		this.getJdbcTemplate().update(sql, objs);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 营业支出    
	 * */
	
	//获取供货商List
	@SuppressWarnings("unchecked")
	public List<Ghsgl> queryGhsglList() throws Exception{
		String sql =" select * from ghsgl ";
		return this.getJdbcTemplate().query(sql, new Ghsgl());
	}
	
	@SuppressWarnings("unchecked")
	public List<Rkjl> queryRkjlList(Object[] objs , Page page , String rkrqb , String rkrqe) throws Exception{
		String sql = " SELECT LJ.*, SUM(t.bcsl) thsl , t.danjia thdj FROM "
				+ "  (SELECT r.rkid , r.rkrq , k.wlmc  ,  r.danjia , r.bcsl  , g.name  , k.wllx  , r.sfzf  FROM  rkjl r , kcgl k , ghsgl g  WHERE   r.kcid = k.kcid AND r.ghsid = g.ghsid  AND wllx NOT IN (10)";
		if(null!=rkrqb&&null!=rkrqe&&!"".equals(rkrqb)&&!"".equals(rkrqe)){
			sql +="  and r.rkrq BETWEEN '"+rkrqb+"' AND '" + rkrqe +"'";
		}
		List<Object> list = new ArrayList<Object>();
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and g.ghsid =? ";
				list.add(objs[0]);
			}
			if(objs.length>=2&&null!=objs[1]&&!"".equals(objs[1])){
				sql +=" and r.sfzf =? ";
				list.add(objs[1]);
			}
		}
	 	sql += " ) LJ LEFT JOIN thgl t ON LJ.rkid = t.rkid  GROUP BY  LJ.rkid  ORDER BY LJ.rkid DESC";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Rkjl(){
			public Rkjl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Rkjl rkjl = new Rkjl();
				rkjl.setRkid(rst.getInt("rkid"));
				rkjl.setRkrq(rst.getString("rkrq"));
				rkjl.getKuCun().setWlmc(rst.getString("wlmc"));
				rkjl.setDanjia(rst.getString("danjia"));
				rkjl.setBcsl(rst.getString("bcsl"));
				rkjl.getGhs().setName(rst.getString("name"));
				rkjl.getKuCun().setWllx(rst.getString("wllx"));
				rkjl.setSfzf(rst.getInt("sfzf"));
				rkjl.setThdj(rst.getString("thdj"));
				rkjl.setThsl(rst.getString("thsl"));
				return rkjl;
			}
		});
	}
	
	
	//统计-- 营业支出应付(物料)
	@SuppressWarnings("unchecked")
	public Cwtzgl queryYYZCYF(Rkjl rkjl , String rkrqb , String rkrqe){
		String sql =" SELECT  SUM(LJ.danjia*LJ.bcsl)  - IFNULL(SUM(t.bcsl*t.danjia)  , 0)  yyzcyf  FROM ";
		   sql +=" (  SELECT r.danjia , r.bcsl , r.rkid    FROM  rkjl r , kcgl k , ghsgl g  WHERE   r.kcid = k.kcid AND r.ghsid = g.ghsid  AND wllx NOT IN (10) AND r.sfzf=1 ";
			if(null!=rkrqb&&null!=rkrqe&&!"".equals(rkrqb)&&!"".equals(rkrqe)){
				sql +="  and r.rkrq BETWEEN '"+rkrqb+"' AND '" + rkrqe +"'";
			}
			if(null!=rkjl&&0!=rkjl.getGhs().getGhsid()){
				sql +=" and g.ghsid="+rkjl.getGhs().getGhsid();
			}
			sql += " ) LJ  LEFT JOIN thgl t ON LJ.rkid = t.rkid ";
		 List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl(){
				public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
					Cwtzgl cwtzgl = new Cwtzgl();
					cwtzgl.setYyzcyf(rst.getInt("yyzcyf"));
					return cwtzgl;
				}
		 });
		 if(null!=cwtzglList&&cwtzglList.size()>0){
			 return cwtzglList.get(0);
		 }
		return null;
	}
	//统计-- 营业支出实付(物料)
	@SuppressWarnings("unchecked")
	public Cwtzgl queryYYZCSF(Rkjl rkjl , String rkrqb , String rkrqe){
		String sql =" SELECT  SUM(LJ.danjia*LJ.bcsl)  - IFNULL(SUM(t.bcsl*t.danjia)  , 0)  yyzcsf  FROM ";
		   sql +=" (  SELECT r.danjia , r.bcsl , r.rkid    FROM  rkjl r , kcgl k , ghsgl g  WHERE   r.kcid = k.kcid AND r.ghsid = g.ghsid  AND wllx NOT IN (10) AND r.sfzf=2 ";
			if(null!=rkrqb&&null!=rkrqe&&!"".equals(rkrqb)&&!"".equals(rkrqe)){
				sql +="  and r.rkrq BETWEEN '"+rkrqb+"' AND '" + rkrqe +"'";
			}
			if(null!=rkjl&&0!=rkjl.getGhs().getGhsid()){
				sql +=" and g.ghsid="+rkjl.getGhs().getGhsid();
			}
			sql += " ) LJ  LEFT JOIN thgl t ON LJ.rkid = t.rkid ";
		List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl(){
			public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
				Cwtzgl cwtzgl = new Cwtzgl();
				cwtzgl.setYyzcsf(rst.getInt("yyzcsf"));
				return cwtzgl;
			}
		});
		if(null!=cwtzglList&&cwtzglList.size()>0){
			return cwtzglList.get(0);
		}
		return null;
	}
	//统计-- 营业支出退货退款(物料)
		@SuppressWarnings("unchecked")
		public Cwtzgl queryZcth(Rkjl rkjl , String rkrqb , String rkrqe){
			String sql=" SELECT  SUM(t.danjia*t.bcsl)  zcth  FROM  rkjl r , thgl t , ghsgl g WHERE   r.rkid = t.rkid AND r.ghsid = g.ghsid ";
			if(null!=rkrqb&&null!=rkrqe&&!"".equals(rkrqb)&&!"".equals(rkrqe)){
				sql +="  and r.rkrq BETWEEN '"+rkrqb+"' AND '" + rkrqe +"'";
			}
			if(null!=rkjl&&0!=rkjl.getGhs().getGhsid()){
				sql +=" and g.ghsid="+rkjl.getGhs().getGhsid();
			}
			List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl(){
				public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
					Cwtzgl cwtzgl = new Cwtzgl();
					cwtzgl.setZcth(rst.getInt("zcth"));
					return cwtzgl;
				}
			});
			if(null!=cwtzglList&&cwtzglList.size()>0){
				return cwtzglList.get(0);
			}
			return null;
		}
		
		
	//设置 营业支出(物料)已支付 未支付  1未付货款  2已付货款
	public void modifyRkjlforZHIFU(int sfzf , int rkid)throws Exception{
		String sql = "update rkjl set sfzf=? where rkid=?";
		Object[] ojbs={sfzf ,  rkid};
		this.getJdbcTemplate().update(sql ,ojbs);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 其他支出
	 * */
	//查询其他支出 明细
	@SuppressWarnings("unchecked")
	public List<Cwtzgl> queryCwtzglListQTZC(Object[] objs , Page page , String bfsdate , String efsdate) throws Exception{
		String sql =" SELECT * FROM CWTZGL WHERE 1=1  and  sztype=1 ";
		List<Object> list = new ArrayList<Object>();
		if(null!=bfsdate&&null!=efsdate&&!"".equals(bfsdate)&&!"".equals(efsdate)){
			sql +="  and fsdate BETWEEN '"+bfsdate+"' AND '" + efsdate +"'";
		}
		if(null!=objs&&objs.length>0){
			if(objs.length>=1&&null!=objs[0]&&!"".equals(objs[0])){
				sql +=" and kmname like ? ";
				list.add("%" +objs[0] + "%" );
			}
		}
		sql += "  ORDER BY CWID DESC ";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Cwtzgl());
	}
	//统计 查询其他支出统计金额
		@SuppressWarnings("unchecked")
		public Cwtzgl queryQTZC(Cwtzgl cwtzgl ,  String bfsdate , String efsdate) throws Exception{
			String sql = " SELECT SUM(jine) qtzc FROM cwtzgl WHERE sztype=1 " ;
			if(null!=cwtzgl&&!"".equals(cwtzgl)){
				sql+=" and kmname like '%"+cwtzgl.getKmname()+"%'";
			}
			if(null!=bfsdate&&null!=efsdate&&!"".equals(bfsdate)&&!"".equals(efsdate)){
				sql +="  and fsdate BETWEEN '"+bfsdate+"' AND '" + efsdate +"'";
			}
			List<Cwtzgl> cwtzglList = this.getJdbcTemplate().query(sql, new Cwtzgl(){
				public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
					Cwtzgl cwtzgl = new Cwtzgl();
					cwtzgl.setQtzc(rst.getInt("qtzc"));
					return cwtzgl;
				}
			});
			if(cwtzglList!=null&&cwtzglList.size()>0){
				return cwtzglList.get(0);
			}
			return null;
		}
		
		//查找一个 新增 修改 都和其他收入方法公用  新增加一个service方法设置sztype=1
		
	
	
	

}
