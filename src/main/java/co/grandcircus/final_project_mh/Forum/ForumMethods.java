package co.grandcircus.final_project_mh.Forum;

import java.util.ArrayList;
import java.util.List;

public class ForumMethods {
	
	
	//Get number of threads in a discussion
	public static long getNumberOfDiscussionThreads(Discussion discuss,
			ThreadDao threadRepo, DiscussionDao discussionRepo) {
		
			//set number of discussion topics
			//Figure out how many threads are in the discussion
			List<Thread> t = threadRepo.findAll();
			List<Thread> threads = new ArrayList<>();
			for (Thread th: t) {
				if (th.getDiscussionId() == discuss.getId()) {
					threads.add(th);
				}
			}
			Long numOfThreads = (long)threads.size();
			return numOfThreads;
		
	}
	
	

}
