package graph;

import java.util.*;

public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses ==0 || prerequisites == null || prerequisites.length == 0) {
			return true;
		}
		
		int[] courseDependences = new int[numCourses];
		for(int i = 0; i < prerequisites.length; i++) {
			//int dependentCourse = prerequisites[i][1];
			int toFinishCourse = prerequisites[i][0];
			
			courseDependences[toFinishCourse]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < numCourses; i++) {
			if (courseDependences[i] == 0) {
				// course that has no dependences
				queue.add(i);
			}
		}

		int totalCouers = queue.size();
		while(!queue.isEmpty()) {
			int top = queue.poll();
			for(int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == top) {
					courseDependences[prerequisites[i][0]]--;
					if (courseDependences[prerequisites[i][0]] == 0) {
						queue.add(prerequisites[i][0]);
						totalCouers++;
					}
				}
			}
		}
        return totalCouers == numCourses;
    }
	
	public static void main(String[] args) {
		int num = 2;
		int[][] dep = {
				{1, 0}, {0, 1}};
		System.out.println(canFinish(num, dep));
	}
}
