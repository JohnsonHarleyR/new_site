package co.grandcircus.final_project_mh;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import co.grandcircus.final_project_mh.User.User;
import co.grandcircus.final_project_mh.User.UserDao;

public class Methods {



	//This holds methods needed by all controllers


	//Check if there's a user logged in
	public static boolean checkLogin(HttpSession session) {

		User user = (User)session.getAttribute("user");
		Boolean loggedIn = (Boolean)session.getAttribute("loggedIn");

		if (user == null) {
			loggedIn = false;
		} else {
			loggedIn = true;
		}

		session.setAttribute("loggedIn", loggedIn);
		//Just to make it so user is logged in longer
		session.setAttribute("user", user);

		return loggedIn;

	}

	//Search Article Description for KeyWords

	public static boolean isArticleOk(String description) {

		description =  description.toLowerCase();

		//Make sure these are all lower case
		String[]words = {"sex", "drugs", "cannabis", "suicide", "death", "politics"
				,"trump", "democrat", "republican", "victoria's secret"};


		for (int i = 0; i < words.length; i ++)
		{  if (description.contains(words[i])) {

			return false;
		}
		}
		return true; 
	}


	//-----------------------------------------------------------------------


	//Basic point methods
	//Most of this methods section is in reference to a scoring system.


	//-Add points to category and to credit system (what do we call the credit system)
	//-At Certain Checkpoints we award for involvement and progress. Level progress.
	//Enable spending credits for perks.(trophies, new challenges, unlock profile perks...)
	//
	//Coordinate the DataBase b4 end of day for Monday Quiz.
	//

	//Current Point Disbursement
	//General Points
	//Total Points (bucket points)

	//Categorical Points
	//- add record points (soul points?)
	//-motivation quote points (soul points)
	//-article save points (mind points)
	//-quiz points (mind points -uncompleted)
	//- exercise points (body points)
	//-add workout points (body points?)



	//General add points method
	public static void addPoints(int points, User user, UserDao repo) {

		user.setPoints(user.getPoints() + points);
		user.setGeneralpoints(user.getGeneralpoints() + points);
		//save user
		repo.save(user);

	}


	//Soul Points

	//Save affirmation (or quote)
	public static void addAffirmationPoints(User user, UserDao repo) {
		//Set number of points it's worth
		final int POINTS = 1; //can grab from challenge list later
		final int LIMIT = 4;


		/*
		//Get todays affirmation saves
		//First store current date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Date date =  new Date(ts.getTime());
		String sDate = sdf.format(date);

		//Get today's save counter for user
		//if it's not there, create new line
		List<SaveCounter> counters = counterRepo.findByUserId(user.getId());
		boolean exists = false;
		SaveCounter counter = null;
		for (SaveCounter c: counters) {
			//Get date out of counter
			Date cDate = c.getDatetime();
			String sCDate = sdf.format(cDate);

			//compare dates
			if (sDate.equals(sCDate)) {
				exists = true;
				counter = c;
			}
		}

		//if date doesn't exist yet, create new line
		if (!exists) {
			//counter = 
		}
		 */

		user.setSoulpoints(user.getSoulpoints() + POINTS);
		user.setPoints(user.getPoints() + POINTS);
		//save user
		repo.save(user);


		//TODO (check if daily limit is reached before adding)


		//Later set up to challenges

	}

	//Body Points

	public static void addExercisePoints(User user, UserDao repo) {
		//Set number of points it's worth
		final int POINTS = 1; //can grab from challenge list later

		user.setBodypoints(user.getBodypoints() + POINTS);
		user.setPoints(user.getPoints() + POINTS);
		//save user
		repo.save(user);


		//TODO (check if daily limit is reached before adding)


		//Later set up to challenges

	}
	//	public static void addWorkoutPoints(User user, UserDao repo) {
	//		//Set number of points it's worth
	//		final int POINTS = 5; //can grab from challenge list later
	//		//final int LIMIT = 2;
	//		
	//		user.setBodypoints(user.getBodypoints() + POINTS);
	//		//save user
	//		repo.save(user);
	//		
	//		
	//		//TODO (check if daily limit is reached before adding)
	//		
	//		
	//		//Later set up to challenges
	//
	//	}

