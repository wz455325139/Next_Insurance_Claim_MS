package com.ac.common.fabric.hfc;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric_ca.sdk.HFCAClient;

import java.util.*;

@Data
public class OrgInfo {

    private String id;
    private String name;
    private String domainName;

    private String mspid;
    private HFCAClient caClient;

    private String caLocation;
    private Properties caProperties = null;

    private HFCUser admin;
    private HFCUser peerAdmin;
    private Map<String, User> userMap = Maps.newHashMap();

    private Map<String, String> peerLocations = Maps.newHashMap();
    private Map<String, String> ordererLocations = Maps.newHashMap();
    private Map<String, String> eventHubLocations = Maps.newHashMap();

    private Set<Peer> peers = Sets.newHashSet();

    public void addPeerLocation(String name, String location) {
        peerLocations.put(name, location);
    }

    public void addOrdererLocation(String name, String location) {
        ordererLocations.put(name, location);
    }

    public void addEventHubLocation(String name, String location) {
        eventHubLocations.put(name, location);
    }

    public String getPeerLocation(String name) {
        return peerLocations.get(name);
    }

    public String getOrdererLocation(String name) {
        return ordererLocations.get(name);
    }

    public String getEventHubLocation(String name) {
        return eventHubLocations.get(name);
    }

    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    public User getUser(String name) {
        return userMap.get(name);
    }

    public void addPeer(Peer peer) {
        peers.add(peer);
    }

    public Collection<String> getOrdererLocations() {
        return Collections.unmodifiableCollection(ordererLocations.values());
    }

    public Collection<String> getEventHubLocations() {
        return Collections.unmodifiableCollection(eventHubLocations.values());
    }

    public Set<Peer> getPeers() {
        return Collections.unmodifiableSet(peers);
    }

    public Set<String> getPeerNames() {
        return Collections.unmodifiableSet(peerLocations.keySet());
    }

    public Set<String> getOrdererNames() {
        return Collections.unmodifiableSet(ordererLocations.keySet());
    }

    public Set<String> getEventHubNames() {
        return Collections.unmodifiableSet(eventHubLocations.keySet());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getMspid() {
        return mspid;
    }

    public void setMspid(String mspid) {
        this.mspid = mspid;
    }

    public HFCAClient getCaClient() {
        return caClient;
    }

    public void setCaClient(HFCAClient caClient) {
        this.caClient = caClient;
    }

    public String getCaLocation() {
        return caLocation;
    }

    public void setCaLocation(String caLocation) {
        this.caLocation = caLocation;
    }

    public Properties getCaProperties() {
        return caProperties;
    }

    public void setCaProperties(Properties caProperties) {
        this.caProperties = caProperties;
    }

    public HFCUser getAdmin() {
        return admin;
    }

    public void setAdmin(HFCUser admin) {
        this.admin = admin;
    }

    public HFCUser getPeerAdmin() {
        return peerAdmin;
    }

    public void setPeerAdmin(HFCUser peerAdmin) {
        this.peerAdmin = peerAdmin;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, String> getPeerLocations() {
        return peerLocations;
    }

    public void setPeerLocations(Map<String, String> peerLocations) {
        this.peerLocations = peerLocations;
    }

    public void setOrdererLocations(Map<String, String> ordererLocations) {
        this.ordererLocations = ordererLocations;
    }

    public void setEventHubLocations(Map<String, String> eventHubLocations) {
        this.eventHubLocations = eventHubLocations;
    }

    public void setPeers(Set<Peer> peers) {
        this.peers = peers;
    }
    

}
