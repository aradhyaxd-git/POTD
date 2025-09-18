class TaskManager {
    class Task{
        int userKiId;
        int taskKiId;
        int importance;
        Task(int userKiId, int taskKiId, int importance){
            this.userKiId=userKiId;
            this.taskKiId=taskKiId;
            this.importance=importance;
        }
    }

    PriorityQueue<Task> pq;
    Map<Integer,Task> map;
        
    public TaskManager(List<List<Integer>> tasks) {
        pq= new PriorityQueue<>((a,b)->{
            if(a.importance!=b.importance) return b.importance-a.importance;
            return b.taskKiId-a.taskKiId;
        });

        map=new HashMap<>();

        for(List<Integer> task:tasks){
            Task t= new Task(task.get(0),task.get(1),task.get(2));
            map.put(t.taskKiId,t);
            pq.add(t);
        }
        
    }
    
    public void add(int userId, int taskId, int priority) {
        Task t= new Task(userId,taskId,priority);
        pq.add(t);
        map.put(taskId,t);     
    }
    
    public void edit(int taskId, int newPriority) {

        Task oldTask= map.get(taskId);

        Task newTask= new Task(oldTask.userKiId,taskId,newPriority);
        pq.add(newTask);

        map.put(taskId,newTask);
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
       
    }
    
  public int execTop() {
    while (!pq.isEmpty()) {  // keep polling until valid
        Task t = pq.poll();
        if (map.get(t.taskKiId)==t) {
            map.remove(t.taskKiId);
            return t.userKiId;
        }
        // else: stale task, skip
    }
    return -1;
}

}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */