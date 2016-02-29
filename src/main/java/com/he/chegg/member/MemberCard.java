package com.he.chegg.member;

public class MemberCard {

	private Member member;
	private CustomDate customDate;
	private long points;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public CustomDate getCustomDate() {
		return customDate;
	}

	public void setCustomDate(CustomDate customDate) {
		this.customDate = customDate;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public MemberCard(Member member, CustomDate customDate, long points) {
		super();
		this.member = member;
		this.customDate = customDate;
		this.points = points;
	}

	@Override
	public String toString() {
		return "MemberCard [member=" + member + ", customDate=" + customDate + ", points=" + points + "]";
	}

}
