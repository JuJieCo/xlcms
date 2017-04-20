package com.jujie.xlcms.model.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.jujie.xlcms.model.dao.ShiGongDanDAO;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.BaoJia;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.ShiGongDan;
import com.jujie.xlcms.struts.bean.Xydwgl;

public class ShiGongDanService {

	private ShiGongDanDAO shiGongDanDAOSer;

	public void setShiGongDanDAOSer(ShiGongDanDAO shiGongDanDAOSer) {
		this.shiGongDanDAOSer = shiGongDanDAOSer;
	}

	//查询不需结算工单LIST
	public List<ShiGongDan> queryShiGongDanList(ShiGongDan shiGongDan, Page page) throws Exception {
		Object[] objs = new Object[20];
		if(null!=shiGongDan){
		if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //施工单号
			objs[0] = shiGongDan.getDanhao().trim();
		}
		if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //车牌号码
			objs[1] = shiGongDan.getCphm().trim();
		}
		if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //协议单位名称
			objs[2] = shiGongDan.getDwmc();
		}
		if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //维修顾问
			objs[3] = shiGongDan.getWxgw();
		}
		if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //客户名称
			objs[4] = shiGongDan.getKhmc().trim();
		}
		if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //客户电话
			objs[5] = shiGongDan.getKhdh().trim();
		}
		if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //车辆品牌
			objs[6] = shiGongDan.getClpp().trim();
		}
		if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //车辆型号
			objs[7] = shiGongDan.getClxh().trim();
		}
		if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //客户类型
			objs[8] = shiGongDan.getKhlx();
		}
		if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //收费类型
			objs[9] = shiGongDan.getSflx();
		}
		if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //维修类型
			objs[10] = shiGongDan.getWxlx();
		}
		if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //维修状态
			objs[11] = shiGongDan.getWxzt();
		}
		if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //工单登记日期开始
			objs[12] = shiGongDan.getGddjrqb();
		}
		if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //工单登记日期结束
			objs[13] = shiGongDan.getGddjrqe();
		}
		if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //预计完工日期开始
			objs[14] = shiGongDan.getBtimey();
		}
		if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //预计完工日期结束
			objs[15] = shiGongDan.getEtimey();
		}
		if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //实际完工日期开始
			objs[16] = shiGongDan.getBtimew();
		}
		if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //实际完工日期结束
			objs[17] = shiGongDan.getEtimew();
		}
		if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //保险到期日期开始
			objs[18] = shiGongDan.getBtimebx();
		}
		if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //保险到期日期结束
			objs[19] = shiGongDan.getEtimebx();
		}
		}
		return shiGongDanDAOSer.queryShiGongDanList(objs, page);
	}
	
	//查询不需结算临时工单LIST
		public List<ShiGongDan> queryShiGongDanTempList(ShiGongDan shiGongDan, Page page) throws Exception {
			Object[] objs = new Object[20];
			if(null!=shiGongDan){
			if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //施工单号
				objs[0] = shiGongDan.getDanhao().trim();
			}
			if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //车牌号码
				objs[1] = shiGongDan.getCphm().trim();
			}
			if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //协议单位名称
				objs[2] = shiGongDan.getDwmc();
			}
			if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //维修顾问
				objs[3] = shiGongDan.getWxgw();
			}
			if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //客户名称
				objs[4] = shiGongDan.getKhmc().trim();
			}
			if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //客户电话
				objs[5] = shiGongDan.getKhdh().trim();
			}
			if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //车辆品牌
				objs[6] = shiGongDan.getClpp().trim();
			}
			if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //车辆型号
				objs[7] = shiGongDan.getClxh().trim();
			}
			if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //客户类型
				objs[8] = shiGongDan.getKhlx();
			}
			if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //收费类型
				objs[9] = shiGongDan.getSflx();
			}
			if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //维修类型
				objs[10] = shiGongDan.getWxlx();
			}
			if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //维修状态
				objs[11] = shiGongDan.getWxzt();
			}
			if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //工单登记日期开始
				objs[12] = shiGongDan.getGddjrqb();
			}
			if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //工单登记日期结束
				objs[13] = shiGongDan.getGddjrqe();
			}
			if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //预计完工日期开始
				objs[14] = shiGongDan.getBtimey();
			}
			if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //预计完工日期结束
				objs[15] = shiGongDan.getEtimey();
			}
			if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //实际完工日期开始
				objs[16] = shiGongDan.getBtimew();
			}
			if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //实际完工日期结束
				objs[17] = shiGongDan.getEtimew();
			}
			if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //保险到期日期开始
				objs[18] = shiGongDan.getBtimebx();
			}
			if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //保险到期日期结束
				objs[19] = shiGongDan.getEtimebx();
			}
			}
			return shiGongDanDAOSer.queryShiGongDanTempList(objs, page);
		}
	
	//查询需要结算工单LIST
	public List<ShiGongDan> queryShiGongDanJiesuanList(ShiGongDan shiGongDan, Page page) throws Exception {
		Object[] objs = new Object[20];
		if(null!=shiGongDan){
		if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //施工单号
			objs[0] = shiGongDan.getDanhao().trim();
		}
		if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //车牌号码
			objs[1] = shiGongDan.getCphm().trim();
		}
		if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //协议单位名称
			objs[2] = shiGongDan.getDwmc();
		}
		if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //维修顾问
			objs[3] = shiGongDan.getWxgw();
		}
		if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //客户名称
			objs[4] = shiGongDan.getKhmc().trim();
		}
		if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //客户电话
			objs[5] = shiGongDan.getKhdh().trim();
		}
		if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //车辆品牌
			objs[6] = shiGongDan.getClpp().trim();
		}
		if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //车辆型号
			objs[7] = shiGongDan.getClxh().trim();
		}
		if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //客户类型
			objs[8] = shiGongDan.getKhlx();
		}
		if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //收费类型
			objs[9] = shiGongDan.getSflx();
		}
		if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //维修类型
			objs[10] = shiGongDan.getWxlx();
		}
		if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //维修状态
			objs[11] = shiGongDan.getWxzt();
		}
		if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //工单登记日期开始
			objs[12] = shiGongDan.getGddjrqb();
		}
		if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //工单登记日期结束
			objs[13] = shiGongDan.getGddjrqe();
		}
		if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //预计完工日期开始
			objs[14] = shiGongDan.getBtimey();
		}
		if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //预计完工日期结束
			objs[15] = shiGongDan.getEtimey();
		}
		if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //实际完工日期开始
			objs[16] = shiGongDan.getBtimew();
		}
		if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //实际完工日期结束
			objs[17] = shiGongDan.getEtimew();
		}
		if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //保险到期日期开始
			objs[18] = shiGongDan.getBtimebx();
		}
		if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //保险到期日期结束
			objs[19] = shiGongDan.getEtimebx();
		}
		}
		return shiGongDanDAOSer.queryShiGongDanJiesuanList(objs, page);
	}
	
	//报价管理 查询待备料工单
	public List<ShiGongDan> queryBeiliaoShiGongDanList(ShiGongDan shiGongDan, Page page) throws Exception {
		Object[] objs = new Object[20];
		if(null!=shiGongDan){
		if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //施工单号
			objs[0] = shiGongDan.getDanhao().trim();
		}
		if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //车牌号码
			objs[1] = shiGongDan.getCphm().trim();
		}
		if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //协议单位名称
			objs[2] = shiGongDan.getDwmc();
		}
		if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //维修顾问
			objs[3] = shiGongDan.getWxgw();
		}
		if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //客户名称
			objs[4] = shiGongDan.getKhmc().trim();
		}
		if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //客户电话
			objs[5] = shiGongDan.getKhdh().trim();
		}
		if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //车辆品牌
			objs[6] = shiGongDan.getClpp().trim();
		}
		if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //车辆型号
			objs[7] = shiGongDan.getClxh().trim();
		}
		if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //客户类型
			objs[8] = shiGongDan.getKhlx();
		}
		if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //收费类型
			objs[9] = shiGongDan.getSflx();
		}
		if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //维修类型
			objs[10] = shiGongDan.getWxlx();
		}
		if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //维修状态
			objs[11] = shiGongDan.getWxzt();
		}
		if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //工单登记日期开始
			objs[12] = shiGongDan.getGddjrqb();
		}
		if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //工单登记日期结束
			objs[13] = shiGongDan.getGddjrqe();
		}
		if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //预计完工日期开始
			objs[14] = shiGongDan.getBtimey();
		}
		if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //预计完工日期结束
			objs[15] = shiGongDan.getEtimey();
		}
		if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //实际完工日期开始
			objs[16] = shiGongDan.getBtimew();
		}
		if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //实际完工日期结束
			objs[17] = shiGongDan.getEtimew();
		}
		if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //保险到期日期开始
			objs[18] = shiGongDan.getBtimebx();
		}
		if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //保险到期日期结束
			objs[19] = shiGongDan.getEtimebx();
		}
		}
		return shiGongDanDAOSer.queryBeiliaoShiGongDanList(objs, page);
	}
	
	
	//初始化工单新增页面
	public ShiGongDan getShiGongDanForModifyAsSave() throws Exception {
			// 初始化工单登记日期
			Calendar cal = Calendar.getInstance();// 取当前日期。
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			ShiGongDan shiGongDan = new ShiGongDan();
			shiGongDan.setGddjrq(sdf.format(cal.getTime()));
			// 初始化单号
			SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyMMddHHmmss");
			String danhao = format1.format(cal.getTime());
			int x = (int) (Math.random() * 100);
			shiGongDan.setDanhao(danhao + x);
			//初始化总费用
			shiGongDan.setZfy("0.00");
			return shiGongDan;
	}
	
	//初始化临时工单新增修改页面
	public ShiGongDan getShiGongDanTempForModify(String gdid) throws Exception {
		if(null!=gdid&&!"".equals(gdid)){
			return shiGongDanDAOSer.queryShiGongDanByID(gdid);
		}else{
			// 初始化工单登记日期
			Calendar cal = Calendar.getInstance();// 取当前日期。
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			ShiGongDan shiGongDan = new ShiGongDan();
			shiGongDan.setGddjrq(sdf.format(cal.getTime()));
			// 初始化单号
			SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyMMddHHmmss");
			String danhao = format1.format(cal.getTime());
			int x = (int) (Math.random() * 100);
			shiGongDan.setDanhao(danhao + x);
			//初始化总费用
			shiGongDan.setZfy("0.00");
			return shiGongDan;
		}
	}
	
	
	//新增工单/修改工单(结算)
	public void modifyShiGongDan(ShiGongDan shiGongDan) throws Exception {
		if (null != shiGongDan.getGdid()&& !"".equals(shiGongDan.getGdid())) {
			shiGongDanDAOSer.modifyShiGongDanForUpdate(shiGongDan); //修改(结算)
		} else {
			//新增
			shiGongDan.setWlzt("0");//设置物料状态为未申请报料
			shiGongDanDAOSer.modifyShiGongDanForSave(shiGongDan); //新增
		}
	}
	
	//新增修改临时工单
	public void modifyShiGongDanTemp(ShiGongDan shiGongDan) throws Exception {
		if (null != shiGongDan.getGdid()&& !"".equals(shiGongDan.getGdid())) {
			shiGongDan.setWlzt("7");//设置物料状态为临时工单
			shiGongDanDAOSer.modifyShiGongDanTempForUpdate(shiGongDan);
		} else {
			//新增
			shiGongDan.setWlzt("7");
			shiGongDanDAOSer.modifyShiGongDanForSave(shiGongDan);
		}
	}
	
	//修改临时工单(提交临时工单到正常工单)
	public void modifyShiGongDanTempForUpdate(ShiGongDan shiGongDan) throws Exception {
		if (null != shiGongDan.getGdid()&& !"".equals(shiGongDan.getGdid())) {
			shiGongDan.setWlzt("0");//设置物料状态为未申请报料
			shiGongDanDAOSer.modifyShiGongDanTempForUpdate(shiGongDan);
		} 
	}
	
	
	//查看施工单
	public ShiGongDan queryShiGongDanByID(String gdid) throws Exception{
		if(null!=gdid && !"".equals(gdid)){
			return shiGongDanDAOSer.queryShiGongDanByID(gdid);
		}else{
			return  null;
		}
	}
	
	//查看施工单对应的报料单
	public List<BaoJia> queryBaoJiaList(String gdid) throws Exception{
		if(null!=gdid && !"".equals(gdid)){
			return shiGongDanDAOSer.queryBaoJiaList(gdid);
		}else{
			return  null;
		}
	}
	
	
	//高级管理查询 施工单信息
	public List<ShiGongDan> queryShiGongDanInfoList(ShiGongDan shiGongDan, Page page) throws Exception {
		Object[] objs = new Object[20];
		if(null!=shiGongDan){
		if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //施工单号
			objs[0] = shiGongDan.getDanhao().trim();
		}
		if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //车牌号码
			objs[1] = shiGongDan.getCphm().trim();
		}
		if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //协议单位名称
			objs[2] = shiGongDan.getDwmc();
		}
		if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //维修顾问
			objs[3] = shiGongDan.getWxgw();
		}
		if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //客户名称
			objs[4] = shiGongDan.getKhmc().trim();
		}
		if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //客户电话
			objs[5] = shiGongDan.getKhdh().trim();
		}
		if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //车辆品牌
			objs[6] = shiGongDan.getClpp().trim();
		}
		if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //车辆型号
			objs[7] = shiGongDan.getClxh().trim();
		}
		if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //客户类型
			objs[8] = shiGongDan.getKhlx();
		}
		if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //收费类型
			objs[9] = shiGongDan.getSflx();
		}
		if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //维修类型
			objs[10] = shiGongDan.getWxlx();
		}
		if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //维修状态
			objs[11] = shiGongDan.getWxzt();
		}
		if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //工单登记日期开始
			objs[12] = shiGongDan.getGddjrqb();
		}
		if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //工单登记日期结束
			objs[13] = shiGongDan.getGddjrqe();
		}
		if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //预计完工日期开始
			objs[14] = shiGongDan.getBtimey();
		}
		if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //预计完工日期结束
			objs[15] = shiGongDan.getEtimey();
		}
		if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //实际完工日期开始
			objs[16] = shiGongDan.getBtimew();
		}
		if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //实际完工日期结束
			objs[17] = shiGongDan.getEtimew();
		}
		if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //保险到期日期开始
			objs[18] = shiGongDan.getBtimebx();
		}
		if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //保险到期日期结束
			objs[19] = shiGongDan.getEtimebx();
		}
		}
		return shiGongDanDAOSer.queryShiGongDanInfoList(objs, page);
	}
	
	//查询一个修改施工单信息
	public ShiGongDan queryShiGongDanInfoForModify(String gdid) throws Exception{
		return shiGongDanDAOSer.queryShiGongDanByID(gdid);
	}
	
	//提交修改工单信息
	public void modifyShiGongDanInfo(ShiGongDan shiGongDan) throws Exception {
		shiGongDanDAOSer.modifyShiGongDanInfoForUpdate(shiGongDan);
	}
	
	

	//自动补全
	public List<ShiGongDan> queryCheLiangListAuto(String q) throws Exception {
		return shiGongDanDAOSer.queryCheLiangListAuto(q);
	}
	
	//查询协议单位名称
	public List<Xydwgl> queryXydwglList() throws Exception{
		return shiGongDanDAOSer.queryXydwglList();
	}
	
	//查询人员(在职接待)
	public List<Rygl> queryJDList() throws Exception{
		return shiGongDanDAOSer.queryJDList();
	}
	//查询人员(所有接待)
	public List<Rygl> queryAllJDList() throws Exception{
		return shiGongDanDAOSer.queryAllJDList();
	}
	//查询人员(所有人员)
	public List<Rygl> queryRYList() throws Exception{
		return shiGongDanDAOSer.queryRYList();
	}

}
