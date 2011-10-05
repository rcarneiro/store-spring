package store.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.GrantedAuthority;

/**
 * Classe para agrupar permissões e usuários.
 * 
 * @author Tarso Bessa
 * 
 */
@Entity(name = "Group")
@Table(name = "T_GROUPS")
public class Group implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 3158732607183646056L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_GROUP")
	private Integer id;
	@Column(name = "NM_NAME")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String getAuthority() {
		return name;
	}

	@Override
	public int compareTo(Object o) {
		return (o!=null && getAuthority()!=null) ? getAuthority().compareTo(((GrantedAuthority)o).getAuthority()): 1;
	}


}
