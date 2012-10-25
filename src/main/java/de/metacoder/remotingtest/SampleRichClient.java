package de.metacoder.remotingtest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.metacoder.remotingtest.spring.GreetingService;

public class SampleRichClient extends JFrame {

	private static final long serialVersionUID = 1L;

	// TODO Service
	
	public SampleRichClient() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/richClientContext.xml");
		final GreetingService service = (GreetingService) context.getBean("httpInvokerProxy");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(new Dimension(640,480));
		setLocationRelativeTo(null);
		JButton callWebserviceButton = new JButton("call web service");
		final TextArea responseTextArea = new TextArea();
		
		callWebserviceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				responseTextArea.setText(responseTextArea.getText() + "\n" + service.hello("world"));
			}
		});
		
		
		add(callWebserviceButton, BorderLayout.NORTH);
		add(responseTextArea, BorderLayout.CENTER);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SampleRichClient client = new SampleRichClient();
	}

}
