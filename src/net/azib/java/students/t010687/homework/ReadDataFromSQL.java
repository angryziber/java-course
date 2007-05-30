package net.azib.java.students.t010687.homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
/**
 * ReadDataFromSQL
 *
 * @author Matu
 */
public class ReadDataFromSQL implements ActionListener{
    private JFrame ParentFrm;
    public ReadDataFromSQL(JFrame Related_frame){
    	ParentFrm = Related_frame;
    }
    public void actionPerformed(ActionEvent e){
    	BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml", ReadDataFromSQL.class));
    	DecathlonDao dechatlonDao = (DecathlonDao) beanFactory.getBean(DecathlonDao.class.getName());
    	
    	List<ResultsOfTheAthlet> Results = dechatlonDao.getCompetition_id(2);
    	ParentFrm.dispose();
    	new DecathlonDataFrm(Results);
    }
  }
