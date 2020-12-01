/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Valentin
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id")
    , @NamedQuery(name = "Order1.findByUFirstName", query = "SELECT o FROM Order1 o WHERE o.uFirstName = :uFirstName")
    , @NamedQuery(name = "Order1.findByULastName", query = "SELECT o FROM Order1 o WHERE o.uLastName = :uLastName")
    , @NamedQuery(name = "Order1.findByUEmail", query = "SELECT o FROM Order1 o WHERE o.uEmail = :uEmail")
    , @NamedQuery(name = "Order1.findByUZipCode", query = "SELECT o FROM Order1 o WHERE o.uZipCode = :uZipCode")
    , @NamedQuery(name = "Order1.findByUCity", query = "SELECT o FROM Order1 o WHERE o.uCity = :uCity")
    , @NamedQuery(name = "Order1.findByUAddress", query = "SELECT o FROM Order1 o WHERE o.uAddress = :uAddress")
    , @NamedQuery(name = "Order1.findByUPhone", query = "SELECT o FROM Order1 o WHERE o.uPhone = :uPhone")
    , @NamedQuery(name = "Order1.findByOrderAmount", query = "SELECT o FROM Order1 o WHERE o.orderAmount = :orderAmount")
    , @NamedQuery(name = "Order1.findByIsActive", query = "SELECT o FROM Order1 o WHERE o.isActive = :isActive")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "uFirstName")
    private String uFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "uLastName")
    private String uLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "uEmail")
    private String uEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "uZipCode")
    private String uZipCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "uCity")
    private String uCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "uAddress")
    private String uAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "uPhone")
    private String uPhone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderAmount")
    private int orderAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private int isActive;
    @JoinTable(name = "orderitem", joinColumns = {
        @JoinColumn(name = "orderID", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "productID", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Product> productCollection;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, String uFirstName, String uLastName, String uEmail, String uZipCode, String uCity, String uAddress, String uPhone, int orderAmount, int isActive) {
        this.id = id;
        this.uFirstName = uFirstName;
        this.uLastName = uLastName;
        this.uEmail = uEmail;
        this.uZipCode = uZipCode;
        this.uCity = uCity;
        this.uAddress = uAddress;
        this.uPhone = uPhone;
        this.orderAmount = orderAmount;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUFirstName() {
        return uFirstName;
    }

    public void setUFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public String getULastName() {
        return uLastName;
    }

    public void setULastName(String uLastName) {
        this.uLastName = uLastName;
    }

    public String getUEmail() {
        return uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getUZipCode() {
        return uZipCode;
    }

    public void setUZipCode(String uZipCode) {
        this.uZipCode = uZipCode;
    }

    public String getUCity() {
        return uCity;
    }

    public void setUCity(String uCity) {
        this.uCity = uCity;
    }

    public String getUAddress() {
        return uAddress;
    }

    public void setUAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getUPhone() {
        return uPhone;
    }

    public void setUPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Order1[ id=" + id + " ]";
    }
    
}
