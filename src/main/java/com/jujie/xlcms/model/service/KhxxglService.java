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
				objs[0] = shiGongDan.getKhlx();  //�ͻ�����;
			}
			if(null!=shiGongDan.getCphm()&&!"".equals(shiGongDan.getCphm())){
				objs[1] = shiGongDan.getCphm(); //���ƺ���
			}
			if(null!=shiGongDan.getKhmc()&&!"".equals(shiGongDan.getKhmc())){
				objs[2] = shiGongDan.getKhmc(); //�ͻ�����
			}
			if(null!=shiGongDan.getTbgs()&&!"0".equals(shiGongDan.getTbgs())){
				objs[3] = shiGongDan.getTbgs(); //Ͷ����˾
			}
			if(null!=shiGongDan.getClpp()&&!"".equals(shiGongDan.getClpp())){
				objs[4] = shiGongDan.getClpp(); //����Ʒ��
			}
			if(null!=shiGongDan.getKhdh()&&!"".equals(shiGongDan.getKhdh())){
				objs[5] = shiGongDan.getKhdh(); //�ͻ��绰
			}
			if(null!=shiGongDan.getWxgw()&&!"0".equals(shiGongDan.getWxgw())){
				objs[6] = shiGongDan.getWxgw(); //ά�޹���
			}
			if(null!=shiGongDan.getClxh()&&!"".equals(shiGongDan.getClxh())){
				objs[7] = shiGongDan.getClxh(); //�����ͺ�
			}
			if(null!=shiGongDan.getDwmc()&&!"0".equals(shiGongDan.getDwmc())){
				objs[8] = shiGongDan.getDwmc(); //Э�鵥λ����
			}
			if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //�����Ǽ����ڿ�ʼ
				objs[9] = shiGongDan.getGddjrqb();
			}
			if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //�����Ǽ����ڽ���
				objs[10] = shiGongDan.getGddjrqe();
			}
			if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //���յ������ڿ�ʼ
				objs[11] = shiGongDan.getBtimebx();
			}
			if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //���յ������ڽ���
				objs[12] = shiGongDan.getEtimebx();
			}
		}
		return khxxDAOSer.queryKhxxList(objs, page);
	}
	
	//�鿴ά�޼�¼
	public List<ShiGongDan> queryWxjlList(String cphm) throws Exception{
		return khxxDAOSer.queryWxjlList(cphm);
	}
	
	
	//��ѯ��Ա(���нӴ�)
	 
	public List<Rygl> queryAllJDList() throws Exception{
		return khxxDAOSer.queryAllJDList();
	}

}