	//Mind Points

	public static void addArticlePoints(User user, UserDao repo) {
		//Set number of points it's worth
		final int POINTS = 1; //can grab from challenge list later
		final int LIMIT = 4;

		user.setMindpoints(user.getMindpoints() + POINTS);
		user.setPoints(user.getPoints() + POINTS);
		//save user
		repo.save(user);


		//TODO (check if daily limit is reached before adding)


		//Later set up to challenges

	}


	public static void addRecordPoints(User user, UserDao repo) {
		//Set number of points it's worth
		final int POINTS = 3; //can grab from challenge list later
		final int LIMIT = 2;

		user.setPoints(user.getPoints() + POINTS);
		//save user
		repo.save(user);


		//TODO (check if daily limit is reached before adding)


		//Later set up to challenges

	}

	//Interactive Points




	//Challenges

	//Sign up
	public static void signUp(User user, UserDao repo) {

		//Set number of points it's worth
		final int POINTS = 10;

		user.setPoints(user.getPoints() + POINTS);
		user.setGeneralpoints(user.getGeneralpoints() + POINTS);
		//save user
		repo.save(user);


	}

	public static Rank getRank(User user, UserDao repo) {


		int bodyPoints = user.getBodypoints();
		int mindPoints = user.getMindpoints();
		int soulPoints = user.getSoulpoints();
        int generalPoints = user.getGeneralpoints();
        

		int totalPoints  = bodyPoints + mindPoints + soulPoints + generalPoints;
		String name = "";

		int minBodyPoints = 0;
		int maxBodyPoints = 0;	
		int minSoulPoints = 0;
		int maxSoulPoints = 0;	
		int minMindPoints = 0;
		int maxMindPoints = 0;


		if(bodyPoints >= 0 && bodyPoints <= 10) {
			name += "Buff";
			minBodyPoints = 0;
			maxBodyPoints = 10;
		}
		else if(bodyPoints > 10 && bodyPoints <=50 ) {
			name += "Swole";
			minBodyPoints = 11;
			maxBodyPoints = 50;
		}
		else if(bodyPoints > 50 && bodyPoints <=100 ) {
			name += "Jacked";
			minBodyPoints = 51;
			maxBodyPoints = 100;
		}


		if(soulPoints >= 0 && soulPoints <= 10) {
			name += " Apprentice";
			minSoulPoints = 0;
			maxSoulPoints = 10;
		}
		else if(soulPoints > 10 && soulPoints <=50 ) {
			name += " Monk";
			minSoulPoints = 11;
			maxSoulPoints = 50;
		}
		else if(soulPoints > 50 && soulPoints <=100 ) {
			name += " Guru";
			minSoulPoints = 51;
			maxSoulPoints = 100;
		}

		if(mindPoints >= 0 && mindPoints <= 10) {
			name += " B.S";
			minMindPoints = 0;
			maxMindPoints = 10;
		}
		else if(mindPoints > 10 && mindPoints <=50 ) {
			name += " M.S";
			minMindPoints = 11;
			maxMindPoints = 50;
		}
		else if(mindPoints > 50 && mindPoints <=100 ) {
			name += " Ph.D";
			minMindPoints = 51;
			maxMindPoints = 100;
		}

		Rank rank = new Rank(bodyPoints, soulPoints, mindPoints, minBodyPoints, 
				maxBodyPoints, minSoulPoints, maxSoulPoints, minMindPoints, 
				maxMindPoints, name, totalPoints);

		return rank;
	}
	
	public static int getTotalPoint(User user) {
		
		int bodyPoints = user.getBodypoints();
		int mindPoints = user.getMindpoints();
		int soulPoints = user.getSoulpoints();
        int generalPoints = user.getGeneralpoints();
        
        int totalPoints  = bodyPoints + mindPoints + soulPoints + generalPoints;
        return totalPoints;
	}
	
	
	

}
