package store.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * This class represents the payment information of an Order.
 */
@Entity
@Table(name="TB_PMT")
public class Payment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2030963575895601740L;
	/**
	 * Constants for the status. This is not a guideline and
	 * we don't want to use enums in JPA, so this application
	 * is just a quick example.
	 */
	public static final String ST_SUBMITTED = "Pedido Realizado";
	public static final String ST_REFUSED = "Recusado";
	public static final String ST_PROCESSED = "Aprovado";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_PMT")
	private Integer id;
	/**
	 * The value informed in the payment.
	 */
	@Column(name="VR_PMT")	
	private BigDecimal value;
	/**
	 * The status of the payment. 'Submitted', 'Refused', 'Processed'.
	 */
	@Column(name="ST_PMT")
	private String status;
	/**
	 * This field will not be persisted. It's used only to pass this information
	 * to the payment processor 
	 */
	@Transient
	private String cardNumber;
	@Transient
	private String cardName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValue() {		
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
}
