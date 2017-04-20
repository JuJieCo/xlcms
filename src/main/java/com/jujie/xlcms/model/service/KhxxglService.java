package com.jujie.xlcms.model.service;

import java.util.List;

import com.jujie.xlcms.model.dao.KhxxglDAO;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class KhxxglService {
	
	private KhxxglDAO khxxDAOSer;

	public void setKhxxDAOSer(KhxxglDAO khxxDAOSer) {
		this.khxxDAOSer = khxxDAOSer;
	}



	public List<ShiGongDan> queryKhxxList(ShiGongDan shiGongDan , Page page) throws Exception{
		Object[] objs = new Object[13];
		if(null!=shiGongDan){
			if(null!=shiGongDan.getKhlx()&&!"0".equals(shiGongDan.getKhlx())){
				objs[0] = shiGongDan.getKhlx();  //客户类型;
			}
			if(null!=shiGongDan.getCphm()&&!"".equals(shiGongDan.getCphm())){
				objs[1] = shiGongDan.getCphm(); //车牌号码
			}
			if(null!=shiGongDan.getKhmc()&&!"".equals(shiGongDan.getKhmc())){
				objs[2] = shiGongDan.getKhmc(); //客户名称
			}
			if(null!=shiGongDan.getTbgs()&&!"0".equals(shiGongDan.getTbgs())){
				objs[3] = shiGongDan.getTbgs(); //投保公司
			}
			if(null!=shiGongDan.getClpp()&&!"".equals(shiGongDan.getClpp())){
				objs[4] = shiGongDan.getClpp(); //车辆品牌
			}
			if(null!=shiGongDan.getKhdh()&&!"".equals(shiGongDan.getKhdh())){
				objs[5] = shiGongDan.getKhdh(); //客户电话
			}
			if(null!=shiGongDan.getWxgw()&&!"0".equals(shiGongDan.getWxgw())){
				objs[6] = shiGongDan.getWxgw(); //维修顾问
			}
			if(null!=shiGongDan.getClxh()&&!"".equals(shiGongDan.getClxh())){
				objs[7] = shiGongDan.getClxh(); //车辆型号
			}
			if(null!=shiGongDan.getDwmc()&&!"0".equals(shiGongDan.getDwmc())){
				objs[8] = shiGongDan.getDwmc(); //协议单位名称
			}
			if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //工单登记日期开始
				objs[9] = shiGongDan.getGddjrqb();
			}
			if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //工单登记日期结束
				objs[10] = shiGongDan.getGddjrqe();
			}
			if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //保险到期日期开始
				objs[11] = shiGongDan.getBtimebx();
			}
			if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //保险到期日期结束
				objs[12] = shiGongDan.getEtimebx();
			}
		}
		return khxxDAOSer.queryKhxxList(objs, page);
	}
	
	//查看维修记录
	public List<ShiGongDan> queryWxjlList(String cphm) throws Exception{
		return khxxDAOSer.queryWxjlList(cphm);
	}
	
	
	//查询人员(所有接待)
	 
	public List<Rygl> queryAllJDList() throws Exception{
		return khxxDAOSer.queryAllJDList();
	}

}
