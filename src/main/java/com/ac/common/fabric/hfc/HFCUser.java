package com.ac.common.fabric.hfc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.util.encoders.Hex;
import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;

import lombok.Data;

@Data
public class HFCUser implements User, Serializable {

	private static final long serialVersionUID = 161862165256217349L;

	private String name;
	private String enrollmentSecret;

	private Set<String> roles = null;
	private String account;
	private String affiliation;
	private String organization;

	private Enrollment enrollment = null;
	private String mspId;

	private transient HFCKeyStore keyValStore;
	private String keyValStoreName;

	public HFCUser(String name, String enrollmentSecret, String org, HFCKeyStore fs) {

		this.name = name;
		this.enrollmentSecret = enrollmentSecret;
		this.keyValStore = fs;
		this.organization = org;
		this.keyValStoreName = toKeyValStoreName(this.name, org);

		String memberStr = keyValStore.getValue(keyValStoreName);
		if (memberStr == null) {
			saveState();
		} else {
			restoreState();
		}

	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
		saveState();
	}

	/**
	 * Set the account.
	 *
	 * @param account
	 *            The account.
	 */
	public void setAccount(String account) {
		this.account = account;
		saveState();
	}

	/**
	 * Determine if this name has been registered.
	 *
	 * @return {@code true} if registered; otherwise {@code false}.
	 */
	public boolean isRegistered() {
		// return !StringUtil.isNullOrEmpty(enrollmentSecret);
		return StringUtils.isNotBlank(enrollmentSecret);
	}

	/**
	 * Determine if this name has been enrolled.
	 *
	 * @return {@code true} if enrolled; otherwise {@code false}.
	 */
	public boolean isEnrolled() {
		return this.enrollment != null;
	}

	/**
	 * Save the state of this user to the key value store.
	 */
	public void saveState() {

		try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			oos.flush();
			keyValStore.setValue(keyValStoreName, Hex.toHexString(bos.toByteArray()));
			// bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Restore the state of this user from the key value store (if found). If
	 * not found, do nothing.
	 */
	public HFCUser restoreState() {

		String memberStr = keyValStore.getValue(keyValStoreName);
		if (null != memberStr) {
			// The user was found in the key value store, so restore the
			// state.
			byte[] serialized = Hex.decode(memberStr);
			ByteArrayInputStream bis = new ByteArrayInputStream(serialized);
			try {
				ObjectInputStream ois = new ObjectInputStream(bis);
				HFCUser state = (HFCUser) ois.readObject();
				if (state != null) {
					this.name = state.name;
					this.roles = state.roles;
					this.account = state.account;
					this.affiliation = state.affiliation;
					this.organization = state.organization;
					this.enrollmentSecret = state.enrollmentSecret;
					this.enrollment = state.enrollment;
					this.mspId = state.mspId;
					return this;
				}
			} catch (Exception e) {
				throw new RuntimeException(String.format("Could not restore state of member %s", this.name), e);
			}
		}

		return null;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
		saveState();
	}

	public static String toKeyValStoreName(String name, String org) {
		return "user." + name + org;
	}

	public void setMPSID(String mspID) {
		this.mspId = mspID;
		saveState();
	}

	@Override
	public String getMspId() {
		// TODO Auto-generated method stub
		return this.mspId;
	}

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getRoles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAccount() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAffiliation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Enrollment getEnrollment() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getEnrollmentSecret() {
        return enrollmentSecret;
    }

    public void setEnrollmentSecret(String enrollmentSecret) {
        this.enrollmentSecret = enrollmentSecret;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public HFCKeyStore getKeyValStore() {
        return keyValStore;
    }

    public void setKeyValStore(HFCKeyStore keyValStore) {
        this.keyValStore = keyValStore;
    }

    public String getKeyValStoreName() {
        return keyValStoreName;
    }

    public void setKeyValStoreName(String keyValStoreName) {
        this.keyValStoreName = keyValStoreName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public void setMspId(String mspId) {
        this.mspId = mspId;
    }
    
    

}
