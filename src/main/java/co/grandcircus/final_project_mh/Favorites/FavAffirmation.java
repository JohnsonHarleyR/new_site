package co.grandcircus.final_project_mh.Favorites;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "favorite_affirmations")
public class FavAffirmation implements Comparable<FavAffirmation> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date datetime;
	private String affirmation;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "on_profile")
	private int onProfile;
	
	public FavAffirmation() {}
	
	
	
	public FavAffirmation(Date datetime, String affirmation, Long userId) {
		super();
		this.datetime = datetime;
		this.affirmation = affirmation;
		this.userId = userId;
		
		onProfile = 0;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getAffirmation() {
		return affirmation;
	}
	public void setAffirmation(String affirmation) {
		this.affirmation = affirmation;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	public int getOnProfile() {
		return onProfile;
	}



	public void setOnProfile(int onProfile) {
		this.onProfile = onProfile;
	}

	

	
	@Override
	public String toString() {
		return "FavAffirmation [id=" + id + ", datetime=" + datetime + ", affirmation=" + affirmation + ", userId="
				+ userId + ", onProfile=" + onProfile + "]";
	}



	//Compare by date. If they're the same, compare by id order.
	//(Guess you could probably just compare by id but oh well. This is
	//more error proof.)
	@Override
	public int compareTo(FavAffirmation o) {
		if (datetime == o.getDatetime()) {
			return id.compareTo(o.getId());
		} else {
			return datetime.compareTo(o.getDatetime());
		}
		
	}
	
	
	
	
}
