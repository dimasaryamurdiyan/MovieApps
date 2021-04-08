package com.widyaanalytic.moviecatalogue.data.source.remote.response
import com.google.gson.annotations.SerializedName


data class ResponseDetailTv(
    @SerializedName("backdrop_path")
    val backdropPath: String, // /z59kJfcElR9eHO9rJbWp4qWMuee.jpg
    @SerializedName("created_by")
    val createdBy: List<CreatedBy>,
    @SerializedName("episode_run_time")
    val episodeRunTime: List<Int>,
    @SerializedName("first_air_date")
    val firstAirDate: String, // 2014-10-07
    @SerializedName("genres")
    val genres: List<GenreTv>,
    @SerializedName("homepage")
    val homepage: String, // http://www.cwtv.com/shows/the-flash/
    @SerializedName("id")
    val id: Int, // 60735
    @SerializedName("in_production")
    val inProduction: Boolean, // true
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("last_air_date")
    val lastAirDate: String, // 2021-03-23
    @SerializedName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir,
    @SerializedName("name")
    val name: String, // The Flash
    @SerializedName("networks")
    val networks: List<Network>,
    @SerializedName("next_episode_to_air")
    val nextEpisodeToAir: NextEpisodeToAir,
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Int, // 138
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int, // 7
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_name")
    val originalName: String, // The Flash
    @SerializedName("overview")
    val overview: String, // After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only "meta-human" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.
    @SerializedName("popularity")
    val popularity: Double, // 1407.503
    @SerializedName("poster_path")
    val posterPath: String, // /lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyTv>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryTv>,
    @SerializedName("seasons")
    val seasons: List<Season>,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageTv>,
    @SerializedName("status")
    val status: String, // Returning Series
    @SerializedName("tagline")
    val tagline: String, // The fastest man alive.
    @SerializedName("type")
    val type: String, // Scripted
    @SerializedName("vote_average")
    val voteAverage: Double, // 7.6
    @SerializedName("vote_count")
    val voteCount: Int // 7096
)

data class CreatedBy(
    @SerializedName("credit_id")
    val creditId: String, // 5bd5a46d0e0a2622bd02be75
    @SerializedName("gender")
    val gender: Int, // 2
    @SerializedName("id")
    val id: Int, // 88967
    @SerializedName("name")
    val name: String, // Greg Berlanti
    @SerializedName("profile_path")
    val profilePath: String // /1T24SiIIDMa9gAmq7QaYwZywq4y.jpg
)

data class GenreTv(
    @SerializedName("id")
    val id: Int, // 18
    @SerializedName("name")
    val name: String // Drama
)

data class LastEpisodeToAir(
    @SerializedName("air_date")
    val airDate: String, // 2021-03-23
    @SerializedName("episode_number")
    val episodeNumber: Int, // 4
    @SerializedName("id")
    val id: Int, // 2542214
    @SerializedName("name")
    val name: String, // Central City Strong
    @SerializedName("overview")
    val overview: String, // The Flash must deal with Abra Kadabra's sudden return to Central City. The villain is back with a vengeance and a score to settle. Meanwhile, Allegra deals with a tricky situation and Caitlin suspects something is off with Frost. Iris is forced to look at a dark moment in her past.
    @SerializedName("production_code")
    val productionCode: String,
    @SerializedName("season_number")
    val seasonNumber: Int, // 7
    @SerializedName("still_path")
    val stillPath: String, // /18C2dzQrF57NZ4qRYUjERXm78Sp.jpg
    @SerializedName("vote_average")
    val voteAverage: Double, // 0.0
    @SerializedName("vote_count")
    val voteCount: Int // 0
)

data class Network(
    @SerializedName("id")
    val id: Int, // 71
    @SerializedName("logo_path")
    val logoPath: String, // /ge9hzeaU7nMtQ4PjkFlc68dGAJ9.png
    @SerializedName("name")
    val name: String, // The CW
    @SerializedName("origin_country")
    val originCountry: String // US
)

data class NextEpisodeToAir(
    @SerializedName("air_date")
    val airDate: String, // 2021-03-30
    @SerializedName("episode_number")
    val episodeNumber: Int, // 5
    @SerializedName("id")
    val id: Int, // 2542215
    @SerializedName("name")
    val name: String, // Fear Me
    @SerializedName("overview")
    val overview: String, // When a powerful new villain, Psych, channels and amplifies everyone's fears in order to wreak havoc on Central City, Barry realizes, with Cecile's help, that he must face his own worst fear in order to beat this new threat. Meanwhile, Joe is surprised when Kristen Kramer from the Governor's Municipal Logistics Commission drops into CCPD for a visit. Iris warns her father to dig deeper on why Kristen is actually there. Caitlin and Frost argue about how to live their lives.
    @SerializedName("production_code")
    val productionCode: String,
    @SerializedName("season_number")
    val seasonNumber: Int, // 7
    @SerializedName("still_path")
    val stillPath: Any, // null
    @SerializedName("vote_average")
    val voteAverage: Double, // 0.0
    @SerializedName("vote_count")
    val voteCount: Int // 0
)

data class ProductionCompanyTv(
    @SerializedName("id")
    val id: Int, // 1957
    @SerializedName("logo_path")
    val logoPath: String, // /3T19XSr6yqaLNK8uJWFImPgRax0.png
    @SerializedName("name")
    val name: String, // Warner Bros. Television
    @SerializedName("origin_country")
    val originCountry: String // US
)

data class ProductionCountryTv(
    @SerializedName("iso_3166_1")
    val iso31661: String, // US
    @SerializedName("name")
    val name: String // United States of America
)

data class Season(
    @SerializedName("air_date")
    val airDate: String, // 2016-04-19
    @SerializedName("episode_count")
    val episodeCount: Int, // 8
    @SerializedName("id")
    val id: Int, // 79954
    @SerializedName("name")
    val name: String, // Specials
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String, // /hce9A21ANLi4n9QtBZEdPFD2eZk.jpg
    @SerializedName("season_number")
    val seasonNumber: Int // 0
)

data class SpokenLanguageTv(
    @SerializedName("english_name")
    val englishName: String, // English
    @SerializedName("iso_639_1")
    val iso6391: String, // en
    @SerializedName("name")
    val name: String // English
)