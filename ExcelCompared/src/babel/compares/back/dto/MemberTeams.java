package babel.compares.back.dto;

import java.util.Comparator;
import java.util.Objects;

public class MemberTeams {
	public String name;
	public String email;
	public String category; 
	public String localitation;
	
	//Constructors
	public MemberTeams() { }
	
	
	public MemberTeams(String name, String emial, String category, String localitation) {
		this.name = name;
		this.email = email;
		this.category = category;
		this.localitation = localitation;
	}
	
	/* hashCode, equal & toSTring */
	@Override
	public int hashCode() {
		return Objects.hash(category, localitation, name, email);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MemberTeams)) {
			return false;
		}
		MemberTeams other = (MemberTeams) obj;
		return Objects.equals(category, other.category) && Objects.equals(localitation, other.localitation)
				&& Objects.equals(name, other.name) && Objects.equals(email, other.email);
	}


	@Override
	public String toString() {
		return "ListTeam [name=" + name + ", email=" + email +", category=" + category + ", localitation=" + localitation + "]";
	}
	
	/* Getters && Setters*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocalitation() {
		return localitation;
	}
	public void setLocalitation(String localitation) {
		this.localitation = localitation;
	}
	
	public static final Comparator<MemberTeams> ORDERBYNAME = new Comparator<MemberTeams>() {
		@Override
		public int compare(MemberTeams m1, MemberTeams m2) {
			return new String(m1.getName()).compareTo(new String(m2.getName()));
		}
	};
}
