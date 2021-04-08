package com.widyaanalytic.moviecatalogue.data.source.remote.response
import com.google.gson.annotations.SerializedName


data class ResponseDetailMovie(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("backdrop_path")
    val backdropPath: String, // /hJuDvwzS0SPlsE6MNFOpznQltDZ.jpg
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any, // null
    @SerializedName("budget")
    val budget: Int, // 0
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String, // https://movies.disney.com/raya-and-the-last-dragon
    @SerializedName("id")
    val id: Int, // 527774
    @SerializedName("imdb_id")
    val imdbId: String, // tt5109280
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_title")
    val originalTitle: String, // Raya and the Last Dragon
    @SerializedName("overview")
    val overview: String, // Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.
    @SerializedName("popularity")
    val popularity: Double, // 3828.086
    @SerializedName("poster_path")
    val posterPath: String, // /lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String, // 2021-03-03
    @SerializedName("revenue")
    val revenue: Int, // 56482606
    @SerializedName("runtime")
    val runtime: Int, // 107
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    val status: String, // Released
    @SerializedName("tagline")
    val tagline: String, // A quest to save her world.
    @SerializedName("title")
    val title: String, // Raya and the Last Dragon
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Double, // 8.4
    @SerializedName("vote_count")
    val voteCount: Int // 1564
)

data class Genre(
    @SerializedName("id")
    val id: Int, // 16
    @SerializedName("name")
    val name: String // Animation
)

data class ProductionCompany(
    @SerializedName("id")
    val id: Int, // 2
    @SerializedName("logo_path")
    val logoPath: String, // /wdrCwmRnLFJhEoH8GSfymY85KHT.png
    @SerializedName("name")
    val name: String, // Walt Disney Pictures
    @SerializedName("origin_country")
    val originCountry: String // US
)

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String, // US
    @SerializedName("name")
    val name: String // United States of America
)

data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String, // English
    @SerializedName("iso_639_1")
    val iso6391: String, // en
    @SerializedName("name")
    val name: String // English
)