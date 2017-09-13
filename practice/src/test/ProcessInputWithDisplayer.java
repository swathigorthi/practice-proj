package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ProcessInputWithDisplayer {
	private static final Map<Long, Set<Long>> map = new HashMap<>();

	public static void main(String[] args) {
		
		//Saving the groups related data first, into a map. 
		processGroupInput();
	
		// Using the group to user map information, we can easily check if a user has any group or not.
		// In order to avoid extra buffer that saves 
		processUserInput();
    	
	}

	private static void processGroupInput() {
		Scanner in= null;
		try {
			in = new Scanner(new File("C:\\Users\\sgorthi\\workspace\\studyblue\\src\\groups.txt"));
			while(in.hasNextLine()){
				String line = in.nextLine();
				String[] arr = line.split(":");
				Long groupId = Long.valueOf(arr[0]);
				String[] userIds = arr.length < 3 ? null : arr[2].split(",");
				Set<Long> userIdSet = userIds !=  null ? new HashSet<>(Arrays.stream(userIds).mapToLong(x -> Long.valueOf(x)).boxed().collect(Collectors.toSet())) : new HashSet<>();
				map.put(groupId, userIdSet);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(in != null){
				in.close();
			}
		}
	}
	
	private static void processUserInput(){
		final Displayer displayer = new Displayer();;
		displayer.start();
		Scanner in= null;
		try {
			in = new Scanner(new File("C:\\Users\\sgorthi\\workspace\\studyblue\\src\\users.txt"));
			while(in.hasNextLine()){
				String line = in.nextLine();
				String[] arr = line.split(":");
				Long userId = Long.valueOf(arr[0]);
				Long groupId = arr.length < 3 ? null : Long.valueOf(arr[2]);
				if(userHasNoValidGroup(userId, groupId)){
					displayer.adduser(userId);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(in != null){
				in.close();
			}
		}
		displayer.finish();
	}

	private static boolean userHasNoValidGroup(Long userId, Long groupId) {
		return groupId == null || !map.containsKey(groupId) || !map.get(groupId).contains(userId);
	}

}
