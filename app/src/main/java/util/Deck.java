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
            cards.add(new Card("A software or hardware that checks information coming from the Internet and depending on the " +
                    "applied configuration settings either blocks it or allows it to pass through is called:","Firewall"));
            cards.add(new Card("A device designed to forward data packets between networks is called:","Router"));
            cards.add(new Card("Allowing a connection through a firewall is known as creating:","Exception"));
            cards.add(new Card("A network device designed for managing the optimal distribution of " +
                    "workloads across multiple computing resources is called:"," Load balancer"));
            cards.add(new Card("The last default rule on a firewall is to","deny all traffic"));
            cards.add(new Card("A computer network service that allows clients to make indirect network " +
                    "connections to other network services is called:","Proxy"));
            cards.add(new Card("a security solution implemented on an individual computer host monitoring " +
                    "that specific system for malicious activities or policy violations","HIDS(Host-based Intrusion Detection System)"));
            cards.add(new Card("One of the measures for securing networking devices includes the practice of disabling unused ports","True"));
            cards.add(new Card("ensures the privacy of a VPN connection","Tunneling"));
            cards.add(new Card("a dedicated device for managing secure connections established over " +
                    "an untrusted network, such as the Internet"," VPN concentrator"));
            cards.add(new Card("refers to a network or host based monitoring system designed to automatically alert " +
                    "administrators of known or suspected unauthorized activity"," IDS(Intrusion Detection System)"));
            cards.add(new Card("A software tool used for monitoring and examining contents of the network " +
                    "traffic is known as: ","Packet sniffer\nProtocol analyzer"));
            cards.add(new Card("Which of the following answers list the protocol and port " +
                    "number used by a spam filter? ","SMTP\nPort number 25"));
            cards.add(new Card("Which of the following acronyms refers to a network security solution combining the functionality of a firewall with additional " +
                    "safeguards such as URL filtering, content inspection, or malware inspection","UTM(Unified Threat Management)"));
            cards.add(new Card("URL filtering restricts access to Internet sites based on which of the following criteria","Web address"));
            cards.add(new Card("Which of the following network security solutions inspects network traffic in " +
                    "real-time and has the capability to stop the ongoing attack","NIPS(Network-based Intrusion Prevention System)"));
            cards.add(new Card("WAF(Web Application Fire Wall)","a firewall controlling access to a web server"));
            cards.add(new Card("ACL(Access Control List)","refers to a set of rules that specify which users or system processes are granted access to objects as well as what " +
                    "operations are allowed on a given object"));
            cards.add(new Card("Which of the following actions can be taken by passive IDS(Intrusion Detection System)?","Logging\nSending an alert"));
            cards.add(new Card("802.1x is an IEEE standard defining:","Port-based network access control"));
            cards.add(new Card("An access control model in which access to resources is granted or denied " +
                    "depending on Access Control List (ACL) entries is also known as:","Rule-Based Access Control"));
            cards.add(new Card("Which of the following security solutions provides a countermeasure against denial-of-service " +
                    "attack characterized by increasing number of half-open connections","Flood guard"));
            cards.add(new Card("the protocol that protects against switching loops","STP"));
            cards.add(new Card("A type of Intrusion Detection System (IDS) that relies on known attack " +
                    "patterns to detect an intrusion is known as","signature-based IDS"));
        }else if("deck3".equals(deckId)){
            cards.add(new Card("Which of the following protocols are used for securing HTTP connections","SSL(Secure socket Layer)\nTLS(Transport Layer Security)"));
            cards.add(new Card("Refers to a suite of protocols used for connecting hosts on the Internet","TCP/IP"));
            cards.add(new Card("FTPS is an extension to the FTP that adds support for","SSL(Secure socket Layer)\nTLS(Transport Layer Security)"));
            cards.add(new Card("The SCP protocol is used for:","Secure file transfer"));
            cards.add(new Card("Which of the protocols is used by the PING utility","ICMP(Internet Control Message Protocol)"));
            cards.add(new Card("The IPv6 loopback address","::1"));
            cards.add(new Card("A networking standard for linking data storage devices over an IP network is known as","iSCSI(Internet Small Computer System Interface)"));
            cards.add(new Card("Facilitate(s) communication between SAN(Storage Area Network) devices","FCoE(Fibre Channel over Ethernet)"));
            cards.add(new Card("The FTP protocol is designed for:","File exchange"));
            cards.add(new Card("A network protocol for secure file transfer over Secure Shell (SSH) is called","SFTP(Secure File Transfer Protocol)"));
            cards.add(new Card("The protocols that does not provide authentication","TFTP"));
            cards.add(new Card("FTP runs by default on ports:","20, 21"));
            cards.add(new Card("Run(s) on port number 22","SSH(Secure Shell), SCP(Secure copy), SFTP(Secure file transfer protocol)"));
            cards.add(new Card("Port number 23 is used by:","Telnet"));
            cards.add(new Card("Which of the following TCP ports is used by SMTP(Simple Mail Transfer Protocol)?","25"));
            cards.add(new Card("DNS(Domain Name Service (Server)) runs on port","53"));
            cards.add(new Card("An HTTP traffic can be enabled by opening port","80"));
            cards.add(new Card("Which ports enable(s) retrieving email messages from a remote server","110, 143"));
            cards.add(new Card("Which of the port numbers are used by NetBIOS","137, 138, 139"));
            cards.add(new Card("IMAP(Internet Message Access Protocol) runs on TCP port","143"));
            cards.add(new Card("Which TCP ports is used by HTTPS","443"));
            cards.add(new Card("The default port number for a Microsoft-proprietary remote connection protocol","3389"));
            cards.add(new Card("Which of the following protocols operate(s) at layer 3 (the network layer) of the OSI model",
                    "IPsec, IPv6, IPv4, ICMP(Internet Control Message Protocol)"));
            cards.add(new Card("Internet Protocol Security (IPsec)","a protocol suite for secure Internet Protocol (IP) communications by authenticating and " +
                    "encrypting each IP packet of a communication session"));
            cards.add(new Card("Internet Control Message Protocol(ICMP)","is one of the main protocols of the internet protocol suite. It is used by network devices, like routers, to send error messages indicating, " +
                    "for example, that a requested service is not available or that a host or router could not be reached."));
            cards.add(new Card("In the OSI model, TCP resides at the","Transport layer"));
        }else if("deck4".equals(deckId)) {
            cards.add(new Card("A wireless encryption schemes that offers the highest level of protection", "WPA2"));
            cards.add(new Card("A wireless security protocol that has been deprecated in favor of newer " +
                    "standards due to known vulnerabilities", "WEP(Wired Equivalent Privacy)"));
            cards.add(new Card("An authentication framework frequently used in wireless networks " +
                    "and point-to-point connections", "EAP(Extensible Authentication Protocol)"));
            cards.add(new Card("A network access control method whereby the 48-bit address assigned to " +
                    "each network card is used to determine access to the network is known as", "MAC filter"));
            cards.add(new Card("A wireless network name is also referred to as:", "SSID(Service Set Identifier)"));
            cards.add(new Card("Which of the following protocols was introduced to strengthen existing WEP " +
                    "implementations without requiring the replacement of legacy hardware", "TKIP(Temporal Key Integrity Protocol)"));
            cards.add(new Card("Disabling SSID broadcast:", "Makes a WLAN harder to discover"));
            cards.add(new Card("The protocols encapsulates EAP within an encrypted and authenticated TLS tunnel",
                    "PEAP(Protected Extensible Authentication Protocol)"));
            cards.add(new Card("AES-based encryption mode implemented in WPA2 is known as:", "CCMP"));
            cards.add(new Card("An optimal WAP antenna placement provides a countermeasure against:", "War driving\nSite survey"));
            cards.add(new Card("WAP configuration settings that allows for adjusting the boundary range of the wireless signal",
                    "Power level controls"));
            cards.add(new Card("A solution allowing administrators to block Internet access for " +
                    "users until they perform required action", "Captive portal"));
            cards.add(new Card("Which of the following antenna types would provide the best coverage for workstations " +
                    "connecting to a WAP placed in a central point of a typical office", "Omnidirectional\nNon-directional"));
            cards.add(new Card("Refers to wireless site survey", "War driving"));
            cards.add(new Card("A technical security control", "Intrusion Detection System (IDS)"));
            cards.add(new Card("An antivirus software identifying non-malicious file as a virus due " +
                    "to faulty virus signature file is an example of:", "False positive error"));
            cards.add(new Card("An operational security control", "Change management"));
            cards.add(new Card("A term that refers to a situation where no alarm is raised when an attack has " +
                    "taken place", "False negative"));
            cards.add(new Card("A policy outlining ways of collecting and managing personal data is known as", "Privacy policy"));
            cards.add(new Card("An acronym which refers to a set of rules enforced in a network that restrict the " +
                    "use to which the network may be put", "AUP(Acceptable Use Policy)"));
            cards.add(new Card("One of the goals behind the mandatory vacations policy is", "to mitigate the occurrence of fraudulent " +
                    "activity within the company"));
            cards.add(new Card("A concept of having more than one person required to complete a given task", "Separation of duties"));
            cards.add(new Card("A security rule that prevents users from accessing information " +
                    "and resources that lie beyond the scope of their responsibilities is known as", "Principle of least privilege"));
            cards.add(new Card("Refers to a risk assessment formula defining probable financial " +
                    "loss due to a risk over a one-year period", "ALE(annualized loss expectancy)"));
        } else if("deck5".equals(deckId)){
            cards.add(new Card("Used to describe the loss of value to an asset based on a single " +
                    "security incident","SLE(Single Loss Expectancy)"));
            cards.add(new Card("An estimate based on the historical data of how often a threat would be " +
                    "successful in exploiting a vulnerability is known as","ARO(Annualized Rate of Occurrence)"));
            cards.add(new Card("Refers to the correct formula for calculating probable financial loss " +
                    "due to a risk over a one-year period","ALE = ARO x SLE"));
            cards.add(new Card("Used to describe the average time required to repair a " +
                    "failed component or device","MTTR(Mean Time To Recover)"));
            cards.add(new Card("A calculation of the Single Loss Expectancy (SLE) is an example of","Quantitative risk assessment"));
            cards.add(new Card("Assessment of risk probability and its impact based on " +
                    "subjective judgment falls into the category of","Qualitative risk assessment"));
            cards.add(new Card("A path or tool allowing an attacker to gain unauthorized " +
                    "access to a system or network is known as","Threat vector"));
            cards.add(new Card("In quantitative risk assessment, this term is used for " +
                    "estimating the likelihood of occurrence of a future threat.","ARO(Annualized Rate of Occurrence)"));
            cards.add(new Card("Contracting out a specialized technical component when the " +
                    "company's employees lack the necessary skills is an example of","Risk transference"));
            cards.add(new Card("Disabling certain system functions or shutting down the system when " +
                    "risks are identified is an example of","Risk avoidance"));
            cards.add(new Card("Which of the answers listed below exemplifies an " +
                    "implementation of risk transference methodology","Insurance policy"));
            cards.add(new Card("Relates closely to the concept of residual risk","Risk acceptance"));
            cards.add(new Card("What type of risk management strategy is in place when accessing the network involves a login banner " +
                    "warning designed to inform potential attacker of the likelihood of getting caught","Risk deterrence"));
            cards.add(new Card("Which of the following security control types can be used in " +
                    "implementing a risk mitigation strategy","Technical\nManagement\nOperational"));
            cards.add(new Card("One of the hardware-related disadvantages of the virtualization technology","Single point of failure"));
            cards.add(new Card("Which of the following acronyms refers to a maximum tolerable period of time required " +
                    "for restoring business functions after a failure or disaster","RTO(Recovery Time Objective)"));
            cards.add(new Card("An agreement between a service provider and the user(s) defining the nature, " +
                    "availability, quality, and scope of the service to be provided is known as","SLA(Service Level Agreement)"));
            cards.add(new Card("Which of the following answers refers to a key document governing " +
                    "the relationship between two business organisations","BPA(Business Partners Agreement)"));
            cards.add(new Card("A document established between two or more parties to define their respective" +
                    " responsibilities in accomplishing a particular goal or mission is known as","MOU(Memorandum Of Understanding)"));
            cards.add(new Card("an agreement established between the organizations that own and operate connected IT " +
                    "systems to document the technical requirements of the interconnection","ISA(Interconnection Security Agreement)"));
            cards.add(new Card("Allows a DLP(Data Loss Prevention) system to fulfil its role","Content inspection"));
            cards.add(new Card("In forensic procedures, a sequence of steps in which different " +
                    "types of evidence should be collected is known as","Order of volatility"));
            cards.add(new Card("In forensic procedures, a chronological record outlining persons in " +
                    "possession of an evidence is referred to as","Chain of custody"));
        } else if("deck6".equals(deckId)) {
            cards.add(new Card("An example order of volatility for a typical computer system",
                    "Memory dump\ntemporary files\ndisk files\narchival media"));
            cards.add(new Card("An exact copy of the entire state of a computer system is called", "System image"));
            cards.add(new Card("In forensic analysis, taking hashes ensures that " +
                    "the collected evidence retains", "Integrity"));
            cards.add(new Card("Refers to any type of information pertaining to an individual that " +
                    "can be used to uniquely identify that person", "PII(Personally identifiable information)"));
            cards.add(new Card("A sticky note with a password kept on sight in user's " +
                    "cubicle would be a violation of which of the following policies", "Clean desk policy"));
            cards.add(new Card("A security control that is used to prevent tailgating", "Mantraps"));
            cards.add(new Card("Zero-day attack exploits", "Vulnerability that is present in already released " +
                    "software but unknown to the software developer"));
            cards.add(new Card("A system combining heating, ventilating, and air conditioning controls is known as", "HVAC"));
            cards.add(new Card("EMI shielding protects the transferred data from", "Outside interference\nEavesdropping"));
            cards.add(new Card("Setting up hot and cold aisles in a server room allows for", "more efficient management of air flow"));
            cards.add(new Card("Examples of physical security control types", "Biometrics\nMotion detection\nVideo surveillance"));
            cards.add(new Card("Examples of deterrent security control", "Lighting\nSigns\nFencing\nBarricades\nGuards"));
            cards.add(new Card("Solutions that add(s) redundancy in areas identified as single points of failure",
                    "RAID(redundant array of independent disks)\nHot site\nUPS(uninterpretable power supply)\nBackup generator"));
            cards.add(new Card("A data storage virtualization technology that combines multiple physical disk drive components into a single logical unit for the " +
                    "purposes of data redundancy, performance improvement, or both", "RAID(redundant array of independent disks)"));
            cards.add(new Card("What is the goal of tabletop exercises", "Disaster recovery planning\nDiscussing a simulated emergency situation"));
            cards.add(new Card("Hardware-based RAID Level 0", "Doesn't offer fault tolerance\nRequires at least two drives to implement"));
            cards.add(new Card("Which of the following solutions does not offer fault tolerance", "RAID 0"));
            cards.add(new Card("A method for passive test of security controls", "Vulnerability scan"));
            cards.add(new Card("Hardware-based RAID Level 1", "Requires at least 2 drives to implement\nIs also referred to as disk mirroring"));
            cards.add(new Card("Offers improved reliability by creating identical data sets on each drive " +
                    "(failure of one drive does not destroy the array, as each drive contains identical copy of the data)", "Hardware-based RAID Level 1"));
            cards.add(new Card("Hardware-based RAID Level 5", "Requires at least 3 drives to implement"));
            cards.add(new Card("Offers increased performance and fault tolerance (single drive failure does not destroy " +
                    "the array and lost data can be re-created from the remaining drives)", "Hardware-based RAID Level 5"));
            cards.add(new Card("What is the function of archive bit", "Indicating whether a file has been modified since the last backup"));
            cards.add(new Card("Refers to a backup technique that allows for creating an exact copy of an entire drive and replicating the drive to a new computer " +
                    "or to another drive on the same computer in case of hard drive failure", "Drive imaging"));
            cards.add(new Card("Restoring data from an incremental backup requires", "All copies of incremental backups made since the last full backup\nCopy of the last full backup"));
            cards.add(new Card("A United States federal government initiative aimed at enabling agencies to continue their essential functions " +
                    "across a broad spectrum of emergencies is known as", "COOP"));
        }else if("deck7".equals(deckId)){
            cards.add(new Card("Backup site types allows for fastest disaster recovery","Hot site"));
            cards.add(new Card("The least expensive type of backup site for an organization to operate","Cold site"));
            cards.add(new Card("Security controls provide(s) confidentiality","Encryption\nSteganography"));
            cards.add(new Card("Steganography allows for","Hiding data within another piece of data"));
            cards.add(new Card("Security controls provide(s) integrity","Hashing\nDigital Signatures\nNon-repudiation"));
            cards.add(new Card("What is the purpose of non-repudiation","Preventing someone from denying that they have taken specific action"));
            cards.add(new Card("A general term used to describe software designed specifically to damage or disrupt the " +
                    "operation of a computer system","Malware"));
            cards.add(new Card("What is adware","Software that displays advertisements"));
            cards.add(new Card("A computer program containing malicious segment that attaches " +
                    "itself to an application program or other executable component is called","Virus"));
            cards.add(new Card("Malicious software collecting information about " +
                    "users without their knowledge / consent is called","Spyware"));
            cards.add(new Card("Malicious software performing unwanted and harmful actions in " +
                    "disguise of a legitimate and useful program","Trojan horse"));
            cards.add(new Card("Software that cannot be clearly classified as malware is referred to as","Grayware"));
            cards.add(new Card("What is the function of Windows Defender software","Protection against spyware and other " +
                    "potentially unwanted software"));
            cards.add(new Card("A collection of software tools used by a hacker in order to mask intrusion and " +
                    "obtain administrator-level access to a computer or computer network is known as","Rootkit"));
            cards.add(new Card("An undocumented way of gaining access to a program, " +
                    "online service or an entire computer system","Backdoor"));
            cards.add(new Card("Malicious code activated by a specific event is known as","Logic bomb"));
            cards.add(new Card("A group of computers running malicious software under " +
                    "control of a hacker is referred to as","Botnet"));
            cards.add(new Card("Malware that restricts access to a computer system by encrypting files " +
                    "or locking the entire system down until the user performs requested action is known as","Ransomware"));
            cards.add(new Card("The process by which malicious software changes its " +
                    "underlying code to avoid detection is called","Polymorphism"));
            cards.add(new Card("A type of virus that takes advantage of various mechanisms specifically designed to make tracing, " +
                    "disassembling and reverse engineering its code more difficult is known as","Armored virus"));
            cards.add(new Card("An example of active eavesdropping","MITM"));
            cards.add(new Card("Uses multiple compromised computer systems against its target","DDoS"));
            cards.add(new Card("When an attacker intercepts user credentials and tries to use this information " +
                    "later for gaining unauthorized access to resources on a network","A replay attack"));
            cards.add(new Card("Authentication protocols offer(s) countermeasures against replay attacks","IPsec\nKerberos"));
            cards.add(new Card("An email sent from unknown source disguised as a source known to the " +
                    "message receiver is an example of","Spoofing"));
            cards.add(new Card("BIA Business Impact Analysis","Identify critical systems and components"));
            cards.add(new Card("CIA triad","Confidentiality\nIntegrity\nAvailability"));
            cards.add(new Card("Attributes of Confidentiality","Encryption\nAccess controls\nSteganography"));
            cards.add(new Card("Attributes of Integrity","Digital Signatures\nCertificates\nNon-repudiation"));
            cards.add(new Card("Attributes of Availability","Redundancy\nFault Tolerance\nPatching"));
            cards.add(new Card("Types of Malware","Virus\nWorm\nTrojan"));
            cards.add(new Card("Pharming Attack","malicious person will seek to corrupt the ips/ DNS poisoning – change the ip address on the DNS table"));
        }else if("deck8".equals(deckId)){
            cards.add(new Card("Attributes of a smurf attack","IP spoofing\nDDoS\nLarge amount of ICMP echo replies"));
            cards.add(new Card("MITM attack","Man-in-the-middle attack, where the attacker secretly relays and possibly " +
                    "alters the communication between two parties who believe they are directly communicating with each other"));
            cards.add(new Card("Smurf Attack","a distributed denial-of-service attack in which large numbers of Internet Control Message Protocol (ICMP) packets with the intended " +
                    "victim's spoofed source IP are broadcast to a computer network using an IP Broadcast address"));
            cards.add(new Card("Phishing/Social engineering","A fraudulent email requesting its recipient to reveal sensitive information " +
                    "(e.g. user name and password) used later by an attacker for the purpose of identity theft"));
            cards.add(new Card("Spim","Unsolicited messages received over an instant messaging system"));
            cards.add(new Card("The practice of using a telephone system to manipulate " +
                    "user into disclosing confidential information is called","Vishing"));
            cards.add(new Card("Phishing scams targeting a specific group of " +
                    "users are referred to as","Spear phishing"));
            cards.add(new Card("Port scan\nDenial-of-service attack\n","apply to xmas attack"));
            cards.add(new Card("The characteristic features of pharming","DNS poisoning\nDomain spoofing"));
            cards.add(new Card("The DNS service is used for translating","Domain names into IP addresses"));
            cards.add(new Card("Refers to a DNS poisoning attack","Pharming"));
            cards.add(new Card("Address Resolution Protocol (ARP) translates","IP addresses into MAC addresses\nNetwork layer addresses into link layer addresses"));
            cards.add(new Card("Takes advantage of the spoofed MAC address","ARP poisoning"));
            cards.add(new Card("Password attacks requires the most computing power","Brute force attack"));
            cards.add(new Card("Password attack that takes advantage of a predefined list of words","Dictionary attack"));
            cards.add(new Card("Rainbow tables","Tables used to speed up the process of password guessing"));
            cards.add(new Card("The contents of a rainbow table entry","Hash / Password"));
            cards.add(new Card("Typo squatting","refers to the practice of registering misspelled domain name closely resembling " +
                    "other well established and popular domain name in hopes of " +
                    "getting Internet traffic from users who would make errors while typing in " +
                    "the web address in their browsers"));
            cards.add(new Card("URL hijacking is also referred to as","Typo squatting"));
            cards.add(new Card("Countermeasures prevent shoulder surfing","Privacy filters\nScreensavers"));
            cards.add(new Card("What is tailgating","Gaining unauthorized access to restricted areas by following another person"));
            cards.add(new Card("Phishing scams targeting people holding high positions in an organization or business are known as","Whaling"));
            cards.add(new Card("Fall(s) into the category of social engineering attacks","Whaling\nShoulder surfing\nDumpster diving\nTailgating\nVishing"));
            cards.add(new Card("Evil twin","Example of rogue access point"));
            cards.add(new Card("The term \"war driving\" refers to","Scanning for unsecured wireless networks while driving in a car\t"));
            cards.add(new Card("Sending unsolicited messages over Bluetooth is known as","Bluejacking"));
        }else if ("deck9".equals(deckId)){
            cards.add(new Card("The practice of gaining unauthorized access to a Bluetooth device is referred to as","Bluesnarfing"));
            cards.add(new Card("What is war chalking","Marking unsecured wireless networks"));
            cards.add(new Card("An attack aimed at exploiting the vulnerability of WEP","IV attack"));
            cards.add(new Card("simplifies configuration of new wireless networks by providing non-technical " +
                    "users with a capability to easily configure network security settings " +
                    "and add new devices to an existing network","WPS"));
            cards.add(new Card("Refers to a Wi-Fi Protected Setup (WPS) exploit","PIN recovery"));
            cards.add(new Card("Wireless security features should not be used due to their known vulnerabilities","WPS\nWEP"));
            cards.add(new Card("What type of action allows an attacker to exploit the XSS vulnerability","Code injection"));
            cards.add(new Card("A common target of cross-site scripting","Dynamic web pages"));
            cards.add(new Card("Which of the following answers refers to a countermeasure against code injection","Input validation"));
            cards.add(new Card("An HTTP exploit which allows attackers to access " +
                    "restricted directories and execute commands outside of the web server's root directory is known as","Directory traversal attack"));
            cards.add(new Card("A temporary area of memory allocated with a " +
                    "fixed size for holding data while it's waiting to be transferred to another location is known as","Buffer"));
            cards.add(new Card("A type of attack aimed at exploiting vulnerability that is " +
                    "present in already released software but unknown to the software developer is called","Zero-day attack"));
            cards.add(new Card("Refers to flash cookies","LSO(Local shared objects) pieces of data that websites which use Adobe Flash may store on a user's computer"));
            cards.add(new Card("A type of exploit that relies on overwriting the " +
                    "contents of memory in order to cause unpredictable results in an " +
                    "application is called","Buffer overflow"));
            cards.add(new Card("What kind of general term is used to describe the process of securing a computer system","Hardening"));
            cards.add(new Card("Security control types that fall into the category of detection controls","CCTV monitoring\nMotion sensors\nIDS"));
            cards.add(new Card("The process of OS hardening involves","Disabling unnecessary services\nPassword protection\nDisabling unnecessary accounts"));
            cards.add(new Card("Security control types that fall into the category of preventative controls","Fencing\nHardware locks\nMantraps"));
            cards.add(new Card("A monitored host containing no valuable data specifically designed to " +
                    "detect unauthorized access attempts is known as","Honeypot"));
            cards.add(new Card("Penetration test with the full prior knowledge on " +
                    "how the system that is to be tested works is called","White box"));
            cards.add(new Card("The practice of finding vulnerability in an application by " +
                    "feeding it incorrect input is known as","Fuzzing"));
            cards.add(new Card("Which of the following programming aspects " +
                    "are critical in secure application development process","Input validation\nError and exception handling"));
            cards.add(new Card("A computer system used to divert the attacker's attention from corporate network is known as","Honeypot"));
            cards.add(new Card("Which of the following answers refers to a user interface element " +
                    "on mobile devices controlling access to a device after the device is switched on","Screen lock"));
        }else if("deck10".equals(deckId)){
            cards.add(new Card("The characteristic features of an advertising-supported software",
                    "Advertisements embedded in a computer application\nA type of software commonly referred to as adware"));
            cards.add(new Card("A computer program containing malicious " +
                    "segment that attaches itself to an application program or other executable component is called","Virus"));
            cards.add(new Card("In computer security, the part of malware " +
                    "code responsible for performing malicious action is referred to as","Payload"));
            cards.add(new Card("Malicious software collecting information " +
                    "about users without their knowledge/consent is known as","Spyware"));
            cards.add(new Card("Malicious software performing unwanted and harmful " +
                    "actions in disguise of a legitimate and useful program is known as","Trojan"));
            cards.add(new Card("Which type of files pose the greatest risk related to the distribution of malware",".exe"));
            cards.add(new Card("drive-by download","an automatic download performed without the user's consent " +
                    "(and often without any notice) aimed at installing malware or potentially unwanted programs"));
            cards.add(new Card("A collection of zombies is known as","Botnet"));
            cards.add(new Card("An example of spyware","Keylogger"));
            cards.add(new Card("A computer virus that actively attacks an antivirus " +
                    "program in an effort to prevent detection is called","Retrovirus"));
            cards.add(new Card("A collection of software tools used by a hacker in order to mask " +
                    "intrusion and obtain administrator-level access to a " +
                    "computer or computer network is known as","Rootkit"));
            cards.add(new Card("Which of the following answers refers to an " +
                    "undocumented (and often legitimate) way of gaining access to a program, " +
                    "online service or an entire computer system","Backdoor"));
            cards.add(new Card("The process of isolation of files and applications suspected " +
                    "of containing malware in order to prevent further execution and potential " +
                    "harm to the user's system is known as","Quarantine"));
            cards.add(new Card("Computer code or command that takes " +
                    "advantage of a design flaw in software is commonly referred to as","Exploit"));
            cards.add(new Card("Ways of delivering online advertising content utilized by adware","Pop-up\nPop-under"));
            cards.add(new Card("A computer that has been compromised by a virus or " +
                    "Trojan horse that puts it under the remote control of an online hijacker is called","Zombie"));
            cards.add(new Card("Deletes or corrupts contents of the target host file instead of attaching itself to the file","Phage virus"));
            cards.add(new Card("A method employed by many computer antivirus programs designed to detect " +
                    "previously unknown types of malware","Heuristics"));
            cards.add(new Card("A group of computers running malicious software under control of a hacker is known as","Botnet"));
            cards.add(new Card("A type of mobile software that while running in disguise of a legitimate " +
                    "program tries to harm user devices or personal data","Malicious app"));
            cards.add(new Card("Anti-malware solutions","Anti-spyware\nAntivirus\nAnti-spam\nPop-up blocker"));
            cards.add(new Card("Components pose a risk of unintended downloading and execution of malware on a PC","Browser plugins\nActiveX controls"));
            cards.add(new Card("A type of rogue application that exploits dialup connections " +
                    "by making unauthorized telephone calls is known as","Dialer"));
            cards.add(new Card("An anti-antivirus exploit","Retrovirus"));
            cards.add(new Card("A malware-infected networked host under remote control of a hacker is commonly referred to as","Bot"));
            cards.add(new Card("A technique used by certain types of malware to cause an " +
                    "error in a program and make it easier to run malicious code","Buffer overflow"));
            cards.add(new Card("A software that automatically plays, displays, " +
                    "or downloads advertisements to a computer is known as","Adware"));
            cards.add(new Card("A type of virus that takes advantage of various mechanisms specifically " +
                    "designed to make tracing, disassembling and reverse engineering its code more difficult is known as","Armored virus"));
            cards.add(new Card("a network security solution combining the functionality of a " +
                    "firewall with additional safeguards such as URL filtering, content " +
                    "inspection, or malware inspection","UTM"));
            cards.add(new Card("Data files containing detection and/or " +
                    "remediation code that antivirus or antispyware products use to " +
                    "identify malicious code are known as","Signature files"));
            cards.add(new Card("Malicious code activated by a specific event is known as","Logic bomb"));
            cards.add(new Card("The process by which a computer virus makes " +
                    "copies of itself to carry out subsequent infections","Replication"));
            cards.add(new Card("A type of Trojan designed to transfer other malware onto a PC via Internet connection is known as","Downloader"));
            cards.add(new Card("Which security measure is in place when a client is denied access to the network due to outdated antivirus software","NAC"));
            cards.add(new Card("A type of Trojan designed to install other malware files onto " +
                    "a PC without the need for an active Internet connection is known as","Dropper"));
            cards.add(new Card("An antivirus software can be kept up to date through","Engine updates\nVirus signature updates"));

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
