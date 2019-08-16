/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "tra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tra.findAll", query = "SELECT t FROM Tra t")
    , @NamedQuery(name = "Tra.findById", query = "SELECT t FROM Tra t WHERE t.id = :id")
    , @NamedQuery(name = "Tra.findByAssignmentAddress", query = "SELECT t FROM Tra t WHERE t.assignmentAddress = :assignmentAddress")
    , @NamedQuery(name = "Tra.findByRequestType", query = "SELECT t FROM Tra t WHERE t.requestType = :requestType")
    , @NamedQuery(name = "Tra.findByDepartureDate", query = "SELECT t FROM Tra t WHERE t.departureDate = :departureDate")
    , @NamedQuery(name = "Tra.findByDepartureTime", query = "SELECT t FROM Tra t WHERE t.departureTime = :departureTime")
    , @NamedQuery(name = "Tra.findByDepartureTransportation", query = "SELECT t FROM Tra t WHERE t.departureTransportation = :departureTransportation")
    , @NamedQuery(name = "Tra.findByDepartureCost", query = "SELECT t FROM Tra t WHERE t.departureCost = :departureCost")
    , @NamedQuery(name = "Tra.findByReturnDate", query = "SELECT t FROM Tra t WHERE t.returnDate = :returnDate")
    , @NamedQuery(name = "Tra.findByReturnTime", query = "SELECT t FROM Tra t WHERE t.returnTime = :returnTime")
    , @NamedQuery(name = "Tra.findByReturnTransportation", query = "SELECT t FROM Tra t WHERE t.returnTransportation = :returnTransportation")
    , @NamedQuery(name = "Tra.findByReturnCost", query = "SELECT t FROM Tra t WHERE t.returnCost = :returnCost")
    , @NamedQuery(name = "Tra.findByTravelTime", query = "SELECT t FROM Tra t WHERE t.travelTime = :travelTime")
    , @NamedQuery(name = "Tra.findByStay", query = "SELECT t FROM Tra t WHERE t.stay = :stay")
    , @NamedQuery(name = "Tra.findByStayCost", query = "SELECT t FROM Tra t WHERE t.stayCost = :stayCost")
    , @NamedQuery(name = "Tra.findByManagerApproval", query = "SELECT t FROM Tra t WHERE t.managerApproval = :managerApproval")
    , @NamedQuery(name = "Tra.findByHrApproval", query = "SELECT t FROM Tra t WHERE t.hrApproval = :hrApproval")
    , @NamedQuery(name = "Tra.findByFinanceApproval", query = "SELECT t FROM Tra t WHERE t.financeApproval = :financeApproval")})
public class Tra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "assignment_address")
    private String assignmentAddress;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "request_type")
    private String requestType;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
    @Column(name = "departure_time")
    private String departureTime;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "departure_transportation")
    private String departureTransportation;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "departure_cost")
    private String departureCost;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
    @Column(name = "return_time")
    private String returnTime;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "return_transportation")
    private String returnTransportation;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "return_cost")
    private String returnCost;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "travel_time")
    private String travelTime;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
    @Column(name = "stay")
    private String stay;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "stay_cost")
    private String stayCost;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "manager_approval")
    private String managerApproval;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
    @Column(name = "hr_approval")
    private String hrApproval;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "finance_approval")
    private String financeApproval;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public Tra() {
    }

    public Tra(Integer id) {
        this.id = id;
    }

    public Tra(Integer id, String assignmentAddress, String requestType, Date departureDate, String departureTime, String departureTransportation, String departureCost, Date returnDate, String returnTime, String returnTransportation, String returnCost, String travelTime, String stay, String stayCost, String managerApproval, String hrApproval, String financeApproval) {
        this.id = id;
        this.assignmentAddress = assignmentAddress;
        this.requestType = requestType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureTransportation = departureTransportation;
        this.departureCost = departureCost;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.returnTransportation = returnTransportation;
        this.returnCost = returnCost;
        this.travelTime = travelTime;
        this.stay = stay;
        this.stayCost = stayCost;
        this.managerApproval = managerApproval;
        this.hrApproval = hrApproval;
        this.financeApproval = financeApproval;
    }

    public Tra(Integer id, String assignmentAddress, String requestType, Date departureDate, String departureTime, String departureTransportation, String departureCost, Date returnDate, String returnTime, String returnTransportation, String returnCost, String travelTime, String stay, String stayCost, String managerApproval, String hrApproval, String financeApproval, Employee employee) {
        this.id = id;
        this.assignmentAddress = assignmentAddress;
        this.requestType = requestType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureTransportation = departureTransportation;
        this.departureCost = departureCost;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.returnTransportation = returnTransportation;
        this.returnCost = returnCost;
        this.travelTime = travelTime;
        this.stay = stay;
        this.stayCost = stayCost;
        this.managerApproval = managerApproval;
        this.hrApproval = hrApproval;
        this.financeApproval = financeApproval;
        this.employee = employee;
    }

    public Tra(String assignmentAddress, String requestType, Date departureDate, String departureTime, String departureTransportation, String departureCost, Date returnDate, String returnTime, String returnTransportation, String returnCost, String travelTime, String stay, String stayCost, String managerApproval, String hrApproval, String financeApproval, Employee employee) {
        this.assignmentAddress = assignmentAddress;
        this.requestType = requestType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureTransportation = departureTransportation;
        this.departureCost = departureCost;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.returnTransportation = returnTransportation;
        this.returnCost = returnCost;
        this.travelTime = travelTime;
        this.stay = stay;
        this.stayCost = stayCost;
        this.managerApproval = managerApproval;
        this.hrApproval = hrApproval;
        this.financeApproval = financeApproval;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssignmentAddress() {
        return assignmentAddress;
    }

    public void setAssignmentAddress(String assignmentAddress) {
        this.assignmentAddress = assignmentAddress;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTransportation() {
        return departureTransportation;
    }

    public void setDepartureTransportation(String departureTransportation) {
        this.departureTransportation = departureTransportation;
    }

    public String getDepartureCost() {
        return departureCost;
    }

    public void setDepartureCost(String departureCost) {
        this.departureCost = departureCost;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnTransportation() {
        return returnTransportation;
    }

    public void setReturnTransportation(String returnTransportation) {
        this.returnTransportation = returnTransportation;
    }

    public String getReturnCost() {
        return returnCost;
    }

    public void setReturnCost(String returnCost) {
        this.returnCost = returnCost;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getStay() {
        return stay;
    }

    public void setStay(String stay) {
        this.stay = stay;
    }

    public String getStayCost() {
        return stayCost;
    }

    public void setStayCost(String stayCost) {
        this.stayCost = stayCost;
    }

    public String getManagerApproval() {
        return managerApproval;
    }

    public void setManagerApproval(String managerApproval) {
        this.managerApproval = managerApproval;
    }

    public String getHrApproval() {
        return hrApproval;
    }

    public void setHrApproval(String hrApproval) {
        this.hrApproval = hrApproval;
    }

    public String getFinanceApproval() {
        return financeApproval;
    }

    public void setFinanceApproval(String financeApproval) {
        this.financeApproval = financeApproval;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Tra)) {
            return false;
        }
        Tra other = (Tra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectTRA.ProjectTRA.model.Tra[ id=" + id + " ]";
    }
    
}
