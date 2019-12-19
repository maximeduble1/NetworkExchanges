package WindowsManagement;

import javax.swing.*;

import src.*;

import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
	
	public static JLabel enterText;
	
	public ConnectingPanel connectPanel;
	public RegisterPanel regPanel;
	public CreateNetworkPanel cnPanel;
	public DefaultMemberDisplayPanel dmdPanel;
	
	private Network networkSelected = null;
	private Member connectedUser = null;
	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<Network> networksAvailable = new ArrayList<Network>();
	
	public Window() {
		
		// CODE FINAL 

		//networksAvailable.add(new Network(new Admin("Bidule", 100), "network"));
		this.connectPanel = new ConnectingPanel(this.networksAvailable, this);
		this.regPanel = new RegisterPanel(this);
		this.cnPanel = new CreateNetworkPanel(this);
		this.dmdPanel = new DefaultMemberDisplayPanel(this);
		
		this.members = new ArrayList<Member>();
		
		
		

		this.setContentPane(connectPanel);
		this.setVisible(true);
		
	}
	
	public void changePanel(String pan) {
		
		this.getContentPane().removeAll();
		this.revalidate();
		this.repaint();
		
		this.updatePanels();
		
		if (pan.equals("Register")) this.setContentPane(this.regPanel);
		else if (pan.equals("Connexion")) this.setContentPane(this.connectPanel);
		else if (pan.equals("CN")) this.setContentPane(this.cnPanel);
		else if (pan.equals("DMD")) this.setContentPane(this.dmdPanel);
		this.revalidate();
		this.repaint();
		
		
		
		System.out.println(this.members.size());
		
	}
	
	public void addMember(Member m) {
		this.members.add(m);
	}
	
	public void updatePanels() {
		this.connectPanel = new ConnectingPanel(this.networksAvailable, this);
		this.regPanel = new RegisterPanel(this);
		this.cnPanel = new CreateNetworkPanel(this);
		this.dmdPanel = new DefaultMemberDisplayPanel(this);
	}

	public ArrayList<Member> getMembers() {
		// TODO Auto-generated method stub
		return this.members;
	}
	
	public boolean passwordCorrect(String username, String password) {
		for(Member m : this.getMembers()) {
			if(m.getName().equals(username)) return m.getPassword().equals(password);
		}
		return false;
	}

	public void addNetwork(Network n) {
		// TODO Auto-generated method stub
		this.networksAvailable.add(n);
	}

	public void setConnectedUserAndNetwork(Member m, Network network) {
		// TODO Auto-generated method stub
		this.connectedUser = m;
		this.networkSelected = network;
	}
	
	public void disconnectUserAndNetwork() {
		this.connectedUser = null;
		this.networkSelected = null;
	}

	public Network getSelectedNetwork() {
		// TODO Auto-generated method stub
		return this.networkSelected;
	}
	
	public Member getConnectedUser() {
		return this.connectedUser;
	}
	
}
