package com.inventory.models;

import java.util.Date;
import java.util.Objects;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", nullable = false, updatable = true, unique = true)
	private String email;
	
	@Column(name = "contact", nullable = false, updatable = true, unique = true)
	private String contact;

	@Column(nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;
	
	@Column(insertable = false)
	@LastModifiedDate
	private Date updatedAt;
	
	public User(Long id, String firstName, String lastName, String email, String contact, Integer idNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
	}

	@Override 
	public final boolean equals(Object o) { 
	  if (this == o) return true; 
	  if (o == null) return false; 
	  Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass(); 
	  Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass(); 
	  if (thisEffectiveClass != oEffectiveClass) return false; 
	  User user = (User) o; 
	  return getId() != null && Objects.equals(getId(), user.getId()); 
	} 
	 
	@Override 
	public final int hashCode() { 
	 return this instanceof HibernateProxy 
	 ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() 
	 : getClass().hashCode(); 
	}
	
}
