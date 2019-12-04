package graph;

import java.util.*;

public class CourseScheduleII {
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] courseOrder = new int[numCourses];
        
        int[] courseDependences = new int[numCourses];
        int len = prerequisites.length;
        
        for(int i = 0; i < len; i++) {
        	int courseToTake = prerequisites[i][0];
//        	int dependentCourse = prerequisites[i][1];
        	courseDependences[courseToTake]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
        	if (courseDependences[i] == 0) {
        		queue.add(i);
        	}
        }
        
        if (queue.isEmpty()) {
        	return null;
        }
        
        int index = 0;
        int coursesNum = queue.size();
        while(!queue.isEmpty()) {
        	int top = queue.poll();
        	courseOrder[index++] = top;
        	
        	for(int i = 0; i < len; i++) {
        		if (top == prerequisites[i][1]) {
        			courseDependences[prerequisites[i][0]]--;
        			if (courseDependences[prerequisites[i][0]] == 0) {
        				queue.add(prerequisites[i][0]);
        				coursesNum++;
        			}
        		}
        	}
        }
        return coursesNum == numCourses ? courseOrder : null;
    }
	
	public static void main(String[] args) {
		int num = 2;
		int[][] dep = {
				{1, 0}};
		int[] res = findOrder(num, dep);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
