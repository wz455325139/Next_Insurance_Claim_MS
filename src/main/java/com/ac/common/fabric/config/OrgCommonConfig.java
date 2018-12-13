package com.ac.common.fabric.config;

import lombok.Data;

@Data
public class OrgCommonConfig {

	private String id;
	private String name;

	private String mspid;
	private String domname;

	private String caLocation;
	private String peerLocations;
	private String ordererLocations;
	private String eventhubLocations;

	private User admin = new User();
	private User user = new User();

	@Data
	public static class User {
		private String name;
		private String password;
		private String privateKey;
		private String publicKey;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getPrivateKey() {
            return privateKey;
        }
        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }
        public String getPublicKey() {
            return publicKey;
        }
        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
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

    public String getMspid() {
        return mspid;
    }

    public void setMspid(String mspid) {
        this.mspid = mspid;
    }

    public String getDomname() {
        return domname;
    }

    public void setDomname(String domname) {
        this.domname = domname;
    }

    public String getCaLocation() {
        return caLocation;
    }

    public void setCaLocation(String caLocation) {
        this.caLocation = caLocation;
    }

    public String getPeerLocations() {
        return peerLocations;
    }

    public void setPeerLocations(String peerLocations) {
        this.peerLocations = peerLocations;
    }

    public String getOrdererLocations() {
        return ordererLocations;
    }

    public void setOrdererLocations(String ordererLocations) {
        this.ordererLocations = ordererLocations;
    }

    public String getEventhubLocations() {
        return eventhubLocations;
    }

    public void setEventhubLocations(String eventhubLocations) {
        this.eventhubLocations = eventhubLocations;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
	
	

}
