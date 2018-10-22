------------------------------CPU Scheduler------------------------------
Authors:
	Marcus Henke
	*Driver class CPUScheduling.java was written by CS321 Instructors

Date Completed:
	September 20, 2018

Summary:
	This program simulates the allocation of processes within a CPU. A
	MaxHeap data structure is used to implement a Priority Queue for
	incoming processes Time units are allocated to the processes at the
	root of the MaxHeap(Front of the Priority Queue. Once a process has
	been given enough time to complete, it is removed from the Priority
	Queue.	At the end of the simulation, the average turn-around time
	for processes and the amount of completed processes will be displayed.

Command Line Arguments & Usage:

	java CPUScheduling <maxProcessTime> <maxPriorityLevel> <timeToIncrementPriority>
	<simulationTime> <processArrivalRate>

	--Processes enter the Priotity Queue at a specified rate given
	by <processArrivalRate>.
	--Upon creation, processes will have a random priority level
	between 1 and <maxPriorityLevel>. This will determine a process's
	location in a priority queue.
	--Each process will have a random time to complete between 1 and
	the specified <maxProcessTime>.
	--In case of the "starvation problem", if a process has not been
	allocated any time for <timeToIncrementPriority>, its priority will
	be incremented by 1 to move it higher up in the Priority Queue.
	--The <simulationTime> specifies how many time units the simulation
	will last.

-------------------------------------------------------------------------
