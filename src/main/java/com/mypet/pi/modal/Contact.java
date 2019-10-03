package com.mypet.pi.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "contatos")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private String breed;

	@Column(name = "description")
	@Type(type = "text")
	private String description;

	@Column(name = "url_image")
	private String urlImage;

	private Boolean vaccinated = Boolean.FALSE;

	private Boolean disease = Boolean.FALSE;

	@Column(name = "pet_size")
	@Enumerated(EnumType.STRING)
	private PetSize petSize;

	@Column(name = "pet_recommended_to")
	@Enumerated(EnumType.STRING)
	private PetRecommendedTo petRecommendedTo;

	@Column(name = "coat_length")
	@Enumerated(EnumType.STRING)
	private CoatLength coatLength;

	private String color;

	private String bloodType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public boolean isDisease() {
		return disease;
	}

	public void setDisease(boolean disease) {
		this.disease = disease;
	}

	public PetSize getPetSize() {
		return petSize;
	}

	public void setPetSize(PetSize petSize) {
		this.petSize = petSize;
	}

	public PetRecommendedTo getPetRecommendedTo() {
		return petRecommendedTo;
	}

	public void setPetRecommendedTo(PetRecommendedTo petRecommendedTo) {
		this.petRecommendedTo = petRecommendedTo;
	}

	public CoatLength getCoatLength() {
		return coatLength;
	}

	public void setCoatLength(CoatLength coatLength) {
		this.coatLength = coatLength;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", age=" + age + ", breed=" + breed + ", description="
				+ description + ", urlImage=" + urlImage + ", vaccinated=" + vaccinated + ", disease=" + disease
				+ ", petSize=" + petSize + ", petRecommendedTo=" + petRecommendedTo + ", coatLength=" + coatLength
				+ ", color=" + color + ", bloodType=" + bloodType + "]";
	}

}
