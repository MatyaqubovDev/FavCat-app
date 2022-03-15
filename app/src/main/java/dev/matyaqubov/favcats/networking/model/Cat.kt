package dev.matyaqubov.favcats.networking.model

import com.google.gson.annotations.SerializedName

data class Cat(

	@field:SerializedName("Cat")
	val cat: List<CatItem?>? = null
)

data class Weight(

	@field:SerializedName("metric")
	val metric: String? = null,

	@field:SerializedName("imperial")
	val imperial: String? = null
)

data class BreedsItem(

	@field:SerializedName("suppressed_tail")
	val suppressedTail: Int? = null,

	@field:SerializedName("wikipedia_url")
	val wikipediaUrl: String? = null,

	@field:SerializedName("origin")
	val origin: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("experimental")
	val experimental: Int? = null,

	@field:SerializedName("life_span")
	val lifeSpan: String? = null,

	@field:SerializedName("cfa_url")
	val cfaUrl: String? = null,

	@field:SerializedName("rare")
	val rare: Int? = null,

	@field:SerializedName("country_codes")
	val countryCodes: String? = null,

	@field:SerializedName("lap")
	val lap: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("short_legs")
	val shortLegs: Int? = null,

	@field:SerializedName("shedding_level")
	val sheddingLevel: Int? = null,

	@field:SerializedName("dog_friendly")
	val dogFriendly: Int? = null,

	@field:SerializedName("natural")
	val natural: Int? = null,

	@field:SerializedName("rex")
	val rex: Int? = null,

	@field:SerializedName("health_issues")
	val healthIssues: Int? = null,

	@field:SerializedName("hairless")
	val hairless: Int? = null,

	@field:SerializedName("weight")
	val weight: Weight? = null,

	@field:SerializedName("alt_names")
	val altNames: String? = null,

	@field:SerializedName("adaptability")
	val adaptability: Int? = null,

	@field:SerializedName("vocalisation")
	val vocalisation: Int? = null,

	@field:SerializedName("intelligence")
	val intelligence: Int? = null,

	@field:SerializedName("social_needs")
	val socialNeeds: Int? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("child_friendly")
	val childFriendly: Int? = null,

	@field:SerializedName("vcahospitals_url")
	val vcahospitalsUrl: String? = null,

	@field:SerializedName("temperament")
	val temperament: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("vetstreet_url")
	val vetstreetUrl: String? = null,

	@field:SerializedName("grooming")
	val grooming: Int? = null,

	@field:SerializedName("hypoallergenic")
	val hypoallergenic: Int? = null,

	@field:SerializedName("indoor")
	val indoor: Int? = null,

	@field:SerializedName("energy_level")
	val energyLevel: Int? = null,

	@field:SerializedName("stranger_friendly")
	val strangerFriendly: Int? = null,

	@field:SerializedName("reference_image_id")
	val referenceImageId: String? = null,

	@field:SerializedName("affection_level")
	val affectionLevel: Int? = null
)

data class CatItem(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("breeds")
	val breeds: List<BreedsItem?>? = null,

	@field:SerializedName("height")
	val height: Int? = null
)
