package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieArrayList: ArrayList<Movie>
    companion object {
        var movieLikes = arrayOf(
            false, false, false, false, false, false, false, false, false, false
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id: Int = item.itemId
        return if (id == R.id.action_about) {
            launchAboutActivity()
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageIds = intArrayOf(
            R.drawable.money_heist, R.drawable.startup, R.drawable.dont_breathe, R.drawable.prison_break, R.drawable.breaking_bad, R.drawable.escape_room, R.drawable.shawshank, R.drawable.inception, R.drawable.the_matrix, R.drawable.parasite
        )

        val movieNames = arrayOf(
            "Money Heist", "Start-Up", "Don't Breathe", "Prison Break", "Breaking Bad", "Escape Room", "The Shawshank Redemption", "Inception", "The Matrix", "Parasite"
        )

        val movieGenres = arrayOf(
            "Crime, Thriller, Action", "Drama, Romance", "Crime, Horror, Thriller", "Action, Adventure, Mystery", "Drama, Crime, Thriller", "Action, Adventure, Horror", "Drama, Crime", "Action, Adventure, Sci-Fi", "Action, Sci-Fi", "Comedy, Drama, Thriller"
        )

        val movieDescriptions = arrayOf(
            "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion memorizing every step, every detail, every probability culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
            "Young entrepreneurs aspiring to launch virtual dreams into reality compete for success and love in the cutthroat world of Korea's high-tech industry.",
            "Rocky, a young woman wanting to start a better life for her and her sister, agrees to take part in the robbery of a house owned by a wealthy blind man with her boyfriend Money and their friend Alex. But when the blind man turns out to be a more ruthless adversary than he seems, the group must find a way to escape his home before they become his latest victims.",
            "An innocent man is framed for the homicide of the Vice President's brother and scheduled to be executed at a super-max penitentiary, thus it's up to his younger brother to save him with his genius scheme: install himself in the same prison by holding up a bank and, as the final month ticks away, launch the escape plan step-by-step to break the both of them out, with his full-body tattoo acting as his guide; a tattoo which hides the layout of the prison facility and necessary clues vital to the escape.",
            "When chemistry teacher Walter White is diagnosed with Stage III cancer and given only two years to live, he decides he has nothing to lose. He lives with his teenage son, who has cerebral palsy, and his wife, in New Mexico. Determined to ensure that his family will have a secure future, Walt embarks on a career of drugs and crime. He proves to be remarkably proficient in this new world as he begins manufacturing and selling methamphetamine with one of his former students. The series tracks the impacts of a fatal diagnosis on a regular, hard working man, and explores how a fatal diagnosis affects his morality and transforms him into a major player of the drug trade.",
            "Six strangers are given mysterious black boxes with tickets to an immersive escape room for a chance to win tons of money. Being locked in several rooms with extreme conditions, they discover the secrets behind the escape room and must fight to survive and to find a way out.",
            "Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of Shawshank after being found guilty of a crime he did not commit. The film portrays the man's unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red.",
            "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.",
            "Thomas A. Anderson is a man living two lives. By day he is an average computer programmer and by night a hacker known as Neo. Neo has always questioned his reality, but the truth is far beyond his imagination. Neo finds himself targeted by the police when he is contacted by Morpheus, a legendary computer hacker branded a terrorist by the government. As a rebel against the machines, Neo must confront the agents: super-powerful computer programs devoted to stopping Neo and the entire human rebellion.",
            "The Kims - mother and father Chung-sook and Ki-taek, and their young adult offspring, son Ki-woo and daughter Ki-jung - are a poor family living in a shabby and cramped half basement apartment in a busy lower working class commercial district of Seoul. Without even knowing it, they, especially Mr. and Mrs. Kim, literally smell of poverty. Often as a collective, they perpetrate minor scams to get by, and even when they have jobs, they do the minimum work required. Ki-woo is the one who has dreams of getting out of poverty by one day going to university. Despite not having that university education, Ki-woo is chosen by his university student friend Min, who is leaving to go to school, to take over his tutoring job to Park Da-hye, who Min plans to date once he returns to Seoul and she herself is in university. The Parks are a wealthy family who for four years have lived in their modernistic house designed by and the former residence of famed architect Namgoong. While Mr. and Mrs. Park are all about status, Mrs. Park has a flighty, simpleminded mentality and temperament, which Min tells Ki-woo to feel comfortable in lying to her about his education to get the job. In getting the job, Ki-woo further learns that Mrs. Park is looking for an art therapist for the Parks' adolescent son, Da-song, Ki-woo quickly recommending his professional art therapist friend \"Jessica\", really Ki-jung who he knows can pull off the scam in being the easiest liar of the four Kims. In Ki-woo also falling for Da-hye, he begins to envision himself in that house, and thus the Kims as a collective start a plan for all the Kims, like Ki-jung using assumed names, to replace existing servants in the Parks' employ in orchestrating reasons for them to be fired. The most difficult to get rid of may be Moon-gwang, the Parks' housekeeper who literally came with the house - she Namgoong's housekeeper when he lived there - and thus knows all the little nooks and crannies of it better than the Parks themselves. The question then becomes how far the Kims can take this scam in their quest to become their version of the Parks."
        )

        val movieRatings = arrayOf(
            "8.3", "8.1", "7.1", "8.3", "9.4", "6.4", "9.3", "8.8", "8.7", "8.6"
        )

//        val movieLikes = arrayOf(
//            false, false, false, false, false, false, false, false, false, false
//        )

        movieArrayList = ArrayList()
        for(i in movieNames.indices){
            val movie = Movie(movieNames[i], movieGenres[i], movieDescriptions[i], movieRatings[i], imageIds[i], movieLikes[i])
            movieArrayList.add(movie)
        }

        binding.listMovie.isClickable = true
        binding.listMovie.adapter = ListViewAdapter(this, movieArrayList)
        binding.listMovie.setOnItemClickListener{ parent, view, position, id ->
            val movieName = movieNames[position]
            val movieGenre = movieGenres[position]
            val movieDescription = movieDescriptions[position]
            val movieRating = movieRatings[position]
            val imageId = imageIds[position]
            val movieLiked = movieLikes[position]

            val intent: Intent = Intent(this, Detail::class.java)
            intent.putExtra("movieName", movieName)
            intent.putExtra("movieGenre", movieGenre)
            intent.putExtra("movieDescription", movieDescription)
            intent.putExtra("movieRating", movieRating)
            intent.putExtra("imageId", imageId)
            intent.putExtra("movieLiked", movieLiked)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }

    fun launchAboutActivity() {
        val intent: Intent = Intent(this, About::class.java)
        startActivity(intent)
    }
}