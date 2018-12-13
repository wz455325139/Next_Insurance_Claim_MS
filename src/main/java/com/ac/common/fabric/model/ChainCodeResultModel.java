package com.ac.common.fabric.model;

import java.util.Collection;

import org.hyperledger.fabric.sdk.ProposalResponse;

import lombok.Data;

@Data
public class ChainCodeResultModel {

	private Collection<ProposalResponse> successful = null;
	private Collection<ProposalResponse> failed = null;

	public ChainCodeResultModel(Collection<ProposalResponse> successful, Collection<ProposalResponse> failed) {
		this.successful = successful;
		this.failed = failed;
	}

    public Collection<ProposalResponse> getSuccessful() {
        return successful;
    }

    public void setSuccessful(Collection<ProposalResponse> successful) {
        this.successful = successful;
    }

    public Collection<ProposalResponse> getFailed() {
        return failed;
    }

    public void setFailed(Collection<ProposalResponse> failed) {
        this.failed = failed;
    }
	
	

}
