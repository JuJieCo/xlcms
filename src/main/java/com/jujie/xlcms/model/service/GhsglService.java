package com.jujie.xlcms.model.service;

import java.util.List;

import com.jujie.xlcms.model.dao.GhsglDAO;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Ghsgl;

public class GhsglService {
	private GhsglDAO ghsglDAOSer;

	public void setGhsglDAOSer(GhsglDAO ghsglDAOSer) {
		this.ghsglDAOSer = ghsglDAOSer;
	}
	
	
	
	
	public List<Ghsgl> queryGhsglList(Ghsgl ghsgl , Page page) throws Exception{
		Object[] objs = new Object[2];
		if (null != ghsgl && !"".equals(ghsgl.getName())) {
			objs[0] = ghsgl.getName();
		}
		if (null != ghsgl && !"0".equals(ghsgl.getStatus())) {
			objs[1] = ghsgl.getStatus();
		}
		return ghsglDAOSer.queryGhsglList(objs, page);
	}
	
	public Ghsgl queryGhsglByID(String ghsid) throws Exception{
		if(null!=ghsid&&!"".equals(ghsid)){
			return ghsglDAOSer.queryGhsglByID(ghsid);
		}
		return null;
	}
	
	public void modifyGhsgl(Ghsgl ghsgl)throws Exception{
		if(null!=ghsgl.getGhsid()&&!"".equals(ghsgl.getGhsid())){
			ghsglDAOSer.modifyGhsglForUpdate(ghsgl);
		}else{
			ghsglDAOSer.modifyGhsglForSave(ghsgl);
		}
	}

}
