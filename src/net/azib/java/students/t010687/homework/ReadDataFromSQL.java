package net.azib.java.students.t010687.homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
/**
 * ReadDataFromSQL
 *
 * @author Matu
 */
public class ReadDataFromSQL implements ActionListener{
    private JFrame parentFrm;
    private DecathlonDao dechatlonDao;
    public ReadDataFromSQL(JFrame related_frame){
    	parentFrm = related_frame;
    }
    public void actionPerformed(ActionEvent e){
    	BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml", ReadDataFromSQL.class));
    	dechatlonDao = (DecathlonDao) beanFactory.getBean(DecathlonDao.class.getName());
    	parentFrm.setEnabled(false);
    	Competition SelectedCompet = getSelectedCompetition();
    	if (SelectedCompet != null){
    		parentFrm.dispose();
    		List<ResultsOfTheAthlet> Results = dechatlonDao.getCompetition_id(SelectedCompet.getId());
    		parentFrm.dispose();
    		new DecathlonDataFrm(Results);
    	}
    	else {
    		parentFrm.setEnabled(true);
    	}
    }
    private Competition getSelectedCompetition(){
    	ArrayList<Competition> Competitions = new ArrayList<Competition>(dechatlonDao.getCompetitions());
    	return (Competition)JOptionPane.showInputDialog(
    			parentFrm, "DECATHLON:\n"
                + "Please select competition:",
                "DECATHLON",JOptionPane.PLAIN_MESSAGE,
                null,Competitions.toArray(), null);
    }
  }

