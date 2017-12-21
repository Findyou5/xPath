package xml_xpath;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ��ȡ��ӡ��Ϣ������xPath����
 */
public class demo2 {

	public static void main(String[] args) throws Exception {
		String[] bh = new String[6];
		
		Document doc = new SAXReader().read(new File("./src/personList.html"));
		String head = "//thead/tr//th";
		List<Element> head_ele = doc.selectNodes(head);
		//�õ���ǩ����
		for(int i = 0 ; i < head_ele.size(); i++){
			bh[i] = "";
			bh[i] += head_ele.get(i).getText();
		}
		//
		String tbody = "//tbody//tr";
		List<Element> person_eles = doc.selectNodes(tbody);
		for(Element p :person_eles){
//			List<Element> per_ems = p.elements();//����������Ϣ
			List<Element> per_ems = p.selectNodes("td");//ʲô����д��������ǰ��ǩ�µġ�����
			for(int i = 0;i<per_ems.size();i++){
				System.out.print(bh[i]+":"+per_ems.get(i).getText()+"   ");
			}
			System.out.println();
		}
		
		
	}

}





