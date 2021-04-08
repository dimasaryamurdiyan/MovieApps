package com.widyaanalytic.moviecatalogue.utils

import com.widyaanalytic.moviecatalogue.data.TVShowEntity

object DataDummy {
//    fun generateDummyMovie(): List<MovieEntity>{
//        val movies = ArrayList<MovieEntity>()
//
//        movies.add(
//            MovieEntity(
//                "m1",
//                "Space Sweepers",
//             "Set in the year 2092 and follows the crew of a space junk collector ship called The Victory. When they discover a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fspace_sweepers.png?alt=media&token=f3769f49-1d22-4448-bf3d-56f986dc2fd7",
//                "6.6",
//                "Action, Adventure, Drama"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m2",
//                "Cek Toko Sebelah",
//                "Right when everything is going well for Erwin, his father falls sick and asks him to drop everything and help out at the family store disappointing Yohan, his irresponsible older brother.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fcek_toko_sebelah.jpg?alt=media&token=7bdac472-ceb9-4320-b5fb-911a4adde599",
//                "8.0",
//                "Comedy, Drama, Family"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m3",
//                "Gundala",
//                "Indonesia's preeminent comic book superhero and his alter ego Sancaka enter the cinematic universe to battle the wicked Pengkor and his diabolical squad of orphan assassins.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fgundala.jpg?alt=media&token=b863a2e0-01cd-4ec3-8740-0242f5974a37",
//                "6.3",
//                "Action, Adventure, Drama"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m4",
//                "The Old Guard",
//                "A covert team of immortal mercenaries is suddenly exposed and must now fight to keep their identity a secret just as an unexpected new member is discovered.",
//               "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fthe_old_guard.jpg?alt=media&token=fd572163-7401-4ba2-ad32-e399da2eab49",
//                "6.6",
//                "Action, Adventure, Fantasy"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m5",
//                "Ready Player One",
//                "When the creator of a virtual reality called the OASIS dies, he makes a posthumous challenge to all OASIS users to find his Easter Egg, which will give the finder his fortune and control of his world.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fready_player_one.jpg?alt=media&token=bf3a31d4-b86e-4b0e-8bd5-71ba367fb8a7",
//                "7.5",
//                "Action, Adventure, Sci-Fi"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m6",
//                "the crime of grindelwald",
//                "This original Netflix series, originally titled La Casa de Papel, follows the Professor (Álvaro Morte), a criminal mastermind who brings eight thieves together to take hostages and lock themselves in the Royal Mint of Spain as he manipulates the police to carry out his plan.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fthe_crimes_of_grindelwald.jpg?alt=media&token=b222ff1a-9853-478a-b98d-2be380d85d3e",
//                "8.5",
//                "Drama, Adventure, Fantasy"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m7",
//                "The Yin-Yang Master",
//                "The second installment of the \"Fantastic Beasts\" series featuring the adventures of Magizoologist Newt Scamander.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fthe_yin_yang_master.jpg?alt=media&token=7b7f4344-bf16-41c7-a5bb-54ca52cce3a5",
//                "6.6",
//                "Action, Drama, Fantasy"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m8",
//                "friend zone",
//                "In this world, there are many people who seem to be wandering along a relationship border-lining 'friends' and 'lovers'.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Ffriend_zone.jpg?alt=media&token=bbbaed43-52e1-42f8-8d06-9f7b7571677e",
//                "7.2",
//                "Comedy, Romance"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m9",
//                "bad genius",
//                "Lynn, a genius high school student who makes money by cheating tests, receives a new task that leads her to set foot on Sydney, Australia. In order to complete the millions-Baht task, Lynn and her classmates have to finish the international STIC(SAT) exam and deliver the answers back to her friends in Thailand before the exam takes place once again in her home country.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fbad-gen.jpg?alt=media&token=8e489894-eb33-43d2-b27e-1b96395a0b8c",
//                "7.6",
//                "Comedy, Crime, Drama"
//            )
//        )
//        movies.add(
//            MovieEntity(
//                "m10",
//                "Susah Sinyal",
//                "Ellen does not keep her promise to watch Kiara's performance at the talent show competition between high schools. Kiara is angry and goes to Sumba alone, where she could feel a glimmer of happiness.",
//                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fsusah_sinyal.jpg?alt=media&token=28945db3-79ac-4ba6-92b7-9af1c4ca3461",
//                "7.1",
//                "Comedy, Drama, Family"
//            )
//        )
//        return movies
//    }

