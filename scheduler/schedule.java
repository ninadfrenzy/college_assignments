import java.io.*;
import java.util.*;

class task{
	public int time_of_execution;
	public String task_name;
	public int arrival_time;
}


class schedule{
	public static Scanner input = new Scanner(System.in);
	public static void main(String args[]){
		
		System.out.println("HELLO AND WELCOME TO SCHEDULER");
		System.out.println("ENTER YOUR CHOICE FOR ALGORITHM");
		System.out.println("1.FCFS\n2.SJF\n3.Priority");
		int choice_of_algorithm = input.nextInt();
		switch(choice_of_algorithm){
			case 1: FCFS();
					break;
			case 2: SJF();
					break;
			case 3: Priority();
					break;
		}

	}

	public static void SJF(){
		System.out.println("NUMBER OF TASKS ? ");
		int number_of_processes = input.nextInt();
		System.out.println("ENTER TASK-NUM AND TIME-OF-EXECUTION AND ARRIVAL TIME");
		String[] task_name = new String[20];
		int[] task_burst = new int[20];
		int[] task_arrival_time = new int[20];
		for(int i=0;i<number_of_processes;i++){
			
			task_name[i] = input.next();
			task_burst[i] = input.nextInt();
			task_arrival_time[i] = input.nextInt();
		}
		// for(int i=0;i<number_of_processes;i++){
		// 	System.out.println(task_set[i].task_name+task_set[i].time_of_execution+task_set[i].arrival_time);
		// }

		//sort by arrival time
		for(int i=0;i<number_of_processes;i++){
			for(int j=0;j<number_of_processes-(i+1);j++){
				if(task_burst[j]>task_burst[j+1]){
					int temp_time = task_arrival_time[j];
					task_arrival_time[j] = task_arrival_time[j+1];
					task_arrival_time[j+1] = temp_time;

					String temp_name = task_name[j];
					task_name[j] = task_name[j+1];
					task_name[j+1] = temp_name;

					int temp_burst = task_burst[j];
					task_burst[j] = task_burst[j+1];
					task_burst[j+1] = temp_burst;

				}
			}

		}

		for(int i=0;i<number_of_processes;i++){
			System.out.println(task_name[i]+" "+task_burst[i]+" "+task_arrival_time[i]);
		}


	}
	public static void FCFS(){
		System.out.println("NUMBER OF TASKS ? ");
		int number_of_processes = input.nextInt();
		System.out.println("ENTER TASK-NUM AND TIME-OF-EXECUTION AND ARRIVAL TIME");
		String[] task_name = new String[20];
		int[] task_burst = new int[20];
		int[] task_arrival_time = new int[20];
		for(int i=0;i<number_of_processes;i++){
			
			task_name[i] = input.next();
			task_burst[i] = input.nextInt();
			task_arrival_time[i] = input.nextInt();
		}
		// for(int i=0;i<number_of_processes;i++){
		// 	System.out.println(task_set[i].task_name+task_set[i].time_of_execution+task_set[i].arrival_time);
		// }

		//sort by arrival time
		for(int i=0;i<number_of_processes;i++){
			for(int j=0;j<number_of_processes-(i+1);j++){
				if(task_arrival_time[j]>task_arrival_time[j+1]){
					int temp_time = task_arrival_time[j];
					task_arrival_time[j] = task_arrival_time[j+1];
					task_arrival_time[j+1] = temp_time;

					String temp_name = task_name[j];
					task_name[j] = task_name[j+1];
					task_name[j+1] = temp_name;

					int temp_burst = task_burst[j];
					task_burst[j] = task_burst[j+1];
					task_burst[j+1] = temp_burst;

				}
			}

		}

		for(int i=0;i<number_of_processes;i++){
			System.out.println(task_name[i]+" "+task_burst[i]+" "+task_arrival_time[i]);
		}
		int[] completion_time = new int[20];
		int[] turn_around_time = new int[20];
		int[] waiting_time = new int[20];
		int avg_turn_around_time = 0;
		int avg_waiting_time = 0;
        for(int  i = 0 ; i < number_of_processes; i++)
        {
            if( i == 0)
            {   
                completion_time[i] = task_arrival_time[i] + task_burst[i];
            }
            else
            {
                if( task_arrival_time[i] > completion_time[i-1])
                {
                    completion_time[i] = task_arrival_time[i] + task_burst[i];
                }
                else
                    completion_time[i] = completion_time[i-1] + task_burst[i];
            }
            turn_around_time[i] = completion_time[i] - task_arrival_time[i] ;        
            waiting_time[i] = turn_around_time[i] - task_burst[i] ;         
            avg_waiting_time += waiting_time[i] ;             
            avg_turn_around_time += turn_around_time[i] ;              
        }

        for(int  i = 0 ; i< number_of_processes;  i++)
        {
            System.out.println(task_name[i] + "  \t " + task_arrival_time[i] + "\t" + task_burst[i] + "\t" 
            	+ completion_time[i] + "\t" + turn_around_time[i] + "\t"  + waiting_time[i] ) ;
        }

        System.out.println("AVG WAITING TIME IS "+avg_waiting_time+" AVG TURN AROUND TIME IS "+avg_turn_around_time);


	}

	public static void Priority() {
		System.out.println("NUMBER OF TASKS ? ");
		int number_of_processes = input.nextInt();
		System.out.println("ENTER TASK-NUM AND TIME-OF-EXECUTION, ARRIVAL TIME AND PRIORITY");
		String[] task_name = new String[20];
		int[] task_burst = new int[20];
		int[] task_arrival_time = new int[20];
		int[] priority = new int[20];
		for(int i=0;i<number_of_processes;i++){
			
			task_name[i] = input.next();
			task_burst[i] = input.nextInt();
			task_arrival_time[i] = input.nextInt();
			priority[i] = input.nextInt();
		}
		// for(int i=0;i<number_of_processes;i++){
		// 	System.out.println(task_set[i].task_name+task_set[i].time_of_execution+task_set[i].arrival_time);
		// }

		//sort by arrival time
		for(int i=0;i<number_of_processes;i++){
			for(int j=0;j<number_of_processes-(i+1);j++){
				if(priority[j]>priority[j+1]){
					int temp_time = task_arrival_time[j];
					task_arrival_time[j] = task_arrival_time[j+1];
					task_arrival_time[j+1] = temp_time;

					String temp_name = task_name[j];
					task_name[j] = task_name[j+1];
					task_name[j+1] = temp_name;

					int temp_burst = task_burst[j];
					task_burst[j] = task_burst[j+1];
					task_burst[j+1] = temp_burst;

					int temp_priority = priority[j];
					priority[j] = priority[j+1];
					priority[j+1] = temp_priority;

				}
			}

		}

		for(int i=0;i<number_of_processes;i++){
			System.out.println(task_name[i]+" "+task_burst[i]+" "+task_arrival_time[i]+" "+priority[i]);
		}
	}
}

