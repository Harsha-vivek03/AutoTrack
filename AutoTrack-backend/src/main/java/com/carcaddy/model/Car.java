package com.carcaddy.model;

import java.time.LocalDate;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carId;
	@NotBlank(message = "This field cannot be empty")
	private String vehicleType;
	@NotBlank(message = "This field cannot be empty")
	private String model;
	@Min(value = 1900, message = "Year of manufacture must be greater than 1900")
	@Max(value = 2025, message = "Year of manufacture must be less than 2025")
	private int yearOfManufacture;
	public Long getCarId() {
		return carId;
	}


	public void setCarId(Long carId) {
		this.carId = carId;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getYearOfManufacture() {
		return yearOfManufacture;
	}


	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}


	public String getLicencePlateNumber() {
		return licencePlateNumber;
	}


	public void setLicencePlateNumber(String licencePlateNumber) {
		this.licencePlateNumber = licencePlateNumber;
	}


	public String getRegistrationCertificate() {
		return registrationCertificate;
	}


	public void setRegistrationCertificate(String registrationCertificate) {
		this.registrationCertificate = registrationCertificate;
	}


	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}


	public double getMileage() {
		return mileage;
	}


	public void setMileage(double mileage) {
		this.mileage = mileage;
	}


	public LocalDate getLastMaintenanceDate() {
		return lastMaintenanceDate;
	}


	public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
		this.lastMaintenanceDate = lastMaintenanceDate;
	}


	public LocalDate getNextMaintenanceDate() {
		return nextMaintenanceDate;
	}


	public void setNextMaintenanceDate(LocalDate nextMaintenanceDate) {
		this.nextMaintenanceDate = nextMaintenanceDate;
	}


	public List<Maintenance> getMaintenance() {
		return maintenance;
	}


	public void setMaintenance(List<Maintenance> maintenance) {
		this.maintenance = maintenance;
	}


	@NotBlank(message = "This field cannot be empty")
	private String licencePlateNumber;
	@NotBlank(message = "This field cannot be empty")
	private String registrationCertificate;
	@NotBlank(message = "This field cannot be empty")
	private String fuelType;
	
	@Positive
	private double mileage;
	@Past(message = "This field value should be  past date")
	private LocalDate lastMaintenanceDate;
	@Future(message = "This field value should be future date")
	private LocalDate nextMaintenanceDate;
	
	
	// A car can have mulutiple maintenance history .So to get the maintenance history of that particular car has
	 @OneToMany(mappedBy = "car", cascade =CascadeType.ALL)
	 @JsonIgnoreProperties("car")
	private List<Maintenance> maintenance;

}