    fun generateTVShows(): List<TVShowEntity>{
        val tvShows = ArrayList<TVShowEntity>()

        tvShows.add(
            TVShowEntity(
                "a1",
                "Money Heist",
                "This original Netflix series, originally titled La Casa de Papel, follows the Professor (Álvaro Morte), a criminal mastermind who brings eight thieves together to take hostages and lock themselves in the Royal Mint of Spain as he manipulates the police to carry out his plan.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fmoney_heist.jpg?alt=media&token=02d6f03c-18ae-4da9-b9d7-b4f3f734c2d7",
                "8.5",
                "12",
                "Action, Crime, Thriller"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a2",
                "The Witcher",
                "Geralt of Rivia, a mutated monster-hunter for hire, journeys toward his destiny in a turbulent world where people often prove more wicked than beasts.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fthe_witcher.jpg?alt=media&token=7652b2fb-2471-4238-87d0-ec514e5aabee",
                "8.2",
                "16",
                "Action, Adventure, Thriller"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a3",
                "Fate: The Winx Saga",
                "A live-action adaptation of Nickelodeon's Winx Club (2004). It follows Bloom as she adjusts to life in the Otherworld, where she must learn to control her dangerous magical powers.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Ffate_the_winx.jpg?alt=media&token=8813b5f5-4205-4f8a-bda2-788bb4f31927",
                "6.9",
                "14",
                "Action, Adventure, Drama"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a4",
                "SHERLOCK",
                "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fsherlock.jpg?alt=media&token=3c6b0ebd-33aa-4751-abf4-0eed24bf9f2d",
                "9.1",
                "15",
                "Drama, Crime, Mystery"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a5",
                "Vincenzo",
                "During a visit to his motherland, a Korean-Italian mafia lawyer gives an unrivaled conglomerate a taste of its own medicine with a side of justice.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fvincenzo.jpg?alt=media&token=49f7ae2d-1af1-4561-948d-61a96d490263",
                "8",
                "20",
                "Comedy, Crime, Romance"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a6",
                "Designated Survivor: 60 Days",
              "When the National Assembly suffers a catastrophic attack, Minister of Environment Park Mu Jin must find a way to lead Korea through the ensuing chaos.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fdesignated.jpg?alt=media&token=f8921566-f7b6-467b-b04d-a7400081aad9",
                "8.1",
                "16",
                "Crime, Thriller"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a7",
                "Peaky Blinders",
                "A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fpeaky_blinders.jpg?alt=media&token=0011c599-b9e2-44e6-88fd-5e9e8e8f33e8",
                "8.8",
                "36",
                "Crime, Drama"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a8",
                "Bridgerton",
                "Wealth, lust, and betrayal set against the backdrop of Regency-era England, seen through the eyes of the powerful Bridgerton family.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2FBridgerton.jpg?alt=media&token=7f914bb7-0326-4c29-8917-85a220e648b6",
                "7.3",
                "9",
                "Drama, Romance"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a9",
                "The Queen's Gambit",
                "Orphaned at the tender age of nine, prodigious introvert Beth Harmon discovers and masters the game of chess in 1960s USA. But child stardom comes at a price.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Fqueens.png?alt=media&token=fbf5eb86-5d56-4836-90fc-e5a2cdf49d09",
                "8.6",
                "7",
                "Drama, Sport"
            )
        )
        tvShows.add(
            TVShowEntity(
                "a10",
                "Lupin",
                "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                "https://firebasestorage.googleapis.com/v0/b/dms-dummy.appspot.com/o/movies%20and%20tv%2Flupin.jpg?alt=media&token=0f92c3e8-95fd-4f1c-ae62-4d0b7d1dd9ac",
                "8.5",
                "5",
                "Action, Crime, Drama"
            )
        )
        return tvShows
    }
}