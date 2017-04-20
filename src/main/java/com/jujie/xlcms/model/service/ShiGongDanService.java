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

	//��ѯ������㹤��LIST
	public List<ShiGongDan> queryShiGongDanList(ShiGongDan shiGongDan, Page page) throws Exception {
		Object[] objs = new Object[20];
		if(null!=shiGongDan){
		if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //ʩ������
			objs[0] = shiGongDan.getDanhao().trim();
		}
		if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //���ƺ���
			objs[1] = shiGongDan.getCphm().trim();
		}
		if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //Э�鵥λ����
			objs[2] = shiGongDan.getDwmc();
		}
		if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //ά�޹���
			objs[3] = shiGongDan.getWxgw();
		}
		if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //�ͻ�����
			objs[4] = shiGongDan.getKhmc().trim();
		}
		if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //�ͻ��绰
			objs[5] = shiGongDan.getKhdh().trim();
		}
		if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //����Ʒ��
			objs[6] = shiGongDan.getClpp().trim();
		}
		if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //�����ͺ�
			objs[7] = shiGongDan.getClxh().trim();
		}
		if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //�ͻ�����
			objs[8] = shiGongDan.getKhlx();
		}
		if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //�շ�����
			objs[9] = shiGongDan.getSflx();
		}
		if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //ά������
			objs[10] = shiGongDan.getWxlx();
		}
		if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //ά��״̬
			objs[11] = shiGongDan.getWxzt();
		}
		if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //�����Ǽ����ڿ�ʼ
			objs[12] = shiGongDan.getGddjrqb();
		}
		if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //�����Ǽ����ڽ���
			objs[13] = shiGongDan.getGddjrqe();
		}
		if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //Ԥ���깤���ڿ�ʼ
			objs[14] = shiGongDan.getBtimey();
		}
		if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //Ԥ���깤���ڽ���
			objs[15] = shiGongDan.getEtimey();
		}
		if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //ʵ���깤���ڿ�ʼ
			objs[16] = shiGongDan.getBtimew();
		}
		if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //ʵ���깤���ڽ���
			objs[17] = shiGongDan.getEtimew();
		}
		if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //���յ������ڿ�ʼ
			objs[18] = shiGongDan.getBtimebx();
		}
		if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //���յ������ڽ���
			objs[19] = shiGongDan.getEtimebx();
		}
		}
		return shiGongDanDAOSer.queryShiGongDanList(objs, page);
	}
	
	//��ѯ���������ʱ����LIST
		public List<ShiGongDan> queryShiGongDanTempList(ShiGongDan shiGongDan, Page page) throws Exception {
			Object[] objs = new Object[20];
			if(null!=shiGongDan){
			if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //ʩ������
				objs[0] = shiGongDan.getDanhao().trim();
			}
			if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //���ƺ���
				objs[1] = shiGongDan.getCphm().trim();
			}
			if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //Э�鵥λ����
				objs[2] = shiGongDan.getDwmc();
			}
			if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //ά�޹���
				objs[3] = shiGongDan.getWxgw();
			}
			if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //�ͻ�����
				objs[4] = shiGongDan.getKhmc().trim();
			}
			if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //�ͻ��绰
				objs[5] = shiGongDan.getKhdh().trim();
			}
			if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //����Ʒ��
				objs[6] = shiGongDan.getClpp().trim();
			}
			if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //�����ͺ�
				objs[7] = shiGongDan.getClxh().trim();
			}
			if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //�ͻ�����
				objs[8] = shiGongDan.getKhlx();
			}
			if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //�շ�����
				objs[9] = shiGongDan.getSflx();
			}
			if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //ά������
				objs[10] = shiGongDan.getWxlx();
			}
			if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //ά��״̬
				objs[11] = shiGongDan.getWxzt();
			}
			if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //�����Ǽ����ڿ�ʼ
				objs[12] = shiGongDan.getGddjrqb();
			}
			if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //�����Ǽ����ڽ���
				objs[13] = shiGongDan.getGddjrqe();
			}
			if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //Ԥ���깤���ڿ�ʼ
				objs[14] = shiGongDan.getBtimey();
			}
			if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //Ԥ���깤���ڽ���
				objs[15] = shiGongDan.getEtimey();
			}
			if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //ʵ���깤���ڿ�ʼ
				objs[16] = shiGongDan.getBtimew();
			}
			if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //ʵ���깤���ڽ���
				objs[17] = shiGongDan.getEtimew();
			}
			if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //���յ������ڿ�ʼ
				objs[18] = shiGongDan.getBtimebx();
			}
			if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //���յ������ڽ���
				objs[19] = shiGongDan.getEtimebx();
			}
			}
			return shiGongDanDAOSer.queryShiGongDanTempList(objs, page);
		}
	
	//��ѯ��Ҫ���㹤��LIST
	public List<ShiGongDan> queryShiGongDanJiesuanList(ShiGongDan shiGongDan, Page page) throws Exception {
		Object[] objs = new Object[20];
		if(null!=shiGongDan){
		if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //ʩ������
			objs[0] = shiGongDan.getDanhao().trim();
		}
		if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //���ƺ���
			objs[1] = shiGongDan.getCphm().trim();
		}
		if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //Э�鵥λ����
			objs[2] = shiGongDan.getDwmc();
		}
		if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //ά�޹���
			objs[3] = shiGongDan.getWxgw();
		}
		if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //�ͻ�����
			objs[4] = shiGongDan.getKhmc().trim();
		}
		if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //�ͻ��绰
			objs[5] = shiGongDan.getKhdh().trim();
		}
		if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //����Ʒ��
			objs[6] = shiGongDan.getClpp().trim();
		}
		if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //�����ͺ�
			objs[7] = shiGongDan.getClxh().trim();
		}
		if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //�ͻ�����
			objs[8] = shiGongDan.getKhlx();
		}
		if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //�շ�����
			objs[9] = shiGongDan.getSflx();
		}
		if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //ά������
			objs[10] = shiGongDan.getWxlx();
		}
		if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //ά��״̬
			objs[11] = shiGongDan.getWxzt();
		}
		if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //�����Ǽ����ڿ�ʼ
			objs[12] = shiGongDan.getGddjrqb();
		}
		if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //�����Ǽ����ڽ���
			objs[13] = shiGongDan.getGddjrqe();
		}
		if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //Ԥ���깤���ڿ�ʼ
			objs[14] = shiGongDan.getBtimey();
		}
		if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //Ԥ���깤���ڽ���
			objs[15] = shiGongDan.getEtimey();
		}
		if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //ʵ���깤���ڿ�ʼ
			objs[16] = shiGongDan.getBtimew();
		}
		if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //ʵ���깤���ڽ���
			objs[17] = shiGongDan.getEtimew();
		}
		if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //���յ������ڿ�ʼ
			objs[18] = shiGongDan.getBtimebx();
		}
		if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //���յ������ڽ���
			objs[19] = shiGongDan.getEtimebx();
		}
		}
		return shiGongDanDAOSer.queryShiGongDanJiesuanList(objs, page);
	}
	
	//���۹��� ��ѯ�����Ϲ���
	public List<ShiGongDan> queryBeiliaoShiGongDanList(ShiGongDan shiGongDan, Page page) throws Exception {
		Object[] objs = new Object[20];
		if(null!=shiGongDan){
		if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //ʩ������
			objs[0] = shiGongDan.getDanhao().trim();
		}
		if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //���ƺ���
			objs[1] = shiGongDan.getCphm().trim();
		}
		if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //Э�鵥λ����
			objs[2] = shiGongDan.getDwmc();
		}
		if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //ά�޹���
			objs[3] = shiGongDan.getWxgw();
		}
		if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //�ͻ�����
			objs[4] = shiGongDan.getKhmc().trim();
		}
		if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //�ͻ��绰
			objs[5] = shiGongDan.getKhdh().trim();
		}
		if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //����Ʒ��
			objs[6] = shiGongDan.getClpp().trim();
		}
		if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //�����ͺ�
			objs[7] = shiGongDan.getClxh().trim();
		}
		if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //�ͻ�����
			objs[8] = shiGongDan.getKhlx();
		}
		if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //�շ�����
			objs[9] = shiGongDan.getSflx();
		}
		if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //ά������
			objs[10] = shiGongDan.getWxlx();
		}
		if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //ά��״̬
			objs[11] = shiGongDan.getWxzt();
		}
		if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //�����Ǽ����ڿ�ʼ
			objs[12] = shiGongDan.getGddjrqb();
		}
		if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //�����Ǽ����ڽ���
			objs[13] = shiGongDan.getGddjrqe();
		}
		if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //Ԥ���깤���ڿ�ʼ
			objs[14] = shiGongDan.getBtimey();
		}
		if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //Ԥ���깤���ڽ���
			objs[15] = shiGongDan.getEtimey();
		}
		if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //ʵ���깤���ڿ�ʼ
			objs[16] = shiGongDan.getBtimew();
		}
		if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //ʵ���깤���ڽ���
			objs[17] = shiGongDan.getEtimew();
		}
		if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //���յ������ڿ�ʼ
			objs[18] = shiGongDan.getBtimebx();
		}
		if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //���յ������ڽ���
			objs[19] = shiGongDan.getEtimebx();
		}
		}
		return shiGongDanDAOSer.queryBeiliaoShiGongDanList(objs, page);
	}
	
	
	//��ʼ����������ҳ��
	public ShiGongDan getShiGongDanForModifyAsSave() throws Exception {
			// ��ʼ�������Ǽ�����
			Calendar cal = Calendar.getInstance();// ȡ��ǰ���ڡ�
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			ShiGongDan shiGongDan = new ShiGongDan();
			shiGongDan.setGddjrq(sdf.format(cal.getTime()));
			// ��ʼ������
			SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyMMddHHmmss");
			String danhao = format1.format(cal.getTime());
			int x = (int) (Math.random() * 100);
			shiGongDan.setDanhao(danhao + x);
			//��ʼ���ܷ���
			shiGongDan.setZfy("0.00");
			return shiGongDan;
	}
	
	//��ʼ����ʱ���������޸�ҳ��
	public ShiGongDan getShiGongDanTempForModify(String gdid) throws Exception {
		if(null!=gdid&&!"".equals(gdid)){
			return shiGongDanDAOSer.queryShiGongDanByID(gdid);
		}else{
			// ��ʼ�������Ǽ�����
			Calendar cal = Calendar.getInstance();// ȡ��ǰ���ڡ�
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			ShiGongDan shiGongDan = new ShiGongDan();
			shiGongDan.setGddjrq(sdf.format(cal.getTime()));
			// ��ʼ������
			SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyMMddHHmmss");
			String danhao = format1.format(cal.getTime());
			int x = (int) (Math.random() * 100);
			shiGongDan.setDanhao(danhao + x);
			//��ʼ���ܷ���
			shiGongDan.setZfy("0.00");
			return shiGongDan;
		}
	}
	
	
	//��������/�޸Ĺ���(����)
	public void modifyShiGongDan(ShiGongDan shiGongDan) throws Exception {
		if (null != shiGongDan.getGdid()&& !"".equals(shiGongDan.getGdid())) {
			shiGongDanDAOSer.modifyShiGongDanForUpdate(shiGongDan); //�޸�(����)
		} else {
			//����
			shiGongDan.setWlzt("0");//��������״̬Ϊδ���뱨��
			shiGongDanDAOSer.modifyShiGongDanForSave(shiGongDan); //����
		}
	}
	
	//�����޸���ʱ����
	public void modifyShiGongDanTemp(ShiGongDan shiGongDan) throws Exception {
		if (null != shiGongDan.getGdid()&& !"".equals(shiGongDan.getGdid())) {
			shiGongDan.setWlzt("7");//��������״̬Ϊ��ʱ����
			shiGongDanDAOSer.modifyShiGongDanTempForUpdate(shiGongDan);
		} else {
			//����
			shiGongDan.setWlzt("7");
			shiGongDanDAOSer.modifyShiGongDanForSave(shiGongDan);
		}
	}
	
	//�޸���ʱ����(�ύ��ʱ��������������)
	public void modifyShiGongDanTempForUpdate(ShiGongDan shiGongDan) throws Exception {
		if (null != shiGongDan.getGdid()&& !"".equals(shiGongDan.getGdid())) {
			shiGongDan.setWlzt("0");//��������״̬Ϊδ���뱨��
			shiGongDanDAOSer.modifyShiGongDanTempForUpdate(shiGongDan);
		} 
	}
	
	
	//�鿴ʩ����
	public ShiGongDan queryShiGongDanByID(String gdid) throws Exception{
		if(null!=gdid && !"".equals(gdid)){
			return shiGongDanDAOSer.queryShiGongDanByID(gdid);
		}else{
			return  null;
		}
	}
	
	//�鿴ʩ������Ӧ�ı��ϵ�
	public List<BaoJia> queryBaoJiaList(String gdid) throws Exception{
		if(null!=gdid && !"".equals(gdid)){
			return shiGongDanDAOSer.queryBaoJiaList(gdid);
		}else{
			return  null;
		}
	}
	
	
	//�߼������ѯ ʩ������Ϣ
	public List<ShiGongDan> queryShiGongDanInfoList(ShiGongDan shiGongDan, Page page) throws Exception {
		Object[] objs = new Object[20];
		if(null!=shiGongDan){
		if (null != shiGongDan.getDanhao() && !"".equals(shiGongDan.getDanhao())) { //ʩ������
			objs[0] = shiGongDan.getDanhao().trim();
		}
		if (null != shiGongDan.getCphm() && !"".equals(shiGongDan.getCphm())) { //���ƺ���
			objs[1] = shiGongDan.getCphm().trim();
		}
		if (null != shiGongDan.getDwmc() && !"".equals(shiGongDan.getDwmc())) { //Э�鵥λ����
			objs[2] = shiGongDan.getDwmc();
		}
		if (null != shiGongDan.getWxgw() && !"".equals(shiGongDan.getWxgw())) { //ά�޹���
			objs[3] = shiGongDan.getWxgw();
		}
		if (null != shiGongDan.getKhmc() && !"".equals(shiGongDan.getKhmc())) { //�ͻ�����
			objs[4] = shiGongDan.getKhmc().trim();
		}
		if (null != shiGongDan.getKhdh() && !"".equals(shiGongDan.getKhdh())) { //�ͻ��绰
			objs[5] = shiGongDan.getKhdh().trim();
		}
		if (null != shiGongDan.getClpp() && !"".equals(shiGongDan.getClpp())) { //����Ʒ��
			objs[6] = shiGongDan.getClpp().trim();
		}
		if (null != shiGongDan.getClxh() && !"".equals(shiGongDan.getClxh())) { //�����ͺ�
			objs[7] = shiGongDan.getClxh().trim();
		}
		if (null != shiGongDan.getKhlx() && !"".equals(shiGongDan.getKhlx())) { //�ͻ�����
			objs[8] = shiGongDan.getKhlx();
		}
		if (null != shiGongDan.getSflx() && !"".equals(shiGongDan.getSflx())) { //�շ�����
			objs[9] = shiGongDan.getSflx();
		}
		if (null != shiGongDan.getWxlx() && !"".equals(shiGongDan.getWxlx())) { //ά������
			objs[10] = shiGongDan.getWxlx();
		}
		if (null != shiGongDan.getWxzt() && !"".equals(shiGongDan.getWxzt())) { //ά��״̬
			objs[11] = shiGongDan.getWxzt();
		}
		if (null != shiGongDan.getGddjrqb() && !"".equals(shiGongDan.getGddjrqb())) { //�����Ǽ����ڿ�ʼ
			objs[12] = shiGongDan.getGddjrqb();
		}
		if (null != shiGongDan.getGddjrqe() && !"".equals(shiGongDan.getGddjrqe())) { //�����Ǽ����ڽ���
			objs[13] = shiGongDan.getGddjrqe();
		}
		if (null != shiGongDan.getBtimey() && !"".equals(shiGongDan.getBtimey())) { //Ԥ���깤���ڿ�ʼ
			objs[14] = shiGongDan.getBtimey();
		}
		if (null != shiGongDan.getEtimey() && !"".equals(shiGongDan.getEtimey())) { //Ԥ���깤���ڽ���
			objs[15] = shiGongDan.getEtimey();
		}
		if (null != shiGongDan.getBtimew() && !"".equals(shiGongDan.getBtimew())) { //ʵ���깤���ڿ�ʼ
			objs[16] = shiGongDan.getBtimew();
		}
		if (null != shiGongDan.getEtimew() && !"".equals(shiGongDan.getEtimew())) { //ʵ���깤���ڽ���
			objs[17] = shiGongDan.getEtimew();
		}
		if (null != shiGongDan.getBtimebx() && !"".equals(shiGongDan.getBtimebx())) { //���յ������ڿ�ʼ
			objs[18] = shiGongDan.getBtimebx();
		}
		if (null != shiGongDan.getEtimebx() && !"".equals(shiGongDan.getEtimebx())) { //���յ������ڽ���
			objs[19] = shiGongDan.getEtimebx();
		}
		}
		return shiGongDanDAOSer.queryShiGongDanInfoList(objs, page);
	}
	
	//��ѯһ���޸�ʩ������Ϣ
	public ShiGongDan queryShiGongDanInfoForModify(String gdid) throws Exception{
		return shiGongDanDAOSer.queryShiGongDanByID(gdid);
	}
	
	//�ύ�޸Ĺ�����Ϣ
	public void modifyShiGongDanInfo(ShiGongDan shiGongDan) throws Exception {
		shiGongDanDAOSer.modifyShiGongDanInfoForUpdate(shiGongDan);
	}
	
	

	//�Զ���ȫ
	public List<ShiGongDan> queryCheLiangListAuto(String q) throws Exception {
		return shiGongDanDAOSer.queryCheLiangListAuto(q);
	}
	
	//��ѯЭ�鵥λ����
	public List<Xydwgl> queryXydwglList() throws Exception{
		return shiGongDanDAOSer.queryXydwglList();
	}
	
	//��ѯ��Ա(��ְ�Ӵ�)
	public List<Rygl> queryJDList() throws Exception{
		return shiGongDanDAOSer.queryJDList();
	}
	//��ѯ��Ա(���нӴ�)
	public List<Rygl> queryAllJDList() throws Exception{
		return shiGongDanDAOSer.queryAllJDList();
	}
	//��ѯ��Ա(������Ա)
	public List<Rygl> queryRYList() throws Exception{
		return shiGongDanDAOSer.queryRYList();
	}

}
