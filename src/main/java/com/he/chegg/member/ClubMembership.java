package com.he.chegg.member;

import java.util.ArrayList;
import java.util.List;

public class ClubMembership {

	List<MemberCard> memberCardList = new ArrayList<MemberCard>();

	public void addMember(MemberCard memberCard) {
		memberCardList.add(memberCard);
	}

	public boolean entry(String memberId) {
		boolean result = false;
		if (memberCardList.size() > 0) {
			for (MemberCard temp : memberCardList) {
				if (temp.getMember().getId().equalsIgnoreCase(memberId)) {
					if (temp.getPoints() > 0) {
						temp.setPoints(temp.getPoints() - 1);
						result = true;
					} else {
						result = false;
					}
				}
			}
		}
		return result;
	}

	public boolean purchase(String memberId, long points) {
		boolean result = false;
		if (memberCardList.size() > 0) {
			for (MemberCard temp : memberCardList) {
				if (temp.getMember().getId().equalsIgnoreCase(memberId)) {
					temp.setPoints(temp.getPoints() + points);
					result = true;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		while(true){
			System.out.println("1.");
		}
		
	}

}
