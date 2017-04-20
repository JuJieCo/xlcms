package com.jujie.xlcms.model.service;

import java.util.List;

import com.jujie.xlcms.model.dao.RyglDAO;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Rygl;

public class RyglService {

	private RyglDAO ryglDAOSer;

	public void setRyglDAOSer(RyglDAO ryglDAOSer) {
		this.ryglDAOSer = ryglDAOSer;
	}

	public List<Rygl> queryRyglList(Rygl rygl, Page page) throws Exception {
		Object[] objs = new Object[2];
		if (null != rygl && !"".equals(rygl)) {
			objs[0] = rygl.getName();
		}
		if (null != rygl && !"".equals(rygl)) {
			objs[1] = rygl.getDept();
		}
		return ryglDAOSer.queryRyglList(objs, page);
	}

	public Rygl queryRyglByID(String ryid)  throws Exception {
		if(null!=ryid&&!"".equals(ryid)){
			return ryglDAOSer.queryRyglByID(ryid);
		} 
		return null;
	}
	
	public void modifyRygl(Rygl rygl) throws Exception {
		if(null!=rygl.getRyid()&&!"".equals(rygl.getRyid())){
			ryglDAOSer.modifyRyglForUpdate(rygl);
		}else{
			ryglDAOSer.modifyRyglForSave(rygl);
		}
	}
	
	
}
