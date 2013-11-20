package com.boredatlunch.whatsforlunch.Model.Polls;

public class PollItem {
	private String businessName;
	private String businessYelpId;
	private int voteCount;
	
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
}
