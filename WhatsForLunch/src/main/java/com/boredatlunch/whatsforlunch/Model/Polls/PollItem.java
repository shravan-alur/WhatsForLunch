package com.boredatlunch.whatsforlunch.Model.Polls;

import java.util.ArrayList;
import java.util.List;

public class PollItem {
	private String businessName;
	private String businessYelpId;
	private List<String> businessAddress;
	private String businessRatingImageUrl;
	private String businessImageUrl;
	private String businessYelpUrl;
	private int voteCount;
	private List<String> itemVotersList  = new ArrayList<String>();;
	
	@Override
	public String toString() {
		return "PollItem [businessName=" + businessName + ", businessYelpId=" + businessYelpId +  ", voteCount=" + voteCount + "]";
	}
	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessYelpId() {
		return businessYelpId;
	}
	public void setBusinessYelpId(String businessYelpId) {
		this.businessYelpId = businessYelpId;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public List<String> getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(List<String> businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getBusinessRatingImageUrl() {
		return businessRatingImageUrl;
	}

	public void setBusinessRatingImageUrl(String businessRatingImageUrl) {
		this.businessRatingImageUrl = businessRatingImageUrl;
	}

	public String getBusinessImageUrl() {
		return businessImageUrl;
	}

	public void setBusinessImageUrl(String businessImageUrl) {
		this.businessImageUrl = businessImageUrl;
	}

	public String getBusinessYelpUrl() {
		return businessYelpUrl;
	}

	public void setBusinessYelpUrl(String businessYelpUrl) {
		this.businessYelpUrl = businessYelpUrl;
	}

	public List<String> getItemVotersList() {
		return itemVotersList;
	}

	public void setItemVotersList(List<String> itemVotersList) {
		this.itemVotersList = itemVotersList;
	}
}
