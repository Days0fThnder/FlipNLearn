package util;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jean-Leman on 2/10/2016.
 */
public class Deck {



    private TextView cardMsg;
    private ArrayList<Card> cards = new ArrayList<>();
    private int deckSize;
    private int cardSize;


    public ArrayList<Card> buildCard (String deckId) {
        if("deck1".equals(deckId)) {
            cards.add(new Card("Demilitarized Zone(DMZ)", "A lightly protected subnet placed on " +
                    "the outside of the company's firewall consisting of publicly available servers"));
            cards.add(new Card("Which part of the 192.168.1.5/24 address " +
                    "identifies its network ID?", "192.168.1"));
            cards.add(new Card("PBX", "solution allowing companies to cut " +
                    "costs related to the managing of internal calls"));
            cards.add(new Card("VoIP", "a solution that allows to make phone calls " +
                    "over a broadband internet connection"));
            cards.add(new Card("/27 subnet mask", "255.255.255.224"));
            cards.add(new Card("What type of system can be compromised through phreaking", "PBX"));
            cards.add(new Card("Virtual Local Area Network()", "a logical grouping of computers that allow computer" +
                    "hosts to act as if they were attached to the same broadcast domain, regardless of their physical location"));
            cards.add(new Card("NAC(Network Access Control)", "a security measure in place when a client is denied access to the network " +
                    "due to outdated antivirus software"));
            cards.add(new Card("Virtualization", "a technology that allows multiple operating systems to " +
                    "work simultaneously on the same hardware"));
            cards.add(new Card("A security stance whereby a host is being granted / denied " +
                    "permissions based on its actions after it has been provided with the access to the network", "Post-admission NAC"));
            cards.add(new Card("A solution used to hide the internal IP addresses by modifying IP address information in " +
                    "IP packet headers while in transit across a traffic routing device ", "NAT(Network Address Translation)"));
            cards.add(new Card("VLAN membership can be set through:", "Trunk port\nPhysical address\nMAC address"));
            cards.add(new Card("the cloud computing infrastructure types clients, instead of buying all the hardware and software, " +
                    "purchase computing resources as an outsourced service from suppliers who own a" +
                    "nd maintain all the necessary equipment", "IaaS"));
            cards.add(new Card("cloud service types would provide the best solution for a " +
                    "web developer intending to create a web app", "PaaS"));
            cards.add(new Card("A cloud computing infrastructure type where applications are hosted over a network " +
                    "(typically Internet) eliminating the need to install and run the software on the customer's own computers is called", "SaaS"));
            cards.add(new Card("The biggest advantage of public cloud is that all services provided through " +
                    "this type of cloud computing service model are offered free of charge", "False"));
            cards.add(new Card("A concept of effective security posture employing multiple tools and " +
                    "different techniques to slow down an attacker is known as:", "Layered security\nDefense in depth"));
            cards.add(new Card("Which of the IPsec modes provides entire packet encryption?", "Tunnel"));
            cards.add(new Card("Which of the protocols listed below is used in network management systems for monitoring network-attached devices?", "SNMP(Simple Network Management Protocol )"));
            cards.add(new Card("Which of the following protocols transmit(s) data in an unencrypted form?", "SNMPv1(Simple Network Management Protocol)\nFTP\nTelnet"));
            cards.add(new Card("designed as a secure replacement for Telnet", "SSH"));
            cards.add(new Card("A system used to convert a computer's host name into an IP address on the Internet is known as", "DNS (Domain Name Service (Server))"));
        }else if("deck2".equals(deckId)){
            cards.add(new Card("test1","ans1"));
            cards.add(new Card("test2","ans2"));
        }

        //setCardMsg(cardMsg);
        //getCardMsg().setText("Swipe for question and answers");
        return cards;

    }

    public TextView getCardMsg() {
        return cardMsg;
    }

    public void setCardMsg(TextView cardMsg) {
        this.cardMsg = cardMsg;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public int getCardSize() {
        return cardSize;
    }

    public void setCardSize(int cardSize) {
        this.cardSize = cardSize;
    }


}
