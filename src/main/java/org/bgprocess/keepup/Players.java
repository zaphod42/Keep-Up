package org.bgprocess.keepup;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Players {
	public List<Player> players = new ArrayList<Player>();
}
