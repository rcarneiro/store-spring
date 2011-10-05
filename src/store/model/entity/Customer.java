package store.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;

/**
 * Class who represents a Customer.   
 * @author Tarso Bessa
 * @author Rafael Carneiro
 */
@Entity
@Table(name="TB_CUSTOMER")
public class Customer implements Serializable, UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1267076889266529479L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_CUST")
	private Integer id;
	/**
	 * Customer name
	 */
	@Column(name="NM_CUST")
	private String name;
	/**
	 * Email 
	 */
	@Column(name="EM_CUST")
	private String email;
	/**
	 * Login of the customer
	 */
	@Column(name="LG_CUST")
	private String login;
	/**
	 * Yes. It's the password.
	 */
	@Column(name="PS_CUST")
	private String pass;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= CascadeType.PERSIST)
	@JoinTable(name = "T_GROUP_USER")
	private Set<Group> groups;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public GrantedAuthority[] getAuthorities() {
		
		List<GrantedAuthority> list =  new ArrayList<GrantedAuthority>();
		list.add(new GrantedAuthorityImpl("ROLE_ANONYMOUS"));
		list.addAll(groups);
		
		return list.toArray(new GrantedAuthority[]{});
	}
	@Override
	public String getPassword() {
		return pass;
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public Set<Group> getGroups() {
		return groups;
	}
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
}
