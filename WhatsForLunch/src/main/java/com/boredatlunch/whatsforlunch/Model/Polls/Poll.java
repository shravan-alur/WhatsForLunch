package com.boredatlunch.whatsforlunch.Model.Polls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Poll {
	@Id
	private String pollId;
	private String creatorName;
	private String creatorEmail;
	private Date createdTimestamp;
	private List<PollItem> pollBusinessesList = new ArrayList<PollItem>();
	private List<String> expiredVotersList = new ArrayList<String>();
	public List<String> getExpiredVotersList() {
		return expiredVotersList;
	}
	public void setExpiredVotersList(List<String> expiredVotersList) {
		this.expiredVotersList = expiredVotersList;
	}
	private int numberOfVoters;
	
	@Override
	public String toString() {
		return "Poll [pollId=" + pollId + ", creatorName=" + creatorName + ", creatorEmail=" + creatorEmail +  ", createdTimestamp=" + createdTimestamp + ", pollBusinessesList=" + pollBusinessesList + "]";
	}
	public String getPollId() {
		return pollId;
	}
	public void setPollId(String pollId) {
		this.pollId = pollId;
	}
	public int getNumberOfVoters() {
		return numberOfVoters;
	}
	public void setNumberOfVoters(int numberOfVoters) {
		this.numberOfVoters = numberOfVoters;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getCreatorEmail() {
		return creatorEmail;
	}
	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public List<PollItem> getPollBusinessesList() {
		return pollBusinessesList;
	}
	public void setPollBusinessesList(List<PollItem> pollBusinessesList) {
		this.pollBusinessesList = pollBusinessesList;
	}
	
	
}
